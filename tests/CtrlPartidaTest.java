
import domini.adapters.IControladorDatos;
import domini.adapters.CtrlDataFactoria;
import domini.model.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
/*Autor Carlos Alvarado*/
public class CtrlPartidaTest {
    @Test
    public void altaPartedTest() throws Exception {
        Jugador j = new Jugador("carlos", "csalvarado", "1234");
        Partida p = new Partida("primera_partida", j, true, 2);
        ArrayList<Integer> code = new ArrayList<>();
        for (int i = 1;i < 6;++i)
            code.add(i);
        p.setCodigo(code);
        System.out.println("Iniciando partida...");
        p.makePlay();
        int turnos = 0;
        while (!p.comprobarFila() && turnos < 10) {
            ++turnos;
            p.makePlay();
        }
        Tablero t = new Tablero(2);
        t = p.getTablero();
        for (int i = 0; i < turnos+1; ++i) {
            ArrayList<Integer> aux = t.getFichas(i);
            ArrayList<Integer> aux_esp = t.getEspiga(i);
            System.out.printf("Turno %s: ",i+1);
            for (int i2 = 0; i2 < aux.size(); ++i2){
                System.out.printf("%s ", aux.get(i2));
            }
            for (int i2 = 0; i2 < aux_esp.size(); ++i2){
                System.out.printf("%s ",aux_esp.get(i2));
            }
            System.out.println();
        }
        System.out.println();
        if (turnos < 10) {
            turnos += 1;
            System.out.println("La partida se ha completado en " + turnos + " turnos.");
        }
        else {
            System.out.println("La partida no se ha completado correctamente.");
        }
        System.out.println("Has finalizado el TEST de Maquina");
        CtrlDataFactoria factoria = CtrlDataFactoria.getInstance();
        IControladorDatos ctrlPartida = factoria.getControladorPartida();
        ctrlPartida.guardar(p);
        assertEquals(true, ctrlPartida.exists("primera_partida"));
    }
    @Test
    public void getPartTest() throws Exception {
        CtrlDataFactoria factoria = CtrlDataFactoria.getInstance();
        IControladorDatos ctrlPartida = factoria.getControladorPartida();
        Partida partida = (Partida) ctrlPartida.get("primera_partida");
        Tablero t = new Tablero(2);
        t = partida.getTablero();
        int turnos = t.getTurno();
        for (int i = 0; i < turnos; ++i) {
            ArrayList<Integer> aux = t.getFichas(i);
            ArrayList<Integer> aux_esp = t.getEspiga(i);
            System.out.printf("Turno %s: ",i+1);
            for (int i2 = 0; i2 < aux.size(); ++i2){
                System.out.printf("%s ", aux.get(i2));
            }
            for (int i2 = 0; i2 < aux_esp.size(); ++i2){
                System.out.printf("%s ",aux_esp.get(i2));
            }
            System.out.println();
        }
        System.out.println();
        if (turnos < 10) {
            turnos += 1;
            System.out.println("La partida se ha completado en " + turnos + " turnos.");
        }
        else {
            System.out.println("La partida no se ha completado correctamente.");
        }
        assertEquals("primera_partida", partida.getId());
        assertEquals("csalvarado",partida.getJugador().getUsuario());
        assertEquals("carlos", partida.getJugador().getNombre());
        assertEquals("1234",partida.getJugador().getPassw());
    }

    @Test
    public void existsPartida() throws Exception {
        CtrlDataFactoria factoria = CtrlDataFactoria.getInstance();
        IControladorDatos ctrlPartida = factoria.getControladorPartida();
        assertEquals(true, ctrlPartida.exists("primera_partida"));
    }



    @Test
    public void borrarPartida() throws Exception {
        CtrlDataFactoria factoria = CtrlDataFactoria.getInstance();
        IControladorDatos ctrlPartida = factoria.getControladorPartida();

        assertEquals(true,ctrlPartida.borrar("primera_partida"));
    }

}