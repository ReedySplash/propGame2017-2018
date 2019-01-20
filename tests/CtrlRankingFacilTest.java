import domini.adapters.CtrlDataFactoria;
import domini.model.Rank;
import domini.model.RankFacil;
import domini.model.Ranking;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CtrlRankingFacilTest {


    @Test
    public void guardarTest() throws Exception {
        Rank rankingFacil = new RankFacil();
        for (int i = 1; i <= 30; ++i) {
            rankingFacil.guardaEnRankingJugadores(Integer.toString(i), i);
        }
        for (int j = 1; j <= 30; ++j) {
            rankingFacil.guardaEnRankingPartidas("victor", j, "partida");
        }
        List<String> listaJugadores = rankingFacil.getRankingJugadores();
        List<String> listaPartidas = rankingFacil.getRankingPartidas();
        for (String e : listaJugadores) System.out.println(e);
        for (String e : listaPartidas) System.out.println(e);

        CtrlDataFactoria fac = CtrlDataFactoria.getInstance();
        fac.getControladorRankingFacil().guardar(rankingFacil);
    }


    @After@Test
    public void getTest() throws Exception {
        Ranking ranking = Ranking.getInstance();
        Rank rankFacil = (RankFacil) ranking.getRankingFacil();
        List<String> listaJugadores1 = rankFacil.getRankingJugadores();
        List<String> listaPartidas1 = rankFacil.getRankingPartidas();
        for (String e : listaJugadores1) System.out.println(e);
        for (String e : listaPartidas1) System.out.println(e);
    }
}