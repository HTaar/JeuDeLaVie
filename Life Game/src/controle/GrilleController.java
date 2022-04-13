package controle;

import modele.Grille;

public class GrilleController {
	private Grille grille;
	
	
	public GrilleController() {
		this.grille = grille;
	}
	
	
	public void changeNbCases(int number) {
		this.grille.setNbCasesLigne(number);
	}
	
	
}
