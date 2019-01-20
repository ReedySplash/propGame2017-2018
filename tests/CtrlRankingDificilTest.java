

import domini.adapters.CtrlDataFactoria;
import domini.model.Rank;
import domini.model.RankDificil;
import domini.model.RankNormal;
import domini.model.Ranking;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
/*Autor Carlos Alvarado*/
public class CtrlRankingDificilTest {
    @Test
    public void guardarTest() throws Exception {
        Rank rankingDificil = new RankDificil();
        for (int i = 1; i <= 30; ++i) {
            rankingDificil.guardaEnRankingJugadores(Integer.toString(i), i);
        }
        for (int j = 1; j <= 30; ++j) {
            rankingDificil.guardaEnRankingPartidas("victor", j, "partida");
        }
        List<String> listaJugadores = rankingDificil.getRankingJugadores();
        List<String> listaPartidas = rankingDificil.getRankingPartidas();
        for (String e : listaJugadores) System.out.println(e);
        for (String e : listaPartidas) System.out.println(e);

        CtrlDataFactoria fac = CtrlDataFactoria.getInstance();
        fac.getControladorRankingDificil().guardar(rankingDificil);
    }
    @After@Test
    public void getTest() throws Exception {
        Ranking ranking = Ranking.getInstance();
        Rank rankDificil = (RankDificil) ranking.getRankingDificil();
        List<String> listaJugadores1 = rankDificil.getRankingJugadores();
        List<String> listaPartidas1 = rankDificil.getRankingPartidas();
        for (String e : listaJugadores1) System.out.println(e);
        for (String e : listaPartidas1) System.out.println(e);
    }

}