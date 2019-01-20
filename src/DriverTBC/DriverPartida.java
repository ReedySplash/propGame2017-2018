//AUTOR: GUILLEM BONET ARNAIZ
package DriverTBC;

import domini.model.Jugador;
import domini.model.Partida;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class DriverPartida {
/*
    private static Partida p;
    private Scanner sc = new Scanner(System.in);

    public void testInitialize() {
        System.out.println("Test Initialize");
        System.out.println("Ingresa un id de partida");
        String id = sc.nextLine();
        System.out.println("Ingresa un rol ( Code Maker / Code Breaker ):");
        String rolName = sc.nextLine();
        boolean rol;
        if (rolName.equals("Code Maker")){
            rol = true;
        } else if (rolName.equals("Code Breaker")){
            rol = false;
        } else {
            System.out.println("Rol incorrecto, assignado Code Breaker");
            rol = false;
        }
        System.out.println("Ingresa un nombre de jugador");
        String nombre = sc.nextLine();
        System.out.println("Ingresa un nombre de usuario");
        String user = sc.nextLine();
        System.out.println("Ingresa una contraseña");
        String pass = sc.nextLine();
        Jugador j = new Jugador(nombre, user, pass);
        p = new Partida(id, j, rol);
        System.out.println("Introduce el codigo a descubrir: (numeros del 0 al 5 que representan colores)");
        System.out.println("Primera ficha:");
        ArrayList<Integer> code = new ArrayList<>();
        int num = getNum();
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
        System.out.println("Partida creada");
    }

    public void testGetId() {
        System.out.println("Test getID");
        System.out.println("El id de tu partida es " + p.getId());
    }

    public void testGetTablero() {
        System.out.println("Test Get Tablero");
        System.out.println("Tu tablero se encuentra en el turno " + p.getTablero().getTurno());
    }

    public void testGetJugador() {
        System.out.println("Test Get Jugador");
        System.out.println("Tu partida pertenece a " + p.getJugador().getNombre());
    }

    public void testGetPuntuacion() {
        System.out.println("Test Get Puntuacion");
        System.out.println("Tu partida tiene " + p.getPuntuacion() + " puntos.");
    }

    public void testIsRol() {
        System.out.println("Test Get Rol");
        if (p.isRol())
            System.out.println("Juegas como Code Maker.");
        else
            System.out.println("Juegas como Code Breaker.");

    }

    public void testGetFechayHora() {
        System.out.println("Test Get Fecha y Hora");
        System.out.println("Dia: " + p.getFechayHora().getDate());
        System.out.println("Mes: " + (p.getFechayHora().getMonth() + 1));
        System.out.println("Año: " + (p.getFechayHora().getYear() + 1900));
        System.out.println("Hora: " + p.getFechayHora().getHours());
        System.out.println("Minuto: " + p.getFechayHora().getMinutes());
    }

    public void testGetFechayHoraAsString() {
        System.out.println("Test Get Fecha y Hora as String");
        System.out.println(p.getFechayHoraAsString());
    }

    public void testSetId() {
        System.out.println("Test Set ID");
        System.out.println("Ingresa un nuevo id de partida");
        String id = sc.nextLine();
        p.setId(id);
        System.out.println("ID de partida modificado.");

    }

    public void testSetFechayHora() {
        System.out.println("Test Set Fecha y Hora");
        Date d = new Date();
        System.out.println("Dia:");
        d.setDate(sc.nextInt());
        System.out.println("Mes:");
        d.setMonth(sc.nextInt() - 1);
        System.out.println("Año:");
        d.setYear(sc.nextInt()-1900);
        System.out.println("Hora:");
        d.setHours(sc.nextInt());
        System.out.println("Minuto:");
        d.setMinutes(sc.nextInt());
        p.setFechayHora(d);
        System.out.println("Fecha y Hora actualizadas.");
    }

    public void testSetFechayHoraWithNumbers() {
        System.out.println("Test Set Fecha y Hora with String");
        System.out.println("Dia:");
        int day = sc.nextInt();
        System.out.println("Mes:");
        int month = sc.nextInt();
        System.out.println("Año:");
        int year = sc.nextInt();
        System.out.println("Hora:");
        int hour = sc.nextInt();
        System.out.println("Minuto:");
        int min = sc.nextInt();
        p.setFechayHora(day, month, year, hour, min);
    }

    public void testGuardarPartida() {
        //guardar partida en archivo
    }

    public void testTerminarPartida() {
        System.out.println("Test Terminar Partida");
        p.terminarPartida();
        Iterator<String> it = Ranking.getInstance().getRankingPartidas().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void testMakePlay() {
        System.out.println("Test Make Play");
        p.makePlay();
    }

    public void testComprobarFila() {
        p.comprobarFila();
    }

    public void menu() {
        System.out.println("**********************************");
        System.out.println("Selecciona la función que quieres probar");
        System.out.println("0 Initialize");
        System.out.println("1 getID");
        System.out.println("2 getTablero");
        System.out.println("3 getJugador");
        System.out.println("4 getPuntuacion");
        System.out.println("5 isRol");
        System.out.println("6 getFechayHora");
        System.out.println("7 getFechayHoraAsString");
        System.out.println("8 setID");
        System.out.println("9 setFechayHora");
        System.out.println("10 setFechayHora with String");
        System.out.println("11 terminarPartida");
        System.out.println("12 makePlay");
        System.out.println("13 comprobarFila");
        System.out.println("14 para salir del Driver");
        System.out.println("**********************************");
    }
    public static void main (String [] args) {
        System.out.println("INICIO DEL TEST DE LA CLASE PARTIDA");
        DriverPartida driver = new DriverPartida();
        Scanner br = new Scanner(System.in);
        int opcio = 0;
        while (opcio!=14) {
            driver.menu();
            opcio = br.nextInt();
            if (opcio > 0 && opcio < 14) {
                if (p == null) {
                    System.out.println("No has inicializado una partida.");
                    System.out.println("Primero usa Test Initialize.");
                    opcio = 15;
                }
            }
            switch (opcio) {
                case 0:
                    driver.testInitialize();
                    break;
                case 1:
                    driver.testGetId();
                    break;
                case 2:
                    driver.testGetTablero();
                    break;
                case 3:
                    driver.testGetJugador();
                    break;
                case 4:
                    driver.testGetPuntuacion();
                    break;
                case 5:
                    driver.testIsRol();
                    break;
                case 6:
                    driver.testGetFechayHora();
                    break;
                case 7:
                    driver.testGetFechayHoraAsString();
                    break;
                case 8:
                    driver.testSetId();
                    break;
                case 9:
                    driver.testSetFechayHora();
                    break;
                case 10:
                    driver.testSetFechayHoraWithNumbers();
                    break;
                case 11:
                    driver.testTerminarPartida();
                    break;
                case 12:
                    if (p.isRol())
                        driver.testMakePlay();
                    else
                        System.out.println("You are the Code Breaker");
                    break;
                case 13:
                    driver.testComprobarFila();
            }
        }
        System.out.println("Has finalizado el TEST de Partida");
    }
    
    private int getNum() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("No has introducido un numero valido.");
            return -1;
        }
    }*/
}
