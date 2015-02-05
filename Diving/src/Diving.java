//GeonHee Ko

import java.util.Scanner;

public class Diving {

	static double score;
	static double degree;
	static double finalscore;
	static double [] scores = new double [7];
	
	
	public static void main(String[] args) {
		inputValidDegreeOfDifficulty();
		inputAllScores();
		calculateScore();
		System.out.println("Final score is " + finalscore + " points.");
	
	}

	public static double inputValidScore(){
		boolean loop= true;
		System.out.println("Enter score :");
		while(loop){
			loop=false;
			Scanner keyboard = new Scanner(System.in);
			score = keyboard.nextDouble();
			if (score<0 || score >10){
				System.out.println("Not a valid score. Enter score between 1 to 10.");
				loop=true;
				}
		}
		return score;	
	}
	
	public static void inputAllScores(){
		for(int i=0; i<scores.length; i++)
			scores[i]=inputValidScore();	
	}
	
	public static double inputValidDegreeOfDifficulty(){

		boolean loop= true;
		System.out.println("Enter Valid Degree of Difficulty (1.2 to 3.8): ");
		while(loop){
			loop=false;
			Scanner keyboard = new Scanner(System.in);
			degree = keyboard.nextDouble();
			if (degree<1.2 || degree >3.8){
				System.out.println("Not a valid degree. Try again.");
				loop=true;
				}
		
		}
		return degree;
	}
	
	public static double calculateScore(){

		int i, j, minIndex;
		double sum=0;
		
		for (i = 0; i < scores.length - 1; i++) {
			minIndex = i;
			for (j = i + 1; j < scores.length; j++)
				if (scores[j] < scores[minIndex])
					minIndex = j;
			if (minIndex != i) {
				double tmp = scores[i];
				scores[i] = scores[minIndex];
				scores[minIndex] = tmp;      
		    }
		}
		
		for(i=1; i<scores.length-1; i++)
			sum += scores[i];
		
		finalscore= sum*degree*0.6;
		
		return finalscore;
		
		
	}
}
