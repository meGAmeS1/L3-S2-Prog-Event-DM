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
public class Moyenne {

    private float note;
    private String commentaire;

    public Moyenne() {
        note = -1;
        commentaire = "";
    }

    public float getNote() {
        return note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public String toString() {
        if (note == -1) {
            return "";
        }
        return String.valueOf(note);
    }

    public void setNote(float note) {
        this.note = note;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

}
