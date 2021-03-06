/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author flemoal
 */
public class MatiereJTable extends JTable {

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);

        //  Color row based on a cell value
        if (!isRowSelected(row)) {
            c.setBackground(getBackground());
            int modelRow = convertRowIndexToModel(row);
            Object value = getModel().getValueAt(modelRow, 2);

            if (value instanceof Float && (float) value != -1) {
                float note = (float) value;
                c.setBackground(Couleur.getNoteColor(note));
            } else {
                c.setBackground(Couleur.getErrorColor());
            }

        }

        return c;
    }
}
