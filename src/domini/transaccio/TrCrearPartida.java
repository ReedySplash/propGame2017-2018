package domini.transaccio;

import domini.adapters.CtrlDataFactoria;
import domini.model.Jugador;
import domini.model.Partida;
import domini.model.Tablero;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TrCrearPartida extends Transaccio implements Serializable {

    private String id;
    private Jugador jugador;
    private int rol;
    private int dificultad;

    public TrCrearPartida(String id, String usuario, int rol, int dificultad) throws Exception {
        this.id = id;
        CtrlDataFactoria factoria = CtrlDataFactoria.getInstance();
        this.jugador = (Jugador) factoria.getControladorJugador().get(usuario);
        this.rol = rol;
        this.dificultad = dificultad;
    }

    @Override
    public void execute() throws Exception  {
        boolean rol_aux;
        ArrayList<Integer> codigo = new ArrayList<>();
        //Falta especificar como hacer IA vs IA, esto es solo para jugador HUMANO
        if(rol == 0) {
            rol_aux = false;
            codigo = new ArrayList<Integer>() {{
                add(ThreadLocalRandom.current().nextInt(0, 6));
                add(ThreadLocalRandom.current().nextInt(0, 6));
                add(ThreadLocalRandom.current().nextInt(0, 6));
            }};
            if (dificultad >= 2)
                codigo.add(ThreadLocalRandom.current().nextInt(0, 6));
            if (dificultad == 3)
                codigo.add(ThreadLocalRandom.current().nextInt(0, 6));
        }
        else rol_aux = true;
        for(int i = 0; i < codigo.size(); ++i) {
            System.out.println(codigo.get(i));
        }

        Partida partida = new Partida(id,jugador,rol_aux,dificultad); //Partida Creada
        if (rol == 0) partida.setCodigo(codigo);
        CtrlDataFactoria factoria = CtrlDataFactoria.getInstance();
        if (rol == 0) {
            jugador.guardaPartida(id,partida.getDificultad());
            factoria.getControladorJugador().borrar(jugador.getUsuario());
            factoria.getControladorJugador().guardar(jugador);
        }
        factoria.getControladorPartida().guardar(partida);
    }
    @Override
    public String getId() {
        return id;
    }
}
