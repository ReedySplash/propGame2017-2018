package domini.transaccio;

import domini.adapters.CtrlDataFactoria;
import domini.model.Rank;
import domini.model.RankDificil;
import domini.model.RankNormal;
import domini.model.Ranking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TrFiltroPartidasRanking extends Transaccio implements Serializable {

    private List<String> rank_list;
    private int Dificultad;
    private Ranking rank;
    private int TipoRanking;


    public TrFiltroPartidasRanking (int Dificultad, int TipoRanking) {
        this.Dificultad = Dificultad;
        this.TipoRanking = TipoRanking;
    }

    @Override
    public void execute() throws Exception {
        rank = Ranking.getInstance();
        CtrlDataFactoria factoria = CtrlDataFactoria.getInstance();
        if (Dificultad == 1) {
            if (TipoRanking == 0) rank_list = rank.getRankingFacil().getRankingPartidas();
            else rank_list = rank.getRankingFacil().getRankingJugadores();
        }

        else if (Dificultad == 2) {
            if (TipoRanking == 0) rank_list = rank.getRankingNormal().getRankingPartidas();
            else {
                rank_list = rank.getRankingNormal().getRankingJugadores();
            }
        }
        else {
            if (TipoRanking == 0) rank_list = rank.getRankingDificil().getRankingPartidas();
            else rank_list = rank.getRankingDificil().getRankingJugadores();
        }

    }
    @Override
    public List<String> getList() {
        return rank_list;
    }
}
