package modele;

import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Main extends Application {
	
    /* Panneaux */
    FlowPane root = new FlowPane();
    ScrollPane scrollpane = new ScrollPane();
	
	/* Paramètres de la grille */
    int nbCasesLigne = 60;
    int nbCasesFormePerso = 12;
    double largeur = 1200;
	double hauteur = 650;
    double tailleCase = (hauteur - 150) / nbCasesLigne;
    
    /* Couleurs */
    String couleur1 = "#2A0944";
    String couleur2 = "#A5E1AD";
    
    /* Epaisseurs des bords des cases */
    int bordGrille = 1;
    int bordFormePerso = 1;
    
    /* Boîtes horizontales */
    HBox hboxApp = new HBox();
    HBox hboxPlayRandom = new HBox();
    HBox hboxVitesse = new HBox();
    HBox hboxSurvie = new HBox();
    HBox hboxNaissance = new HBox();
    HBox hboxFormePerso = new HBox();
    /* Boîtes verticales */
    VBox vboxGrille = new VBox();
    VBox vboxCommandes = new VBox();
    VBox vboxVitesse = new VBox();
    VBox vboxSurvie = new VBox();
    VBox vboxNaissance = new VBox();
    /* Panneaux */
    GridPane grillePrincipale = new GridPane();
    GridPane grilleFormePerso = new GridPane();
    /* Textes */
    Label labelTitreGrille = new Label("LE JEU DE LA VIE");
    Label labelVitesse = new Label("Vitesse d'évolution");
    Label labelSurvie = new Label("Nombre de voisins nécessaires pour la survie");
    Label labelNaissance = new Label("Nombre de voisins nécessaires pour la naissance");
    Label labelFormePerso = new Label("Forme personnalisée");
    /* Tableaux */
    Case[][] tableauGrille = new Case[nbCasesLigne][nbCasesLigne];
    Case[][] tableauFormePerso = new Case[nbCasesFormePerso][nbCasesFormePerso];
    /* Boutons */
    Button buttonPlay = new Button("PLAY");
    Button buttonRandomGrille = new Button("Générer une grille aléatoire");
    Button buttonFormePerso = new Button("Ajouter la figure sur la grille");
    /* Radio-buttons */
    RadioButton rbVitesse1 =  new RadioButton("x0.5");
    RadioButton rbVitesse2 =  new RadioButton("x1");
    RadioButton rbVitesse3 =  new RadioButton("x2");
    RadioButton rbVitesse4 =  new RadioButton("x3");
    /* Groupe pour radio-buttons */
    ToggleGroup tg = new ToggleGroup();
    /* Checkboxes */
    CheckBox cbSurvie0 =  new CheckBox("0");
    CheckBox cbSurvie1 =  new CheckBox("1");
    CheckBox cbSurvie2 =  new CheckBox("2");
    CheckBox cbSurvie3 =  new CheckBox("3");
    CheckBox cbSurvie4 =  new CheckBox("4");
    CheckBox cbSurvie5 =  new CheckBox("5");
    CheckBox cbSurvie6 =  new CheckBox("6");
    CheckBox cbSurvie7 =  new CheckBox("7");
    CheckBox cbSurvie8 =  new CheckBox("8");
    CheckBox cbNaissance1 =  new CheckBox("1");
    CheckBox cbNaissance2 =  new CheckBox("2");
    CheckBox cbNaissance3 =  new CheckBox("3");
    CheckBox cbNaissance4 =  new CheckBox("4");
    CheckBox cbNaissance5 =  new CheckBox("5");
    CheckBox cbNaissance6 =  new CheckBox("6");
    CheckBox cbNaissance7 =  new CheckBox("7");
    CheckBox cbNaissance8 =  new CheckBox("8");

/**********************************************************************************************/
    
    public void start(Stage primaryStage) {
    	/* FENÊTRE DE L'APPLICATION */
        Scene scene = new Scene(root, largeur, hauteur);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        /**************************************************************************************/
        /* PLATEAU DU JEU : GRILLE + TITRE DU JEU */
		vboxGrille.setAlignment(Pos.CENTER);
		vboxGrille.setPadding(new Insets(20, 20, 20, 20));
        /* Titre de la grille */
        labelTitreGrille.getStyleClass().add("label1");
        /* Grille Principale */      
        for(int i=0 ; i<nbCasesLigne ; i++) {
        	for(int j=0 ; j<nbCasesLigne ; j++) {
        		Case caseCourante = tableauGrille[i][j];
        		caseCourante = new Case(i, j, true);
        		if(caseCourante.isVivante())
        			caseCourante.setStyle("-fx-fill: "+couleur1+";");
        		else
        			caseCourante.setStyle("-fx-fill: "+couleur2+";");
        		caseCourante.setHeight(tailleCase);
        		caseCourante.setWidth(tailleCase);
        		caseCourante.setStrokeWidth(bordGrille);
        		caseCourante.setStroke(Color.web(couleur2));
        		grillePrincipale.add(caseCourante, i, j);
        	}
        }
        grillePrincipale.setHgap(-1);
		grillePrincipale.setVgap(-1);
		grillePrincipale.setAlignment(Pos.CENTER);
        vboxGrille.getChildren().addAll(labelTitreGrille, grillePrincipale);
        /**************************************************************************************/
        /* PANNEAU DES COMMANDES */
        vboxCommandes.setAlignment(Pos.CENTER);
        vboxCommandes.setSpacing(15);
        vboxCommandes.setPadding(new Insets(40, 10, 10, 10));
        /* Boutons Play/Stop + Grille aléatoire */
        hboxPlayRandom.getChildren().addAll(buttonPlay, buttonRandomGrille);
        hboxPlayRandom.setAlignment(Pos.CENTER);
        hboxPlayRandom.setSpacing(10);
        vboxCommandes.getChildren().add(hboxPlayRandom);
        buttonPlay.setPrefHeight(60);
        buttonPlay.setOnAction(event -> {
        	if(buttonPlay.getText() == "STOP")
        		buttonPlay.setText("PLAY");
        	else
        		buttonPlay.setText("STOP");
        });
        buttonRandomGrille.setPrefHeight(60);
        buttonRandomGrille.setOnAction(event -> {
        	Random rd = new Random();
        	for(int i=0 ; i<nbCasesLigne ; i++) {
            	for(int j=0 ; j<nbCasesLigne ; j++) {
            		Case caseCourante = tableauGrille[i][j];
            		caseCourante = new Case(i, j, rd.nextBoolean());
            		if(caseCourante.isVivante())
            			caseCourante.setStyle("-fx-fill: "+couleur1+";");
            		else
            			caseCourante.setStyle("-fx-fill: "+couleur2+";");
            		caseCourante.setHeight(tailleCase);
            		caseCourante.setWidth(tailleCase);
            		caseCourante.setStrokeWidth(bordGrille);
            		caseCourante.setStroke(Color.web(couleur2));
            		grillePrincipale.add(caseCourante, i, j);
            	}
            }        	
        });
        grillePrincipale.setOnMouseClicked(event -> {
        	Case cellule = (Case) event.getTarget();
        	if(cellule.isVivante())
        		cellule.setStyle("-fx-fill: "+couleur2+";");
        	else
        		cellule.setStyle("-fx-fill: "+couleur1+";");
        });
        /* Choix de la vitesse d'évolution */
        vboxVitesse.setAlignment(Pos.CENTER);
        vboxVitesse.setSpacing(7);
        hboxVitesse.setAlignment(Pos.CENTER);
        rbVitesse1.setToggleGroup(tg);
        rbVitesse2.setToggleGroup(tg);
        rbVitesse3.setToggleGroup(tg);
        rbVitesse4.setToggleGroup(tg);
        hboxVitesse.getChildren().addAll(rbVitesse1, rbVitesse2, rbVitesse3, rbVitesse4);
        vboxVitesse.getChildren().addAll(labelVitesse, hboxVitesse);
        vboxCommandes.getChildren().add(vboxVitesse);
        /* Choix de la règle pour la survie */
        vboxSurvie.setAlignment(Pos.CENTER);
        vboxSurvie.setSpacing(7);
        hboxSurvie.setAlignment(Pos.CENTER);
        hboxSurvie.getChildren().addAll(cbSurvie0, cbSurvie1, cbSurvie2, cbSurvie3, cbSurvie4,
        								cbSurvie5, cbSurvie6, cbSurvie7, cbSurvie8);
        vboxSurvie.getChildren().addAll(labelSurvie, hboxSurvie);
        vboxCommandes.getChildren().add(vboxSurvie);
        /* Choix de la règle pour la naissance */
        vboxNaissance.setAlignment(Pos.CENTER);
        vboxNaissance.setSpacing(7);
        hboxNaissance.setAlignment(Pos.CENTER);
        hboxNaissance.getChildren().addAll(cbNaissance1, cbNaissance2, cbNaissance3, cbNaissance4,
				cbNaissance5, cbNaissance6, cbNaissance7, cbNaissance8);
        hboxNaissance.setSpacing(2);
		vboxNaissance.getChildren().addAll(labelNaissance, hboxNaissance);
		vboxCommandes.getChildren().add(vboxNaissance);
		/* Ajout d'une forme personnalisée */
		hboxFormePerso.setAlignment(Pos.TOP_CENTER);
		hboxFormePerso.setSpacing(20);
		for(int i=0 ; i<nbCasesFormePerso ; i++) {
        	for(int j=0 ; j<nbCasesFormePerso ; j++) {
        		Case caseCourante = tableauFormePerso[i][j];
        		caseCourante = new Case(i, j, true);
        		if(caseCourante.isVivante())
        			caseCourante.setStyle("-fx-fill: "+couleur1+";");
        		else
        			caseCourante.setStyle("-fx-fill: "+couleur2+";");
        		caseCourante.setHeight(10);
        		caseCourante.setWidth(10);
        		caseCourante.setStrokeWidth(bordFormePerso);
        		caseCourante.setStroke(Color.web(couleur2));
        		grilleFormePerso.add(caseCourante, i, j);
        	}
        }
		grilleFormePerso.setHgap(-1);
		grilleFormePerso.setVgap(-1);
		grilleFormePerso.setAlignment(Pos.CENTER);
		buttonFormePerso.setPrefHeight(11*nbCasesFormePerso + 2*bordFormePerso);
		hboxFormePerso.getChildren().addAll(grilleFormePerso, buttonFormePerso);
		vboxCommandes.getChildren().add(hboxFormePerso);
		
        /**************************************************************************************/
        
        /* Paramètres d'affichage de la fenêtre principale de l'application */
        hboxApp.getChildren().addAll(vboxGrille, vboxCommandes);
        hboxApp.setAlignment(Pos.TOP_CENTER);
        hboxApp.setSpacing(30);
        root.getChildren().add(hboxApp);
        root.setAlignment(Pos.CENTER);
        /* Affichage de la fenêtre */
        primaryStage.setTitle("Le Jeu de la Vie - Achraf T. & Nicolas B.");
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.show();        
    }

/**************************************************************************************************************************/
    
    public static void main(String[] args) {
        launch(args);
    }
}
