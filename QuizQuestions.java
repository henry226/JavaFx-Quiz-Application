package CS662_FinalProject;
public class QuizQuestions {
	static String[][] quiz1 = new String[5][5];
	static String[][] quiz2 = new String[5][5];

    public static String[][] setQuiz1(){
    	
    	quiz1[0][0]="Perhaps only a minority of scientific researchers were succumbing to bias, but their skewed findings\n were having __________ effect on published research.";
    	quiz1[0][1]="a redundant";
    	quiz1[0][2]="a rejuvenating";
    	quiz1[0][3]="a disproportional"; // correct
    	quiz1[0][4]="a waning";

    	quiz1[1][0]="The era`s examples of __________ that are cited by the author can be balanced by occasions when\n dissent was tolerated.";
    	quiz1[1][1]="censorship"; // correct
    	quiz1[1][2]="ambivalence";
    	quiz1[1][3]="cogency";
    	quiz1[1][4]="forbearance";
        
    	quiz1[2][0]="Paleontologists seeking dinosaur fossils made many __________ finds in the years just before the\n Second World War; even excavations that produced no bones at all sometimes proved to be\n revealing.";
    	quiz1[2][1]="surprising";
    	quiz1[2][2]="conspicuous";
    	quiz1[2][3]="instructive"; // correct
    	quiz1[2][4]="perplexing";

    	quiz1[3][0]="Because people expect theater directors to be authoritarians, many were surprised that Clark\n was so _____.";
    	quiz1[3][1]="indolent";
    	quiz1[3][2]="histrionic";
    	quiz1[3][3]="megalomaniacal";
    	quiz1[3][4]="egalitarian"; // correct

    	quiz1[4][0]="The ability of the Grand Banks cod fishery to sustain intensive cod harvesting for many years\n gave it a reputation for __________ that deceived even scientifically sophisticated observers";
    	quiz1[4][1]="hazardousness";
    	quiz1[4][2]="unpredictability";
    	quiz1[4][3]="inexhaustibility"; // correct 
    	quiz1[4][4]="inscrutability";
        
		 return quiz1;
	}
	
    public static String[][] setQuiz2(){
    	
    	quiz2[0][0]="Quantity A: 80 percent of the price of the item after the increase\nQuantity B: x";
    	quiz2[0][1]="Quantity A is greater.";
    	quiz2[0][2]="Quantity B is greater."; // Correct
    	quiz2[0][3]="The two quantities are equal.";
    	quiz2[0][4]="The relationship cannot be determined from the information given.";
    	

    	quiz2[1][0]="In a list consisting of 10 numbers, 5 numbers are greater than 20 and 5 numbers are less than 20.\n Quantity A: The median of the numbers in the list. Quantity B: 20.";
    	quiz2[1][1]="Quantity A is greater.";
    	quiz2[1][2]="Quantity B is greater.";
    	quiz2[1][3]="The two quantities are equal.";
    	quiz2[1][4]="The relationship cannot be determined from the information given."; // Correct
 
        
    	quiz2[2][0]="Points R, S, and T are on the number line, and the distance between R and S is greater than\nthe distance between S and T. Quantity A: RT. Quantity B: RS";
        quiz2[2][1]="Quantity A is greater.";
        quiz2[2][2]="Quantity B is greater.";
        quiz2[2][3]="The two quantities are equal.";
        quiz2[2][4]="The relationship cannot be determined from the information given."; // correct


        quiz2[3][0]="The driver of a car traveling at a speed of 40 miles per hour had to stop the car quickly. If the\ndriver`s reaction time was 3/4 of a second, approximately how many feet did the car travel\nduring the driver`s reaction time? (1 mile = 5,280 feet)";
        quiz2[3][1]="30"; 
        quiz2[3][2]="45"; // correct
        quiz2[3][3]="60";
        quiz2[3][4]="75";

        quiz2[4][0]="Of the integers 2, 7, and 49, which, if any, are divisors of 7^49 + 1";
        quiz2[4][1]="2 only"; // correct
        quiz2[4][2]="7 only";
        quiz2[4][3]="7 and 49 only";
        quiz2[4][4]="none";

         return quiz2;
	}
}
