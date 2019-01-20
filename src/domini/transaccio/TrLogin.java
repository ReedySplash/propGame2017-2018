package domini.transaccio;

import domini.adapters.CtrlDataFactoria;
import domini.model.Jugador;

import javax.swing.*;

public class TrLogin extends Transaccio {
    private String usuario;
    private String pass;
    public boolean LoginProducido;


    public TrLogin(String usuario, String pass) {
        this.usuario = usuario;
        this.pass = pass;
    }
    @Override
    public void execute() throws Exception {
        LoginProducido = false;
        try
        {

            if (usuario.length() == 0 || pass.length() == 0) JOptionPane.showMessageDialog(null,"DEBES PONER TU USUARIO Y CONTRASEÑA");
            else {
                CtrlDataFactoria factor = CtrlDataFactoria.getInstance();
                if (factor.getControladorJugador().exists(usuario)) {
                    Jugador aux = (Jugador) factor.getControladorJugador().get(usuario);
                    if (!aux.esLogin(usuario, pass)) {
                        JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA");
                    }
                    else {
                        LoginProducido = true;
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "USUARIO INCORRECTO");
                }
            }
        }
        catch (Exception e)
        {
            throw new Exception(e);
        }

    }

    @Override
    public boolean loginProducido() {
        return LoginProducido;
    }

}
