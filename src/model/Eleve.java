/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author flemoal
 */
public class Eleve extends Personne {
    private Moyenne[] listeMoyenne;
    private String commentaireGeneral;
    
    public Eleve(String nom, String prenom) {
        super(nom, prenom);
        commentaireGeneral = "";
        listeMoyenne = new Moyenne[Matiere.values().length];
        for(int i=0;i<listeMoyenne.length;i++)
            listeMoyenne[i]=new Moyenne();
    }
    
    public float getNote(Matiere m)
    {
        if(listeMoyenne[m.ordinal()]!=null)
            return listeMoyenne[m.ordinal()].getNote();
        return -1;
    }
    
    public String getCommentaire(Matiere m)
    {
        if(listeMoyenne[m.ordinal()]!=null)
            return listeMoyenne[m.ordinal()].getCommentaire();
        return "";
    }

    public String getCommentaireGeneral() {
        return commentaireGeneral;
    }
    
    public void setNote(Matiere m, float note) {
        listeMoyenne[m.ordinal()].setNote(note);
    }

    public void setCommentaireGeneral(String commentaireGeneral) {
        this.commentaireGeneral = commentaireGeneral;
    }
    
    
}
