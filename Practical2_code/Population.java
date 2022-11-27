import java.util.Random;

public class Population {
    int popSize;
    Individual[] population;
    Random generator = new Random(System.currentTimeMillis());
    

    Population(int popSize){
        this.popSize=popSize;
        this.population = new Individual[popSize];
    }

    //initialize first population
    public void initialize(){
        for (int i = 0; i < popSize; i++) {
			char[] tempChromosome = new char[Practical2.TARGET.length()];
			for (int j = 0; j < Practical2.TARGET.length(); j++) {
				tempChromosome[j] = Practical2.alphabet[generator.nextInt(Practical2.alphabet.length)]; //choose a random letter in the alphabet
			}
			population[i] = new Individual(tempChromosome);
            // TODO Set fittnes for the individual
		}
    }
    public void selection(Individual[] population){
        //TODO
    }
    public int populationSize(){
        return population.length;
    }
}
