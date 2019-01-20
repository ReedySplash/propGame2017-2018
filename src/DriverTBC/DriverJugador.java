package DriverTBC;
import domini.model.Jugador;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*Autor Carlos Alvarado*/
public class DriverJugador {
    Jugador jugador;
    Scanner sc = new Scanner(System.in);
    public void testConstructor() {
        System.out.println("@testConstructor()");
        System.out.println("Ingresa tu nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingresa tu usuario");
        String usuario = sc.nextLine();
        System.out.println("Ingresa tu contraseña");
        String passwd = sc.nextLine();
        jugador = new Jugador(nombre,usuario,passwd);
        System.out.println("Ingresa tu contraseña");
        System.out.println("Hola " + jugador.getNombre()+", se ha creado tu jugador correctamente :)");
    }

    public void testGetNombre(){
        System.out.println("@testGetNombre");
        System.out.println("El Nombre con que has inicializado el jugador es '"+jugador.getNombre()+"'");
    }

    public void testGetUsuario() {
        System.out.println("@testGetUsuario");
        System.out.println("El Usuario con que has inicializado el jugador es '"+jugador.getUsuario()+"'");
    }

    public void testGetPuntuacio() {
        System.out.println("@testGetPuntuacio");
        //System.out.println("Tu puntuacion es '"+String.valueOf(jugador.getPuntuacio())+"'");
    }

    public void testGetNumeroPartidasJugadas() {
        System.out.println("@testGetNumeroPartidasJugadas");
        System.out.println("El numero de partidas que has jugado es '"+String.valueOf(jugador.getNumeroPartidasJugadas())+"'");
    }

    public void testGetListaPartidasJugadas() {
        System.out.println("@testGetListaPartidasJugadas");
        List<String> lista = new ArrayList<>();
        lista = jugador.getListaPartidasJugadas();
        if (jugador.getNumeroPartidasJugadas() == 0) System.out.println("Aún no has jugado partidas");
        else {
            System.out.println("Estas son tus partidas jugadas");
            for (String e : lista) System.out.println(e);
        }
    }

    public void testSetPuntuacio() {
        //System.out.println("Tu puntuación actual es '" + String.valueOf(jugador.getPuntuacio())+"'");
        System.out.println("Ingresa una puntuacion que te gustaria tener entre [1-100]");
        int puntuacio = sc.nextInt();
        //jugador.setPuntuacio(puntuacio);
        //System.out.println("Ahora tu puntuación es '"+String.valueOf(jugador.getPuntuacio())+"'");
    }

    public void testSetNombre() {
        System.out.println("@testSetNombre");
        System.out.println("Tu nombre es '"+jugador.getNombre()+"'");
        String nombreAntiguo = jugador.getNombre();
        System.out.println("Cambia tu nombre por otro");
        String nombre = sc.nextLine();
        jugador.setNombre(nombre);
        System.out.println("Tu nombre era '" + nombreAntiguo+"', ahora es '"+ nombre+"'");
    }

    public void testSetUsuario() {
        System.out.println("@testSetUsuario");
        System.out.println("Tu Usuario es '"+jugador.getUsuario()+"'");
        String usuarioAntiguo = jugador.getUsuario();
        System.out.println("Cambia tu usuario por otro");
        String usuario = sc.nextLine();
        jugador.setUsuario(usuario);
        System.out.println("Tu usuario era '" + usuarioAntiguo+"', ahora es '"+ usuario+"'");
    }

    public void testSetPassword() {
        System.out.println("@testSetPassword");
        System.out.println("Comprueba tu contraseña");
        System.out.println("Ingresa tu contraseña");
        String passwd = sc.nextLine();
        if (jugador.esLogin(jugador.getUsuario(), passwd)) {
            System.out.println("Contraseña correcta!");
            System.out.println("Ingresa contraseña nueva");
            String newPasswd = sc.nextLine();
            if (jugador.cambiarPassword(jugador.getUsuario(),passwd,newPasswd)) System.out.println("Contraseña cambiada correctamente!");
            else System.out.println("No se pudo cambiar la contraseña, intentelo de nuevo!");
        }
        else System.out.println("Contraseña incorrecta!, intenta de nuevo");
    }

    public void testGuardaPartida() {
        System.out.println("@testGuardaPartida");
        System.out.println("Ingresa el nombre de una partida");
        String partida = sc.nextLine();
        jugador.guardaPartida(partida,0);
        System.out.println("El numero de partidas que has jugado es '"+String.valueOf(jugador.getNumeroPartidasJugadas())+"'");
        System.out.println("Estas son tus partidas jugadas");
        List<String> lista = new ArrayList<>();
        lista = jugador.getListaPartidasJugadas();
        for (String e : lista) System.out.println(e);
}
    public void testBorrarPartida() {
        System.out.println("@testBorrarPartida");
        if (jugador.getNumeroPartidasJugadas() == 0) System.out.println("Aun no has jugado partidas, no puedes borrar ninguna");
        else {
            System.out.println("Puedes mirar las partidas que hay para borrar alguna");
            System.out.println("El numero de partidas que has jugado es '" + String.valueOf(jugador.getNumeroPartidasJugadas()) + "'");
            System.out.println("Estas son tus partidas jugadas");
            List<String> lista = new ArrayList<>();
            lista = jugador.getListaPartidasJugadas();
            for (String e : lista) System.out.println(e);
            System.out.println("Ingresa una partida para borrarla");
            String partida = sc.nextLine();
            jugador.borraPartida(partida);
            System.out.println("El nuevo numero de partidas que has jugado es '" + String.valueOf(jugador.getNumeroPartidasJugadas()) + "'");
            System.out.println("Estas son tus partidas jugadas sin la que has decidido borrar");
            lista = jugador.getListaPartidasJugadas();
            for (String e : lista) System.out.println(e);
        }
    }

    public void testEsLogin() {
        System.out.println("@tesEsLogin");
        System.out.println("Comprueba si tu contraseña es correcta");
        System.out.println("Ingresa tu contraseña");
        String passwd = sc.nextLine();
        if (jugador.esLogin(jugador.getUsuario(), passwd)) System.out.println("Contraseña correcta");
        else System.out.println("Contraseña incorrecta!, intentalo de nuevo mas tarde");
    }

    public void testCambiarPassword() {
        System.out.println("@testCambiarPassword");
        System.out.println("Ingresa tu contraseña antigua");
        String passwd = sc.nextLine();
        if (jugador.esLogin(jugador.getUsuario(), passwd)) {
            System.out.println("Contraseña correcta");
            System.out.println("Ingresa la contraseña nueva");
            String newPasswd = sc.nextLine();
            if (jugador.cambiarPassword(jugador.getUsuario(),passwd,newPasswd)) System.out.println("Contraseña cambiada correctamente!");
            else System.out.println("Algo ha fallado, intentalo de nuevo");
        }
        else {
            System.out.println("Contraseña incorrecta!, no puedes cambiar la contraseñas si no ingresas la antigua correctamente");
            System.out.println("Inténtalo de nuevo");
        }
    }

    public void menu() {
        System.out.println("**********************************");
        System.out.println("Selecciona la función que quieres probar");
        System.out.println("1 getNombre");
        System.out.println("2 getUsuario");
        System.out.println("3 getPuntuacio");
        System.out.println("4 getNumeroPartidasJugadas");
        System.out.println("5 getListaPartidasJugadas");
        System.out.println("6 setPuntuacio");
        System.out.println("7 setNombre");
        System.out.println("8 setUsuario");
        System.out.println("9 setPassword");
        System.out.println("10 guardaPartida");
        System.out.println("11 borrarPartida");
        System.out.println("12 esLogin");
        System.out.println("13 cambiarPassword");
        System.out.println("0 para salir del Driver");
        System.out.println("**********************************");
    }
    public static void main (String [] args) {
        System.out.println("INICIO DEL TEST DE LA CLASE JUGADOR");
        DriverJugador prueba = new DriverJugador();
        prueba.testConstructor();
        Scanner br = new Scanner(System.in);
        prueba.menu();
        int opcio = br.nextInt();
        while (opcio!=0) {
            switch (opcio) {
                case 1:
                    prueba.testGetNombre();
                    break;
                case 2:
                    prueba.testGetUsuario();
                    break;
                case 3:
                    prueba.testGetPuntuacio();
                    break;
                case 4:
                    prueba.testGetNumeroPartidasJugadas();
                    break;
                case 5:
                    prueba.testGetListaPartidasJugadas();
                    break;
                case 6:
                    prueba.testSetPuntuacio();
                    break;
                case 7:
                    prueba.testSetNombre();
                    break;
                case 8:
                    prueba.testSetUsuario();
                    break;
                case 9:
                    prueba.testSetPassword();
                    break;
                case 10:
                    prueba.testGuardaPartida();
                    break;
                case 11:
                    prueba.testBorrarPartida();
                    break;
                case 12:
                    prueba.testEsLogin();
                    break;
                case 13:
                    prueba.testCambiarPassword();
                    break;
            }
            prueba.menu();
            opcio = br.nextInt();
        }
        System.out.println("Has finalizado el TEST de Jugador");
    }
}
