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

		Text questionNo = new Text("Q1:");
		questionNo.setLayoutX(31);
		questionNo.setLayoutY(56);
		questionNo.setStyle("-fx-font-size:20;");

		Text questions = new Text("questions");
		questions.setLayoutX(138);
		questions.setLayoutY(56);
		questions.setStyle("-fx-font-size:19;");

		RadioButton optionA = new RadioButton("A )");
		optionA.setLayoutX(50);
		optionA.setLayoutY(112);
		optionA.setStyle("-fx-font-size:16;");

		RadioButton optionB = new RadioButton("B )");
		optionB.setLayoutX(50);
		optionB.setLayoutY(151);
		optionB.setStyle("-fx-font-size:16;");

		RadioButton optionC = new RadioButton("C )");
		optionC.setLayoutX(50);
		optionC.setLayoutY(191);
		optionC.setStyle("-fx-font-size:16;");

		RadioButton optionD = new RadioButton("D )");
		optionD.setLayoutX(50);
		optionD.setLayoutY(231);
		optionD.setStyle("-fx-font-size:16;");

		Button nextQuestion = new Button("Save & Continue");
		nextQuestion.setLayoutX(50);
		nextQuestion.setLayoutY(299);
		nextQuestion.setPrefWidth(155);
		nextQuestion.setPrefHeight(35);

		Button finishQuiz = new Button("Finish Quiz");
		finishQuiz.setLayoutX(450);
		finishQuiz.setLayoutY(299);
		finishQuiz.setPrefWidth(155);
		finishQuiz.setPrefHeight(35);

		pane.getChildren().addAll(questionNo, questions, optionA, optionB, optionC, optionD, nextQuestion, finishQuiz);

		Scene scene = new Scene(anchorPane);
		scene.getStylesheets().add(getClass().getResource("/CSS/main.css").toExternalForm());
		anchorPane.getChildren().add(pane);

		QuizController quizController = new QuizController();
		quizController.setQuizController(optionA, optionB, optionC, optionD, questionNo, questions, nextQuestion, finishQuiz);
		
		nextQuestion.setOnAction(e -> {
			try {
				quizController.NextButton();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

		finishQuiz.setOnAction(e -> {
			try {
				quizController.setDialogBox();
				//subStage.hide();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

		subStage.setScene(scene);
		subStage.show();
	}

	public static void setStage_hide() {
		QuizView.subStage.hide();
	}
}
