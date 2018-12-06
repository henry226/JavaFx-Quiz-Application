package CS662_FinalProject;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeView {
	ImageView imageView = new ImageView();
	Image icon = new Image("https://www.bay.one/media/wysiwyg/qz-logo.png"); // Quiz application icon 
	
	public void setHomeView(){
        Stage stage = new Stage();
        stage.setTitle("Quiz Game");
		AnchorPane anchorPane = new AnchorPane();
		anchorPane.setId("anPane");
		Scene scene = new Scene(anchorPane, 640, 412); // declare scene size
		scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm()); // Get external stylesheet
		
		// Set up quiz icon
		imageView.setImage(icon);
		imageView.setFitWidth(200);
		imageView.setFitHeight(120);
		imageView.setLayoutX(220);
		imageView.setLayoutY(90);
		
		// Set up label
		Label label = new Label("Start Your Round");
		label.setStyle("-fx-text-fill: red; -fx-font-size:22; -fx-font-weight:bold;");
		label.setLayoutX(230);
		label.setLayoutY(250);
	   
		// set up begin button
		Button begin = new Button("Begin Quiz");
		begin.setLayoutX(200);
		begin.setLayoutY(300);
		begin.setPrefWidth(245);
		begin.setPrefHeight(50);
		
        //add action on user click the begin button
		begin.setOnAction(e -> {
			//System.out.println("button clicked");
			new QuizView();
			stage.hide();
		});
		
		// add functions to the pane
		anchorPane.getChildren().addAll(imageView, begin, label);
		// show the scene
		stage.setScene(scene);
		stage.show();		
	}
}
