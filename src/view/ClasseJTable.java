/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import model.Matiere;

/**
 *
 * @author flemoal
 */
public class ClasseJTable extends JTable{
    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);

        //  Color row based on a cell value
        if (!isRowSelected(row)) {
            c.setBackground(getBackground());
            int modelRow = convertRowIndexToModel(row);
            
            float sommeNote = 0;
            int nbNote = 0;
            
            for(int i = 0; i < Matiere.values().length ; i++) {
                Object value = getModel().getValueAt(modelRow, 2 + i);
                
                if (value instanceof Float) {
                    sommeNote += (float) value;
                    nbNote++;
                }
            }
            
            if(nbNote == 0) {
                c.setBackground(Couleur.getErrorColor());
            } else {
                float moyenne = sommeNote / nbNote;
                c.setBackground(Couleur.getMoyenneColor(moyenne));
            }
            
            

        }

        return c;
    }
}
