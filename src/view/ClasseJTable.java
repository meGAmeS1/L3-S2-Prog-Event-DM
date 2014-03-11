/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import model.Matiere;

/**
 *
 * @author flemoal
 */
public class ClasseJTable extends JTable {

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);

        //  Color row based on a cell value
        if (!isRowSelected(row)) {
            c.setBackground(getBackground());
            int modelRow = convertRowIndexToModel(row);

            Object value = getModel().getValueAt(modelRow, 2 + Matiere.values().length);

            if (value instanceof Float) {
                float moyenne = (float) value;
                c.setBackground(Couleur.getMoyenneColor(moyenne));
            } else {
                c.setBackground(Couleur.getErrorColor());
            }

        }

        return c;
    }
}
