package dades;
/*Autor Carlos Alvarado*/
import domini.model.Partida;

import java.io.*;
/*Autor Carlos Alvarado*/
public class CtrlPartida extends ControladorDatos {

    public CtrlPartida() { super();}
    /*Post: Devuelve la partida con el nombre nom guardado en disco*/
    @Override
    public Object get(String nom) throws Exception {
        String ruta = getRuta();
        Partida partida = new Partida();
        partida = (Partida) getObj(nom, getString(ruta) + nom + ".dat");
        return partida;
    }
    /*Devuelve la ruta final del objeto*/
    private String getString(String ruta) {
        return ruta + File.separator + "partidas" + File.separator;
    }
    /*Post: Devuelve un booleano que nos indica si la partida con el nombre nom existe en disco */
    @Override
    public boolean exists(String nom) throws Exception {
        String ruta = getRuta();
        if (existsObj(nom,getString(ruta) + nom + ".dat")) return true;
        else return false;
    }
    /*Post: Guarda la partida con el nombre nom guardado en disco*/
    @Override
    public void guardar(Object objeto) throws Exception {
        String ruta = getRuta();
        Partida partida = new Partida();
        partida = (Partida) objeto;
        guardaObj(partida, partida.getId(),getString(ruta) + partida.getId() + ".dat");
    }
    /*Post: Borra la partida con el nombre nom guardado en disco*/
    @Override
    public boolean borrar(String nom) throws Exception {
        String ruta = getRuta();
        if (borrarObj(nom,getString(ruta) + nom + ".dat")) return true;
        else return false;
    }
}

