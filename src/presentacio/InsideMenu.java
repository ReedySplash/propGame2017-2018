
package presentacio;


import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class InsideMenu extends javax.swing.JPanel {
    private javax.swing.JButton jugarButton;
    private javax.swing.JButton configuracionButton;
    private javax.swing.JButton cargarPartidaButton;
    private javax.swing.JButton verRankingsButton;
    private javax.swing.JButton volverButton;
    private javax.swing.JComboBox<String> comboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JList<String> list1;
    private javax.swing.JScrollPane jScrollPane1;
    private JFrame frame_inside;
    private ControladorPresentacion presentacion;



    public InsideMenu(ControladorPresentacion presentacion, JFrame frame) {
        initComponents();
        frame_inside = frame;
        this.presentacion = presentacion;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        list1 = new javax.swing.JList<>();
        jugarButton = new javax.swing.JButton();
        configuracionButton = new javax.swing.JButton();
        cargarPartidaButton = new javax.swing.JButton();
        verRankingsButton = new javax.swing.JButton();
        volverButton = new javax.swing.JButton();
        LabelUsuario = new javax.swing.JLabel();

        setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Usuario:");

        jLabel3.setText("Dificultad:");

        comboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Facil", "Normal", "Dificil" }));
        comboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        list1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Play as CodeBreaker", "Play as CodeMaker" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(list1);

        jugarButton.setText("Nueva Partida");

        configuracionButton.setText("Configuracion");

        cargarPartidaButton.setText("Cargar Partida");

        verRankingsButton.setText("Ver Rankings");

        volverButton.setText("Volver");
        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rol;
                if (list1.getSelectedIndex() == 0) rol = 0;
                else if (list1.getSelectedIndex() == 1) rol = 1;
                else rol = 2;
                try {
                    presentacion.GameScreen(LabelUsuario.getText(),rol,comboBox1.getSelectedIndex()+1);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        verRankingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presentacion.VentanaRanking();
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presentacion.start();
            }
        });
        configuracionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    presentacion.VentanaConfiguracion(LabelUsuario.getText());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        cargarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    presentacion.VentanaCargarPartida(LabelUsuario.getText());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        LabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(LabelUsuario))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(cargarPartidaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(verRankingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane1))
                                                .addGap(52, 52, 52)
                                                .addComponent(volverButton))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(configuracionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jugarButton)))
                                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(LabelUsuario))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jugarButton)
                                        .addComponent(cargarPartidaButton))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(configuracionButton)
                                        .addComponent(verRankingsButton)
                                        .addComponent(volverButton))
                                .addContainerGap())
        );
    }// </editor-fold>

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void set_on (String usuario) {
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = miPantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;
        frame_inside.setBounds(anchoPantalla/4,alturaPantalla/4,anchoPantalla/2,alturaPantalla/2);
        Image miIcono = miPantalla.getImage("datos" + File.separator + "iconos" + File.separator + "mind.jpg");
        frame_inside.setIconImage(miIcono);
        frame_inside.setResizable(false);
        frame_inside.setContentPane(this);
        if (usuario.length() != 0) LabelUsuario.setText(usuario);
        frame_inside.pack();
        frame_inside.setVisible(true);
    }


}
