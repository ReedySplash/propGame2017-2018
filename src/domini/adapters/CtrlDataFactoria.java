package domini.adapters;

import dades.*;

/*Autor Carlos Alvarado*/
public class CtrlDataFactoria {
    private static CtrlDataFactoria ourInstance = new CtrlDataFactoria();
    private IControladorDatos ctrlJugador;
    private IControladorDatos ctrlPartida;
    private IControladorDatos ctrlRankingFacil;
    private IControladorDatos ctrlRankingNormal;
    private IControladorDatos ctrlRankingDificil;

    public static CtrlDataFactoria getInstance() {
        return ourInstance;
    }

    private CtrlDataFactoria() {
        ctrlJugador = new CtrlJugador();
        ctrlPartida = new CtrlPartida();
        ctrlRankingFacil = new CtrlRankingFacil();
        ctrlRankingNormal = new CtrlRankingNormal();
        ctrlRankingDificil = new CtrlRankingDificil();
    }

    public IControladorDatos getControladorJugador() {
        return ctrlJugador;
    }

    public IControladorDatos getControladorPartida() { return ctrlPartida; }

    public IControladorDatos getControladorRankingFacil() { return ctrlRankingFacil; }

    public IControladorDatos getControladorRankingNormal() { return ctrlRankingNormal; }

    public IControladorDatos getControladorRankingDificil() { return ctrlRankingDificil;}
}
