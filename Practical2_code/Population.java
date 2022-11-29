import java.util.Random;

public class Population {
    int popSize;
    Individual[] population;
    Random generator = new Random(System.currentTimeMillis());
    int totalFittnes;

    

    Population(int popSize){
        this.popSize=popSize;
        this.population = new Individual[popSize];
    }

    //initialize first population
    public void initialize(){
        int Id=1;
        for (int i = 0; i < popSize; i++) {
			char[] tempChromosome = new char[Practical2.TARGET.length()];
			for (int j = 0; j < Practical2.TARGET.length(); j++) {
				tempChromosome[j] = Practical2.alphabet[generator.nextInt(Practical2.alphabet.length)]; //choose a random letter in the alphabet
			}
			population[i] = new Individual(tempChromosome);
            population[i].calculateFittnes(population[i]);
            population[i].ID=Id;
            totalFittnes+=population[i].getFitness();
            Id++;
		}
    }
    public void selection(Population pop){
        int[] RWheel =new int[totalFittnes]; 
        int IndexWheel=0;
        for (int i = 0; i < pop.populationSize(); i++) {
            if(pop.population[i].getFitness()>0){
                if(pop.population[i].getFitness()==1){
                    RWheel[IndexWheel]=pop.population[i].ID;
                    System.out.println(pop.population[i].ID+" bruh " + IndexWheel);
                    IndexWheel++;
                   
                }
                else{
                for (int j = 1; j <= pop.population[i].getFitness(); j++) {
                    RWheel[j]=pop.population[i].ID;
                    System.out.println(pop.population[i].ID+" meow " +IndexWheel);
                    IndexWheel++;
                }
            }
               
            }
        }
       // System.out.println(RWheel[totalFittnes-1]);
       System.out.println("-----------------------------------------------");
       System.out.println(RWheel[1]+ " pos 1");
        for (int i = 0; i < RWheel.length; i++) {
            System.out.println(RWheel[i]+" index: " +i);
        }
        System.out.println(RWheel.length);
    }
    public int populationSize(){
        return population.length;
    }
}
