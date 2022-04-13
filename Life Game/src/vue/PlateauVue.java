package vue;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modele.Grille;

public class PlateauVue extends VBox {
	
	private Grille grille;
	private Label titre;
	
	public PlateauVue(Grille grille, Label titre) {
		this.grille = grille;
		this.titre = titre;
	}

	public Grille getGrille() {
		return grille;
	}

	public void setGrille(Grille grille) {
		this.grille = grille;
	}

	public Label getTitre() {
		return titre;
	}

	public void setTitre(Label titre) {
		this.titre = titre;
	}
	

}
