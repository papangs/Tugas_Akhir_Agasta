/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout;

import Control.Control_Alternatif;
import Control.Control_Kriteria;
import Control.Control_Main;
import Control.Control_UserAdmin;
import Control.Control_Alternatif_Kriteria;
import Control.Control_Graph;
import Control.Control_Matrix_Alternatif;
import Control.Control_Matrix_Kriteria;
import Control.Control_Perangkingan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Irawan Papang S
 */
public class Main extends javax.swing.JFrame {

    java.util.Date tglsekarang = new java.util.Date();
    private SimpleDateFormat smpdtfmt = new SimpleDateFormat("dd MMMMMMMMM yyyy", Locale.getDefault());
    private String tanggal = smpdtfmt.format(tglsekarang);

    Control_Kriteria control;
    Control_Alternatif controla;
    Control_UserAdmin controlem;
    Control_Alternatif_Kriteria controlsim;
    Control_Main controlmain;
    Control_Matrix_Kriteria controlm;
    Control_Perangkingan controlp;
    Control_Matrix_Alternatif controlal;
    Control_Graph controlg;

    Kriteria a;
    Alternatif_Kriteria b;
    Alternatif c;
    UserAdmin f;
    Matrix_Kriteria m;
    Perangkingan p;
    Matrix_Alternatif al;
    Graphh j;

    public Main() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);

        setJam();
        jLabel6.setText(tanggal);

        a = new Kriteria();
        b = new Alternatif_Kriteria();
        c = new Alternatif();
        f = new UserAdmin();
        m = new Matrix_Kriteria();
        p = new Perangkingan();
        al = new Matrix_Alternatif();
        j = new Graphh();

        control = new Control_Kriteria();
        controla = new Control_Alternatif();
        controlem = new Control_UserAdmin();
        controlsim = new Control_Alternatif_Kriteria();
        controlm = new Control_Matrix_Kriteria();
        controlp = new Control_Perangkingan();
        controlal = new Control_Matrix_Alternatif();
        controlg = new Control_Graph();

//        buttonImageReflection2.setVisible(false);
    }

    public final void setJam() {
        ActionListener taskPerformer = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                String nol_jam = "", nol_menit = "", nol_detik = "";

                java.util.Date dateTime = new java.util.Date();
                int nilai_jam = dateTime.getHours();
                int nilai_menit = dateTime.getMinutes();
                int nilai_detik = dateTime.getSeconds();

                if (nilai_jam <= 9) {
                    nol_jam = "0";
                }
                if (nilai_menit <= 9) {
                    nol_menit = "0";
                }
                if (nilai_detik <= 9) {
                    nol_detik = "0";
                }

                String jam = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = nol_detik + Integer.toString(nilai_detik);

                jLabel4.setText(jam + ":" + menit + ":" + detik + "");
            }
        };
        new javax.swing.Timer(1000, taskPerformer).start();
    }

    public void panggil(String userlogin) {
        switch (userlogin) {
            case "User":
                enable(true);

                if (!j.isVisible()) {
                    try {
                        jDesktopPanetransparan1.add(j);
                        j.show();
                        controlg.getData(j);
                        j.setClosable(false);
                        j.setMaximum(true);
                        j.setSelected(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        j.show();
                        controlg.getData(j);
                        j.setClosable(false);
                        j.setMaximum(true);
                        j.setSelected(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                break;
            case "Admin":
                enable(false);

                if (!j.isVisible()) {
                    try {
                        jDesktopPanetransparan1.add(j);
                        j.show();
                        controlg.getData(j);
                        j.setClosable(false);
                        j.setMaximum(true);
                        j.setSelected(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        j.show();
                        controlg.getData(j);
                        j.setClosable(false);
                        j.setMaximum(true);
                        j.setSelected(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case "Superadmin":
                enable(false);

                if (!j.isVisible()) {
                    try {
                        jDesktopPanetransparan1.add(j);
                        j.show();
                        controlg.getData(j);
                        j.setClosable(false);
                        j.setMaximum(true);
                        j.setSelected(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        j.show();
                        controlg.getData(j);
                        j.setClosable(false);
                        j.setMaximum(true);
                        j.setSelected(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
        }
    }

    public void enable(boolean status) {
        jMenu4.setVisible(!status);
        buttonImageReflection1.setVisible(!status);
        buttonImageReflection2.setVisible(!status);
        buttonImageReflection3.setVisible(!status);
        buttonImageReflection4.setVisible(!status);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPaneGambar1 = new Background.JDesktopPaneGambar();
        panelGlass1 = new usu.widget.glass.PanelGlass();
        buttonImageReflection1 = new usu.widget.glass.ButtonImageReflection();
        buttonImageReflection2 = new usu.widget.glass.ButtonImageReflection();
        buttonImageReflection3 = new usu.widget.glass.ButtonImageReflection();
        buttonImageReflection4 = new usu.widget.glass.ButtonImageReflection();
        buttonImageReflection5 = new usu.widget.glass.ButtonImageReflection();
        buttonImageReflection6 = new usu.widget.glass.ButtonImageReflection();
        buttonImageReflection7 = new usu.widget.glass.ButtonImageReflection();
        jSeparator4 = new javax.swing.JSeparator();
        panelGlass2 = new usu.widget.glass.PanelGlass();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelGlass4 = new usu.widget.glass.PanelGlass();
        jLabel4 = new javax.swing.JLabel();
        jDesktopPanetransparan1 = new Background.JDesktopPanetransparan();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        panelGlass3 = new usu.widget.glass.PanelGlass();
        jLabel6 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sistem Penunjang Keputusan Pemilihan VGA Gamming Terbaik Menggunakan Analytical Hierarchy Process (AHP)");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close(evt);
            }
        });

        buttonImageReflection1.setForeground(new java.awt.Color(51, 0, 51));
        buttonImageReflection1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1461876790_stock_task-assigned-to copy.png"))); // NOI18N
        buttonImageReflection1.setText("Kriteria");
        buttonImageReflection1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        buttonImageReflection1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImageReflection1ActionPerformed(evt);
            }
        });

        buttonImageReflection2.setForeground(new java.awt.Color(0, 0, 0));
        buttonImageReflection2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1465288918_Briefcase.png"))); // NOI18N
        buttonImageReflection2.setText("Alternatif Kriteria");
        buttonImageReflection2.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        buttonImageReflection2.setName(""); // NOI18N
        buttonImageReflection2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImageReflection2ActionPerformed(evt);
            }
        });

        buttonImageReflection3.setForeground(new java.awt.Color(51, 0, 51));
        buttonImageReflection3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1461997018_drive-harddisk-system.png"))); // NOI18N
        buttonImageReflection3.setText("Altefnatif");
        buttonImageReflection3.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        buttonImageReflection3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImageReflection3ActionPerformed(evt);
            }
        });

        buttonImageReflection4.setForeground(new java.awt.Color(0, 0, 0));
        buttonImageReflection4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1493405495_29.png"))); // NOI18N
        buttonImageReflection4.setText("Matrix Kriteria");
        buttonImageReflection4.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        buttonImageReflection4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImageReflection4ActionPerformed(evt);
            }
        });

        buttonImageReflection5.setForeground(new java.awt.Color(51, 0, 51));
        buttonImageReflection5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1461996712_tests.png"))); // NOI18N
        buttonImageReflection5.setText("Hasil Rangking");
        buttonImageReflection5.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        buttonImageReflection5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImageReflection5ActionPerformed(evt);
            }
        });

        buttonImageReflection6.setForeground(new java.awt.Color(0, 0, 0));
        buttonImageReflection6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1462699640_draw-path.png"))); // NOI18N
        buttonImageReflection6.setText("Matrix Alternatif");
        buttonImageReflection6.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        buttonImageReflection6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImageReflection6ActionPerformed(evt);
            }
        });

        buttonImageReflection7.setForeground(new java.awt.Color(0, 0, 0));
        buttonImageReflection7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconfinder_118770_home_icon_512px.png"))); // NOI18N
        buttonImageReflection7.setText("Home");
        buttonImageReflection7.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        buttonImageReflection7.setName(""); // NOI18N
        buttonImageReflection7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImageReflection7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGlass1Layout = new javax.swing.GroupLayout(panelGlass1);
        panelGlass1.setLayout(panelGlass1Layout);
        panelGlass1Layout.setHorizontalGroup(
            panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonImageReflection6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonImageReflection2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonImageReflection4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonImageReflection5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonImageReflection7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addComponent(buttonImageReflection1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonImageReflection3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelGlass1Layout.setVerticalGroup(
            panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonImageReflection7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonImageReflection1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonImageReflection3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonImageReflection2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonImageReflection4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonImageReflection6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonImageReflection5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SISTEM PENUNJANG KEPUTUSAN");

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PEMILIHAN VGA GAMING TERBAIK");

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MENGGUNAKAN ANALYTICAL HIERARCHY PROCESS (AHP)");

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Agasta Putra, Universitas Bhayangkara Surabaya");

        javax.swing.GroupLayout panelGlass2Layout = new javax.swing.GroupLayout(panelGlass2);
        panelGlass2.setLayout(panelGlass2Layout);
        panelGlass2Layout.setHorizontalGroup(
            panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelGlass2Layout.setVerticalGroup(
            panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(22, 22, 22))
        );

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout panelGlass4Layout = new javax.swing.GroupLayout(panelGlass4);
        panelGlass4.setLayout(panelGlass4Layout);
        panelGlass4Layout.setHorizontalGroup(
            panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelGlass4Layout.setVerticalGroup(
            panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDesktopPanetransparan1.setOpaque(false);
        jDesktopPanetransparan1.setLayout(new java.awt.BorderLayout());

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 17)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout panelGlass3Layout = new javax.swing.GroupLayout(panelGlass3);
        panelGlass3.setLayout(panelGlass3Layout);
        panelGlass3Layout.setHorizontalGroup(
            panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelGlass3Layout.setVerticalGroup(
            panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));

        jDesktopPaneGambar1.setLayer(panelGlass1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar1.setLayer(jSeparator4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar1.setLayer(panelGlass2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar1.setLayer(panelGlass4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar1.setLayer(jDesktopPanetransparan1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar1.setLayer(jSeparator5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar1.setLayer(jSeparator6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar1.setLayer(panelGlass3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar1.setLayer(jSeparator7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneGambar1Layout = new javax.swing.GroupLayout(jDesktopPaneGambar1);
        jDesktopPaneGambar1.setLayout(jDesktopPaneGambar1Layout);
        jDesktopPaneGambar1Layout.setHorizontalGroup(
            jDesktopPaneGambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneGambar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPaneGambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPaneGambar1Layout.createSequentialGroup()
                        .addGroup(jDesktopPaneGambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelGlass3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelGlass4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelGlass2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator4)
                    .addGroup(jDesktopPaneGambar1Layout.createSequentialGroup()
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDesktopPanetransparan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGlass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDesktopPaneGambar1Layout.setVerticalGroup(
            jDesktopPaneGambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneGambar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPaneGambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPaneGambar1Layout.createSequentialGroup()
                        .addGroup(jDesktopPaneGambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jDesktopPaneGambar1Layout.createSequentialGroup()
                                .addComponent(panelGlass4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelGlass3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(panelGlass2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(jDesktopPaneGambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDesktopPanetransparan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator5)
                            .addComponent(jSeparator6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelGlass1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jDesktopPaneGambar1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1496315888_button_cancel.png"))); // NOI18N
        jMenuItem9.setText("Log Out");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1493449455_Log Out.png"))); // NOI18N
        jMenuItem8.setText("Exit");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("User Admin");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/student_list.png"))); // NOI18N
        jMenuItem1.setText("Add User");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonImageReflection1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImageReflection1ActionPerformed
        // TODO add your handling code here:
        if (!a.isVisible()) {
            try {
                jDesktopPanetransparan1.add(a);
                a.show();
                control.getData(a);
                a.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                a.show();
                control.getData(a);
                a.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonImageReflection1ActionPerformed

    private void buttonImageReflection2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImageReflection2ActionPerformed
        // TODO add your handling code here:
        if (!b.isVisible()) {
            try {
                jDesktopPanetransparan1.add(b);
                b.show();
                controlsim.getData(b);
                b.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                b.show();
                controlsim.getData(b);
                b.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonImageReflection2ActionPerformed

    private void buttonImageReflection3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImageReflection3ActionPerformed
        // TODO add your handling code here:
        if (!c.isVisible()) {
            try {
                jDesktopPanetransparan1.add(c);
                controla.getData(c);
                c.show();
                c.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                controla.getData(c);
                c.show();
                c.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonImageReflection3ActionPerformed

    private void close(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_close
        // TODO add your handling code here:
        int yakin = JOptionPane.showConfirmDialog(this, "Are you Sure Exit Application ?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (yakin == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_close

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        close(null);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        int yakin = JOptionPane.showConfirmDialog(this, "Are you Sure Log Out Application ?", "Confirm", JOptionPane.YES_NO_OPTION);
        Login o = new Login();
        if (yakin == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            o.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu4MouseClicked

    private void buttonImageReflection4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImageReflection4ActionPerformed
        // TODO add your handling code here:
        if (!m.isVisible()) {
            try {
                jDesktopPanetransparan1.add(m);
                m.show();
                m.setSelected(true);
                controlm.getData(m);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                m.show();
                m.setSelected(true);
                controlm.getData(m);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonImageReflection4ActionPerformed

    private void buttonImageReflection5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImageReflection5ActionPerformed
        // TODO add your handling code here:
        if (!p.isVisible()) {
            try {
                jDesktopPanetransparan1.add(p);
                p.show();
                p.setSelected(true);
                controlp.getData(p);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                p.show();
                p.setSelected(true);
                controlp.getData(p);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonImageReflection5ActionPerformed

    private void buttonImageReflection6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImageReflection6ActionPerformed
        // TODO add your handling code here:
        if (!al.isVisible()) {
            try {
                jDesktopPanetransparan1.add(al);
                al.show();
                al.setSelected(true);
                controlal.getData(al);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                al.show();
                al.setSelected(true);
                controlal.getData(al);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonImageReflection6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if (!f.isVisible()) {
            try {
                controlem.getData(f);
                jDesktopPanetransparan1.add(f);
                controlem.getData(f);
                f.show();
                f.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                controlem.getData(f);
                f.show();
                f.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void buttonImageReflection7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImageReflection7ActionPerformed
        // TODO add your handling code here:
        if (!j.isVisible()) {
            try {
                jDesktopPanetransparan1.add(j);
                j.show();
                controlg.getData(j);
                j.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                j.show();
                controlg.getData(j);
                j.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonImageReflection7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.glass.ButtonImageReflection buttonImageReflection1;
    private usu.widget.glass.ButtonImageReflection buttonImageReflection2;
    private usu.widget.glass.ButtonImageReflection buttonImageReflection3;
    private usu.widget.glass.ButtonImageReflection buttonImageReflection4;
    private usu.widget.glass.ButtonImageReflection buttonImageReflection5;
    private usu.widget.glass.ButtonImageReflection buttonImageReflection6;
    private usu.widget.glass.ButtonImageReflection buttonImageReflection7;
    private Background.JDesktopPaneGambar jDesktopPaneGambar1;
    public Background.JDesktopPanetransparan jDesktopPanetransparan1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private usu.widget.glass.PanelGlass panelGlass1;
    private usu.widget.glass.PanelGlass panelGlass2;
    private usu.widget.glass.PanelGlass panelGlass3;
    private usu.widget.glass.PanelGlass panelGlass4;
    // End of variables declaration//GEN-END:variables

}
