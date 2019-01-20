//AUTOR: GUILLEM BONET ARNAIZ
package domini.model;

import dades.CtrlRankingNormal;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

public class Partida implements Serializable {

    private static final Logger LOGGER = Logger.getLogger( Partida.class.getName() );

    private String id;
    private Tablero tablero;
    private Jugador jugador;
    private Maquina maquina;
    private boolean rol; //true = CM; false = CB;
    private int puntuacion;
    private int dificultad;

    //crea una nueva partida con el id, jugador i rol especificados, le asigna una puntuacion de 0, la fecha y hora actuales y una maquina (IA).
    public Partida(String id, Jugador jugador, boolean rol, int dificultad) {
        super();
        this.puntuacion = 0;
        this.id = id;
        this.rol = rol;
        this.jugador = jugador;
        this.tablero = new Tablero(dificultad);
        if (rol)
            this.maquina = new Maquina(dificultad);
        this.dificultad = dificultad;
    }

    public Partida() {
        super();
    }

    public String getId() {
        return id;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public boolean isRol() {
        return rol;
    }

    public int getDificultad() {return dificultad;}

    public void setId(String id) {
        this.id = id;
    }

    public void setCodigo(ArrayList<Integer> code) {
        tablero.setCodigo(code);
    }

    //guarda la puntuacion de la partida en el ranking de partidas y le suma la puntuacion al jugador
    //en caso de que sea Code Breaker
    public void terminarPartida() {
        puntuacion = tablero.getPuntuacion();
        if (!rol) {
            if (dificultad == 1) {
                jugador.setPuntosAcumuladosFacil(jugador.getPuntosAcumuladosFacil() + puntuacion);
            }
            if (dificultad == 2) {
                jugador.setPuntosAcumuladosNormal(jugador.getPuntosAcumuladosNormal() + puntuacion);
            }
            if (dificultad == 3) {
                jugador.setPuntosAcumuladosDificil(jugador.getPuntosAcumuladosDificil() + puntuacion);
            }
        }
    }

    //llama a la maquina para que haga un movimiento
    public void makePlay() {
        maquina.makePlay(tablero);
    }

    //comprueba la fila del turno actual, y si el turno es igual o mayor a 25 termina la partida
    public boolean comprobarFila() {
        if (tablero.getTurno() < 25) {
            if (tablero.getFichas(tablero.getTurno()).size() == 0) {
                LOGGER.info("No has rellenado el turno actual.");
                return false;
            } else
                return tablero.comprobarFila();
        }
        else {
            terminarPartida();
            return false;
        }
    }



}
