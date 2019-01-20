package domini.transaccio;

import domini.adapters.CtrlDataFactoria;
import domini.model.Partida;

import java.io.Serializable;
import java.util.ArrayList;

public class TrGetTablero extends Transaccio implements Serializable {


    private String id_partida;
    private ArrayList<ArrayList<Integer>> fichas_tablero;
    private ArrayList<ArrayList<Integer>> espigas_tablero;
    private int turno;

    public TrGetTablero(String selectedValue) {
        this.id_partida = selectedValue;
    }


    @Override
    public void execute() throws Exception {
        CtrlDataFactoria factoria = CtrlDataFactoria.getInstance();
        Partida partida = (Partida) factoria.getControladorPartida().get(id_partida.substring(0,19));

        espigas_tablero = new ArrayList<>();
        fichas_tablero = new ArrayList<>();
        turno = partida.getTablero().getTurno();
        for (int i = 0; i <= turno; ++i) {
            fichas_tablero.add(i,partida.getTablero().getFichas(i));
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
        return turno;
    }
    @Override
    public String get_String() {
        return id_partida;
    }
}
