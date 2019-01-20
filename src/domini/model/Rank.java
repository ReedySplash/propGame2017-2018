package domini.model;

import javafx.util.Pair;

import java.io.Serializable;
import java.util.*;
/*Autor: Carlos Alvarado*/
public abstract class Rank implements Serializable {

    /*Creadora*/
    public Rank() {}

    /*Post: Guarda un jugador y su puntuacion en el ranking*/
    protected void setPuntuacioJugador(String jugador, int puntuacio, ArrayList<Tupla> rankingJugadores) {
        Tupla t = new Tupla(jugador, puntuacio);
        boolean existe = existe(jugador, rankingJugadores);
        int indice = 0;
        if (existe) {
            for(Tupla t1 : rankingJugadores) {
                if (t1.getUsuario().equals(jugador)) rankingJugadores.set(indice, t);//hacemos reemplazo
                ++indice;
            }
        }
        else rankingJugadores.add(t);
        Collections.sort(rankingJugadores, new Comparator<Tupla>() {
            public int compare(Tupla o1, Tupla o2) {
                return ((Comparable<Integer>) o2.getPuntuacio()).compareTo(o1.getPuntuacio());
            }
        });
    }

    protected boolean existe(String nombre, ArrayList<Tupla> lista) {
        boolean res = false;
        for(Tupla t : lista) {
            if (t.getUsuario().equals(nombre)) {
                res = true;
            }
        }
        return res;
    }

    /*Post: Devuelve una lista con la puntuacion de cada jugador*/
    protected List<String> getRankingJugadores(List<Tupla> rankingJugadores) {

        List<String> res = new ArrayList<String>();
        for(Tupla str: rankingJugadores) { res.add("Usuario: "+str.getUsuario() + ", Puntuación: " + str.getPuntuacio());}
        return res;
    }

    /*Post: Guarda una partida con un id, nombre de usuario y puncion en el Ranking*/
    protected void setRankingPartidas(Tripleta nuevo, List<Tripleta> rankingPartidas) {
        rankingPartidas.add(nuevo);
        Collections.sort(rankingPartidas, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Tripleta) (o2)).getPuntuacion()).compareTo(((Tripleta) (o1)).getPuntuacion());
            }
        });
    }

    /*Post: Devuelve una lista con las partidas jugadas, con id de partida, usuario y puntuacion*/
    protected List<String> getRankPartidas(List<Tripleta> rankingPartidas) {
        List<String> res = new ArrayList<String>();
        for (Tripleta str : rankingPartidas) { res.add("Partida: "+ str.getPartida() + ", Jugador: " + str.getJugador() + ", Puntuación:" + str.getPuntuacion()); }
        return res;
    }

    /*Post: Guarda un jugador y su puntuacion en el ranking*/
    public abstract void guardaEnRankingJugadores(String jugador,int puntuacio);

    /*Post: Retorna una lista con el ranking de jugadores*/
    public abstract List<String> getRankingJugadores();

    /*Post: Guarda una partida en el ranking*/
    public abstract void guardaEnRankingPartidas(String jugador, int puntuacio, String partida);

    /*Post: Retorna una lista con el ranking de partidas*/
    public abstract List<String> getRankingPartidas();

}

