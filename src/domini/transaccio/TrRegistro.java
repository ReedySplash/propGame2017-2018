package domini.transaccio;

import domini.adapters.CtrlDataFactoria;
import domini.model.Jugador;

import javax.swing.*;

public class TrRegistro extends Transaccio {



    private String nombre;
    private String usuari;
    private String pass;

    public TrRegistro(String nombre, String usuario, String pass) {
        this.nombre = nombre;
        this.usuari = usuario;
        this.pass = pass;
    }
    @Override
    public void execute() throws Exception {
        CtrlDataFactoria factor = CtrlDataFactoria.getInstance();
        if (factor.getControladorJugador().exists(usuari)) {
            JOptionPane.showMessageDialog(null,"NOMBRE DE USUARIO YA EN USO");
        }

        else {
            Jugador jugador = new Jugador(nombre, usuari, pass);
            factor.getControladorJugador().guardar(jugador);
            if (factor.getControladorJugador().exists(usuari)) {
                JOptionPane.showMessageDialog(null, "USUARIO REGISTRADO CORRECTAMENTE");
            } else {
                JOptionPane.showMessageDialog(null, "HA HABIDO UN ERROR EN EL REGISTRO");
            }
        }
    }

}
