/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerEtablissement;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;
import model.Classe;
import model.Eleve;
import model.Enseignant;
import model.Matiere;

/**
 *
 * @author flemoal
 */
public class VueEnseignant extends javax.swing.JFrame {

    private ControllerEtablissement ce;
    private Enseignant enseignant;

    private ClasseTableModel tableClasse;
    private MatiereTableModel tableMatiere;

    private final static YourCellRenderer cellRenderer = new YourCellRenderer("0.00");

    /**
     * Creates new form VueEnseignant
     */
    public VueEnseignant(ControllerEtablissement ce, Enseignant enseignant, JFrame parent) {
        this.ce = ce;
        this.enseignant = enseignant;
        this.tableClasse = new ClasseTableModel();
        this.tableMatiere = new MatiereTableModel();

        initComponents();

        for (int i = 0; i <= Matiere.values().length; i++) {
            this.jTableClasse.getColumnModel().getColumn(2 + i).setCellRenderer(cellRenderer);
        }

        this.jTableMatiere.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        
        this.jPanelClasse.setVisible(false);
        this.jPanelMatiere.setVisible(false);

        this.jTree1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelClasse = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableClasse = new ClasseJTable();
        jPanelMatiere = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableMatiere = new view.MatiereJTable();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFichier = new javax.swing.JMenu();
        jMenuItemDisconnect = new javax.swing.JMenuItem();
        jMenuItemQuit = new javax.swing.JMenuItem();

        jPanelClasse.setLayout(new java.awt.BorderLayout());

        jTableClasse.setAutoCreateRowSorter(true);
        jTableClasse.setModel(this.tableClasse);
        jScrollPane2.setViewportView(jTableClasse);

        jPanelClasse.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanelMatiere.setLayout(new java.awt.BorderLayout());

        jTableMatiere.setAutoCreateRowSorter(true);
        jTableMatiere.setModel(this.tableMatiere);
        jScrollPane4.setViewportView(jTableMatiere);

        jPanelMatiere.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gestions des classes - Enseignant");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jSplitPane1.setDividerLocation(150);
        jSplitPane1.setResizeWeight(0.1);

        jTree1.setModel(getTreeClasses());
        jTree1.setCellRenderer(new view.ClasseTreeCellRenderer(ce,enseignant));
        jTree1.setRootVisible(false);
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jPanel1.setLayout(new java.awt.BorderLayout());
        jSplitPane1.setRightComponent(jPanel1);

        jMenuFichier.setText("Fichier");

        jMenuItemDisconnect.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.META_MASK));
        jMenuItemDisconnect.setText("Déconnexion");
        jMenuItemDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDisconnectActionPerformed(evt);
            }
        });
        jMenuFichier.add(jMenuItemDisconnect);

        jMenuItemQuit.setText("Quitter");
        jMenuItemQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemQuitActionPerformed(evt);
            }
        });
        jMenuFichier.add(jMenuItemQuit);

        jMenuBar1.add(jMenuFichier);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemQuitActionPerformed
        this.ce.quitApp(this);
    }//GEN-LAST:event_jMenuItemQuitActionPerformed

    private void jMenuItemDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDisconnectActionPerformed
        this.ce.disconnect(this);
    }//GEN-LAST:event_jMenuItemDisconnectActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.ce.disconnect(this);
    }//GEN-LAST:event_formWindowClosing

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();

        if (node != null) {
            Object nodeInfo = node.getUserObject();

            if ((nodeInfo instanceof Classe)) {
                Classe c = (Classe) nodeInfo;

                this.tableClasse.setIsProfPrincipal(c.getProfesseurPrincipal().equals(enseignant));
                this.tableClasse.refreshWith(c.getEleves());

                this.jPanel1.removeAll();
                this.jPanel1.add(jPanelClasse, BorderLayout.CENTER);

                this.jPanelClasse.setVisible(true);
                this.jPanelMatiere.setVisible(false);
                return;
            } else if ((nodeInfo instanceof Matiere)) {
                Matiere mat = (Matiere) nodeInfo;
                DefaultMutableTreeNode nodePraent = (DefaultMutableTreeNode) node.getParent();

                if (nodePraent != null) {
                    Object nodeParentInfo = nodePraent.getUserObject();
                    if ((nodeParentInfo instanceof Classe)) {
                        Classe c = (Classe) nodeParentInfo;

                        this.tableMatiere.setIsProfOfThis(enseignant.getMatiere().equals(mat));
                        this.tableMatiere.refreshWith(c.getEleves(), mat);

                        this.jPanel1.removeAll();
                        this.jPanel1.add(jPanelMatiere, BorderLayout.CENTER);

                        this.jPanelClasse.setVisible(false);
                        this.jPanelMatiere.setVisible(true);
                        return;
                    }
                }
            }

        }
        this.jPanel1.removeAll();
    }//GEN-LAST:event_jTree1ValueChanged

    private TreeModel getTreeClasses() {
        // Racine de l'arbre
        DefaultMutableTreeNode treeRoot = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode nodeClasse;

        for (Classe c : this.ce.getEtablissement().getClasses()) {
            if (c.isMember(enseignant)) {
                nodeClasse = new DefaultMutableTreeNode(c);

                for (Enseignant e : c.getEnseignants()) {
                    // S'agissant d'un tableau il faut ignorer les éléments
                    // manquants au cas où
                    if (e == null) {
                        continue;
                    }

                    nodeClasse.add(new DefaultMutableTreeNode(e.getMatiere()));
                }

                treeRoot.add(nodeClasse);

            }
        }

        return new DefaultTreeModel(treeRoot);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFichier;
    private javax.swing.JMenuItem jMenuItemDisconnect;
    private javax.swing.JMenuItem jMenuItemQuit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelClasse;
    private javax.swing.JPanel jPanelMatiere;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTableClasse;
    private javax.swing.JTable jTableMatiere;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

    class ClasseTableModel extends AbstractTableModel {

        private TreeSet<Eleve> eleves;
        private String[] columnNames;
        private boolean isProfPrincipal;

        public ClasseTableModel() {
            List<String> columns = new ArrayList<>();
            columns.add("Nom");
            columns.add("Prénom");
            for (Matiere m : Matiere.values()) {
                columns.add(m.toString());
            }
            columns.add("Moyenne");
            columns.add("Commentaire général");

            columnNames = columns.toArray(new String[3 + Matiere.values().length]);

            this.eleves = new TreeSet<>();
            this.isProfPrincipal = false;
        }
        
        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        @Override
        public int getRowCount() {
            return eleves.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Eleve e = (Eleve) eleves.toArray()[row];
            if (col == 0) {
                return e.getNom();
            } else if (col == 1) {
                return e.getPrenom();
            } else if (col > 1 && col < 2 + Matiere.values().length) {
                return e.getNote(Matiere.values()[col - 2]);
            } else if (col == 2 + Matiere.values().length) {
                return e.getMoyenne();
            } else if (col == 3 + Matiere.values().length) {
                return e.getCommentaireGeneral();
            } else {
                return null;
            }
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        public void refreshWith(TreeSet<Eleve> eleves) {
            this.eleves = eleves;
            fireTableDataChanged();
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            if (col == 3 + Matiere.values().length) {
                return isProfPrincipal;
            } else {
                return false;
            }
        }

        public void setIsProfPrincipal(boolean isProfPrincipal) {
            this.isProfPrincipal = isProfPrincipal;
        }

        @Override
        public void setValueAt(Object value, int row, int col) {
            if (col != 3 + Matiere.values().length) {
                return;
            }

            String com = (String) value;
            Eleve e = (Eleve) eleves.toArray()[row];
            e.setCommentaireGeneral(com);
        }
    }

    class MatiereTableModel extends AbstractTableModel {

        private TreeSet<Eleve> eleves;
        private Matiere mat;
        private String[] columnNames = {"Nom", "Prénom", "Note", "Commentaire"};
        private boolean isProfOfThis;

        public MatiereTableModel() {
            this.eleves = new TreeSet<>();
            this.isProfOfThis = false;
        }

        @Override
        public int getRowCount() {
            return eleves.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Eleve e = (Eleve) eleves.toArray()[row];
            switch (col) {
                case 0:
                    return e.getNom();
                case 1:
                    return e.getPrenom();
                case 2:
                    return e.getNote(mat);
                case 3:
                    return e.getCommentaire(mat);
                default:
                    return null;
            }
        }

        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        public void setIsProfOfThis(boolean isProfOfThis) {
            this.isProfOfThis = isProfOfThis;
        }

        public void refreshWith(TreeSet<Eleve> eleves, Matiere mat) {
            this.eleves = eleves;
            this.mat = mat;
            fireTableDataChanged();
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            if (col == 2 || col == 3) {
                return isProfOfThis;
            } else {
                return false;
            }
        }

        @Override
        public void setValueAt(Object value, int row, int col) {
            if (col == 2) {
                Float note = (Float) value;
                if (note < 0 || note > 20) {
                    return;
                }
                Eleve e = (Eleve) eleves.toArray()[row];
                e.setNote(mat, note);
            } else if (col == 3) {
                String com = (String) value;
                Eleve e = (Eleve) eleves.toArray()[row];
                e.setCommentaire(mat, com);
            }

        }
    }
}
