package presentacio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FiltroRanking {


    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JLabel jLabel1;
    private java.awt.Label label1;
    private javax.swing.JPanel FiltroRank;
    private JFrame frame;
    private ControladorPresentacion presentacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private List<String> rank_list;


    public FiltroRanking(ControladorPresentacion presentacion, JFrame frame) {
        this.presentacion = presentacion;
        this.frame = frame;
        initComponents();

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea1.setText("");
                presentacion.VentanaInsideMenu("");
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea1.setText("");
                if (jRadioButton2.isSelected() && jRadioButton1.isSelected()) JOptionPane.showMessageDialog(null,"SELECCIONA SOLO 1 TIPO DE FILTRO");
                else {
                    //Por Partida
                    if (jRadioButton1.isSelected()) {
                        try {
                            rank_list = presentacion.FilrarRanking_Partida(jComboBox1.getSelectedIndex()+1,0);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        for (int i = 0; i < rank_list.size(); ++i) {
                             jTextArea1.append(rank_list.get(i));
                             jTextArea1.append("\n");
                         }
                    }
                    //Por Jugador
                    if (jRadioButton2.isSelected()) {
                        try {
                            rank_list = presentacion.FilrarRanking_Partida(jComboBox1.getSelectedIndex()+1,1);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        for (int i = 0; i < rank_list.size(); ++i) {
                            jTextArea1.append(rank_list.get(i));
                            jTextArea1.append("\n");
                        }

                    }
                }
            }
        });

        jRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jRadioButton2.isSelected() && jRadioButton1.isSelected()) jRadioButton2.setSelected(false);
            }
        });

        jRadioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jRadioButton2.isSelected() && jRadioButton1.isSelected()) jRadioButton1.setSelected(false);
            }
        });
    }

    public void run() {
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = miPantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;
        this.frame.setBounds(anchoPantalla/4,alturaPantalla/4,anchoPantalla/2,alturaPantalla/2);        //frame.setLocation(720,390);
        Image miIcono = miPantalla.getImage("datos" + File.separator + "iconos" + File.separator + "mind.jpg");
        this.frame.setIconImage(miIcono);
        this.frame.setResizable(false);
        this.frame.setContentPane(FiltroRank);
        this.frame.pack();
        this.frame.setVisible(true);
    }


    private void initComponents() {


        label1 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        FiltroRank = new JPanel();

        label1.setFont(new java.awt.Font("Eras Bold ITC", 1, 18)); // NOI18N
        label1.setText("Filtro de Rankings");

        jButton1.setText("Volver");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Facil", "Normal", "Dificil" }));

        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Por Partida");

        jRadioButton2.setText("Por Jugador");

        jButton2.setText("Mostrar");


        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Dificultad:");

        jTextArea1.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(FiltroRank);
        FiltroRank.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jRadioButton1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                                                .addComponent(jRadioButton2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(1, 1, 1)
                                                                                .addComponent(jLabel1)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jRadioButton1)
                                                        .addComponent(jRadioButton2))
                                                .addGap(27, 27, 27)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1))
                                                .addGap(42, 42, 42)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(28, Short.MAX_VALUE))
        );
    }

}

