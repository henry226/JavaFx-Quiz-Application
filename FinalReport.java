package CS662_FinalProject;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FinalReport {
	static Stage subStage;

	public void setFinalReport() {
		
		// set stage and title
		subStage = new Stage();
		subStage.setTitle("Final Score");
		
		// create pane
		AnchorPane anchorPane = new AnchorPane();
		anchorPane.setPrefWidth(637);
		anchorPane.setPrefHeight(442);
		anchorPane.setStyle("-fx-background-color:#fff;");
		
		// create labels
		Label congratz = labels("Congratulations", 224, 27, "-fx-text-fill:#eb3b3b; -fx-font-size:20; -fx-font-weight:bold;");
		Label successLabel = labels("You have successfully completed Quiz game", 140, 302, "-fx-font-size:18;");
		Label scoreLabel = labels("Your Score is", 230, 260, "-fx-font-size:20; -fx-font-weight:bold;");
		Label score = labels("/5", 360, 260, "-fx-font-size:20; -fx-font-weight:bold;");
		
		// back to home button
		Button backHome = new Button(" Go To Home ");
		backHome.setLayoutX(228);
		backHome.setLayoutY(356);
		backHome.setPrefWidth(170);
		backHome.setPrefHeight(40);
		
		// set image
		ImageView imgView = new ImageView();
		Image img = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLFX7WzNZR5JLDkENqEZZic_5-SYbQRlYWZXRgloV7RdRPTppm");
        imgView.setFitWidth(300);
        imgView.setFitHeight(180);
        imgView.setImage(img);
        imgView.setLayoutX(150);
        imgView.setLayoutY(57);
	
		int no = 0;

		no = QuizController.countCorrectAnswers();
		score.setText(no + "/5");

		// when backHome button is clicked, hind final report class and go back to homeView
		backHome.setOnAction(e -> {
			FinalReport.subStage.hide();
			HomeView homeView = new HomeView();
			homeView.setHomeView();
		});
		
		// set scene 
		Scene scene = new Scene(anchorPane);
		anchorPane.getChildren().addAll(congratz, successLabel, backHome, scoreLabel, score, imgView);
		scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
		subStage.setScene(scene);
		subStage.show();
	}
	
	// create labels
	public static Label labels(String title, int xLocation, int yLocation, String style) {
		
		Label labels = new Label(title);
		labels.setLayoutX(xLocation);
		labels.setLayoutY(yLocation);
		labels.setStyle(style);
		
		return labels;
	}
}
