package DriverTBC;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*Autor Carlos Alvarado*/

public class DriverRanking {
    /*Ranking ranking;
    Scanner sc = new Scanner(System.in);
    Scanner it = new Scanner(System.in);
    public void testConstructor() {
        System.out.println("@testConstructor()");
        System.out.println("Creamos una instancia de ranking, no necesitamos parametros");
        ranking = Ranking.getInstance();
    }

    public void testGuardaPuntuacioJugador() {
        System.out.println("@testGuardaPuntuacioJugador");
        ranking.guardaPuntuacioJugador("carlos",50);
        ranking.guardaPuntuacioJugador("victor",40);
        ranking.guardaPuntuacioJugador("guillem", 20);
        System.out.println("Tienes el siguiente ranking de jugadores");
        List<String> lista = new ArrayList<>();
        lista = ranking.getRankingJugadores();
        for (String e : lista) System.out.println(e);
        System.out.println("Ingresa un usuario de un jugador al ranking, ejemplo 'adria'");
        String usuario = sc.nextLine();
        System.out.println("Ingresa la puntuación del jugador, ejemplo '100'");
        int puntuacio = it.nextInt();
        ranking.guardaPuntuacioJugador(usuario,puntuacio);
        System.out.println("Ahora el ranking de jugadores es:");
        lista = ranking.getRankingJugadores();
        for (String e : lista) System.out.println(e);
    }

    public void testBorrarJugador() {
        System.out.println("@testBorrarJugador");
        if (ranking.getTotalRankingJugadores() == 0) System.out.println("No hay jugadores en el ranking, no puedes borrar a nadie");
        else {
            System.out.println("Tienes el siguiente ranking de Jugadores");
            List<String> lista = new ArrayList<>();
            lista = ranking.getRankingJugadores();
            for (String e : lista) System.out.println(e);
            System.out.println("Ingresa el nombre de el jugador que quieres eliminar del ranking");
            String jugador = sc.nextLine();
            ranking.borrarJugador(jugador);
            System.out.println("Ahora el ranking de Jugadores es:");
            lista = ranking.getRankingJugadores();
            for (String e : lista) System.out.println(e);
        }
    }

    public void testGetRankingJugadores() {
        System.out.println("@testGetRankingJugadores");
        if (ranking.getTotalRankingJugadores() == 0) System.out.println("No hay jugadores en el ranking, no hay partidas que borrar");
        else {
            System.out.println("Tienes el siguiente ranking de Jugadores");
            List<String> lista = new ArrayList<>();
            lista = ranking.getRankingJugadores();
            for (String e : lista) System.out.println(e);
        }
    }

    public void testGuardaPuntuacioPartida() {
        System.out.println("@testGuardaPuntuacioPartida");
        ranking.guardaPuntuacioPartida("14/11/2017 09:46",50);
        ranking.guardaPuntuacioPartida("1/11/2017 21:46",40);
        ranking.guardaPuntuacioPartida("13/10/2017 04:50", 20);
        System.out.println("Tienes el siguiente ranking de Partidas");
        List<String> lista = new ArrayList<>();
        lista = ranking.getRankingPartidas();
        for (String e : lista) System.out.println(e);
        System.out.println("Ingresa una partida al ranking, ejemplo 'fecha hora' que se ha iniciado una partida");
        String partida = sc.nextLine();
        System.out.println("Ingresa la puntuación de la partida, ejemplo '100'");
        int puntuacio = it.nextInt();
        ranking.guardaPuntuacioPartida(partida,puntuacio);
        System.out.println("Ahora el ranking de Partidas es:");
        lista = ranking.getRankingPartidas();
        for (String e : lista) System.out.println(e);
    }

    public void testBorrarPartida() {
        System.out.println("@testBorrarPartida");
        if (ranking.getTotalRankingPartidas() == 0) System.out.println("No hay partidas en el ranking, no puedes borrar ninguna partida");
        else {
            System.out.println("Tienes el siguiente ranking de Partidas");
            List<String> lista = new ArrayList<>();
            lista = ranking.getRankingPartidas();
            for (String e : lista) System.out.println(e);
            System.out.println("Ingresa el nombre de la partida que quieres eliminar del ranking");
            String partida = sc.nextLine();
            ranking.borrarPartida(partida);
            System.out.println("Ahora el ranking de Partidas es:");
            lista = ranking.getRankingPartidas();
            for (String e : lista) System.out.println(e);
        }
    }

    public void testGetRankingPartidas() {
        System.out.println("@testGetRankingPartidas");
        if (ranking.getTotalRankingPartidas() == 0) System.out.println("No hay partidas en el ranking");
        else {
            System.out.println("Tienes el siguiente ranking de Partidas");
            List<String> lista = new ArrayList<>();
            lista = ranking.getRankingPartidas();
            for (String e : lista) System.out.println(e);
        }
    }

    public void testOrdenaPorPuntuacio() {
        System.out.println("@testOrdenaPorPuntuacio");
        ranking.guardaPuntuacioJugador("carlos",50);
        ranking.guardaPuntuacioJugador("victor",40);
        ranking.guardaPuntuacioJugador("guillem", 20);
        System.out.println("Tienes el siguiente ranking de jugadores");
        List<String> lista = new ArrayList<>();
        lista = ranking.getRankingJugadores();
        for (String e : lista) System.out.println(e);
        System.out.println("Ingresa un usuario de un jugador al ranking, ejemplo 'adria'");
        String usuario = sc.nextLine();
        System.out.println("Ingresa la puntuación del jugador, ejemplo '100'");
        int puntuacio = it.nextInt();
        ranking.guardaPuntuacioJugador(usuario,puntuacio);
        System.out.println("Ahora el ranking ORDENADO POR PUNTUACION es:");
        lista = ranking.getRankingJugadores();
        for (String e : lista) System.out.println(e);
    }

    public void testGetTotalRankingJugadores() {
        System.out.println("@testGetTotalRankingJugadores");
        System.out.println("El total de jugadores en el ranking es de '"+ ranking.getTotalRankingJugadores()+"'");
    }

    public void testGetTotalRankingPartidas() {
        System.out.println("@testGetTotalRankingPartidas");
        System.out.println("El total de Partidas en el ranking es de '"+ ranking.getTotalRankingPartidas()+"'");
    }

    public void menu() {
        System.out.println("**********************************");
        System.out.println("Selecciona la función que quieres probar");
        System.out.println("1 guardaPuntuacioJugador");
        System.out.println("2 borrarJugador");
        System.out.println("3 getRankingJugadores");
        System.out.println("4 guardaPuntuacioPartida");
        System.out.println("5 borrarPartida");
        System.out.println("6 getRankingPartidas");
        System.out.println("7 ordenaPorPuntuacio");
        System.out.println("8 getTotalRankingJugadores");
        System.out.println("9 getTotalRankingPartidas");
        System.out.println("**********************************");
    }
    public static void main (String [] args) {
        DriverRanking prueba = new DriverRanking();
        prueba.testConstructor();
        Scanner br = new Scanner(System.in);
        prueba.menu();
        int opcio = br.nextInt();
        while (opcio!=0) {
            switch (opcio) {
                case 1:
                    prueba.testGuardaPuntuacioJugador();
                    break;
                case 2:
                    prueba.testBorrarJugador();
                    break;
                case 3:
                    prueba.testGetRankingJugadores();
                    break;
                case 4:
                    prueba.testGuardaPuntuacioPartida();
                    break;
                case 5:
                    prueba.testBorrarPartida();
                    break;
                case 6:
                    prueba.testGetRankingPartidas();
                    break;
                case 7:
                    prueba.testOrdenaPorPuntuacio();
                    break;
                case 8:
                    prueba.testGetTotalRankingJugadores();
                    break;
                case 9:
                    prueba.testGetTotalRankingPartidas();
                    break;
            }
            prueba.menu();
            opcio = br.nextInt();
        }
        System.out.println("Has finalizado el TEST de Ranking");
        br.close();

    }
*/
}
