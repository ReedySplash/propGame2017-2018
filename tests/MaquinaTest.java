package tests;//AUTOR: GUILLEM BONET ARNAIZ
import domini.model.Maquina;
import domini.model.Tablero;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class MaquinaTest {

    @Test
    public void makePlay() throws Exception {
        Random rand = new Random();
        int turnos = 0;
        //Hacemos 10 partidas con codigo aleatorio
        for (int i = 0; i < 10; ++i) {
            turnos = 0;
            ArrayList<Integer> li = new ArrayList<>();
            li.add(rand.nextInt(6));
            li.add(rand.nextInt(6));
            li.add(rand.nextInt(6));
            li.add(rand.nextInt(6));
            Tablero t = new Tablero(li, 2);
            Maquina m = new Maquina(2);
            m.makePlay(t);
            //si tarda mas de 10 turnos termina el algoritmo
            while (!t.comprobarFila() && turnos < 24) {
                ++turnos;
                long x = new Date().getTime();
                m.makePlay(t);
                //System.out.println(new Date().getTime() - x);
            }
            //if (turnos > 5) System.out.println(turnos);
            assert(turnos <= 10);
        }
    }

    @Test
    public void makePlay2() throws Exception {
        Random rand = new Random();
        int turnos = 0;
        //Hacemos 10 partidas con codigo aleatorio
        for (int i = 0; i < 10; ++i) {
            turnos = 0;
            ArrayList<Integer> li = new ArrayList<>();
            li.add(rand.nextInt(6));
            li.add(rand.nextInt(6));
            li.add(rand.nextInt(6));
            Tablero t = new Tablero(li, 1);
            Maquina m = new Maquina(1);
            m.makePlay(t);
            //si tarda mas de 10 turnos termina el algoritmo
            while (!t.comprobarFila() && turnos < 24) {
                ++turnos;
                long x = new Date().getTime();
                m.makePlay(t);
                //System.out.println(new Date().getTime() - x);
            }
            //if (turnos > 5) System.out.println(turnos);
            assert(turnos <= 10);
        }
    }

    @Test
    public void makePlay3() throws Exception {
        Random rand = new Random();
        int turnos = 0;
        //Hacemos 10 partidas con codigo aleatorio
        for (int i = 0; i < 10; ++i) {
            turnos = 0;
            ArrayList<Integer> li = new ArrayList<>();
            li.add(rand.nextInt(6));
            li.add(rand.nextInt(6));
            li.add(rand.nextInt(6));
            li.add(rand.nextInt(6));
            li.add(rand.nextInt(6));
            Tablero t = new Tablero(li, 3);
            Maquina m = new Maquina(3);
            m.makePlay(t);
            //si tarda mas de 10 turnos termina el algoritmo
            while (!t.comprobarFila() && turnos < 10) {
                ++turnos;
                long x = new Date().getTime();
                m.makePlay(t);
                //System.out.println(new Date().getTime() - x);
            }
            //if (turnos > 5) System.out.println(turnos);
            assert(turnos <= 10);
        }
    }

}