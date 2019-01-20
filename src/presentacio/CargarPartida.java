package presentacio;

import domini.model.Partida;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CargarPartida extends JPanel {
    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private ControladorPresentacion presentacion;
    private JFrame frame;
    private String[] partidas_guardadas;
    // End of variables declaration


    public CargarPartida(ControladorPresentacion presentacion, JFrame frame, List<String> partidas_guardadas) {
        this.partidas_guardadas = new String[partidas_guardadas.size()];
        for (int i = 0; i < partidas_guardadas.size(); ++i) {
            this.partidas_guardadas[i] =partidas_guardadas.get(i);
        }
        this.presentacion = presentacion;
        this.frame = frame;
        initComponents();
    }


    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jButton3 = new javax.swing.JButton();
        jList1 = new javax.swing.JList<>();
        jButton1.setText("Borrar Partida");
        jButton1.setName(""); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        jButton2.setText("Cargar Partida");
        jButton2.setName(""); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton2ActionPerformed(evt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = partidas_guardadas;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );

        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                                .addComponent(jButton2)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addContainerGap())
        );
    }/// </editor-fold>


    public void setOn() {
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = miPantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;
        frame.setBounds(anchoPantalla/4,alturaPantalla/4,anchoPantalla/2,alturaPantalla/2);
        //frame.setLocation(720,390);
        Image miIcono = miPantalla.getImage("datos" + File.separator + "iconos" + File.separator + "mind.jpg");
        frame.setIconImage(miIcono);
        frame.setResizable(false);
        frame.setContentPane(this);
        frame.pack();
        frame.setVisible(true);
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        presentacion.VentanaInsideMenu("");
    }


    private void jButton2ActionPerformed(ActionEvent evt) throws Exception {
        if (!jList1.isSelectionEmpty()) presentacion.CargarPartida(jList1.getSelectedValue());
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        if (!jList1.isSelectionEmpty()) {
            int n = JOptionPane.showConfirmDialog(null, "Estas seguro de que quieres borrar la partida","Borrar Partida",JOptionPane.YES_NO_OPTION);
            if(n == 0) {
                String partidaBorrada  = jList1.getSelectedValue();
                presentacion.BorrarPartida(partidaBorrada);
            }
        }
    }
}


