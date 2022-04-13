package modele;

import javafx.scene.shape.Rectangle;

public class Case extends Rectangle {

    private int ligne, colonne;
    private boolean vivante;

    public Case(int x, int y) {
    	this.ligne = x;
        this.colonne = y;
        this.vivante = false;
    }
    
    public boolean isVivante() {
        return vivante;
    }

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	public void setVivante(boolean vivante) {
		this.vivante = vivante;
		if(vivante)
			this.setStyle("-fx-fill: #2A0944;");
		else
			this.setStyle("-fx-fill: #A5E1AD;");
	}

}
