package CS662_FinalProject;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Tips {
	
	public void setRaningsView(){
        Stage stage = new Stage();
        stage.setTitle("Quiz Game");
		AnchorPane anchorPane = new AnchorPane();
		anchorPane.setStyle("-fx-background-color:#fff;");
		Scene scene = new Scene(anchorPane, 640, 412); // declare scene size
		scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm()); // Get external stylesheet
		
		ImageView imgView = new ImageView();
		Image img = new Image("https://cms.qz.com/wp-content/uploads/2018/02/forgetting-curve-annotated.png?w=1400&strip=all&quality=75");
		imgView.setFitWidth(635);
        imgView.setFitHeight(300);
        imgView.setLayoutX(0);
        imgView.setLayoutY(50);
        imgView.setImage(img);
		
		// Set up label
		Label label = new Label(" Forgetting Curve ");
		label.setStyle("-fx-text-fill: red; -fx-font-size:22; -fx-font-weight:bold;");
		label.setLayoutX(230);
		label.setLayoutY(5);
		
		
	   
		// set up begin button
		Button home = new Button(" Back To Home ");
		home.setLayoutX(200);
		home.setLayoutY(360);
		home.setPrefWidth(245);
		home.setPrefHeight(50);
		
        //add action on user click the begin button
		home.setOnAction(e -> {
			//System.out.println("button clicked");
			HomeView homeView = new HomeView();
			homeView.setHomeView();
			stage.hide();
		});
		
		// add functions to the pane
		//anchorPane.getChildren().addAll(imageView, begin, label);
		anchorPane.getChildren().addAll(home, label, imgView);
		// show the scene
		stage.setScene(scene);
		stage.show();		
	}
}
