package domini.model;

import javafx.util.Pair;

import java.io.Serializable;
import java.util.*;

/*Autor Carlos Alvarado*/
public class RankDificil extends Rank implements Serializable{

    private List<Tripleta> rankingPartidas = new LinkedList<Tripleta>();
    private ArrayList<Tupla> rankingJugadores = new ArrayList<Tupla>();

    public RankDificil() {
        super();
    }

    /*Post: Guarda un jugador y su puntuacion en el ranking*/
    @Override
    public void guardaEnRankingJugadores(String jugador,int puntuacio) {
        setPuntuacioJugador(jugador, puntuacio, rankingJugadores);
    }

    /*Post: Retorna una lista con el ranking de jugadores*/
    @Override
    public List<String> getRankingJugadores() {
        List<String> result = getRankingJugadores(rankingJugadores);
        return result;
    }

    /*Post: Guarda una partida en el ranking*/
    @Override
    public void guardaEnRankingPartidas(String jugador, int puntuacio, String partida) {
        Tripleta trip = new Tripleta(partida,jugador,Integer.toString(puntuacio));
        setRankingPartidas(trip,rankingPartidas);
    }

    /*Post: Retorna una lista con el ranking de partidas*/
    @Override
    public List<String> getRankingPartidas() {
        List<String> result = new LinkedList<String>();
        result = getRankPartidas(rankingPartidas);
        return result;
    }

}

