package modele;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;

public class Grille {
	private int nbCasesLigne;
	private ArrayList<ArrayList<Case>> tableauGrille;
	
	public Grille(int nbCasesLigne, ArrayList<ArrayList<Case>> tableauGrille) {
		this.nbCasesLigne = nbCasesLigne;
		this.tableauGrille = tableauGrille;
	}

	public int getNbCasesLigne() {
		return nbCasesLigne;
	}

	public void setNbCasesLigne(int nbCasesLigne) {
		this.nbCasesLigne = nbCasesLigne;
	}

	public ArrayList<ArrayList<Case>> getTableauGrille() {
		return tableauGrille;
	}

	public void setTableauGrille(ArrayList<ArrayList<Case>> tableauGrille) {
		this.tableauGrille = tableauGrille;
	}
	
}
