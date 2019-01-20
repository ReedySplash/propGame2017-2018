//AUTOR: VICTOR MURCIANO DURAN
package domini.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Tablero implements Serializable {

    private ArrayList<Fila> filas;
    private int turno;
    private ArrayList<Integer> codigo;

    /*
    Crea una nueva instancia de la clase code.Tablero
    Pre: Le pasamos un ArrayList de code.COLOR_FICHA que es nuestro codigo de la partida ha descubrir
    Post: Crea un nuevo tablero y le asocia un valor a todos sus parametros
     */
    public Tablero(ArrayList<Integer> aux,int dificultad) {
        turno = 0;
        codigo = aux;
        filas = new ArrayList<>(25);
        for (int i = 0; i < 25; ++i) {
            Fila fila = new Fila(dificultad);
            filas.add(fila);
        }
    }

    /*
     Crea una nueva instancia de la clase code.Tablero
     Pre:
     Post: Crea un nuevo tablero y le asocia un valor a turno
    */
    public Tablero(int dificultad) {
        turno = 0;
        filas = new ArrayList<>(25);
        for (int i = 0; i < 25; ++i) {
            Fila fila = new Fila(dificultad);
            filas.add(fila);
        }
    }

    /*
    Inserta el codigo que el jugador desde la interfaz ha establecido como code maker
    Pre: Se le pasa el codigo a insertar
    Post: Le asocia el valor de aux a codigo
     */
    public void setCodigo(ArrayList<Integer> aux) {
        codigo = aux;
    }

    /*
     Añade la fila al tablero
     Pre: Se le pasa un  un ArrayList de code.COLOR_FICHA
     Post: Se le inserta a la fila de fichas del tablero del turno actual las fichas seleccionadas por el jugador o CPU
    */
    public void setFila(ArrayList<Integer> aux) {
        filas.get(turno).setFila(aux);
    }

    /*
     Añade la espiga al tablero
     Pre: Se le pasa una lista de integers
     Post: Se le inserta a la fila de espigas del tablero del turno actual las espigas que ha generado el jugador o CPU
    */
    public void setEspiga(ArrayList<Integer> list) {
        filas.get(turno).setEspiga(list);
        ++turno;
    }

    /*
     Coge la fila de espigas del turno específico
     Pre: Se le pasa el turno del que queremos la fila
     Post: Devuelve un ArrayList<code.Espiga> que contiene las espigas del turno en concreto
    */
    public ArrayList<Integer> getEspiga(int numero) {
        return filas.get(numero).getEspigas();
    }

    /*
    Coger la fila de fichas del turno específico
    Pre: Se le pasa el turno del que queremos la fila
    Post: Devuelve un ArrayList<code.Ficha> que contiene las fichas del turno en concreto, como la fila empieza a contar desde 0, el turno sera +1
    */
    public ArrayList<Integer> getFichas(int numero) {
        return filas.get(numero).getFichas();
    }

    /*
    Devuelve el turno
    Pre:
    Post: Devuelve el turno en que nos encontramos
    */
    public int getTurno() {
        return turno;
    }

    public int getBlancas(int numero) {
        return filas.get(numero).getBlancas();
    }

    public int getNegras(int numero) { return filas.get(numero).getNegras();}

    private int calcular_puntuacion() {
        int puntuacion = 260;
        for (int i = 0; i < turno; ++i) {
            puntuacion -= 10;
        }
        return puntuacion;
    }

    public int getPuntuacion() {
        return this.calcular_puntuacion();
    }

    /*
    Comprobar las fichas correctas del turno en que acabamos de insertar una fila (Para CPU)
    Pre:
    Post: Nos devuelve True si la fila que acabamos de insertar ha acertado el codigo del codemaker
    */
    public boolean comprobarFila() {
        boolean acertado = filas.get(turno).comprobarFilayCrearEspigas(codigo);
        ++turno;
        return acertado;
    }


}
