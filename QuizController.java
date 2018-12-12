package CS662_FinalProject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;

public class QuizController {
	// declare variables
    private ToggleGroup toggleGroup;
    private RadioButton optionA;
    private RadioButton optionB;
    private RadioButton optionC;
    private RadioButton optionD;
    private Button save_next;
    private Button finish;
    private Text questionNo;
    private Text questions;

	
    //static String s;
    String[][] quizQuestions;
    static String[][] quizAnswers;
    static HashMap<Integer, String> quizAns;
    public static int quizID;
    public static int quizCounter = 0;
    static HashMap<Integer, String> wrongAns;
    static HashMap<Integer, String> userChoice;
    public static String checked;
    
    // Final report 
    
    FinalReport submit = new FinalReport();
    // you could use a Builder pattern here to make this parameter list much shorter
    // this would be needed be used basically as a constructor
    // QuizController controller = new QuizController.QuizControllerBuilder()
    //    .setOptionA(optionA)
    //    .setOptionB(optionB)
    //    .setOptionC(optionC)
    //    .setQuestionNo(questionNo)
    //    ....
    //    .createController()
    
    public void setQuizController(int quizType, RadioButton optionA, RadioButton optionB, RadioButton optionC, RadioButton optionD, Text questionNo,
    		Text questions, Button save_next, Button finish) {
    //public QuizController(RadioButton optionA, RadioButton optionB, RadioButton optionC, RadioButton optionD, Text questionNo, Text questions) {
    	// initial quiz ID to 0
    	quizID=0;
    	this.optionA = optionA;
    	this.optionB = optionB;
    	this.optionC = optionC;
    	this.optionD =optionD;
    	this.save_next=save_next;
    	this.finish = finish;
    	this.questionNo = questionNo;
    	this.questions = questions;

    	
    	toggleGroup = new ToggleGroup();
    	optionA.setToggleGroup(toggleGroup);
    	optionB.setToggleGroup(toggleGroup);
    	optionC.setToggleGroup(toggleGroup);
    	optionD.setToggleGroup(toggleGroup);
		
		
    	quizQuestions = new String[10][5];
    	quizAnswers = new String[10][2];
    	quizAns = new HashMap<Integer, String>();
         
         if(quizType == 1){
        	 quizQuestions = QuizQuestions.setQuiz1();
        	 //quizAnswers = QuizAnswers.getAnswer1();
        	 quizAns = QuizAnswers.getAnswerOne();
                   
        }
        else{
        	quizQuestions = QuizQuestions.setQuiz2();
        	//quizAnswers = QuizAnswers.getAnswer2();
        	quizAns = QuizAnswers.getAnswerTwo();
        }
      
         //map=new HashMap<Integer, String>();
         userChoice = new HashMap<Integer, String>();
         readQuestions(quizID);  
    }
    
	// Read the questions from QuizQestions classes.
    public void readQuestions(int i){
		        		       
    	questions.setText(quizQuestions[i][0]);
    	optionA.setText("A)  " + quizQuestions[i][1]);
    	optionB.setText("B)  " + quizQuestions[i][2]);
    	optionC.setText("C)  " + quizQuestions[i][3]);
    	optionD.setText("D)  " + quizQuestions[i][4]);
    	
    	// Remove Strings A, B, C, D 
    	/*optionA.getText().substring(4);  
    	optionB.getText().substring(4);
    	optionC.getText().substring(4); 
    	optionD.getText().substring(4);
    	*/
    	// Reset radio buttons
    	optionA.setSelected(false);
    	optionB.setSelected(false);
    	optionC.setSelected(false);
    	optionD.setSelected(false);   	
    }
    
    // set the quiz ID
    public void setQuizID(int id){
    	quizID = id;
    }
   
    // get the quiz ID
    public int getQuizID(){
		 return quizID;
	}
	
    // get selected value
	public String getSelected(){
		return checked;
	}
	
	// The question number Q1 ... Q5
	public void setQuestionNo(int n){	
		int num = n;
		num++;
		questionNo.setText("Q" + num + ": ");	 
	}
	
	// User clicked the next button
	public void NextButton() throws IOException{
		groupAction();
		quizCounter++;
		System.out.println(quizCounter);
		if(quizID < 4){
			userChoice.put(quizID+1,getSelected());
      
			if(Objects.equals(quizID, 4)){   
	           setQuestionNo(quizID); 
	           readQuestions(quizID);
	           quizID++;
           }
	       else{
	    	   quizID++;
	    	   checked = null;
	    	   setQuestionNo(quizID); 
	           readQuestions(quizID);
	       }
       }
		// if quiz ID > 4, currently 5
		else {
		     this.submit();    	  
	  }
	}
	
	// If user enters finish button
	public void setDialogBox() throws IOException{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Quit Quiz");
		String message = " Submit and quit the quiz ?";
		alert.setContentText(message);

		Optional<javafx.scene.control.ButtonType> action = alert.showAndWait();
		if ((action.isPresent()) && (action.get() == javafx.scene.control.ButtonType.OK)) {
			this.submit();   
		}
		/*else{
			System.out.println("else here");
			quizID--;
		}*/
	}
	
	//The radio button actions
	public void groupAction() {      
		if(optionA.isSelected()){
			checked = optionA.getText().substring(4);
		}
		else if(optionB.isSelected()){
			checked = optionB.getText().substring(4);
		}
		else if(optionC.isSelected()){
			checked = optionC.getText().substring(4); 
		}
		else if(optionD.isSelected()){
			checked = optionD.getText().substring(4);
		} 
	}
	
	// calculate the scores
    public static int countCorrectAnswers(){
    	//int numberOfQuizs = 5;
    	int numberOfQuizs = quizID+1;
        //int count = 0;
        
        for(int i=1;i<numberOfQuizs;i++)
        	//if(quizAnswers[i][1].equals(map.get(i))){
        	if((quizAns.get(i)).equals(userChoice.get(i))){
        		//count++;
        		quizAns.remove(i);
        		//System.out.println(quizAns.size());
        }
         //return count;
        return 5 - quizAns.size();
    }
    
	//submit quiz 
	public void submit(){
	  submit.setFinalReport();	
	  QuizView.setStage_hide();
	}
	
	
}
