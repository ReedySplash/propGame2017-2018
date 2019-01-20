//AUTOR: GUILLEM BONET ARNAIZ
package DriverTBC;

import domini.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class DriverMaquina {

    private static Partida p;
    private static Scanner sc = new Scanner(System.in);

    public static void main (String [] args) {
        System.out.println("Test de Maquina");
        DriverMaquina driver = new DriverMaquina();
        System.out.println("Ingresa un id de partida");
        String id = sc.nextLine();
        String rolName = new String();
        boolean rol = true;
        while (!rolName.equals("Code Maker") && !rolName.equals("Code Breaker")) {
            System.out.println("Ingresa un rol ( Code Maker / Code Breaker ):");
            rolName = sc.nextLine();
            if (rolName.equals("Code Maker")) {
                rol = true;
            } else if (rolName.equals("Code Breaker")) {
                rol = false;
            }
        }
        System.out.println("Ingresa un nombre de jugador");
        String nombre = sc.nextLine();
        System.out.println("Ingresa un nombre de usuario");
        String user = sc.nextLine();
        System.out.println("Ingresa una contraseña");
        String pass = sc.nextLine();
        Jugador j = new Jugador(nombre, user, pass);
        Partida p = new Partida(id, j, true, 2);
        ArrayList<Integer> code = new ArrayList<>();
        int num;
        System.out.println("Introduce el codigo a descubrir: (numeros del 0 al 5 que representan colores)");
        System.out.println("Primera ficha:");
        num = getNum();
        while (num < 0 || num > 5) {
            System.out.println("Introduce un numero entre 0 i 5:");
            num = getNum();
        }
        code.add(num);
        System.out.println("Segunda ficha:");
        num = getNum();
        while (num < 0 || num > 5) {
            System.out.println("Introduce un numero entre 0 i 5:");
            num = getNum();
        }
        code.add(num);
        System.out.println("Tercera ficha:");
        num = getNum();
        while (num < 0 || num > 5) {
            System.out.println("Introduce un numero entre 0 i 5:");
            num = getNum();
        }
        code.add(num);
        System.out.println("Cuarta ficha:");
        num = getNum();
        while (num < 0 || num > 5) {
            System.out.println("Introduce un numero entre 0 i 5:");
            num = getNum();
        }
        code.add(num);
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
            System.out.println("Puntutacion: "+ t.getPuntuacion());
        }
        else {
            System.out.println("La partida no se ha completado correctamente.");
        }
        System.out.println("Has finalizado el TEST de Maquina");
    }

    private static int getNum() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("No has introducido un numero valido.");
            return -1;
        }
    }
}
