package domini.model;

import java.io.Serializable;
/*Autor Carlos Alvarado*/
public class Tripleta implements Serializable{
    private String partida;
    private String jugador;
    private int puntuacion;

    public Tripleta(String partida, String jugador, String puntuacion) {
        this.jugador = jugador;
        this.partida = partida;
        this.puntuacion = Integer.parseInt(puntuacion);
    }

    public Tripleta() { super();}


    public String getJugador() {
        return jugador;
    }

    public String getPartida() {
        return partida;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
