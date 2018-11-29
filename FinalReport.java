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
		subStage = new Stage();
		subStage.setTitle("Final Score");

		AnchorPane anchorPane = new AnchorPane();
		anchorPane.setPrefWidth(637);
		anchorPane.setPrefHeight(442);
		anchorPane.setStyle("-fx-background-color:#fff;");

		Label congratz = new Label("Congratulations");
		congratz.setStyle("-fx-text-fill:#eb3b3b; -fx-font-size:20; -fx-font-weight:bold;");
		congratz.setLayoutX(224);
		congratz.setLayoutY(27);

		Label successLabel = new Label("You have successfully completed Quiz game");
		successLabel.setLayoutX(140);
		successLabel.setLayoutY(302);
		successLabel.setStyle("-fx-font-size:18;");

		Label scoreLabel = new Label("Your Score is");
		scoreLabel.setLayoutX(230);
		scoreLabel.setLayoutY(260);
		scoreLabel.setStyle("-fx-font-size:20; -fx-font-weight:bold;");

		Label score = new Label("/5");
		score.setLayoutX(360);
		score.setLayoutY(260);
		score.setStyle("-fx-font-size:20; -fx-font-weight:bold;");

		Button backHome = new Button(" Go To Home ");
		backHome.setLayoutX(228);
		backHome.setLayoutY(356);
		backHome.setPrefWidth(170);
		backHome.setPrefHeight(40);

		ImageView imgView = new ImageView();
		Image img = new Image("/image/smileface.jpg");
        imgView.setFitWidth(300);
        imgView.setFitHeight(180);
        imgView.setImage(img);
        imgView.setLayoutX(150);
        imgView.setLayoutY(57);
		 
		int no = 0;

		no = QuizController.countCorrectAnswers();
		score.setText(no + "/5");

		// set final report
		backHome.setOnAction(e -> {
			FinalReport.subStage.hide();
			HomeView homeView = new HomeView();
			homeView.setHomeView();
		});

		Scene scene = new Scene(anchorPane);
		anchorPane.getChildren().addAll(congratz, successLabel, backHome, scoreLabel, score, imgView);
		scene.getStylesheets().add(getClass().getResource("/CSS/main.css").toExternalForm());
		subStage.setScene(scene);
		subStage.show();
	}
}
