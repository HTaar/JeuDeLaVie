package vue;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CommandesVue extends VBox {
	
	private HBox hboxBoutons, hboxVitesse, hboxSurvie, hboxNaissance;
	private VBox vboxVitesse, vboxSurvie, vboxNaissance;
	private Label labelVitesse = new Label("Vitesse d'évolution");
	private Label labelSurvie = new Label("Nombre de voisins nécessaires pour la survie");
	private Label labelNaissance = new Label("Nombre de voisins nécessaires pour la naissance");
	private Button buttonPlay = new Button("PLAY");
    private Button buttonRandom = new Button("RANDOM");
	private Button buttonReset = new Button("RESET");
	private CheckBox[] checkboxesSurvie = new CheckBox[9];
	private CheckBox[] checkboxesNaissance = new CheckBox[8];
	
	public CommandesVue() {
		this.hboxBoutons = new HBox();
		this.vboxVitesse = new VBox();
		this.vboxSurvie = new VBox();
		this.vboxNaissance = new VBox();
		
		this.hboxBoutons.getChildren().addAll(this.buttonPlay, this.buttonRandom, this.buttonReset);
		
		this.vboxVitesse.getChildren().add(this.labelVitesse);
		for(int i=0 ; i<4 ; i++)
			this.vboxVitesse.getChildren().add(new RadioButton(Integer.toString(i+1)));
		
		for(int i=0 ; i<9)
		for(int i=0 ; i<9 ; i++)
			this.hboxSurvie.getChildren().add(new CheckBoxInteger.toString(i));
		this.vboxSurvie.getChildren().add(labelSurvie);
		this.vboxSurvie.getChildren().add(this.hboxSurvie);
		
		
			
		
		this.hboxNaissance.getChildren().addAll();
		this.hboxSurvie.getChildren().addAll();
		this.hboxVitesse.getChildren().addAll();
		this.vboxVitesse.getChildren().addAll();
		
	}
	
	
}
