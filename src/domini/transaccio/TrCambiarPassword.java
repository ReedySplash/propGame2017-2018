package domini.transaccio;

import domini.adapters.CtrlDataFactoria;
import domini.model.Jugador;

public class TrCambiarPassword  extends Transaccio {

    private String usuario;
    private String password;
    private String nombre;
    private String newPassword;

    public TrCambiarPassword(String usuario) throws Exception {
        CtrlDataFactoria FactoriaDatos = CtrlDataFactoria.getInstance();
        Jugador aux  = (Jugador)FactoriaDatos.getControladorJugador().get(usuario);
        this.usuario = usuario;
        password = aux.getPassw();
        nombre = aux.getNombre();
    }
    @Override
    public void GuardarNuevosDatos(String NewPassword) throws Exception {
        this.newPassword = NewPassword;
    }

    @Override
    public void execute() throws Exception {
        CtrlDataFactoria FactoriaDatos = CtrlDataFactoria.getInstance();
        Jugador aux = (Jugador)FactoriaDatos.getControladorJugador().get(usuario);
        if(!aux.cambiarPassword(usuario,aux.getPassw(),newPassword)) {
            throw new Exception("Fallo al cambiar la contraseña, intenta de nuevo");
        }
        FactoriaDatos.getControladorJugador().borrar(usuario);
        FactoriaDatos.getControladorJugador().guardar(aux);
    }

    @Override
    public String getPassword () {
        return password;
    }

    @Override
    public String getNomb () {
        return nombre;
    }
}
