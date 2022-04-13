package vue;

import javafx.scene.paint.Color;
import modele.Case;

public class CaseVue {
	
	private Case cellule;
	private String couleur1 = "#2A0944";
    private String couleur2 = "#A5E1AD";
	
	public CaseVue(Case cellule) {
		this.cellule = cellule;
	}
	
	public void afficheCase() {
		if(this.cellule.isVivante())
			this.cellule.setFill(Color.web(couleur1));
		else
			this.cellule.setFill(Color.web(couleur2));
	}
	
	public void changeCouleur() {
		if(this.cellule.isVivante())
			this.cellule.setFill(Color.web(couleur2));
		else
			this.cellule.setFill(Color.web(couleur1));
	}
	
	
}
