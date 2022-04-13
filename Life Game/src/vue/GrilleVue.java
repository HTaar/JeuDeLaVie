package vue;

import modele.Case;
import modele.Grille;

public class GrilleVue extends GridPane {
	private Grille grille;
	
	public GrilleVue(Grille grille, Case[][] tableauGrille) {
		int nbCases = this.grille.getNbCasesLigne();
		this.grille = grille;
		this.tableauGrille = new Case[nbCases][nbCases];
		
		for(int i=0 ; i<nbCases ; i++) {
        	for(int j=0 ; j<nbCases ; j++) {
        		Case caseCourante = tableauGrille[i][j];
        		caseCourante = new Case(i, j);
        		CaseVue caseVue = new CaseVue(caseCourante);
        		caseCourante.setHeight(10);
        		caseCourante.setWidth(10);
        		this.grille.add(caseCourante, i, j);
        	}
        }
	}
	
	
	public void randomGrille() {
		
	}
	
	
	

}
