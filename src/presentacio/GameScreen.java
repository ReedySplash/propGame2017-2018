package presentacio;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

public class GameScreen {
    private JFrame frame_inside;
    private JPanel guess;
    private JPanel leftPanel;
    private Integer nRows = 0;
    private Integer guessSize = 0;
    private boolean userIsCodeBreaker;
    private ArrayList<Integer> currentGuess = new ArrayList<>();
    private ArrayList<Color> colors = new ArrayList<Color>(){{
        add(Color.BLUE);
        add(Color.PINK);
        add(Color.RED);
        add(Color.ORANGE);
        add(Color.GREEN);
        add(Color.YELLOW);
    }};

    private ControladorPresentacion presentacion;
    private int dif;
    private String id;
    private GameScreen thisGS;

    String [] botones2 = {"Guardar y Salir", "Borrar y Salir", "Reanudar"};

    Object [] botones = {"Guardar y Salir", "Borrar y Salir", "Reanudar"};

    public GameScreen(ControladorPresentacion presentacion, JFrame frame , int dif, String id, boolean codebreaker) {
        this.presentacion = presentacion;
        frame_inside = frame;
        this.dif = dif;
        this.id = id;
        this.userIsCodeBreaker = codebreaker;
        thisGS = this;
    }

    public void start_GameScreen() {
        JPanel pantalla = new JPanel(new BorderLayout());
        pantalla.setPreferredSize(new Dimension(675, 500));

        //Draw right panel (colors panel, guess panel, submit button and clear guess button)
        JPanel rightPanel = new JPanel(new BorderLayout());
        //rightPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
        rightPanel.setPreferredSize(new Dimension(250, 800));
        pantalla.add(rightPanel, BorderLayout.EAST);

        //draw colors panel
        JPanel fichas = new JPanel();
        //fichas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fichas.setPreferredSize(new Dimension(250, 150));
        rightPanel.add(fichas, BorderLayout.NORTH);

        newBola(colors.get(0), fichas, new Dimension(60, 60), true);
        newBola(colors.get(1), fichas, new Dimension(60, 60), true);
        newBola(colors.get(2), fichas, new Dimension(60, 60), true);
        newBola(colors.get(3), fichas, new Dimension(60, 60), true);
        newBola(colors.get(4), fichas, new Dimension(60, 60), true);
        newBola(colors.get(5), fichas, new Dimension(60, 60), true);

        //draw guess/code panel
        guess = new JPanel();
        if (userIsCodeBreaker)
            guess.setBorder(BorderFactory.createTitledBorder("Guess"));
        else
            guess.setBorder(BorderFactory.createTitledBorder("Code"));
        guess.setPreferredSize(new Dimension(80, 100));
        rightPanel.add(guess, BorderLayout.CENTER);

        //draw clear button
        Button clear = new Button();
        if (userIsCodeBreaker)
            clear.setLabel("Clear guess");
        else
            clear.setLabel("Clear code");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guess.removeAll();
                guess.repaint();
                guessSize = 0;
                currentGuess.clear();
            }
        });

        //create exit button
        Button Salir = new Button();
        if(!userIsCodeBreaker) Salir.setLabel("Salir");
        else {Salir.setLabel("Salir/Pausar");}
        Salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guess.removeAll();
                guess.repaint();
                guessSize = 0;
                currentGuess.clear();
                int n = -1;
                if (userIsCodeBreaker)
                    n = JOptionPane.showOptionDialog(null, "Partida Pausada: ¿Que quieres hacer?", "Partida Pausada", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null,botones2,botones[0]);
                if (!userIsCodeBreaker || n == 1) {
                    try {
                        presentacion.BorrarPartida_Actual(id, dif);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                if (!userIsCodeBreaker || n == 1 || n == 0) presentacion.VentanaInsideMenu("");
            }
        });

        //create submit button
        Button submit  = new Button();
        if (userIsCodeBreaker)
            submit.setLabel("Submit Guess");
        else
            submit.setLabel("Submit Code");
        if (userIsCodeBreaker) {
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((guessSize == 3 && dif == 1) || (guessSize == 4 && dif == 2) || (guessSize == 5 && dif == 3)) {
                        ArrayList<Integer> Espigas = new ArrayList<>(2);
                        try {
                            Espigas = presentacion.CalculaEspigas(currentGuess, id);
                            try {
                                newRow(currentGuess, Espigas.get(1), Espigas.get(0));
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        guess.removeAll();
                        guess.repaint();
                        guessSize = 0;
                        currentGuess.clear();
                    } else
                        JOptionPane.showMessageDialog(null,"Intento mal introducido");
                }
            });
        } else {
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((guessSize == 3 && dif == 1) || (guessSize == 4 && dif == 2) || (guessSize == 5 && dif == 3)) {
                        try {
                            leftPanel.removeAll();
                            leftPanel.repaint();
                            presentacion.TurnoMaquina(currentGuess, thisGS, id);
                            guess.removeAll();
                            guess.repaint();
                            guessSize = 0;
                            currentGuess.clear();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"Codigo mal introducido");
                    }
                }
            });
        }

        //create buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 3));
        //buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        buttonsPanel.setPreferredSize(new Dimension(280, 280));
        buttonsPanel.add(clear, BorderLayout.NORTH);
        buttonsPanel.add(submit, BorderLayout.CENTER);
        buttonsPanel.add(Salir, BorderLayout.SOUTH);


        //add buttons panel to right panel
        rightPanel.add(buttonsPanel, BorderLayout.SOUTH);

        //Draw left panel
        leftPanel = new JPanel(new FlowLayout());
        //leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        leftPanel.setPreferredSize(new Dimension(425, 2500));
        leftPanel.setMaximumSize(new Dimension(600, 2500));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getViewport().add(leftPanel);

        pantalla.add(scrollPane, BorderLayout.WEST);

        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = miPantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;
        frame_inside.setBounds(anchoPantalla/4,alturaPantalla/4,anchoPantalla/2,alturaPantalla/2);
        //frame.setLocation(720,390);


        Image miIcono = miPantalla.getImage("datos" + File.separator + "iconos" + File.separator + "mind.jpg");
        frame_inside.setIconImage(miIcono);
        frame_inside.setResizable(false);
        frame_inside.setContentPane(pantalla);
        frame_inside.pack();
        frame_inside.setVisible(true);
    }

    private FichaGUI newBola(Color color, JPanel parent, Dimension dimension, boolean clickable) {
        FichaGUI f = new FichaGUI(color, dimension);
        if (clickable) {
            f.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                    if ((guessSize < 3 && dif == 1) || (guessSize < 4 && dif == 2) || (guessSize < 5 && dif == 3)) {
                        newBola(color, guess, new Dimension(40, 40), false);
                        ++guessSize;
                        if (color == Color.BLUE)
                            currentGuess.add(0);
                        else if (color == Color.PINK)
                            currentGuess.add(1);
                        else if (color == Color.RED)
                            currentGuess.add(2);
                        else if (color == Color.ORANGE)
                            currentGuess.add(3);
                        else if (color == Color.GREEN)
                            currentGuess.add(4);
                        else if (color == Color.YELLOW)
                            currentGuess.add(5);
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
        }
        parent.add(f, BorderLayout.WEST);
        frame_inside.pack();
        return f;
    }

    private JPanel newRow(ArrayList<Integer> fichas, Integer black, Integer white) throws Exception {
        ++nRows;
        JPanel row = new JPanel();
        //row.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        row.setPreferredSize(new Dimension(375, 80));

        newBola(colors.get(fichas.get(0)), row, new Dimension(45, 45), false);
        newBola(colors.get(fichas.get(1)), row, new Dimension(45, 45), false);
        newBola(colors.get(fichas.get(2)), row, new Dimension(45, 45), false);

        if (dif >= 2)
            newBola(colors.get(fichas.get(3)), row, new Dimension(45, 45), false);

        if (dif == 3)
            newBola(colors.get(fichas.get(4)), row, new Dimension(45, 45), false);

        JPanel check = new JPanel();
        //check.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        check.setPreferredSize(new Dimension(50, 67));

        for (int i = 0; i < black; ++i)
            newBola(Color.BLACK, check, new Dimension(15,15), false);
        for (int i = 0; i < white; ++i)
            newBola(Color.WHITE, check, new Dimension(15,15), false);

        row.add(check, null);

        leftPanel.add(row, BorderLayout.NORTH);
        frame_inside.pack();

        if(black == 4 && dif == 2 && userIsCodeBreaker) FinalizarPartida();
        else if(black == 5 && dif == 3 && userIsCodeBreaker) FinalizarPartida();
        else if(black == 3 && dif == 1 && userIsCodeBreaker) FinalizarPartida();
        else if (nRows == 25) {
            JOptionPane.showMessageDialog(null, "Partida no superada en menos de 25 turnos, tu puntuación es de 0");
            presentacion.BorrarPartida_Actual(id, dif);
            presentacion.VentanaInsideMenu("");
        }
        return row;
    }

    private void FinalizarPartida() throws Exception {
        int puntuacion = presentacion.FinalizarPartida(id.substring(0,19));
        JOptionPane.showMessageDialog(null,"Felicidades! Has completado la partida en " + nRows + " turno/s, tu puntuacion ha sido de " + puntuacion);
        presentacion.VentanaInsideMenu("");
    }

    public void rellenar(ArrayList<ArrayList<Integer>> fichas, ArrayList<ArrayList<Integer>> espigas, int turno) {
        for(int i = 0; i < turno; ++i) {
            try {
                newRow(fichas.get(i), espigas.get(i).get(0), espigas.get(i).get(1));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
