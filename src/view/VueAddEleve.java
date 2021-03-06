/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerEtablissement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import model.Classe;
import model.Niveau;

/**
 *
 * @author flemoal
 */
public class VueAddEleve extends javax.swing.JDialog {

    private DefaultComboBoxModel listeNumero, listeNiveau;
    private ControllerEtablissement ce;

    /**
     * Creates new form VueAddEleve
     */
    public VueAddEleve(JFrame parent, ControllerEtablissement ce) {
        super(parent, true);
        this.ce = ce;
        this.listeNiveau = new DefaultComboBoxModel();
        this.listeNumero = new DefaultComboBoxModel();

        initComponents();
        this.fillJCBNiveau();
        this.fillJCBNumero();

        getRootPane().setDefaultButton(jButtonAdd);

        setLocationRelativeTo(parent);
    }

    private void fillJCBNiveau() {
        this.listeNiveau.removeAllElements();
        Classe cPrev = null;
        for (Classe cCurr : ce.getEtablissement().getClasses()) {
            if (cPrev == null || cCurr.getNiveau() != cPrev.getNiveau()) {
                this.listeNiveau.addElement(cCurr.getNiveau());
            }

            cPrev = cCurr;
        }
    }

    private void fillJCBNumero() {
        this.listeNumero.removeAllElements();
        Niveau n = (Niveau) this.jCBNiveau.getSelectedItem();

        for (Classe c : ce.getEtablissement().getClasses()) {
            if (c.getNiveau().compareTo(n) == 0) {
                this.listeNumero.addElement(c.getNumero());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFNom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTFPrenom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCBNiveau = new javax.swing.JComboBox();
        jCBNumero = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jButtonCancel = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajout d'un élève");
        setResizable(false);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Nom :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.8;
        jPanel1.add(jTFNom, gridBagConstraints);

        jLabel2.setText("Prénom :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jTFPrenom, gridBagConstraints);

        jLabel3.setText("Niveau et groupe :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabel3, gridBagConstraints);

        jCBNiveau.setModel(this.listeNiveau);
        jCBNiveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBNiveauActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        jPanel1.add(jCBNiveau, gridBagConstraints);

        jCBNumero.setModel(this.listeNumero);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        jPanel1.add(jCBNumero, gridBagConstraints);

        jButtonCancel.setText("Annuler");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonCancel);

        jButtonAdd.setText("Ajouter");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAdd);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jCBNiveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBNiveauActionPerformed
        this.fillJCBNumero();
    }//GEN-LAST:event_jCBNiveauActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        this.ce.addEleve(this, jTFNom.getText(), jTFPrenom.getText(),
                (Niveau) jCBNiveau.getSelectedItem(), (int) jCBNumero.getSelectedItem());
    }//GEN-LAST:event_jButtonAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JComboBox jCBNiveau;
    private javax.swing.JComboBox jCBNumero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTFNom;
    private javax.swing.JTextField jTFPrenom;
    // End of variables declaration//GEN-END:variables
}
