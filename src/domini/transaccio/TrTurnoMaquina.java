package domini.transaccio;

import domini.adapters.CtrlDataFactoria;
import domini.model.Partida;

import java.io.Serializable;
import java.util.ArrayList;

public class TrTurnoMaquina extends Transaccio implements Serializable {

    private Partida partida;
    private ArrayList<ArrayList<Integer>> fichas_tablero;
    private ArrayList<ArrayList<Integer>> espigas_tablero;


    public TrTurnoMaquina(String id, ArrayList<Integer> currentGuess) throws Exception {
        CtrlDataFactoria factoria = CtrlDataFactoria.getInstance();
        partida = (Partida) factoria.getControladorPartida().get(id);
        partida.setCodigo(currentGuess);
        factoria.getControladorPartida().guardar(partida);
    }

    @Override
    public void execute() throws Exception {
        partida.makePlay();
        int turnos = 0;
        while (!partida.comprobarFila() && turnos < 25) {
            ++turnos;
            partida.makePlay();
        }

        espigas_tablero = new ArrayList<>(25);
        fichas_tablero = new ArrayList<>(25);
        for (int i = 0; i <= turnos; ++i) {
            fichas_tablero.add(partida.getTablero().getFichas(i));
            ArrayList<Integer> espigas = new ArrayList<>();
            espigas.add(partida.getTablero().getNegras(i));
            espigas.add(partida.getTablero().getBlancas(i));
            espigas_tablero.add(espigas);
        }

    }
    @Override
    public ArrayList<ArrayList<Integer>> getFichas_Tablero() {
        return fichas_tablero;
    }
    @Override
    public ArrayList<ArrayList<Integer>> getEspigas_Talero() {
        return espigas_tablero;
    }
    @Override
    public int get_turno() {
        return partida.getTablero().getTurno();
    }
}
