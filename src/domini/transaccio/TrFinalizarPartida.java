package domini.transaccio;



import domini.adapters.CtrlDataFactoria;
import domini.model.*;

import java.io.Serializable;

public class TrFinalizarPartida extends Transaccio implements Serializable {

    private Partida partida;
    private int puntuacion;

    public TrFinalizarPartida(String id) throws Exception {
        CtrlDataFactoria factoria = CtrlDataFactoria.getInstance();
        partida = (Partida) factoria.getControladorPartida().get(id);
    }

    @Override
    public void execute() throws Exception {
        CtrlDataFactoria factoria = CtrlDataFactoria.getInstance();
        partida.terminarPartida();
        puntuacion = partida.getPuntuacion();
        Ranking ranking = Ranking.getInstance();
        Jugador jugador = (Jugador) factoria.getControladorJugador().get(partida.getJugador().getUsuario());
        String id_string = partida.getId();
        id_string = getId_string(factoria, ranking, jugador, id_string);
        jugador.borraPartida(id_string);
        factoria.getControladorJugador().borrar(jugador.getUsuario());
        factoria.getControladorJugador().guardar(jugador);
        factoria.getControladorPartida().borrar(id_string.substring(0,19));
    }

    private String getId_string(CtrlDataFactoria factoria, Ranking ranking, Jugador jugador, String id_string) throws Exception {
        if (partida.getDificultad() == 2) {
            jugador.setPuntosAcumuladosNormal(jugador.getPuntosAcumuladosNormal()+puntuacion);
            Rank rankNormal = (RankNormal) ranking.getRankingNormal();
            rankNormal.guardaEnRankingPartidas(partida.getJugador().getUsuario(), puntuacion, partida.getId());
            rankNormal.guardaEnRankingJugadores(partida.getJugador().getUsuario(), jugador.getPuntosAcumuladosNormal());
            factoria.getControladorRankingNormal().borrar("rankingNormal");
            factoria.getControladorRankingNormal().guardar(rankNormal);
            id_string = id_string.substring(0,19) +" Normal";
        } else if (partida.getDificultad() == 1) {
            jugador.setPuntosAcumuladosFacil(jugador.getPuntosAcumuladosFacil()+puntuacion);
            Rank rankFacil = (RankFacil) ranking.getRankingFacil();
            rankFacil.guardaEnRankingPartidas(partida.getJugador().getUsuario(), puntuacion, partida.getId());
            rankFacil.guardaEnRankingJugadores(partida.getJugador().getUsuario(), jugador.getPuntosAcumuladosFacil());
            factoria.getControladorRankingFacil().borrar("rankingFacil");
            factoria.getControladorRankingFacil().guardar(rankFacil);
            id_string = id_string.substring(0,19) +" Fácil";
        }else if (partida.getDificultad() == 3) {
            jugador.setPuntosAcumuladosDificil(jugador.getPuntosAcumuladosDificil()+puntuacion);
            Rank rankDificil = (RankDificil) ranking.getRankingDificil();
            rankDificil.guardaEnRankingPartidas(partida.getJugador().getUsuario(), puntuacion, partida.getId());
            rankDificil.guardaEnRankingJugadores(partida.getJugador().getUsuario(), jugador.getPuntosAcumuladosDificil());
            factoria.getControladorRankingDificil().borrar("rankingDificil");
            factoria.getControladorRankingDificil().guardar(rankDificil);
            id_string = id_string.substring(0,19) +" Difícil";
        }
        return id_string;
    }

    @Override
    public int getPuntuacion() {
        return puntuacion;
    }
}
