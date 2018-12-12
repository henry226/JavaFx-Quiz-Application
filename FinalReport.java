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
	//private Image img;
	
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
		Label score = labels("5", 360, 260, "-fx-font-size:20; -fx-font-weight:bold;");
		
		// back to home button
		Button backHome = finalButtons(" Go To Home ", 400, 356, 170, 40);
		// view Answer button
		Button viewAns = finalButtons(" Some Tips ", 70, 356, 170, 40);
		
		int no = 0;
		no = QuizController.countCorrectAnswers();
		score.setText(no + "/5");
		
		// set image depends on grade
		ImageView imgView = new ImageView();
		if(no > 2) {
			img(imgView, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLFX7WzNZR5JLDkENqEZZic_5-SYbQRlYWZXRgloV7RdRPTppm", 300, 180, 150, 57);
		}
		else {
			img(imgView, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGggfJR65rZq8LMsbONrK95m2IDZHdk_Y1zVa2cgPU4B4P9N6U", 250, 180, 180, 65);
		}
	
		// when backHome button is clicked, hind final report class and go back to homeView
		backHome.setOnAction(e -> {
			FinalReport.subStage.hide();
			HomeView homeView = new HomeView();
			homeView.setHomeView();
		});
		
		viewAns.setOnAction(e -> {
			FinalReport.subStage.hide();
			Tips tip = new Tips();
			tip.setRaningsView();
		});
		
		// set scene 
		Scene scene = new Scene(anchorPane);
		anchorPane.getChildren().addAll(congratz, successLabel, backHome, viewAns, scoreLabel, score, imgView);
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
	
	// set up image
	public static void img(ImageView imgView,String url, int width, int height, int xLocation, int yLocation) {
		Image img = new Image(url);
		imgView.setFitWidth(width);
        imgView.setFitHeight(height);
        imgView.setLayoutX(xLocation);
        imgView.setLayoutY(yLocation);
        imgView.setImage(img);
	}
	
	// set up buttons 
	public static Button finalButtons(String title, int xLocation, int yLocation, int width, int height){
		Button button = new Button(title);
		button.setLayoutX(xLocation);
		button.setLayoutY(yLocation);
		button.setPrefWidth(width);
		button.setPrefHeight(height);
		
		return button;
	}
}
