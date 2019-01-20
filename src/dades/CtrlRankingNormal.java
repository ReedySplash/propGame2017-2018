package dades;

import domini.model.Rank;
import domini.model.RankNormal;
import java.io.File;
/*Autor Carlos Alvarado*/
public class CtrlRankingNormal extends ControladorDatos {

    public CtrlRankingNormal() {
    }
    /*Post: Devuelve el objeto con el nombre nom guardado en disco*/
    @Override
    public Object get(String nom) throws Exception {
        String ruta = getRuta();
        Rank rank = new RankNormal();
        rank = (RankNormal) getObj(nom, getString(ruta) + nom + ".dat");
        return rank;
    }
    /*Devuelve la ruta final del objeto*/
    private String getString(String ruta) {
        return ruta + File.separator + "rankings" + File.separator;
    }

    /*Post: Devuelve un booleano que nos indica si el objeto con el nombre nom existe en disco */
    @Override
    public boolean exists(String nom) throws Exception {
        String ruta = getRuta();
        if (existsObj(nom,getString(ruta) + nom + ".dat")) return true;
        else return false;
    }
    /*Post: Guarda el objeto con el nombre nom guardado en disco*/
    @Override
    public void guardar(Object objeto) throws Exception {
        String ruta = getRuta();
        Rank rankingNormal = new RankNormal();
        rankingNormal = (RankNormal) objeto;
        guardaObj(rankingNormal, "rankingNormal",getString(ruta) + "rankingNormal" + ".dat");
    }
    /*Post: Borra el objeto con el nombre nom guardado en disco*/
    @Override
    public boolean borrar(String nom) throws Exception {
        String ruta = getRuta();
        if (borrarObj(nom,getString(ruta) + nom + ".dat")) return true;
        else return false;
    }
}
