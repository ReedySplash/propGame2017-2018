package domini.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/*Autor Carlos Alvarado*/
public class Jugador implements Serializable{
    /*atributos*/
    private String nombre;
    private String usuario;//clave primaria, debe ser unica en el fichero
    private String passw;
    private int puntosAcumuladosFacil;
    private int puntosAcumuladosNormal;
    private int puntosAcumuladosDificil;
    private ArrayList<String> idPartidas;
    private int numeroPartidasGuardadas;

    /*Metodos*/

    /*Creadoras*/
    public Jugador(String nombre, String usuario, String passw) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.passw = passw;
        puntosAcumuladosFacil = 0;
        puntosAcumuladosNormal = 0;
        puntosAcumuladosDificil = 0;
        idPartidas = new ArrayList<String>();
        numeroPartidasGuardadas = idPartidas.size();
    }

    public Jugador() {super(); }

    /*Consultoras*/
    /*Post: Devuelve el nombre del jugador*/
    public String getNombre() {
        return nombre;
    }

    /*Post: Devuelve el usuario del jugador*/
    public String getUsuario() {
        return usuario;
    }

    /*Post: Devuelve la contraseña del jugador*/
    public String getPassw() {return passw;}

    /*Post: Devuelve los puntos acumulados en modo facil*/
    public int getPuntosAcumuladosFacil() {
        return puntosAcumuladosFacil;
    }

    /*Post: Devuelve los puntos acumulados en modo normal*/
    public int getPuntosAcumuladosNormal() {
        return puntosAcumuladosNormal;
    }

    /*Post: Devuelve los puntos acumulados en modo dificil*/
    public int getPuntosAcumuladosDificil() {
        return puntosAcumuladosDificil;
    }

    /*Post: Obtener el numero de partidas totales que ha registrado el jugador*/
    public int getNumeroPartidasJugadas() { return numeroPartidasGuardadas;}

    /*Obtener la lista de las partidas jugadas por el jugador*/
    /*Post: Devuelve una lista con las partidas jugadas por el jugador*/
    public List<String> getListaPartidasJugadas() { return idPartidas.subList(0,numeroPartidasGuardadas); }

    /*Modificadoras*/

    /*Post: Modifica los puntos acumulados en modo facil por el parametro puntosAcumuladosFacil */
    public void setPuntosAcumuladosFacil(int puntosAcumuladosFacil) {
        this.puntosAcumuladosFacil = puntosAcumuladosFacil;
    }

    /*Post: Modifica los puntos acumulados en modo normal por el parametro puntosAcumuladosNormal */
    public void setPuntosAcumuladosNormal(int puntosAcumuladosNormal) {
        this.puntosAcumuladosNormal = puntosAcumuladosNormal;
    }

    /*Post: Modifica los puntos acumulados en modo dificil por el parametro puntosAcumuladosDificil */
    public void setPuntosAcumuladosDificil(int puntosAcumuladosDificil) {
        this.puntosAcumuladosDificil = puntosAcumuladosDificil;
    }

    /*Modifica el nombre del jugador*/
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*Modifica el usuario del jugador*/
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /*Modifica el password del jugador por el que pasamos como parametro*/
    public void setPassword(String passw) {
        this.passw = passw;
    }

    /*Se guarda el identificador de la partida en la que participa el jugador*/
    /*Post: Se guarda la partida que pasamo por parametro*/
    public void guardaPartida(String partida, int dif) {
        String dificultad;
        if (dif == 1) dificultad = "Fácil";
        else if (dif == 2) dificultad = "Normal";
        else dificultad = "Difícil";
        idPartidas.add(String.valueOf(partida)+" "+dificultad);
        numeroPartidasGuardadas = idPartidas.size();
    }
    /*Post: Devuelve la partida con identificador i*/
    public String consultaPartida(int i) {return idPartidas.get(i);}


    /*Se borrar la partida de la lista de partidas del jugador*/
    /*Post: Si la partida esta en la lista se borra de la lista, en caso contrario la operacion no realiza nada*/
    public void borraPartida(String partida) {
        if (idPartidas.remove(partida)) numeroPartidasGuardadas = idPartidas.size();
    }
     /*Verificar si el usuario y contraseña son correctos para hacer login*/
     /*Post: Si usuario y contraseña son correcto retornamos un true, caso contrario retornamos false*/
    public boolean esLogin(String usuario, String passw) {
        if (this.usuario.equals(usuario) && this.passw.equals(passw)) return true;
        else return false;
    }

    /*Cambio de contraseña*/
    /*Post: Si el usuario y contraseña son correctos cambiamos la contraseña por el passwNou*/
    public boolean cambiarPassword(String usuari, String passwAntic, String passwNou) {
        if (esLogin(usuari, passwAntic))  {
            setPassword(passwNou);
            return true;
        }
        else return false;
    }
}
