package domini.model;

import domini.adapters.CtrlDataFactoria;

import java.io.Serializable;

/*Autor Carlos Alvarado*/


public class Ranking implements Serializable {
    private static Ranking ourInstance = new Ranking();
    private Rank rankingFacil;
    private Rank rankingNormal;
    private Rank rankingDificil;
    public static Ranking getInstance() {
        return ourInstance;
    }

    /*Constructora*/
    private Ranking() {
        rankingFacil = new RankFacil();
        rankingNormal = new RankNormal();
        rankingDificil = new RankDificil();
    }

    /*Obtiene una instancia del ranking en modo facil*/
    public Rank getRankingFacil() throws Exception {
        CtrlDataFactoria fac = CtrlDataFactoria.getInstance();
        rankingFacil = (RankFacil) fac.getControladorRankingFacil().get("rankingFacil");
        return rankingFacil;
    }

    /*Obtiene una instancia del ranking en modo normal*/
    public Rank getRankingNormal() throws Exception {
        CtrlDataFactoria fac = CtrlDataFactoria.getInstance();
        rankingNormal = (RankNormal) fac.getControladorRankingNormal().get("rankingNormal");
        return rankingNormal;
    }

    /*Obtiene una instancia del ranking en modo dificil*/
    public Rank getRankingDificil() throws Exception{
        CtrlDataFactoria fac = CtrlDataFactoria.getInstance();
        rankingDificil = (RankDificil) fac.getControladorRankingDificil().get("rankingDificil");
        return rankingDificil;
    }
}
