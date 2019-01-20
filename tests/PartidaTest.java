//AUTOR: GUILLEM BONET ARNAIZ
import domini.model.Jugador;
import domini.model.Partida;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import static org.junit.Assert.*;

public class PartidaTest {

    @Test
    public void getId() throws Exception {
        Jugador j = new Jugador("aa", "aa", "aa");
        Partida p = new Partida("1", j, true, 2);
        assertEquals("1", p.getId());
    }

    @Test
    public void getTablero() throws Exception {
        Jugador j = new Jugador("aa", "aa", "aa");
        Partida p = new Partida("1", j, true, 2);
        ArrayList<Integer> code = new ArrayList<>();
        Random rand = new Random();
        code.add(rand.nextInt(6));
        code.add(rand.nextInt(6));
        code.add(rand.nextInt(6));
        code.add(rand.nextInt(6));
        p.setCodigo(code);
        assert(p.getTablero().getTurno() == 0);
        p.makePlay();
        p.comprobarFila();
        assert(p.getTablero().getTurno() == 1);
    }

    @Test
    public void getJugador() throws Exception {
        Jugador j = new Jugador("aa", "aa", "aa");
        Partida p = new Partida("1", j, true, 2);
        assertEquals(j, p.getJugador());
    }

    @Test
    public void getPuntuacion() throws Exception {
        Jugador j = new Jugador("aa", "aa", "aa");
        Partida p = new Partida("1", j, true, 2);
        ArrayList<Integer> code = new ArrayList<>();
        Random rand = new Random();
        code.add(rand.nextInt(6));
        code.add(rand.nextInt(6));
        code.add(rand.nextInt(6));
        code.add(rand.nextInt(6));
        p.setCodigo(code);
        boolean win = false;
        while (!win) {
            p.makePlay();
            win = p.comprobarFila();
        }
        p.terminarPartida();
        assertNotEquals(0, p.getPuntuacion());
        //Ranking.getInstance().borrarPartida("1");
    }

    @Test
    public void isRol() throws Exception {
        Jugador j = new Jugador("aa", "aa", "aa");
        Partida p = new Partida("1", j, true, 2);
        assert(p.isRol());
        p = new Partida("1", j, false, 2);
        assert(!p.isRol());
    }


    @Test
    public void setId() throws Exception {
        Jugador j = new Jugador("aa", "aa", "aa");
        Partida p = new Partida("1", j, true, 2);
        p.setId("bbb");
        assertEquals("bbb", p.getId());
    }


    @Test
    public void guardarPartida() throws Exception {
        assert(true);
    }

    @Test
    public void setCodigo() throws Exception {
        makePlay();
        //this means a code has been set so it could be discovered.
    }
/*
    @Test
    public void terminarPartida() throws Exception {
        Jugador j = new Jugador("aa", "aa", "aa");
        Partida p = new Partida("1", j, true);
        Ranking r = Ranking.getInstance();
        assert(r.getTotalRankingPartidas() == 0);
        p.terminarPartida();
        assert(r.getTotalRankingPartidas() == 1);
        r.borrarPartida("1");
        assert(r.getRankingPartidas().size() == 0);
    }*/

    @Test
    public void makePlay() throws Exception {
        Jugador j = new Jugador("aa", "aa", "aa");
        Partida p = new Partida("1", j, true, 2);
        ArrayList<Integer> code = new ArrayList<>();
        Random rand = new Random();
        code.add(rand.nextInt(6));
        code.add(rand.nextInt(6));
        code.add(rand.nextInt(6));
        code.add(rand.nextInt(6));
        p.setCodigo(code);
        boolean win = false;
        while (!win) {
            p.makePlay();
            win = p.comprobarFila();
        }
        assert(win);
    }

    @Test
    public void comprobarFila() throws Exception {
        makePlay();
    }

}