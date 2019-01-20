//AUTOR: VICTOR MURCIANO DURAN
package DriverTBC;

import domini.model.Fila;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DriverFila {
    private ArrayList<Fila> filas;
    private int fila_selecionada;



    private DriverFila() {
        filas = new ArrayList<>();
        fila_selecionada = 0;
    }

    private void escoger_fila() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Lista de Filas creadas: (para seleccionar una escribe su numero)");
        for (int i = 0; i < filas.size(); ++i) {
            System.out.printf("Fila %s\n", i + 1);
        }
        int nueva_fila = reader.nextInt()-1;
        if (nueva_fila > filas.size()) {
            System.out.println("La fila no existe, sigues con la que tenias antes si ya la habias creado");
        }
        else {
            fila_selecionada = nueva_fila;
        }
    }

    //Test de la constructora de code.Fila
    private void testConstructor_estandar() {
       // filas.add(new Fila());
        fila_selecionada = filas.size()-1;
        System.out.printf("Fila %s creada y seleccionada con éxito\n", filas.size());
    }

    private void testConstructor(int dificultad) {
        filas.add(new Fila(dificultad));
        fila_selecionada = filas.size()-1;
        System.out.printf("Fila %s creada y seleccionada con éxito\n", filas.size());
    }

    private void testSetFila_fichas() {
        Scanner reader = new Scanner(System.in);
        if (filas.size() == 0) {
            System.out.println("Debes crear una Fila antes");
            return;
        }
        if (filas.get(fila_selecionada).getFichas().size() > 0) {
            System.out.println("Fila de fichas ya insertada, crea una nueva Fila para insertar una nueva");
            return;
        }
        int size = filas.get(fila_selecionada).getSize();
        System.out.printf("Elige %s colores mediante una cadena de valores del 0-5 separados de un espacio {azul, marron, rojo, naranja, verde, amarillo}\n", size);
        ArrayList<Integer> aux = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            int color = reader.nextInt();
            aux.add(color);
        }
        filas.get(fila_selecionada).setFila(aux);
        System.out.printf("Fila de fichas insertada a Fila %s con éxito\n", fila_selecionada + 1);
    }

    private void testsetEspigas() {
        Scanner reader = new Scanner(System.in);
        if (filas.size() == 0) {
            System.out.println("Debes crear una Fila antes");
            return;
        }
        if (filas.get(fila_selecionada).getEspigas().get(0) != -1) {
            System.out.println("Fila de espigas ya insertada, crea una nueva Fila para insertar una nueva");
            return;
        }
        int size = filas.get(fila_selecionada).getSize();
        System.out.printf("Elige %s valores mediante una cadena de valores del 0 al -2 \n" + "Espiga sin valor: -1\n" + "Espiga sin color: 0\n" + "Espiga de color blanca: 1\n" + "Espiga de color negra: 2\n", size);
        ArrayList<Integer> aux = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            int espiga = reader.nextInt();
            aux.add(espiga);
        }
        filas.get(fila_selecionada).setEspiga(aux);
        System.out.printf("Fila de espigas insertada a Fila %s con éxito\n", fila_selecionada + 1);
    }


    private void testgetFichas() {
        if (filas.size() == 0) {
            System.out.println("Debes crear una Fila antes");
            return;
        }
        ArrayList<Integer> fichas;
        fichas = filas.get(fila_selecionada).getFichas();
        if (fichas.size() == 0) {
            System.out.println("Fila de fichas aun no insertada");
            return;
        }
        for (int i = 0; i < fichas.size(); ++i) {
            int index = fichas.get(i);
            System.out.printf(index + " ");
        }
        System.out.printf("\n");
    }


    private void testgetEspigas() {
        if (filas.size() == 0) {
            System.out.println("Debes crear una Fila antes");
            return;
        }
        ArrayList<Integer> espigas;
        espigas = filas.get(fila_selecionada).getEspigas();

        if (espigas.get(0) == -1) {
            System.out.println("Fila de espigas aun no insertada/creada");
            return;
        }
        for (int i = 0; i < espigas.size(); ++i) {
            System.out.printf("%s ", espigas.get(i));
        }
        System.out.printf("\n");
    }

    private void testcomprobarFila_y_modFila() {
        Scanner reader = new Scanner(System.in);
        if (filas.size() == 0) {
            System.out.println("Debes crear una Fila antes");
            return;
        }
        if (filas.get(fila_selecionada).getFichas().size() == 0) {
            System.out.println("Fila de fichas aun no insertada");
            return;
        }
        if (filas.get(fila_selecionada).getEspigas().get(0) != -1) {
            System.out.println("Espigas ya creadas, crea una nueva Fila para poder insertar unas nuevas");
            return;
        }
        if (filas.get(fila_selecionada).getFichas().size() == 0) {
            System.out.println("Fila de fichas aun no creada, debes crear una antes para poderla comprar con el codigo del Code Maker");
            return;
        }
        System.out.printf("Elige %s colores mediante un valor del 0-5 en forma de Code Maker {azul, marron, rojo, naranja, verde, amarillo}, cada numero separado de 1 espacio\n",filas.get(fila_selecionada).getSize());
        ArrayList<Integer> fichas_aux = new ArrayList<>();
        for (int i = 0; i < filas.get(fila_selecionada).getSize(); ++i) {
            fichas_aux.add(reader.nextInt());
        }
        boolean cert = filas.get(fila_selecionada).comprobarFilayCrearEspigas(fichas_aux);
        testgetEspigas();
        if (cert) System.out.println("coinciden todas, CODIGO OCULTO DESCUBIERTO");
        else System.out.println("no coinciden todas, CODIGO OCULTO AUN NO DESCUBIERTO");
    }

    private void testgetNegras() {
        if (filas.size() == 0) {
            System.out.println("Debes crear una Fila antes");
            return;
        }
        System.out.printf("Espigas negras: %s\n",filas.get(fila_selecionada).getNegras());
    }

    private void testgetBlancas() {
        if (filas.size() == 0) {
            System.out.println("Debes crear una Fila antes");
            return;
        }
        System.out.printf("Espigas blancas: %s\n",filas.get(fila_selecionada).getBlancas());
    }

    private void menuFilas() {
        System.out.println("*********************************");
        System.out.println("Selecciona una función");
        System.out.println("-----Funciones a probar de la clase Fila-----");
        System.out.println("1 Crear Fila_estandar");
        System.out.println("2 Crear Fila con dificultad");
        System.out.println("3 Insertar Fila de Fichas");
        System.out.println("4 Insertar Fila de Espigas");
        System.out.println("5 Get Fila de Fichas ");
        System.out.println("6 Get Fila de Espigas ");
        System.out.println("7 Comprobar Fila con el codigo a descubrir que le pasamos(Set Espigas automatico)");
        System.out.println("8 Get nº Espigas negras");
        System.out.println("9 Get nº Espigas blancas");
        System.out.println("-----Funciones exclusivas del Test-----");
        System.out.println("10 Cambiar Fila seleccionada");
        System.out.println("11 Salir");
        System.out.println("*********************************");
    }


    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        DriverFila prueba = new DriverFila();

        System.out.println("INICIO DEL TEST");
        prueba.menuFilas();
        int opcion = reader.nextInt();
        while (opcion != 11) {
            switch (opcion) {
                case 1:
                    prueba.testConstructor_estandar();
                    break;

                case 2:
                    System.out.println("Que dificultad quieres?\n"+"1: Facil(3 valores a descubrir)\n"+"2: Normal(4 valores a descubrir)\n"+"3: Dificil(5 valores a descubrir)\n");
                    int dificultad = reader.nextInt();
                    prueba.testConstructor(dificultad);
                    break;

                case 3:
                    prueba.testSetFila_fichas();
                    break;

                case 4:
                    prueba.testsetEspigas();
                    break;

                case 5:
                    prueba.testgetFichas();
                    break;

                case 6:
                    prueba.testgetEspigas();
                    break;

                case 7:
                    prueba.testcomprobarFila_y_modFila();
                    break;

                case 8:
                    prueba.testgetNegras();
                    break;

                case 9:
                    prueba.testgetBlancas();
                    break;

                case 10:
                    prueba.escoger_fila();

            }
            prueba.menuFilas();
            opcion = reader.nextInt();
        }
        System.out.println("Test Finalizado");
    }
}

