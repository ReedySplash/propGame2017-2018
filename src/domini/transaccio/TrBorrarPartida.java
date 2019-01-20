package domini.transaccio;

import domini.adapters.CtrlDataFactoria;
import domini.model.Jugador;
import domini.model.Partida;

import java.io.Serializable;

public class TrBorrarPartida extends Transaccio implements Serializable {

    private String id_partida;
    private String usuario;

    public TrBorrarPartida(String partida) {
        this.id_partida = partida;
    }

    @Override
    public void execute() throws Exception {
        CtrlDataFactoria factoria = CtrlDataFactoria.getInstance();
        Partida partida = (Partida) factoria.getControladorPartida().get(id_partida.substring(0,19));
        Jugador jugador = (Jugador) factoria.getControladorJugador().get(partida.getJugador().getUsuario());
        jugador.borraPartida(id_partida);
        usuario = jugador.getUsuario();
        factoria.getControladorJugador().borrar(jugador.getUsuario());
        factoria.getControladorJugador().guardar(jugador);
        factoria.getControladorPartida().borrar(id_partida.substring(0,19));
    }
    @Override
    public String getUsuario() {
        return usuario;
    }
}
