package dades;

import domini.model.Jugador;
import java.io.*;
/*Autor Carlos Alvarado*/
public class CtrlJugador extends ControladorDatos {

    public CtrlJugador() {
        super();
    }
    /*Post: Devuelve el Jugador con el nombre nom guardado en disco*/
    @Override
    public Object get(String nom) throws Exception {
        String ruta = getRuta();
        Jugador jugador = new Jugador();
        jugador = (Jugador) getObj(nom, getString(ruta) + nom + ".dat");
        return jugador;
    }
    /*Devuelve la ruta final del objeto*/
    private String getString(String ruta) {
        return ruta + File.separator + "usuarios" + File.separator;
    }

    /*Post: Devuelve un booleano que nos indica si el jugador con el nombre nom existe en disco */
    @Override
    public boolean exists(String nom) throws Exception {
        String ruta = getRuta();
        if (existsObj(nom,getString(ruta) + nom + ".dat")) return true;
        else return false;
    }
    /*Post: Guarda el jugador con el nombre nom guardado en disco*/
    @Override
    public void guardar(Object objeto) throws Exception {
        String ruta = getRuta();
        Jugador jugador = new Jugador();
        jugador = (Jugador) objeto;
        guardaObj(jugador, jugador.getUsuario(),getString(ruta) + jugador.getUsuario() + ".dat");
    }
    /*Post: Borra el jugador con el nombre nom guardado en disco*/
    @Override
    public boolean borrar(String nom) throws Exception {
        String ruta = getRuta();
        if (borrarObj(nom,getString(ruta) + nom + ".dat")) return true;
        else return false;
    }


}