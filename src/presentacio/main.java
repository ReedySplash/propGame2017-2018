package presentacio;

import domini.adapters.CtrlDataFactoria;
import domini.model.Rank;
import domini.model.RankDificil;
import domini.model.RankFacil;
import domini.model.RankNormal;

public class main {

    public static void main (String[] args) throws Exception {
        ControladorPresentacion pre = new ControladorPresentacion();
        CtrlDataFactoria fac = CtrlDataFactoria.getInstance();
        if (!fac.getControladorRankingFacil().exists("rankingFacil")) {
            Rank rankingFacil = new RankFacil();
            fac.getControladorRankingFacil().guardar(rankingFacil);
        }
        if(!fac.getControladorRankingNormal().exists("rankingNormal")){
            Rank rankingNormal = new RankNormal();
            fac.getControladorRankingNormal().guardar(rankingNormal);
        }
        if(!fac.getControladorRankingDificil().exists("rankingDificil")) {
            Rank rankingDificil = new RankDificil();
            fac.getControladorRankingDificil().guardar(rankingDificil);
        }
        pre.start();
    }
}
