import java.io.IOException;
import java.util.Random;

/**
 * Some very basic stuff to get you started. It shows basically how each
 * chromosome is built.
 * 
 * @author Jo Stevens
 * @version 1.0, 14 Nov 2008
 * 
 * @author Alard Roebroeck
 * @version 1.1, 12 Dec 2012
 * 
 */

public class Practical2 {

	static final String TARGET = "HELLO WORLD";
	static char[] alphabet = new char[27];

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//---necessary variable initialization---------
		int popSize = 100;
		for (char c = 'A'; c <= 'Z'; c++) {
			alphabet[c - 'A'] = c;
		}
		alphabet[26] = ' ';
		Population population1= new Population(popSize);
		//DataGathering wirter = new DataGathering(popSize, population1, popSize, false, "data.txt", "");
		//----------------------------------------------
		//actual code
		
		//while loop?
		// code bellow sholud be an else statement because population initialization only happens once  
		
		population1.initialize();
		// What does your population look like?
		HeapSort.sort(population1.population);

		for (int i = 0; i < population1.populationSize(); i++) {
			System.out.println("ID: "+population1.population[i].ID+"| "+population1.population[i].genoToPhenotype()+" | "+population1.population[i].getFitness());
		}
		System.out.println("Total Fittnes: "+ population1.totalFittnes);
		
		/**  What would happen imho
		 * 
		 * what do we have(up until this point)----> population with certain fittnes values
		 * selection()
		 * crossover()
		 * mutation() <-maybe should be included in the crossover method
		 * reproduction()<- I have no idea how we gona do this
		 * loop starts again
		 */
		while(Population.HighestFittnes<=10){
			population1.selection(population1);
			HeapSort.sort(population1.population);
			// for (int i = 0; i < population1.populationSize(); i++) {
			// 	System.out.println("ID: "+population1.population[i].ID+"| "+population1.population[i].genoToPhenotype()+" | "+population1.population[i].getFitness());
			// }
			//System.out.println("Total Fittnes: "+ population1.totalFittnes+"Current best solution: " + Population.bestInClass.genoToPhenotype()+" "+Population.HTotalFittnes +"best fitness");

		}
		System.out.println(population1.population[0].genoToPhenotype());
		System.out.println(Population.numberGenerations);
	}
}
