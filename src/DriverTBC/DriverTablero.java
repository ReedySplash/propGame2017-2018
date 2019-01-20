//AUTOR: VICTOR MURCIANO DURAN
package DriverTBC;

import domini.model.Tablero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DriverTablero {

    private ArrayList<Tablero> tableros;
    private int Tablero_Seleccionado;


    private DriverTablero() {
        Tablero_Seleccionado = 0;
        tableros = new ArrayList<>();

    }

    private void escoger_tablero() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Lista de Tableros creados: (para seleccionar una escribe su numero)");
        for (int i = 0; i < tableros.size(); ++i) {
            System.out.printf("Tablero %s\n", i + 1);
        }
        int nuevo_tablero = reader.nextInt()-1;
        if (nuevo_tablero > tableros.size()) {
            System.out.println("El tablero no existe, sigues con el que tenias antes");
        }
        else {
            Tablero_Seleccionado = nuevo_tablero;
        }
    }

    private void TestConstructoraTablero_estandar() {

       tableros.add(new Tablero(2));
       System.out.println("Tablero creado con éxito");
    }

    private void TestsetCodigo(){
        Scanner reader = new Scanner(System.in);
        int size = tableros.get(Tablero_Seleccionado).getEspiga(0).size();
        System.out.printf("Elige %s colores mediante una cadena de valores entre 0-5 {azul, marron, rojo, naranja, verde, amarillo}\n", size);
        ArrayList<Integer> aux = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            int color = reader.nextInt();
            aux.add(color);
        }
        tableros.get(Tablero_Seleccionado).setCodigo(aux);
    }


    private void TestsetFichas() {
        Scanner reader = new Scanner(System.in);
        int size = tableros.get(Tablero_Seleccionado).getEspiga(0).size();
        System.out.printf("Elige %s colores mediante una cadena de valores entre 0-5 {azul, marron, rojo, naranja, verde, amarillo}\n", size);
        ArrayList<Integer> aux = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            int color = reader.nextInt();
            aux.add(color);
        }
        tableros.get(Tablero_Seleccionado).setFila(aux);
    }


    private void TestsetEspiga() {
        Scanner reader = new Scanner(System.in);
        int size = tableros.get(Tablero_Seleccionado).getEspiga(0).size();
        System.out.printf("Elige %s valores mediante una cadena de numeros entre 0 y -2 \n" + "Espiga sin valor: -1\n" + "Espiga sin color: 0\n" + "Espiga de color blanca: 1\n" + "Espiga de color negra: 2\n", size);
        ArrayList<Integer> aux = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            int espiga = reader.nextInt();
            aux.add(espiga);
        }
        tableros.get(Tablero_Seleccionado).setEspiga(aux);
        System.out.println("Fila de espigas insertada con éxito, se ha avanzado al turno siguiente");
    }


    private void TestgetEspiga() {
        System.out.println("¿De que Turno quiere las espigas?");
        Scanner reader = new Scanner(System.in);
        int turno = reader.nextInt()-1;
        if (turno > 24) {
            System.out.println("Turno superior al permitido, el máximo es 25");
            return;
        }
        ArrayList<Integer> espigas = tableros.get(Tablero_Seleccionado).getEspiga(turno);
        if (espigas.get(0) == -1) System.out.println("Fila de Espigas aun no creada, no se ha comprobado la fila de fichas con el codigo");
        else {
            System.out.printf("Estas son las espigas del turno %s del Tablero %s\n", turno + 1, Tablero_Seleccionado);
            for (Integer espiga : espigas) {
                System.out.printf("%s ", espiga);
            }
            System.out.printf("\n");
        }
    }

    private void TestgetFichas(){
        Scanner reader = new Scanner(System.in);
        System.out.println("¿De que turno quieres ver las fichas?");
        int turno = reader.nextInt();
        if (turno > 24) {
            System.out.println("Turno superior al permitido, el máximo es 25");
            return;
        }
        ArrayList<Integer> fichas_aux = tableros.get(Tablero_Seleccionado).getFichas(turno-1);
        if (fichas_aux.size() == 0) System.out.println("Fila de Fichas aun no establecida");
        else {
            System.out.printf("Estas son las fichas del turno %s Tablero %s\n", turno, Tablero_Seleccionado + 1);
            for (Integer aFichas_aux : fichas_aux) {
                System.out.printf("%s ", aFichas_aux);
            }
            System.out.printf("\n");
        }
    }

    private void testgetpuntuacion() {
        System.out.printf("Actualmente esta es tu puntuación: %s\n",tableros.get(Tablero_Seleccionado).getPuntuacion());
    }

    private void testgetNegras() {
        Scanner reader = new Scanner(System.in);
        System.out.println("¿De que turno quieres ver las negras?");
        int turno = reader.nextInt();
        if (tableros.get(Tablero_Seleccionado).getEspiga(0).get(0) != -1) {
            System.out.printf("Espigas negras: %s\n",tableros.get(Tablero_Seleccionado).getNegras(turno-1));
        }
        else {
            System.out.println("Espigas no insertadas");
        }
    }

    private void testgetBlancas() {
        Scanner reader = new Scanner(System.in);
        System.out.println("¿De que turno quieres ver las blancas?");
        int turno = reader.nextInt();
        if (tableros.get(Tablero_Seleccionado).getEspiga(0).get(0) != -1) {
            System.out.printf("Espigas blancas: %s\n",tableros.get(Tablero_Seleccionado).getBlancas(turno-1));
        }
        else {
            System.out.println("Espigas no insertadas");
        }
    }


    private void TestComprobarFila() {
        int turno = tableros.get(Tablero_Seleccionado).getTurno();
        if ( tableros.get(Tablero_Seleccionado).getFichas(turno).size() == 0) System.out.println("Fila de fichas aun no establecida, inserte una para poder comprobarla con el codigo");
        else {
            boolean conseguido = tableros.get(Tablero_Seleccionado).comprobarFila();
            if (conseguido) System.out.println("Fila comprobada con éxito, codigo acertado, se han creado las espigas correspondientes y se ha avanzado al turno siguiente");
            else { System.out.println("Fila comprobada con éxito, codigo no acertado, se han creado las espigas correspondientes y se ha avanzado al turno siguiente"); }
        }

    }

    private void TestGetTurno() {
        System.out.printf("Turno: %s\n",tableros.get(Tablero_Seleccionado).getTurno()+1);
    }

    private void menuTablero() {
        System.out.println("*********************************");
        System.out.println("Selecciona una función");
        System.out.println("-----Funciones a probar de la clase Tablero-----");
        System.out.println("1 Crear Tablero_estandar");
        System.out.println("2 Crear Tablero con dificultad y codigo determinados por el usuario y CODE MAKER respectivamente");
        System.out.println("3 Insertar Codigo a descubrir de la partida");
        System.out.println("4 Insertar Fila de Fichas en el turno actual");
        System.out.println("5 Insertar Fila de Espigas en el turno actual");
        System.out.println("6 Get Fila de Fichas de un turno en concreto ");
        System.out.println("7 Get Fila de Espigas de un turno en concreto");
        System.out.println("8 (¡¡SOLO SI EL TABLERO YA TIENE EL CODIGO INSERTADO!!)Comprobar Fila del turno actual con el codigo a descubrir que hemos insertado con anterioridad(Set Espigas automatico)");
        System.out.println("9 Get Puntuacion");
        System.out.println("10 Get espigas negras");
        System.out.println("11 Get espigas blancas");
        System.out.println("12 Get Turno actual");
        System.out.println("-----Funciones exclusivas del Test-----");
        System.out.println("13 Cambiar Tablero seleccionado");
        System.out.println("14 Salir");
        System.out.println("*********************************");
    }

    public static void main (String [] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        DriverTablero prueba = new DriverTablero();

        System.out.println("INICIO DEL TEST");
        prueba.menuTablero();
        int opcion = reader.nextInt();
        while (opcion != 14) {
            switch (opcion) {
                case 1:
                     prueba.TestConstructoraTablero_estandar();
                    break;

                case 2:
                    break;

                case 3:
                    if (prueba.tableros.size() == 0) {
                        System.out.println("Debes crear un tablero antes");
                        break;
                    }
                    prueba.TestsetCodigo();
                    break;

                case 4:
                    if (prueba.tableros.size() == 0) {
                        System.out.println("Debes crear un tablero antes");
                        break;
                    }
                    prueba.TestsetFichas();
                    break;

                case 5:
                    if (prueba.tableros.size() == 0) {
                        System.out.println("Debes crear un tablero antes");
                        break;
                    }
                    prueba.TestsetEspiga();
                    prueba.TestGetTurno();
                    break;

                case 6:
                    if (prueba.tableros.size() == 0) {
                        System.out.println("Debes crear un tablero antes");
                        break;
                    }
                    prueba.TestgetFichas();
                    break;

                case 7:
                    if (prueba.tableros.size() == 0) {
                        System.out.println("Debes crear un tablero antes");
                        break;
                    }
                    prueba.TestgetEspiga();
                    break;

                case 8:
                    if (prueba.tableros.size() == 0) {
                        System.out.println("Debes crear un tablero antes");
                        break;
                    }
                    prueba.TestComprobarFila();
                    prueba.TestGetTurno();
                    break;

                case 9:
                    if (prueba.tableros.size() == 0) {
                        System.out.println("Debes crear un tablero antes");
                        break;
                    }
                    prueba.testgetpuntuacion();
                    break;

                case 10:
                    if (prueba.tableros.size() == 0) {
                        System.out.println("Aun no tienes tableros creados");
                        break;
                    }
                    prueba.testgetNegras();
                    break;

                case 11:
                    if (prueba.tableros.size() == 0) {
                        System.out.println("Aun no tienes tableros creados");
                        break;
                    }
                    prueba.testgetBlancas();
                    break;

                case 12:
                    if (prueba.tableros.size() == 0) {
                        System.out.println("Debes crear un tablero antes");
                        break;
                    }
                    prueba.TestGetTurno();
                    break;

                case 13:
                    if (prueba.tableros.size() == 0) {
                        System.out.println("Aun no tienes tableros creados");
                        break;
                    }
                    prueba.escoger_tablero();
                    break;

            }
            prueba.menuTablero();
            opcion = reader.nextInt();
        }
        System.out.println("Test Finalizado");
    }

}

//Salta si no hay codigo creado

