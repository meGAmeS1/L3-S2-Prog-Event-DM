/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;

/**
 *
 * @author flemoal
 */
public class Couleur {

    private static final int alpha = 65;
    private static final Color colMin = new Color(150, 35, 55);
    private static final Color colMoy = new Color(220, 180, 10);
    private static final Color colMax = new Color(90, 170, 50);
    private static final Color colErr = new Color(14, 47, 89, alpha);
    
    private static final int moyMin = 6;
    private static final int moyMax = 14;
    private static final int noteMin = 0;
    private static final int noteMax = 20;
    
    
    public static  Color getErrorColor() {
        return colErr;
    }
    
    public static Color getMoyenneColor(float moyenne) {
        float n = (moyenne < moyMin) ? moyMin : ((moyenne > moyMax) ? moyMax : moyenne);
        float bal = (n - moyMin) / (float) (moyMax - moyMin);
        
        return getBlendedColor(bal);
    }
    
    public static Color getNoteColor(float note) {
        float n = (note < noteMin) ? noteMin : ((note > noteMax) ? noteMax : note);
        float bal = (n - noteMin) / (float) (noteMax - noteMin);
        
        return getBlendedColor(bal);
    }

    public static Color getBlendedColor(float balance) {
        float percentage = (balance < 0) ? 0 : ((balance > 1) ? 100 : balance * 100);
        Color col;
        if (percentage < 50) {
            col = interpolate(colMin, colMoy, percentage / (float) 50);
        } else {
            col = interpolate(colMoy, colMax, (percentage - 50) / (float) 50);
        }
        
        return new Color(col.getRed(), col.getGreen(), col.getBlue(), alpha);
    }

    private static Color interpolate(Color c1, Color c2, float fraction) {
        float r = c1.getRed() + (c2.getRed() - c1.getRed()) * fraction;
        float b = c1.getBlue() + (c2.getBlue() - c1.getBlue()) * fraction;
        float g = c1.getGreen() + (c2.getGreen() - c1.getGreen()) * fraction;

        return new Color((int) r, (int) g, (int) b);
    }
}
