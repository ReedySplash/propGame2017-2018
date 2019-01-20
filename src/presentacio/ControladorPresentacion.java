package presentacio;

import domini.transaccio.*;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ControladorPresentacion {
    private JFrame frame = new JFrame("Mastermind");
    //Transaccion
    private Transaccio transaccio;
    //Vistas
    private MainMenu Inicio = null;
    private Registro VRegistro = null;
    private InsideMenu InsideMenu = null;
    private FiltroRanking FiltroRank = null;
    private VentanaConfigurar Configurar = null;
    private GameScreen gamescreen = null;
    private CargarPartida cargar = null;



    public void start() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (Inicio == null) Inicio = new MainMenu(this,frame);
        Inicio.set_on();
        frame.pack();
        frame.setVisible(true);

    }


    public void VentanaRegistro() {
        if (VRegistro  == null) {
            VRegistro = new Registro(this,frame);
        }
        VRegistro.set_on();
    }

    public void VentanaInsideMenu(String usuari) {
        if (InsideMenu == null) {
            InsideMenu = new InsideMenu(this,frame);
        }
        InsideMenu.set_on(usuari);
    }

    public void VentanaRanking() {
        if (FiltroRank == null) {
            FiltroRank = new FiltroRanking(this,frame);
        }
        FiltroRank.run();
    }

    public void GameScreen(String usuario,int rol,int dificultad) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
        Date date = new Date();
        transaccio = new TrCrearPartida(dateFormat.format(date),usuario,rol,dificultad);
        transaccio.execute();
        if (rol == 0) {
            gamescreen = new GameScreen(this, this.frame, dificultad,transaccio.getId(), true);
            gamescreen.start_GameScreen();

        }
        else if (rol == 1) {
            gamescreen = new GameScreen(this, this.frame, dificultad,transaccio.getId(), false);
            gamescreen.start_GameScreen();
        }

    }

    public void VentanaConfiguracion(String usuario) throws Exception {
        transaccio = new TrCambiarPassword(usuario);
        Configurar = new VentanaConfigurar(this,frame,usuario,transaccio.getNomb(),transaccio.getPassword());

    }

    public void VentanaCargarPartida(String usuario) throws Exception {
        transaccio = new TrCargarPartidas(usuario);
        transaccio.execute();
        List<String> partidas = transaccio.getPartidas();
        cargar = new CargarPartida(this,frame,partidas);
        cargar.setOn();
    }

    public void CambiarPassword(String NewPassword) throws Exception {
        transaccio.GuardarNuevosDatos(NewPassword);
        transaccio.execute();
        JOptionPane.showMessageDialog(null,"Contraseña cambiada correctamente");
    }

    public List<String> FilrarRanking_Partida(int selectedIndex, int tipo) throws Exception {
        transaccio = new TrFiltroPartidasRanking(selectedIndex, tipo);
        transaccio.execute();
        return transaccio.getList();
    }

    public void login(String usuario, String pass) throws Exception {
        transaccio = new TrLogin(usuario,pass);
        transaccio.execute();
        if (transaccio.loginProducido()) {
            VentanaInsideMenu(usuario);
        }
    }

    public void ResgistrarUsuario(String nombre, String usuario, String pass) throws Exception {
        transaccio = new TrRegistro(nombre,usuario,pass);
        transaccio.execute();
    }

    public void TurnoMaquina(ArrayList<Integer> currentGuess, GameScreen gs, String id) throws Exception {
        String id2 = id.substring(0,19);
        transaccio = new TrTurnoMaquina(id2,currentGuess);
        transaccio.execute();
        ArrayList<ArrayList<Integer>> fichas_tablero = transaccio.getFichas_Tablero();
        ArrayList<ArrayList<Integer>> espigas_tablero = transaccio.getEspigas_Talero();
        int turno = transaccio.get_turno();
        gs.rellenar(fichas_tablero, espigas_tablero, turno);
    }

    public ArrayList<Integer> CalculaEspigas(ArrayList<Integer> currentGuess, String id) throws Exception {
        transaccio = new TrCalculaEspigas(currentGuess,id);
        transaccio.execute();
        return transaccio.getEspigas();
    }

    public int FinalizarPartida(String id) throws Exception {
        transaccio = new TrFinalizarPartida(id);
        transaccio.execute();
        return transaccio.getPuntuacion();
    }

    public void BorrarPartida(String selectedValue) throws Exception {
        transaccio = new TrBorrarPartida(selectedValue);
        transaccio.execute();
        VentanaCargarPartida(transaccio.getUsuario());
    }

    public void BorrarPartida_Actual(String id, int dif) throws Exception {
        String id_string = id;
        if (dif == 1) {
            id_string = id_string.substring(0,19) +" Fácil";
        }
        else if (dif == 2) {
            id_string = id_string.substring(0,19) +" Normal";
        }
        else {
            id_string = id_string.substring(0,19) +" Difícil";
        }
        BorrarPartida(id_string);
    }

    public void CargarPartida(String selectedValue) throws Exception {
        transaccio = new TrGetTablero(selectedValue);
        transaccio.execute();
        ArrayList<ArrayList<Integer>> fichas_tablero = transaccio.getFichas_Tablero();
        ArrayList<ArrayList<Integer>> espigas_tablero = transaccio.getEspigas_Talero();
        String id = transaccio.get_String();
        int turno = transaccio.get_turno();
        int dificultad;
        char letra = selectedValue.charAt(20);
        if (letra == 'F') {
            dificultad = 1;
        }
        else if (letra == 'N') {
            dificultad = 2;
        }
        else {
            dificultad = 3;
        }
        gamescreen = new GameScreen(this, this.frame, dificultad,id, true);
        gamescreen.start_GameScreen();
        gamescreen.rellenar(fichas_tablero,espigas_tablero,turno);
    }
}
