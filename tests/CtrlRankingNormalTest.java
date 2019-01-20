

import domini.adapters.CtrlDataFactoria;
import domini.model.Rank;
import domini.model.RankFacil;
import domini.model.RankNormal;
import domini.model.Ranking;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
/*Autor Carlos Alvarado*/
public class CtrlRankingNormalTest  {
    Rank rankingNormal = null;
    @Before
    public void setUp() throws Exception {

    }
    @Test
    public void guardarTest() throws Exception {
        rankingNormal = new RankNormal();
        for (int i = 1; i <= 30; ++i) {
            rankingNormal.guardaEnRankingJugadores(Integer.toString(i), i);
        }
        for (int j = 1; j <= 30; ++j) {
            rankingNormal.guardaEnRankingPartidas("victor", j, "partida");
        }
        List<String> listaJugadores = rankingNormal.getRankingJugadores();
        List<String> listaPartidas = rankingNormal.getRankingPartidas();
        for (String e : listaJugadores) System.out.println(e);
        for (String e : listaPartidas) System.out.println(e);

        CtrlDataFactoria fac = CtrlDataFactoria.getInstance();
        fac.getControladorRankingNormal().guardar(rankingNormal);
    }

    @Test
    public void getTest() throws Exception {
        Ranking ranking = Ranking.getInstance();
        rankingNormal = ranking.getRankingNormal();
        List<String> listaJugadores1 = rankingNormal.getRankingJugadores();
        List<String> listaPartidas1 = rankingNormal.getRankingPartidas();
        for (String e : listaJugadores1) System.out.println(e);
        for (String e : listaPartidas1) System.out.println(e);
    }
    @Test
    public void getTestCarlos() throws Exception {
        Ranking ranking = Ranking.getInstance();
        rankingNormal = ranking.getRankingNormal();
        rankingNormal.guardaEnRankingJugadores("carlos",500);
        List<String> listaJugadores1 = rankingNormal.getRankingJugadores();
        List<String> listaPartidas1 = rankingNormal.getRankingPartidas();
        for (String e : listaJugadores1) System.out.println(e);
        for (String e : listaPartidas1) System.out.println(e);
    }

    @Test
    public void getTestCarlos1() throws Exception {
        Ranking ranking = Ranking.getInstance();
        rankingNormal = ranking.getRankingNormal();
        rankingNormal.guardaEnRankingJugadores("carlos",200);
        List<String> listaJugadores1 = rankingNormal.getRankingJugadores();
        List<String> listaPartidas1 = rankingNormal.getRankingPartidas();
        for (String e : listaJugadores1) System.out.println(e);
        for (String e : listaPartidas1) System.out.println(e);
    }
    @Test
    public void getTestCarlos2() throws Exception {
        Ranking ranking = Ranking.getInstance();
        rankingNormal = ranking.getRankingNormal();
        //rankingNormal.guardaEnRankingJugadores("carlos",200);
        rankingNormal.guardaEnRankingJugadores("carlos",10000);
        //rankingNormal.guardaEnRankingJugadores("victor",300);
        List<String> listaJugadores1 = rankingNormal.getRankingJugadores();
        List<String> listaPartidas1 = rankingNormal.getRankingPartidas();
        for (String e : listaJugadores1) System.out.println(e);
        for (String e : listaPartidas1) System.out.println(e);
    }

}