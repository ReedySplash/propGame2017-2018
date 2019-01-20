package domini.transaccio;

import domini.adapters.CtrlDataFactoria;
import domini.model.Partida;

import java.io.Serializable;
import java.util.ArrayList;

public class TrCalculaEspigas extends Transaccio implements Serializable {

    private ArrayList<Integer> currentGuess;
    private String id;
    private ArrayList<Integer> Espigas;

    public TrCalculaEspigas(ArrayList<Integer> currentGuess, String id) {
        this.currentGuess = currentGuess;
        this.id = id;
    }

    @Override
    public void execute() throws Exception {
        CtrlDataFactoria factoria = CtrlDataFactoria.getInstance();
        Partida partida = (Partida) factoria.getControladorPartida().get(id.substring(0,19));
        partida.getTablero().setFila(currentGuess);
        partida.comprobarFila();
        Espigas = new ArrayList<>(2);
        Espigas.add(partida.getTablero().getBlancas(partida.getTablero().getTurno()-1));
        Espigas.add(partida.getTablero().getNegras(partida.getTablero().getTurno()-1));
        factoria.getControladorPartida().borrar(id.substring(0,19));
        factoria.getControladorPartida().guardar(partida);
    }
    @Override
    public ArrayList<Integer> getEspigas() {
        return Espigas;
    }
}
