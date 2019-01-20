//AUTOR: VICTOR MURCIANO DURAN
package domini.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Fila implements Serializable {

    private ArrayList<Integer> fichas;
    private ArrayList<Integer> espigas;
    private int blancas;
    private int negras;
    private int size;

    /*
     Segun la dificultad definimos un array mayor o menor
     Pre: Le pasamos la dificultad por un String
     Post: Crea una Fila segun la dificultad y establece a 0 las blancas y negras
    */
    public Fila(int dificultad){
        if (dificultad == 1) {
             fichas = new ArrayList<Integer>(3);
             espigas = new ArrayList<Integer>(3);
             for (int i = 0; i < 3; ++i) {
                 espigas.add(-1);
             }
             size = 3;
        }
        else if (dificultad == 2) {
            fichas = new ArrayList<Integer>(4);
            espigas = new ArrayList<Integer>(4);
            for (int i = 0; i < 4; ++i) {
                espigas.add(-1);
            }
            size = 4;
        }
        else if (dificultad == 3) {
            fichas = new ArrayList<Integer>(5);
            espigas = new ArrayList<Integer>(5);
            for (int i = 0; i < 5; ++i) {
                espigas.add(-1);
            }
            size = 5;
        }
        blancas = 0;
        negras = 0;

    }

    /*
     Añade el ArrayList que le pasamos a la Fila actual de fichas
     Pre: Se le pasa un  un ArrayList de COLOR_FICHA
     Post: Se le inserta a la fila de fichas
    */
    public void setFila(List<Integer>aux){
        for (int i = 0; i < aux.size(); ++i) {
            fichas.add(i,aux.get(i));
        }
    }

    /*
      Añade el List que le pasamos a la Fila actual de espigas
      Pre: Se le pasa un  un lista de integers
      Post: Se le inserta a la fila de espigas
     */
    public void setEspiga(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); ++i) {
            espigas.set(i,list.get(i));
            if (espigas.get(i) == 2) ++negras;
            else if (espigas.get(i) == 1) ++blancas;
        }
    }

    /*
     Nos devuelve el tamaño de la fila
     Pre:
     Post: Devuelve el tamaño como un integer
    */
    public int getSize() {return size;}
    /*
     Devuelve la fila de fichas
     Pre:
     Post: Devuelve un ArrayList<Ficha> que contiene las fichas de la Fila de fichas
    */
    public ArrayList<Integer> getFichas() {
        return fichas;
    }

    /*
    Devuelve la fila de espigas
    Pre:
    Post: Devuelve un ArrayList<Espiga> que contiene la fila de espigas
    */
    public ArrayList<Integer> getEspigas() {
        return espigas;
    }

    /*
     Nos devuelve el nº de espigas blancas
     Pre:
     Post: Devuelve en un int el nª de blancas
     */
    public int getBlancas() { return blancas; }

    /*
     Nos devuelve el nº de espigas negras
     Pre:
     Post: Devuelve en un int el nª de negras
     */
    public int getNegras() { return negras; }




    //ALGORITMOS PARA CPU

    /*
     Este algoritmo te comprueba si la Fila acutal es igual al codigo que le pasamos
     Pre: Se le pasa el codigo a descubrir
     Post: Nos devuelve en un ArrayList: el nº de negras, nº de blancas, y un bool que nos dice si Fila.fichas == codigo
     */
    public ArrayList<Integer> AlgoritmoMaquinaExclusivo(ArrayList<Integer> codigo) {

            comprobarFilayCrearEspigas(codigo);
            int bool = 0;
            if (size == negras) bool = 1;
            ArrayList<Integer> solucion = new ArrayList<>();
            solucion.add(blancas);
            solucion.add(negras);
            solucion.add(bool);
            negras = 0;
            blancas = 0;
            return solucion;
    }



     /*
     Este algoritmo te comprueba si has descubierto el codigo con la combinacion de fichas de la code.Fila
     Pre: Se le pasa el codigo a descubrir
     Post: Devuelve un bool que nos dice si las fila de fichas es igual al codigo(true) y actualiza los valotes de negras y blancas
     */
    public boolean comprobarFilayCrearEspigas(ArrayList<Integer> col){
        int aux_i;
        ArrayList<Integer> aux_fichas = new ArrayList<>(size);
        for (int index = 0; index < size; ++index) {
            aux_fichas.add(-1);
        }
        int cambiado = 0;
        for (int i = 0; i < size; ++i) {
            cambiado = 0;
            aux_i = -1;
            for (int j = 0; j < col.size(); ++j) {
                if (Objects.equals(fichas.get(i), col.get(j))) {
                    if (i == j) {
                        if (aux_fichas.get(i) != -1) --blancas;
                        while (cambiado > 0) {
                            --cambiado;
                            --blancas;
                        }
                        ++negras;
                        aux_fichas.set(i, fichas.get(j));
                        break;
                    } else {
                        if (cambiado == 0 && (aux_fichas.get(j) == -1)) {
                            ++blancas;
                            ++cambiado;
                            aux_i = j;
                        }
                    }
                }
            }
            if (cambiado != 0) aux_fichas.set(aux_i, col.get(aux_i));
        }

        //Colocamos las espigas
        int i = 0;
        for (i = 0; i < negras ; ++i) {
            espigas.set(i,2);
        }
        for (int j = 0; j < blancas; ++i,++j ) {
            espigas.set(i,1);
        }
        while (i < size) {
            espigas.set(i,0);
            ++i;
        }

        return negras == fichas.size();
    }
}
