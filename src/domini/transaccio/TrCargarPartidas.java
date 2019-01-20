package domini.transaccio;

import domini.adapters.CtrlDataFactoria;
import domini.model.Jugador;
import domini.model.Partida;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TrCargarPartidas extends Transaccio implements Serializable{

    private String usuario;
    private List<String> partidas;

    public TrCargarPartidas(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public void execute() throws Exception {
        partidas = new ArrayList<>();
        CtrlDataFactoria factoria = CtrlDataFactoria.getInstance();
        Jugador jugador = (Jugador) factoria.getControladorJugador().get(usuario);
        this.partidas = jugador.getListaPartidasJugadas();
    }
    @Override
    public List<String> getPartidas() {
        return partidas;
    }
}
