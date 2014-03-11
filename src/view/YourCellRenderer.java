/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author flemoal
 */
class YourCellRenderer extends DefaultTableCellRenderer {
   private final NumberFormat formatter;

   public YourCellRenderer() {
      this.formatter = NumberFormat.getNumberInstance();
      setHorizontalAlignment(JLabel.RIGHT);
   }

   public YourCellRenderer(String format) {
      if (format == null) {
         throw new IllegalArgumentException("format cannot be null");
      }
      this.formatter = new DecimalFormat(format);
      setHorizontalAlignment(JLabel.RIGHT);
   }

   protected void setValue(Object value) {
      if (value instanceof Number) {
         value = formatter.format(value);
      }
      super.setValue(value);
   }
}
