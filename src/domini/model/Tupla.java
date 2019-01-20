package domini.model;

import java.io.Serializable;

public class Tupla implements Serializable{
    private String usuario;
    private int Puntuacio;

    public Tupla(String usuario, int puntuacio) {
        this.usuario = usuario;
        Puntuacio = puntuacio;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getPuntuacio() {
        return Puntuacio;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
