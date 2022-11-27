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
	 */
	public static void main(String[] args) {
		//---necessary variable initialization---------
		int popSize = 100;
		for (char c = 'A'; c <= 'Z'; c++) {
			alphabet[c - 'A'] = c;
		}
		alphabet[26] = ' ';
		//----------------------------------------------
		//actual code

		Population population1= new Population(popSize);
		population1.initialize();
		// What does your population look like?
		for (int i = 0; i < population1.populationSize(); i++) {
			System.out.println(population1.population[i].genoToPhenotype());
		}
		// What would happen imho
		
	}
}
