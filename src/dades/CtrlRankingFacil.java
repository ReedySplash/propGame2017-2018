package dades;

import domini.model.Rank;
import domini.model.RankFacil;
import java.io.File;
/*Autor Carlos Alvarado*/
public class CtrlRankingFacil extends ControladorDatos {
    public CtrlRankingFacil() { super();}

    /*Post: Devuelve el objeto con el nombre nom guardado en disco*/
    @Override
    public Object get(String nom) throws Exception {
        String ruta = getRuta();
        Rank rank = new RankFacil();
        rank = (Rank) getObj(nom, getString(ruta) + nom + ".dat");
        return rank;
    }
    /*Post: Devuelve un booleano que nos indica si el objeto con el nombre nom existe en disco */
    @Override
    public boolean exists(String nom) throws Exception {
        String ruta = getRuta();
        if (existsObj(nom,getString(ruta) + nom + ".dat")) return true;
        else return false;
    }
    /*Devuelve la ruta final del objeto*/
    private String getString(String ruta) {
        return ruta + File.separator + "rankings" + File.separator;
    }

    /*Post: Guarda el objeto con el nombre nom guardado en disco*/
    @Override
    public void guardar(Object objeto) throws Exception {
        String ruta = getRuta();
        Rank rankingFacil = new RankFacil();
        rankingFacil = (RankFacil) objeto;
        guardaObj(rankingFacil, "rankingFacil",getString(ruta) + "rankingFacil" + ".dat");
    }
    /*Post: Borra el objeto con el nombre nom guardado en disco*/
    @Override
    public boolean borrar(String nom) throws Exception {
        String ruta = getRuta();
        if (borrarObj(nom,getString(ruta) + nom + ".dat")) return true;
        else return false;
    }

}
