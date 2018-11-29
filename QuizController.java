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
    private Text scores;
	
    static String s;
    String[][] quizQuestions;
    static String[][] quizAnswers;
    public static int quizID;
    static HashMap<Integer, String> map;
    public static String checked;
    
    // Final report 
    FinalReport submit = new FinalReport();
    public void setQuizController(RadioButton optionA, RadioButton optionB, RadioButton optionC, RadioButton optionD, Text questionNo,
    		Text questions, Button save_next, Button finish){ 
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
    	
    	// Get an random integer between 1 to 2
    	Random randGen = new Random();
        int randNum = randGen.nextInt(2);
         
         if(randNum == 0){
        	 quizQuestions = QuizQuestions.setQuiz1();
        	 quizAnswers = QuizAnswers.getAnswer1();
                   
        }
        else{
        	quizQuestions = QuizQuestions.setQuiz2();
        	quizAnswers = QuizAnswers.getAnswer2();
        }
      
         map=new HashMap<Integer, String>();
         readQuestions(quizID);  
    }
    
    public void readQuestions(int i){
		        		       
    	questions.setText(quizQuestions[i][0]);
    	optionA.setText("A)  " + quizQuestions[i][1]);
    	optionB.setText("B)  " + quizQuestions[i][2]);
    	optionC.setText("C)  " + quizQuestions[i][3]);
    	optionD.setText("D)  " + quizQuestions[i][4]);
        
    	// Remove Strings A, B, C, D 
    	optionA.getText().substring(4);  
    	optionB.getText().substring(4);
    	optionC.getText().substring(4); 
    	optionD.getText().substring(4);
    	
    	// Reset radiobuttons
    	optionA.setSelected(false);
    	optionB.setSelected(false);
    	optionC.setSelected(false);
    	optionD.setSelected(false);   	
    }
    
    public void setQuizID(int id){
    	quizID = id;
    }
   
    public int getQuizID(){
		 return quizID;
	}
		
	public String getSelected()
	{
		return checked;
	}
	
	public void setQuestionNo(int no){	
		int num = no;
		num++;
		questionNo.setText("Q" + num + ": ");	 
	}
	
	public void NextButton() throws IOException{
		groupAction();
	  
		if(quizID < 4){
			map.put(quizID,getSelected());
      
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
       } // end if
	  else {
		     this.submit();    	  
	  }
	}
	
	public void setDialogBox() throws IOException{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Quit Quiz");
		String message = " Submit and quit the quiz ?";
		alert.setContentText(message);

		Optional<javafx.scene.control.ButtonType> action = alert.showAndWait();
		if ((action.isPresent()) && (action.get() == javafx.scene.control.ButtonType.OK)) {
			this.submit();   
			//System.out.println("if here");
		}
		else{
			System.out.println("else here");
			//quizID--;
		}
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
    	int numberOfQuizs = 5;
        int count=0;
        
        for(int i=0;i<numberOfQuizs;i++)
        	if(quizAnswers[i][1].equals(map.get(i))){
        	 count++;
        	 count++;
        }
         return count;
    }
	//sumbmit quiz 
	public void submit()
	{
	  submit.setFinalReport();	
	  QuizView.setStage_hide();
	}
	
	
}
