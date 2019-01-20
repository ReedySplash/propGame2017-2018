//AUTOR: GUILLEM BONET ARNAIZ
package domini.model;

import java.io.Serializable;
import java.util.*;

public class Maquina implements Serializable{

    private Collection<ArrayList<Integer>> PC; //possible combinations
    private Collection<ArrayList<Integer>> AC; //possible combinations
    private ArrayList<Integer> lastGuess; //last guess made by the IA
    private static List<ArrayList<Integer>> PO; //possible outputs
    private int dificultad;

    public Maquina(int dif) {
        dificultad = dif;
        int ncomb;
        if (dif == 1)
            ncomb = 6*6*6;
        else if (dif == 2)
            ncomb = 6*6*6*6;
        else
            ncomb = 6*6*6*6*6;
        this.PC = new ArrayList<>(ncomb - 1);
        this.AC = new ArrayList<>(ncomb - 1);
        this.PO = generatePosibleOutputs();

        //Generate 2 colours and get its future position in the PC array
        Random rand = new Random();
        int color = rand.nextInt(6);
        int otroColor = rand.nextInt(6);
        int n = color*36 + otroColor*6 + otroColor;
        if (dif != 1)
            n += color*216;
        if (dif == 3)
            n += color*1296;

        //Generates all possible combinations of code pegs, each combination is an ArrayList<Integer> of 4 integers where
        //each integers represents a code peg and the given number represents a colour and adds them to PC and AC.
        for (int i = 0; i < n; ++i) {
            ArrayList<Integer> element = addElement(i);
            PC.add(element);
            AC.add(element);
        }
        //Our first guess is saved in the lastGuess variable
        lastGuess = addElement(n);
        PC.add(lastGuess);
        for (int i = n+1; i < ncomb; ++i) {
            ArrayList<Integer> element = addElement(i);
            PC.add(element);
            AC.add(element);
        }

    }

    public void makePlay(Tablero t) {
        if (t.getTurno() != 0) {
            //get last output
            int white = t.getBlancas(t.getTurno()-1);
            int black = t.getNegras(t.getTurno()-1);
            ArrayList<Integer> o = new ArrayList<>();
            o.add(white);
            o.add(black);

            //delete last guess from PC
            PC.remove(lastGuess);
            AC.remove(lastGuess);

            //create Fila with last guess
            Fila f = new Fila(dificultad);
            f.setFila(lastGuess);
            deleteDiscardedPossibilities(true, o, f);

            int max = -1;

            //if the difficulty is set to 3, use PC as it
            //would be too expensive in time to use AC
            //also use PC if it has less than 5 possibilities
            Iterator<ArrayList<Integer>> itCombs;
            if (dificultad == 3 || PC.size() < 5)
                itCombs = PC.iterator();
            else
                itCombs = AC.iterator();

            //if PC size is greater than 1000 is is too expensive in time
            // to evaluate, so it will choose one possibility at random
            if (PC.size() < 1000) {
                while (itCombs.hasNext()) {
                    ArrayList<Integer> comb = itCombs.next();
                    //for each possible guess

                    f = new Fila(dificultad);
                    f.setFila(comb);
                    int min = 8000;
                    for (Iterator<ArrayList<Integer>> outputs = PO.iterator(); outputs.hasNext(); ) {
                        ArrayList<Integer> output = outputs.next();

                        //get numbers of deleted combinations for each possible output and guess
                        int num = deleteDiscardedPossibilities(false, output, f);
                        if (num < min) //found new minimum
                            min = num;
                    }
                    if (min > max || (min == max && PC.contains(comb))) { //our guess is the maximum minimum
                        max = min;
                        lastGuess = comb;
                    }
                }
            } else {
                //choose a possibility at random
                Random rand = new Random();
                int randIndex = rand.nextInt(PC.size());
                Iterator<ArrayList<Integer>> pc = PC.iterator();
                ArrayList<Integer> obj = pc.next();
                for (int i = 1; i < randIndex; ++i)
                    obj = pc.next();
                lastGuess = obj;
            }
        }
        if (PC.size() == 1)
            lastGuess = PC.iterator().next();
        t.setFila(lastGuess); //make guess
    }

    //Given an output of Fila.AlgoritmoMaquinaExclusivo function, counts (and deletes them if delete boolean is set to true)
    //the number of possibilities in PC that would not give the same output given a combination (meaning that the possibility is
    //not the answer).
    private int deleteDiscardedPossibilities (boolean delete, ArrayList<Integer> output, Fila combination) {
        int res = 0;
        ArrayList<Integer> combEspigas;
        for (Iterator<ArrayList<Integer>> i = PC.iterator(); i.hasNext();) {
            ArrayList<Integer> item = i.next();
            combEspigas = combination.AlgoritmoMaquinaExclusivo(item);
            if (output.get(0) != combEspigas.get(0) || output.get(1) != combEspigas.get(1)) {
                if (delete)
                  i.remove();
                ++res;
            }
        }
        return res;
    }

    //Generates the list of all possible combinations of key pegs (except all black), each combination is an ArrayList<Integer>
    //where the first integer is the number of white key pegs and the second integer is the number of black key pegs.
    private List<ArrayList<Integer>> generatePosibleOutputs () {
        int n;
        if (dificultad == 1)
            n = 3;
        else if (dificultad == 2)
            n = 4;
        else
            n = 5;
        List<ArrayList<Integer>> res = new ArrayList<>(14);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j+i <= n) {
                    ArrayList<Integer> item = new ArrayList<>();
                    item.add(i);
                    item.add(j);
                    res.add(item);
                }
            }
        }
        ArrayList<Integer> item = new ArrayList<>();
        item.add(0);
        item.add(n);
        res.add(item);
        return res;
    }

    //For a given i returns the code pegs that should be in the position i in the all posibilities array.
    private ArrayList<Integer> addElement(int i) {
        ArrayList<Integer> item = new ArrayList<>();
        if (dificultad == 3)
            item.add((i/1296)%6);
        if (dificultad != 1)
            item.add((i/216)%6);
        item.add((i/36)%6);
        item.add((i/6)%6);
        item.add(i%6);
        return item;
    }

}
