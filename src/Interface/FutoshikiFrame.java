
package Interface;


import algorithmes.Backtracking;
import algorithmes.Graph;
import algorithmes.SET;
import algorithmes.ST;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.Integer.max;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.paint.LinearGradient;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Rabab
 */
public class FutoshikiFrame extends javax.swing.JFrame {

    private static int dimTotal;    //Dimension total de la grille(valeurs + contraintes)
    private static JTextField[][] grilleTotal; //valeurs + contraintes
    private static int dimension; // Dimension choisie par le joueur (4, 5, 6, 7, 8)
    private static int [][] values; // Les valeurs
    private static char [][] contraintesHoriz;//Grille des contraintes horizontales : < et >
    private static char [][] contraintesVert; //Grille des contraintes verticales : ^ et v
    ST<String, String> config;
    
    public FutoshikiFrame() {
        java.awt.event.ActionEvent evt = null;
        initComponents();
        this.getContentPane().setBackground(new Color(0, 210, 211));
        this.setIconImage(Toolkit.getDefaultToolkit()
                .getImage(FutoshikiFrame.class.getResource("/Icon/futoshiki.png")));
        jouerBtnActionPerformed(evt);       
    }
    //Retourne les valeurs de la grille
    public int[][] getValues(){
        return this.values;
    }
    //Retourne les contraintes horizontales
    public char [][] getContraintesHoriz()
    {
        return this.contraintesHoriz;
    }
    //Retourne les contraintes verticales
    public char [][] getContraintesVert()
    {
        return this.contraintesVert;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jouerBtn = new javax.swing.JButton();
        dimensionCmb = new javax.swing.JComboBox<>();
        gamePanel = new javax.swing.JPanel();
        solutionBtn = new javax.swing.JButton();
        difficulteCmb = new javax.swing.JComboBox<>();
        ameliorationsCmb = new javax.swing.JComboBox<>();
        verifierBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        durreExecLbl = new javax.swing.JLabel();
        remplirBtn = new javax.swing.JButton();
        restartBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Futoshiki");
        setBackground(new java.awt.Color(146, 240, 240));

        jouerBtn.setBackground(new java.awt.Color(255, 226, 106));
        jouerBtn.setFont(new java.awt.Font("Calibri", 1, 17)); // NOI18N
        jouerBtn.setText("Jouer");
        jouerBtn.setToolTipText("Commencer le jeu");
        jouerBtn.setMaximumSize(new java.awt.Dimension(59, 30));
        jouerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jouerBtnActionPerformed(evt);
            }
        });

        dimensionCmb.setBackground(new java.awt.Color(255, 204, 0));
        dimensionCmb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dimensionCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4x4", "5x5", "6x6", "7x7", "8x8" }));
        dimensionCmb.setMinimumSize(new java.awt.Dimension(43, 23));
        dimensionCmb.setPreferredSize(new java.awt.Dimension(43, 30));
        dimensionCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dimensionCmbActionPerformed(evt);
            }
        });

        gamePanel.setBackground(new Color(0, 210, 211));
        gamePanel.setAlignmentX(50.0F);
        gamePanel.setPreferredSize(new java.awt.Dimension(800, 800));

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );

        solutionBtn.setBackground(new java.awt.Color(255, 153, 255));
        solutionBtn.setFont(new java.awt.Font("Calibri", 1, 17)); // NOI18N
        solutionBtn.setText("Solution");
        solutionBtn.setToolTipText("Afficher la solution");
        solutionBtn.setPreferredSize(new java.awt.Dimension(147, 39));
        solutionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solutionBtnActionPerformed(evt);
            }
        });

        difficulteCmb.setBackground(new java.awt.Color(255, 204, 0));
        difficulteCmb.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        difficulteCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "facile", "normal", "difficile" }));
        difficulteCmb.setPreferredSize(new java.awt.Dimension(58, 30));

        ameliorationsCmb.setBackground(new java.awt.Color(255, 204, 0));
        ameliorationsCmb.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        ameliorationsCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Backtracking simple", "MRV", "FC", "AC1", "LCV" }));
        ameliorationsCmb.setPreferredSize(new java.awt.Dimension(117, 30));

        verifierBtn.setBackground(new java.awt.Color(255, 153, 255));
        verifierBtn.setFont(new java.awt.Font("Calibri", 1, 17)); // NOI18N
        verifierBtn.setText("Vérifier solution");
        verifierBtn.setToolTipText("Vérifier votre solution");
        verifierBtn.setPreferredSize(new java.awt.Dimension(147, 39));
        verifierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifierBtnActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 0, 204));
        jLabel1.setFont(new java.awt.Font("Calibri", 3, 38)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 204));
        jLabel1.setText("Futoshiki");

        durreExecLbl.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        remplirBtn.setBackground(new java.awt.Color(255, 153, 255));
        remplirBtn.setFont(new java.awt.Font("Calibri", 1, 17)); // NOI18N
        remplirBtn.setText("Remplir une case");
        remplirBtn.setToolTipText("Remplir une case");
        remplirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remplirBtnActionPerformed(evt);
            }
        });

        restartBtn.setBackground(new java.awt.Color(255, 153, 255));
        restartBtn.setFont(new java.awt.Font("Calibri", 1, 17)); // NOI18N
        restartBtn.setText("Recommencer");
        restartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(dimensionCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ameliorationsCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(difficulteCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jouerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(durreExecLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(restartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(solutionBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(verifierBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(remplirBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(25, 25, 25)
                        .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dimensionCmb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(difficulteCmb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jouerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ameliorationsCmb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(verifierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(solutionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(remplirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(restartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(durreExecLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jouerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouerBtnActionPerformed
        durreExecLbl.setText("");
        config = null;
        // On récupère le choix du ComboBox
        int index = dimensionCmb.getSelectedIndex();        
        switch (index) {
            case 0:
                dimension = 4;
                break;
            case 1:
                dimension = 5;
                break;
            case 2:
                dimension = 6;
                break;
            case 3:
                dimension = 7;
                break;
            case 4:
                dimension = 8;
                break;
            default:
                break;              
        }
      
        this.dimTotal = dimension * 2 - 1;
        grilleTotal = new JTextField[dimTotal][dimTotal];
        values = new int[dimension][dimension];
        contraintesHoriz = new char[dimension][dimension - 1];
        contraintesVert = new char[dimension - 1][dimension];
        
        // On efface le panel avant de créer une nouvlle grille
        gamePanel.removeAll();
        gamePanel.repaint();
        
        //La position de la grille 
        switch(dimension) {
            case 4:
                gamePanel.setPreferredSize(new Dimension(300 , 310));
                this.add(gamePanel, BorderLayout.CENTER);
                this.setPreferredSize(new Dimension(550, 430));
                this.pack();
                break;
            case 5:
                gamePanel.setSize(new Dimension(gamePanel.getWidth() +100 , gamePanel.getHeight()+100));
                this.add(gamePanel, BorderLayout.CENTER);
                this.setPreferredSize(new Dimension(620, 490));
                this.pack();
                break;
            case 6:
                gamePanel.setSize(new Dimension(gamePanel.getWidth() +100 , gamePanel.getHeight()+700));
                this.add(gamePanel, BorderLayout.CENTER);
                this.setPreferredSize(new Dimension(700 , 580));
                this.pack();
                break;
            case 7:
                gamePanel.setSize(new Dimension(gamePanel.getWidth() +200 , gamePanel.getHeight()+700));
                this.add(gamePanel, BorderLayout.CENTER);
                this.setPreferredSize(new Dimension(770 , 650));
                this.pack();
                break;
            case 8:
                gamePanel.setSize(new Dimension(gamePanel.getWidth() +200 , gamePanel.getHeight()+800));
                this.add(gamePanel, BorderLayout.CENTER);
                this.setPreferredSize(new Dimension(850 , 720));
                this.pack();
                break; 
        }
        
        //On positionne le JTextField des nombres et contraintes dans la grille
        for (int i = 0; i < dimTotal ; i++) {
            for (int j = 0; j < dimTotal ; j++) {
                
                grilleTotal[i][j] = new JTextField();
                grilleTotal[i][j].setHorizontalAlignment(JTextField.CENTER);
                gamePanel.add(grilleTotal[i][j]);
                
                if (i % 2 == 0 && j % 2 == 0) {
                     //la position des JTextField des nombres
                    grilleTotal[i][j].setBounds(j * 40 , i * 40 , 50 , 50);
                    grilleTotal[i][j].setFont(new Font("", Font.BOLD, 20));
                    
                    JTextField textField = grilleTotal[i][j];
                    // Listener sur chaque case des valeurs pour vérifier la valeur saisie dans la case 
                    grilleTotal[i][j].addKeyListener(new KeyAdapter() {
                         public void keyTyped(KeyEvent e) {
                             char ch = e.getKeyChar();
                             // Si la valeur est < à 0 ou > à la valeur maximale 
                             if(((ch < '1') || (ch > (char)(dimension+'0'))) && (ch != KeyEvent.VK_BACK_SPACE))
                                textField.setForeground(Color.magenta);
                             else
                                textField.setForeground(Color.black);
                        }
                    });
                } else {
                    //la position des JTextField des contraintes
                    grilleTotal[i][j].setBounds(j * 40 + 10 , i * 40 + 10 , 30 , 30);
                    grilleTotal[i][j].setFont(new Font("", Font.PLAIN, 24));
                    grilleTotal[i][j].setBackground(new Color(0, 210, 211));
                    grilleTotal[i][j].setEditable(false);
                    grilleTotal[i][j].setBorder(null);
                }
                if (i % 2 != 0 && j % 2 != 0)
                    grilleTotal[i][j].setVisible(false);               
            }           
        }           
        //Remplissage des contraintes
        switch(dimension) {
            case 4:
                if(difficulteCmb.getSelectedIndex() == 0)
                {
                    grilleTotal[0][1].setText("<");
                    grilleTotal[1][4].setText("^");
                    grilleTotal[1][6].setText("^");
                    grilleTotal[6][1].setText("<");
                    grilleTotal[5][6].setText("^");
                    grilleTotal[6][6].setText("2");
                }
                if(difficulteCmb.getSelectedIndex() == 1)
                {
                    grilleTotal[0][2].setText("3");
                    grilleTotal[1][4].setText("v");
                    grilleTotal[3][4].setText("v");
                    grilleTotal[3][6].setText("v");
                    grilleTotal[5][0].setText("^");
                    grilleTotal[6][5].setText(">");
                }
                if(difficulteCmb.getSelectedIndex() == 2)
                {
                    grilleTotal[0][0].setText("3");
                    grilleTotal[0][6].setText("1");
                    grilleTotal[3][2].setText("^");
                    grilleTotal[3][4].setText("^");
                    grilleTotal[6][5].setText(">");
                }
                break;
            case 5:
                if(difficulteCmb.getSelectedIndex() == 0)
                {
                    grilleTotal[0][3].setText(">");
                    grilleTotal[0][7].setText("<");
                    grilleTotal[4][3].setText(">");
                    grilleTotal[5][4].setText("v");
                    grilleTotal[6][0].setText("4");
                    grilleTotal[6][5].setText(">");
                    grilleTotal[8][1].setText(">");
                    grilleTotal[8][2].setText("3");
                }
                if(difficulteCmb.getSelectedIndex() == 1)
                {
                    grilleTotal[0][0].setText("3");
                    grilleTotal[0][1].setText(">");
                    grilleTotal[2][1].setText("<");
                    grilleTotal[3][8].setText("v");
                    grilleTotal[4][5].setText(">");
                    grilleTotal[5][6].setText("v");
                    grilleTotal[6][2].setText("1");
                    grilleTotal[8][7].setText(">");
                    grilleTotal[8][8].setText("3");
                }
                if(difficulteCmb.getSelectedIndex() == 2)
                {
                    grilleTotal[0][1].setText("<");
                    grilleTotal[0][6].setText("2");
                    grilleTotal[2][3].setText(">");
                    grilleTotal[3][4].setText("v");
                    grilleTotal[4][1].setText(">");
                    grilleTotal[6][1].setText(">");
                    grilleTotal[6][5].setText("<");
                    grilleTotal[6][8].setText("4");
                    grilleTotal[7][4].setText("v");
                    grilleTotal[8][5].setText("<");
                }
                break;
            case 6:
                if(difficulteCmb.getSelectedIndex() == 0)
                {
                    grilleTotal[0][5].setText(">");
                    grilleTotal[0][6].setText("4");
                    grilleTotal[1][2].setText("^");
                    grilleTotal[1][10].setText("^");
                    grilleTotal[3][2].setText("v");
                    grilleTotal[4][7].setText(">");
                    grilleTotal[4][9].setText(">");
                    grilleTotal[5][6].setText("^");
                    grilleTotal[6][1].setText(">");
                    grilleTotal[6][9].setText(">");
                    grilleTotal[7][10].setText("v");
                    grilleTotal[8][7].setText(">");
                    grilleTotal[8][9].setText(">");
                    grilleTotal[9][2].setText("^");
                    grilleTotal[10][5].setText("<");
                    grilleTotal[10][9].setText(">");
                }
                if(difficulteCmb.getSelectedIndex() == 1) 
                {
                    grilleTotal[1][0].setText("v");
                    grilleTotal[2][2].setText("4");
                    grilleTotal[2][3].setText("<");
                    grilleTotal[2][9].setText(">");
                    grilleTotal[4][0].setText("4");
                    grilleTotal[4][1].setText(">");
                    grilleTotal[4][4].setText("1");
                    grilleTotal[5][2].setText("v");
                    grilleTotal[5][8].setText("^");
                    grilleTotal[6][0].setText("6");
                    grilleTotal[6][7].setText("<");
                    grilleTotal[7][8].setText("^");
                    grilleTotal[8][9].setText("<");
                    grilleTotal[10][1].setText(">");
                    grilleTotal[10][10].setText("2");
                }
                if(difficulteCmb.getSelectedIndex() == 2)
                {
                    grilleTotal[1][0].setText("v");
                    grilleTotal[1][6].setText("^");
                    grilleTotal[2][5].setText("<");
                    grilleTotal[3][2].setText("v");
                    grilleTotal[3][8].setText("^");
                    grilleTotal[4][9].setText(">");
                    grilleTotal[5][2].setText("v");
                    grilleTotal[5][4].setText("^");
                    grilleTotal[5][8].setText("^");
                    grilleTotal[6][5].setText("<");
                    grilleTotal[7][2].setText("v");
                    grilleTotal[8][5].setText("<");
                    grilleTotal[8][9].setText(">");
                    grilleTotal[9][0].setText("v");
                    grilleTotal[9][8].setText("^");
                    grilleTotal[10][0].setText("5");
                    grilleTotal[10][6].setText("1");
                    grilleTotal[10][9].setText(">");
                }
                break;
            case 7:
                if(difficulteCmb.getSelectedIndex() == 0)
                {
                    grilleTotal[0][0].setText("6");
                    grilleTotal[0][1].setText(">");
                    grilleTotal[1][2].setText("v");
                    grilleTotal[1][10].setText("v");
                    grilleTotal[2][1].setText("<");
                    grilleTotal[2][3].setText(">");
                    grilleTotal[2][11].setText(">");
                    grilleTotal[3][2].setText("v");
                    grilleTotal[3][6].setText("v");
                    grilleTotal[4][4].setText("5");
                    grilleTotal[5][8].setText("^");
                    grilleTotal[5][12].setText("v");
                    grilleTotal[6][7].setText(">");
                    grilleTotal[8][8].setText("3");
                    grilleTotal[9][10].setText("v");
                    grilleTotal[10][1].setText(">");
                    grilleTotal[10][4].setText("3");
                    grilleTotal[10][6].setText("7");
                    grilleTotal[10][9].setText(">");
                    grilleTotal[11][0].setText("v");
                    grilleTotal[11][4].setText("v");
                    grilleTotal[11][8].setText("^");
                    grilleTotal[11][10].setText("v");
                }
                if(difficulteCmb.getSelectedIndex() == 1)
                {
                    grilleTotal[0][9].setText("<");
                    grilleTotal[2][4].setText("2");
                    grilleTotal[2][9].setText("<");
                    grilleTotal[3][0].setText("^");
                    grilleTotal[3][2].setText("^");
                    grilleTotal[3][4].setText("v");
                    grilleTotal[6][2].setText("6");
                    grilleTotal[6][3].setText("<");
                    grilleTotal[6][7].setText("<");
                    grilleTotal[6][11].setText("<");
                    grilleTotal[7][0].setText("v");
                    grilleTotal[7][2].setText("^");
                    grilleTotal[8][7].setText("<");
                    grilleTotal[8][8].setText("5");
                    grilleTotal[8][9].setText(">");
                    grilleTotal[10][0].setText("4");
                    grilleTotal[10][1].setText("<");
                    grilleTotal[10][5].setText(">");
                    grilleTotal[10][11].setText("<");
                    grilleTotal[12][0].setText("5");
                    grilleTotal[12][4].setText("3");
                    grilleTotal[12][9].setText("<");
                }
                if(difficulteCmb.getSelectedIndex() == 2)
                {
                    grilleTotal[0][8].setText("4");
                    grilleTotal[0][11].setText(">");
                    grilleTotal[0][12].setText("3");
                    grilleTotal[1][2].setText("v");
                    grilleTotal[1][4].setText("v");
                    grilleTotal[1][6].setText("^");
                    grilleTotal[3][0].setText("^");
                    grilleTotal[3][2].setText("v");
                    grilleTotal[4][2].setText("3");
                    grilleTotal[4][5].setText("<");
                    grilleTotal[4][11].setText(">");
                    grilleTotal[4][12].setText("2");
                    grilleTotal[5][4].setText("v");
                    grilleTotal[6][1].setText("<");
                    grilleTotal[6][6].setText("1");
                    grilleTotal[6][10].setText("3");
                    grilleTotal[8][9].setText("<");
                    grilleTotal[9][4].setText("v");
                    grilleTotal[9][6].setText("^");
                    grilleTotal[9][8].setText("^");
                    grilleTotal[10][2].setText("5");
                    grilleTotal[12][5].setText(">");
                    grilleTotal[12][6].setText("4");
                    grilleTotal[12][9].setText("<");
                    grilleTotal[12][11].setText("<");
                }
                break;
            case 8:
                if(difficulteCmb.getSelectedIndex() == 0)
                {
                    grilleTotal[0][0].setText("6");
                    grilleTotal[0][1].setText(">");
                    grilleTotal[0][5].setText(">");
                    grilleTotal[1][4].setText("^");
                    grilleTotal[1][6].setText("^");
                    grilleTotal[2][9].setText(">");
                    grilleTotal[3][0].setText("v");
                    grilleTotal[3][8].setText("^");
                    grilleTotal[4][1].setText("<");
                    grilleTotal[4][3].setText("<");
                    grilleTotal[4][7].setText(">");
                    grilleTotal[4][11].setText(">");
                    grilleTotal[4][13].setText("<");
                    grilleTotal[5][0].setText("v");
                    grilleTotal[7][14].setText("^");
                    grilleTotal[8][1].setText(">");
                    grilleTotal[8][3].setText("<");
                    grilleTotal[8][7].setText(">");
                    grilleTotal[9][8].setText("v");
                    grilleTotal[9][10].setText("v");
                    grilleTotal[10][5].setText(">");
                    grilleTotal[10][10].setText("3");
                    grilleTotal[10][13].setText(">");
                    grilleTotal[11][2].setText("^");
                    grilleTotal[11][6].setText("v");
                    grilleTotal[11][12].setText("^");
                    grilleTotal[12][3].setText(">");
                    grilleTotal[12][7].setText(">");
                    grilleTotal[12][12].setText("5");
                    grilleTotal[13][2].setText("^");
                    grilleTotal[13][12].setText("v");
                    grilleTotal[14][0].setText("3");
                    grilleTotal[14][2].setText("5");
                    grilleTotal[14][3].setText(">");
                    grilleTotal[14][5].setText(">");
                    grilleTotal[14][9].setText("<");
                    grilleTotal[14][10].setText("7");
                }
                if(difficulteCmb.getSelectedIndex() == 1)
                {
                    grilleTotal[0][3].setText("<");
                    grilleTotal[0][5].setText("<");
                    grilleTotal[0][6].setText("6");
                    grilleTotal[0][9].setText(">");
                    grilleTotal[0][12].setText("2");
                    grilleTotal[1][0].setText("^");
                    grilleTotal[1][8].setText("^");
                    grilleTotal[1][12].setText("v");
                    grilleTotal[2][4].setText("6");
                    grilleTotal[2][5].setText(">");
                    grilleTotal[2][9].setText("<");
                    grilleTotal[4][5].setText(">");
                    grilleTotal[4][11].setText(">");
                    grilleTotal[5][10].setText("^");
                    grilleTotal[5][12].setText("v");
                    grilleTotal[6][3].setText(">");
                    grilleTotal[6][7].setText(">");
                    grilleTotal[7][0].setText("v");
                    grilleTotal[7][2].setText("v");
                    grilleTotal[7][8].setText("^");
                    grilleTotal[7][14].setText("v");
                    grilleTotal[8][3].setText(">");
                    grilleTotal[8][9].setText("<");
                    grilleTotal[9][0].setText("v");
                    grilleTotal[9][14].setText("^");
                    grilleTotal[10][1].setText("<");
                    grilleTotal[11][4].setText("v");
                    grilleTotal[12][9].setText("<");
                    grilleTotal[13][6].setText("v");
                    grilleTotal[13][12].setText("^");
                    grilleTotal[14][1].setText("<");
                    grilleTotal[14][3].setText("<");
                    grilleTotal[14][10].setText("2");
                    grilleTotal[14][12].setText("5");
                    grilleTotal[14][13].setText(">");
                }
                if(difficulteCmb.getSelectedIndex() == 2)
                {
                    grilleTotal[0][3].setText("<");
                    grilleTotal[0][5].setText("<");
                    grilleTotal[0][6].setText("6");
                    grilleTotal[0][9].setText(">");
                    grilleTotal[0][12].setText("2");
                    grilleTotal[1][0].setText("^");
                    grilleTotal[1][8].setText("^");
                    grilleTotal[2][4].setText("6");
                    grilleTotal[2][5].setText(">");
                    grilleTotal[2][9].setText("<");
                    grilleTotal[4][5].setText(">");
                    grilleTotal[4][11].setText(">");
                    grilleTotal[5][10].setText("^");
                    grilleTotal[5][12].setText("v");
                    grilleTotal[6][3].setText(">");
                    grilleTotal[6][7].setText(">");
                    grilleTotal[7][0].setText("v");
                    grilleTotal[7][2].setText("v");
                    grilleTotal[7][8].setText("^");
                    grilleTotal[7][14].setText("v");
                    grilleTotal[8][3].setText(">");
                    grilleTotal[8][9].setText("<");
                    grilleTotal[9][0].setText("v");
                    grilleTotal[9][14].setText("^");
                    grilleTotal[10][1].setText("<");
                    grilleTotal[11][4].setText("v");
                    grilleTotal[12][9].setText("<");
                    grilleTotal[13][6].setText("v");
                    grilleTotal[13][12].setText("^");
                    grilleTotal[14][1].setText("<");
                    grilleTotal[14][3].setText("<");
                    grilleTotal[14][10].setText("2");
                    grilleTotal[14][12].setText("5");
                    grilleTotal[14][13].setText(">");
                }
                break;
        }
        solutionBtn.setEnabled(true);
        verifierBtn.setEnabled(true);
        remplirBtn.setEnabled(true);
    }//GEN-LAST:event_jouerBtnActionPerformed

    //Méthode qui récupère les valeurs et les contraintes de la grille  
    public boolean getGridElements(JTextField [][] MyGrid)
    {
        // Initialisation des valeurs et des contraintes 
        values = new int[dimension][dimension];
        contraintesHoriz = new char[dimension][dimension - 1];
        contraintesVert = new char[dimension - 1][dimension];
        
        //On récupère et on vérifie ce qui est inséré dans la case 
        for(int i = 0; i < dimTotal; i++)
        {
            for(int j = 0; j < dimTotal; j++)
            {
                //Si la grille n'est pas vide
                if(!MyGrid[i][j].getText().equals(""))
                {
                    //Si cette case contient un nombre
                    if(i % 2 == 0 && j % 2 == 0)
                    {
                        try {
                            //On récupère le nombre dans la case
                            int val = Integer.parseInt(MyGrid[i][j].getText());
                            values[i/2][j/2] = val;
                        }
                        catch(NumberFormatException ex) {
                            ex.printStackTrace();
                            return false;
                        }
                    }
                    //Si cette case contient une contrainte horizontale(< et >)
                    else if(i % 2 == 0 && j % 2 != 0)
                    {
                        char contrHoriz = MyGrid[i][j].getText().charAt(0);
                        //On récupère la contrainte dans la case
                        contraintesHoriz[i/2][(j-1)/2] = contrHoriz;
                    }
                    //Si cette case contient une contrainte verticale(^ et v)
                    else if(i % 2 != 0 && j % 2 == 0)
                    {
                        char contrVert = MyGrid[i][j].getText().charAt(0);
                        contraintesVert[(i-1)/2][j/2] = contrVert;
                    }
                }
            }
        }
        return true;
    }
    
    private void solution(){
       Graph G = new Graph();     
        config = new ST<String, String>();    
        // On récupère le type de la variante choisie
        int typeVariante = ameliorationsCmb.getSelectedIndex();
        
        switch(typeVariante)
        {
            case 0: //Backtracking Simple
                Backtracking.withDEGREES = false;
                Backtracking.withMRV = false;
                Backtracking.withAC1 = false;
                Backtracking.withFC = false;
                Backtracking.withLCV = false;
                break;
            case 1: // MRV
                Backtracking.withMRV = true;
                Backtracking.withDEGREES = false;
                Backtracking.withAC1 = false;
                Backtracking.withFC = false;
                Backtracking.withLCV = false;
                break;
            case 2: // FC
                Backtracking.withFC = true;
                Backtracking.withAC1 = false;
                Backtracking.withDEGREES = false;
                Backtracking.withMRV = false;
                Backtracking.withLCV = false;
                break;
            case 3: // AC1
                Backtracking.withAC1 = true;
                Backtracking.withFC = false;
                Backtracking.withDEGREES = false;
                Backtracking.withMRV = false;
                Backtracking.withLCV = false;
                break;
            case 4: // LCV
                Backtracking.withLCV = true;
                Backtracking.withAC1 = false;
                Backtracking.withFC = false;
                Backtracking.withDEGREES = false;
                Backtracking.withMRV = false;
                break;
        }
        
        //On vérifie si les éléments de la grille sont récupérés
        if(getGridElements(grilleTotal))
        {
            //Contraintes des lignes 
            for(int i = 0; i < dimension; i++) // Ligne
            {
                for(int j = 0; j < dimension - 1; j++) // Colonne
                {
                    for(int k = j + 1; k < dimension; k++)
                    {
                        String val1 = "x" + i + "" + j;
                        String val2 = "x" + i + "" + k;
                        //System.out.println(val1 + "  " + val2);
                        G.addEdge(val1, val2);
                    }
                }
            }
            // Contraintes des colonnes 
            for(int i = 0; i < dimension; i++){ // Colonne
                for(int j = 0; j < dimension; j++){ // Ligne
                    for(int k = j + 1; k < dimension; k++){
                        String val1 = "x" + j + "" + i;
                        String val2 = "x" + k + "" + i;
                        //System.out.println(val1 + "  " + val2);
                        G.addEdge(val1, val2);
                    }
                    // Contraintes verticale
                    if(i < dimension - 1 && (contraintesVert[i][j] == '^' || contraintesVert[i][j] == 'v')){
                        //System.out.println("Contraites vert : " + i + "," + j + " = " + contraintesVert[i][j]);
                        
                        boolean cond = contraintesVert[i][j] != '^';
                        
                        String val1 = cond ? "s" + j + "" + i : "s" + j + "" + (i+1);
                        String val2 = cond ? "x" + j + "" + (i+1) : "x" + j + "" + i;
                        
                        G.addEdge(val2, val1);
                        
                        val1 = val1.replace("s", "x");
                        val2 = val2.replace("x","i");
                        
                        G.addEdge(val1, val2);
                    }
                    // Contraintes horizontales
                    if(j < dimension - 1 && (contraintesHoriz[i][j] == '<' || contraintesHoriz[i][j] == '>')){
                        //System.out.println("Contraites horiz : " + i + "," + j + " = " + contraintesHoriz[i][j]);

                        boolean cond = contraintesHoriz[i][j] == '<';
                        
                        String val1 = cond ? "s" + (j+1) + "" + i : "s" + j + "" + i;
                        String val2 = cond ? "x" + j + "" + i : "x" + (j+1) + "" + i;
                        
                        G.addEdge(val2, val1);
                        
                        val1 = val1.replace("s", "x");
                        val2 = val2.replace("x","i");
                        
                        G.addEdge(val1, val2);
                    }
                }
            }
            
            // Table des domaines
            ST<String, SET<String>> domainTable = new ST<String, SET<String>>();
            // Remplissage des domaines
            Object[][] domains = new Object[dimension][dimension];
            // Initialisation des domaines
            for(int i = 0; i < dimension; i++) // Colonne
            {
                for(int j = 0; j < dimension; j++) // Ligne
                {
                    domains[i][j] = new SET<String>();
                }
            }
            // Remplir les domaines 
            for(int i = 0; i < dimension; i++) // Colonne
            {
                for(int j = 0; j < dimension; j++) // Ligne
                {
                    if(values[i][j] != 0)
                    {
                        // Domaine avec une seule valeur si la case est remplie
                        ((SET<String>)domains[i][j]).add(new String(String.valueOf(values[i][j]))); 
                    }
                    else
                    {
                        for(int k = 1; k <= dimension; k++)
                        {
                            ((SET<String>)domains[i][j]).add(""+k);
                        }
                    }
                }
            }
            // Ajout des domaines à la table 
            for(int i = 0; i < dimension; i++) 
            {
                for(int j = 0; j < dimension; j++)
                {
                    domainTable.put("x"+i+""+j, ((SET<String>)domains[i][j]));
                }
            }
            // Affichage des domaines de chaque cellule 
            System.out.println("\nLa table des domaines est : ");
            Set<String> keys = (Set<String>) domainTable.getST().keySet();
            for(String key : keys)
            {
                System.out.println("Le domaine de " + key + " est: " + domainTable.getST().get(key));
            }
            
            for(int i = 0; i < dimension; i++) // Ligne 
            {
                for(int j = 0; j < dimension; j++) // Colonne
                {
                    config.put("x"+i+""+j,""); // Variables non affectées
                }
            }
            System.out.println("Calcul de la solution en cours ...");
            //  Appliquer l'algorithme du Backtracking pour calculer le solution 
            Backtracking backtracking = new Backtracking(this);
            System.out.println("Constraints: ");
            System.out.println("-------------- Graph ---------------");
            System.out.println(G);
            ST<String, String> result = backtracking.backtracking(config, domainTable, G);
        }
        else
            System.out.println("Erreur de récupération des éléments de la grille !");         
   }
    
    private void solutionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solutionBtnActionPerformed
        jouerBtnActionPerformed(evt);
        long tempsDebut = System.currentTimeMillis();
        
        solution();
            //  Affichage de la solution 
            for(int i = 0; i < dimension; i++) // Ligne
            { 
                System.out.println("");    
                for(int j = 0; j < dimension; j++) // Colonne
                {
                    if(config.get("x"+j+""+i) != null){
                        
                        grilleTotal[i*2][j*2].setText(config.get("x"+j+""+i));
                        grilleTotal[i*2][j*2].setEditable(false);
                        
                        System.out.print(config.get("x"+i+""+j)+" ");
                    }
                }
            }
                    
            gamePanel.repaint();
        
        long tempsFin = System.currentTimeMillis();
        float seconds = (tempsFin - tempsDebut) / 1000F;
        durreExecLbl.setText("Exécuté en : "+ Float.toString(seconds) + " secondes.");
        
        solutionBtn.setEnabled(false);
        verifierBtn.setEnabled(false);
        remplirBtn.setEnabled(false);
    }//GEN-LAST:event_solutionBtnActionPerformed

    public boolean verifContraintes(){
        //On récupère les éléments de la grille
        getGridElements(grilleTotal);
        // Vérification des contraintes entre colonnes et lignes 
        for(int i = 0; i < dimension; i++)
        {
            for(int j = 0; j < dimension; j++)
            {
                int val = values[i][j];
                if(val != 0) // Si la cellule contient un nombre
                {
                    // Vérification des valeurs insérées(ne doivent pas être < à 1 ou > dimension) 
                    if(val < 1 || val > dimension)
                    {
                        JOptionPane.showMessageDialog(null, "La valeur " + val + " insérée dans la cellule "
                                + "[" + i + ", " + j + "] n'appartient pas au domaine des valeurs possibles !");
                        return false;
                    }
                    // On vérifie si la valeur est doublée dans la meme colonne 
                    for(int row = 0; row < dimension; row++)
                    {
                        if(row != i) // Pour ne pas comparer avec la même cellule
                        {
                            if(val == values[row][j]) // Si on trouve une cellule contenant la même valeur
                            {
                                JOptionPane.showMessageDialog(null, "La valeur de la cellule [" + (i+1) + ", " + (j+1) + "] "
                                        + "est doublé dans cette colonne (la cellule [" + (row+1) + ", " + (j+1) + "]) !");
                                return false;
                            }
                        }
                    }
                    // On vérifie si la valeur est doublée dans la meme ligne 
                    for(int col = 0; col < dimension; col++)
                    {
                        if(col != j) // Pour ne pas comparer avec la même cellule
                        {
                            if(val == values[i][col]) // Si on trouve un cellule contenant la même valeur
                            {
                                JOptionPane.showMessageDialog(null, "La valeur de la cellule [" + (i+1) + ", " + (j+1) + "] "
                                        + "est doublé dans cette ligne (la cellule [" + (i+1) + ", " + (col+1) + "]) !");
                                return false;
                            }
                        }
                    }
                    // Vérification des signes entre les cellules horizontales : > et < 
//                    //Comparaison de la valeur avec la valeur à gauche 
                    if(j != 0) //  j >= 1
                    {
                        if(contraintesHoriz[i][j - 1] != ' ') // Si la case contient un signe
                        {
                            if(values[i][j - 1] != 0) // Si la case à gauche contient un nombre
                            {
                                switch(contraintesHoriz[i][j - 1]) // Deux cas : '<' et '>'
                                {
                                    case '>':
                                        if(values[i][j - 1] < val) // Si la valeur est inférieure à la valeur à gauche
                                        {
                                            JOptionPane.showMessageDialog(null, "La valeur " + val + " est > à la valeur " 
                                                    + values[i][j-1] + "\n (cellule [" + (i*2+1) + ", " + (j*2+2) + "] "
                                                            + "et [" + (i*2+1) + ", " + (j*2+1) + "]) !");
                                            return false;
                                        }
                                        break;
                                    case '<':
                                        if(values[i][j - 1] > val) // Si la valeur est supérieure à la cellule à gauche
                                        {
                                            JOptionPane.showMessageDialog(null, "La valeur " + val + " est < à la valeur " 
                                                    + values[i][j-1] + "\n (cellule [" + (i*2+1) + ", " + (j*2+2) + "] "
                                                            + "et [" + (i*2+1) + ", " + (j*2+1) + "]) !");
                                            return false;
                                        }
                                        break;
                                }
                            }
                        }
                    }
                    //Comparaison de la valeur avec la valeur à droite 
                    if(j != dimension - 1) // Puisque la grille des contraintes horizontales est de nbre de colonne = dimension - 1
                    {
                        if(contraintesHoriz[i][j] != ' ') // Si la case contient un signe
                        {
                            if(values[i][j + 1] != 0) // Si la case à droite contient un nombre
                            {
                                switch(contraintesHoriz[i][j]) // Deux cas : '<' et '>'
                                {
                                    case '>':
                                        if(values[i][j + 1] > val) // Si la valeur est inférieure à la cellule à droite
                                        {
                                            JOptionPane.showMessageDialog(null, "La valeur " + val + 
                                                    " est < à la valeur " + values[i*2][j*2+1] + 
                                                    "\n (cellule [" + (i*2+1) + ", " + (j*2+2) + "] "
                                                            + "et [" + (i*2+1) + ", " + (j*2+1) + "]) !");
                                            return false;
                                        }
                                        break;
                                    case '<':
                                        if(values[i][j + 1] < val) // Si la valeur est supérieure à la cellule à droite
                                        {
                                            JOptionPane.showMessageDialog(null, "La valeur " + val + " est > à la valeur " + values[i][j+1] + "\n (cellule [" + (i+1) + ", " + (j+1) + "] et [" + (i+1) + ", " + (j) + "]) !");
                                            return false;
                                        }
                                        break;
                                }
                            }
                        }
                    }
                    //Vérification des signes entre les cellules verticales : ^ et v
//                    //Comparaison de la valeur avec la valeur en haut
                    if(i != 0) // i >= 1
                    {
                        if(contraintesVert[i - 1][j] != ' ') // Si la case contient un signe
                        {
                            if(values[i - 1][j] != 0) // Si la case en haut contient un nombre
                            {
                                switch(contraintesVert[i - 1][j]) // Deux cas : '^' et 'v'
                                {
                                    case '^':
                                        if(values[i - 1][j] > val) // Si la valeur est inférieure à la cellule en haut
                                        {
                                            JOptionPane.showMessageDialog(null, "La valeur " + val + " est < à la valeur " + values[i - 1][j] + "\n (cellule [" + (i+1) + ", " + (j+1) + "] et [" + (i) + ", " + (j+1) + "]) !");
                                            return false;
                                        }
                                        break;
                                    case 'v':
                                        if(values[i - 1][j] < val) // Si la valeur est supérieure à la cellule en haut
                                        {
                                            JOptionPane.showMessageDialog(null, "La valeur " + val + " est > à la valeur " + values[i - 1][j] + "\n (cellule [" + (i+1) + ", " + (j+1) + "] et [" + (i) + ", " + (j+1) + "]) !");
                                            return false;
                                        }
                                        break;
                                }
                            }
                        }
                    }
                    //Comparaison de la valeur avec la valeur en haut
                    if(i != dimension - 1) //  ligne = dimension - 1
                    {
                        if(contraintesVert[i][j] != ' ') // Si la case contient un signe
                        {
                            if(values[i + 1][j] != 0) // Si la case en bas contient un nombre
                            {
                                switch(contraintesVert[i][j]) // Deux cas : '⋀' et '⋁'
                                {
                                    case '^':
                                        if(values[i + 1][j] < val) // Si la valeur est supérieure à la cellule en bas
                                        {
                                            JOptionPane.showMessageDialog(null, "La valeur " + val + " est > à la valeur " + values[i + 1][j] + "\n (cellule [" + (i+1) + ", " + (j+1) + "] et [" + (i) + ", " + (j+1) + "]) !");
                                            return false;
                                        }
                                        break;
                                    case 'v':
                                        if(values[i + 1][j] > val) // Si la valeur est inférieure à la cellule en bas
                                        {
                                            JOptionPane.showMessageDialog(null, "La valeur " + val + " est < à la valeur " + values[i + 1][j] + "\n (cellule [" + (i+1) + ", " + (j+1) + "] et [" + (i) + ", " + (j+1) + "]) !");
                                            return false;
                                        }
                                        break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    private void dimensionCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dimensionCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dimensionCmbActionPerformed

    private void verifierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifierBtnActionPerformed
        getGridElements(grilleTotal);
        for(int i = 0; i < dimension ; i++)
        {
            for(int j = 0; j < dimension ; j++)
            {   
                if(values[i][j] == 0) // Si on a des cases vides
                {
                    JOptionPane.showMessageDialog(null, "Tu n'as pas terminé"
                                         + "\nIl y'a encore des cases vides !");
                    System.out.println("Tu n'as pas terminé !");
                    return;
                } 
            }
        }
        if(verifContraintes()) // Si les contraintes sont vérifiées
        {
            JOptionPane.showMessageDialog(null, "Aucune erreur "
                                            + "\nFélicitations :)");
            System.out.println("Aucune d'erreur !");
            return;
        }
        else
        {
            System.out.println("Erreur !");
            return;
        }
    }//GEN-LAST:event_verifierBtnActionPerformed
    
    private void remplirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remplirBtnActionPerformed
        if(config == null)
            solution();
 
        int randomNum1 = ThreadLocalRandom.current().nextInt(0, dimension);
        int randomNum2 = ThreadLocalRandom.current().nextInt(0, dimension);

        //System.out.println(randomNum1+"  "+randomNum2+ "     "+config.get("x"+randomNum1+""+randomNum2) );

        if(config.get("x"+randomNum1+""+randomNum2) != null){

            grilleTotal[randomNum1*2][randomNum2*2].setText(config.get("x"+randomNum1+""+randomNum2));
            grilleTotal[randomNum1*2][randomNum2*2].setEditable(false);
        }
    }//GEN-LAST:event_remplirBtnActionPerformed

    private void restartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartBtnActionPerformed
        jouerBtnActionPerformed(evt);
    }//GEN-LAST:event_restartBtnActionPerformed
 
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
                  
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FutoshikiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FutoshikiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FutoshikiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FutoshikiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FutoshikiFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ameliorationsCmb;
    private javax.swing.JComboBox<String> difficulteCmb;
    private javax.swing.JComboBox<String> dimensionCmb;
    private javax.swing.JLabel durreExecLbl;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jouerBtn;
    private javax.swing.JButton remplirBtn;
    private javax.swing.JButton restartBtn;
    private javax.swing.JButton solutionBtn;
    private javax.swing.JButton verifierBtn;
    // End of variables declaration//GEN-END:variables
}
