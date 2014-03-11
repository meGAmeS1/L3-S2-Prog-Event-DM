/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerEtablissement;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import model.Classe;
import model.Enseignant;
import model.Matiere;

/**
 *
 * @author flemoal
 */
public class MyTreeCellRenderer extends DefaultTreeCellRenderer {

    private ControllerEtablissement ce;
    private Enseignant ens;

    public MyTreeCellRenderer(ControllerEtablissement ce, Enseignant ens) {
        super();
        this.ce = ce;
        this.ens = ens;
    }

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
//        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        setFont(new Font("Lucida Grande", Font.PLAIN, 12));
        Object userObject = ((DefaultMutableTreeNode) value).getUserObject();

        if (userObject instanceof Classe) {
            if (((Classe) userObject).getProfesseurPrincipal().equals(ens)) {
                renderInBold();
            } else {
                renderDefault();
            }
        } else if (userObject instanceof Matiere) {
            if (((Matiere) userObject).equals(ens.getMatiere())) {
                renderInRed();
            } else {
                renderDefault();
            }
        } else {
            renderDefault();
        }

        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        return this;
    }

    private void renderDefault() {
        this.setTextNonSelectionColor(Color.BLACK);
        this.setTextSelectionColor(Color.BLACK);
        setFont(getFont().deriveFont(Font.PLAIN));
    }

    private void renderInBold() {
        this.setTextNonSelectionColor(Color.BLACK);
        this.setTextSelectionColor(Color.BLACK);
        setFont(getFont().deriveFont(Font.BOLD));
    }

    private void renderInRed() {
        Color red = new Color(150, 35, 55);
        this.setTextNonSelectionColor(red);
        this.setTextSelectionColor(red);
        setFont(getFont().deriveFont(Font.PLAIN));
    }
}
