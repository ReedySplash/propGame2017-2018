import domini.adapters.IControladorDatos;
import domini.adapters.CtrlDataFactoria;

import domini.model.Jugador;
import org.junit.Test;

import static org.junit.Assert.*;
/*Autor Carlos Alvarado*/
public class JugadorTest {

    @Test
    public void creaYobtieneJugadorTest() throws Exception {
        Jugador j = new Jugador("carlos", "csalvarado", "1234");
        CtrlDataFactoria factoria = CtrlDataFactoria.getInstance();
        factoria.getControladorJugador().guardar(j);
        Jugador nuevo = (Jugador) factoria.getControladorJugador().get("csalvarado");
        assertEquals(true, factoria.getControladorJugador().exists("csalvarado"));
        assertEquals("csalvarado",nuevo.getUsuario() );
        assertEquals("carlos", nuevo.getNombre());
        assertEquals("1234", nuevo.getPassw());
        assertEquals(0, nuevo.getNumeroPartidasJugadas());
        //assertEquals(0, nuevo.getPuntuacio());
    }

    @Test
    public void creaJugador2Test() throws Exception {
        Jugador j = new Jugador("victor", "vmurciano", "1234");
        CtrlDataFactoria factoria = CtrlDataFactoria.getInstance();
        IControladorDatos ctrlJugador = factoria.getControladorJugador();
        ctrlJugador.guardar(j);
        Jugador nuevo = new Jugador();
        nuevo = (Jugador) ctrlJugador.get("vmurciano");
        assertEquals(true, ctrlJugador.exists("vmurciano"));
        assertEquals("vmurciano",nuevo.getUsuario() );
        assertEquals("victor", nuevo.getNombre());
        assertEquals("1234", nuevo.getPassw());
        assertEquals(0, nuevo.getNumeroPartidasJugadas());
        //assertEquals(0, nuevo.getPuntuacio());
    }

    @Test
    public void creaJugador3Test() throws Exception {
        Jugador j = new Jugador("guillem", "gbonet", "1234");
        CtrlDataFactoria factoria = CtrlDataFactoria.getInstance();
        IControladorDatos ctrlJugador = factoria.getControladorJugador();
        ctrlJugador.guardar(j);
        Jugador nuevo = new Jugador();
        nuevo = (Jugador) ctrlJugador.get("gbonet");
        assertEquals(true, ctrlJugador.exists("gbonet"));
        assertEquals("gbonet",nuevo.getUsuario() );
        assertEquals("guillem", nuevo.getNombre());
        assertEquals("1234", nuevo.getPassw());
        assertEquals(0, nuevo.getNumeroPartidasJugadas());
        //assertEquals(0, nuevo.getPuntuacio());
    }

    @Test
    public void borrarJugadorTest() throws Exception {
        CtrlDataFactoria factoria = CtrlDataFactoria.getInstance();
        IControladorDatos ctrlJugador = factoria.getControladorJugador();
        assertEquals(true,ctrlJugador.borrar("csalvarado"));
        assertEquals(true,ctrlJugador.borrar("vmurciano"));
    }


}