package CS662_FinalProject;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class QuizView {
	
	static Stage subStage;
	
	QuizView() {
		subStage = new Stage();
		subStage.setTitle("Quiz Game");

		AnchorPane anchorPane = new AnchorPane();
		anchorPane.setPrefWidth(900);
		anchorPane.setPrefHeight(343);

		Pane pane = new Pane();
		pane.setPrefWidth(900);
		pane.setPrefHeight(372);
		pane.setStyle("-fx-background-color:#fff;");
		
		// Create question number text
		Text questionNo = new Text("Q1:");
		questionNo.setLayoutX(50);
		questionNo.setLayoutY(56);
		questionNo.setStyle("-fx-font-size:20;");
		
		// Create questions text
		Text questions = new Text("questions");
		questions.setLayoutX(85);
		questions.setLayoutY(56);
		questions.setStyle("-fx-font-size:19;");

		// Create A, B, C, D multiple choice
		RadioButton optionA = multipleChoice("A )", 50, 112);
		RadioButton optionB = multipleChoice("B )", 50, 151);
		RadioButton optionC = multipleChoice("C )", 50, 191);
		RadioButton optionD = multipleChoice("D )", 50, 231);

		// create buttons
		Button nextQuestion = buttons("Save & Continue", 50, 299, 155, 35);
		Button finishQuiz = buttons("Finish Quiz", 700, 299, 155, 35);
		
		// add pane and scene
		pane.getChildren().addAll(questionNo, questions, optionA, optionB, optionC, optionD, nextQuestion, finishQuiz);
		Scene scene = new Scene(anchorPane);
		scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
		anchorPane.getChildren().add(pane);

		QuizController quizController = new QuizController();
		quizController.setQuizController(optionA, optionB, optionC, optionD, questionNo, questions, nextQuestion, finishQuiz);
		
		// nextQuestion button action
		nextQuestion.setOnAction(e -> {
			try {
				quizController.NextButton();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		// finishQuiz button action
		finishQuiz.setOnAction(e -> {
			try {
				quizController.setDialogBox();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

		subStage.setScene(scene);
		subStage.show();
	}
	
	// Create multiple choice option
	public static RadioButton multipleChoice(String title, int xLocation, int yLocation) {
		RadioButton option = new RadioButton(title);
		option.setLayoutX(xLocation);
		option.setLayoutY(yLocation);
		option.setStyle("-fx-font-size:16;");
		
		return option;
	}
	
	// Create save_next and finish buttons
	public static Button buttons(String title, int xLocation, int yLocation, int width, int height) {
		Button button = new Button(title);
		button.setLayoutX(xLocation);
		button.setLayoutY(yLocation);
		button.setPrefWidth(width);
		button.setPrefHeight(height);
		
		return button;
	}

	public static void setStage_hide() {
		QuizView.subStage.hide();
	}
}
