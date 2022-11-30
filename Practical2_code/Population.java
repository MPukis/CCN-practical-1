import java.util.Random;

public class Population {
    int popSize;
    Individual[] population;
    Random generator = new Random(System.currentTimeMillis());
    int totalFittnes;
    double mutationRate=0.1;

    int generation=0;
    static int HTotalFittnes=0;
    static double HighestFittnes=0;
    static Individual bestInClass;
    static int numberGenerations;
    

    Population(int popSize){
        this.popSize=popSize;
        this.population = new Individual[popSize];
        numberGenerations=0;
    }

    //initialize first population
    public void initialize(){
        int Id=0;
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
        numberGenerations++;
        //System.out.println("selection");
        //RWheel
        int[] RWheel =new int[totalFittnes]; 
        int IndexWheel=0;
        for (int i = 0; i < pop.populationSize(); i++) {
            if(pop.population[i].getFitness()>0){
                if(pop.population[i].getFitness()==1){
                  //  System.out.println("STRING " + pop.population[i].genoToPhenotype()+ "fitness : " + pop.population[i].getFitness());
                    RWheel[IndexWheel]=pop.population[i].ID;
                    IndexWheel++;
                }
                else{
                for (int j = 1; j <= pop.population[i].getFitness(); j++) {
                    if(HighestFittnes<=pop.population[i].getFitness()){

                        HighestFittnes=pop.population[i].getFitness();
                        bestInClass=pop.population[i].clone();
                    }
                   // System.out.println("STRING " + pop.population[i].genoToPhenotype()+ " fitness : " + pop.population[i].getFitness() + "");
                    RWheel[IndexWheel]=pop.population[i].ID;
                    IndexWheel++;
                }
            }
               
            }
        }
        int []tempBest = new int[10];
        for (int i = 0; i <tempBest.length ; i++) {
            tempBest[i]=RWheel[i];
        }
        // RWheel done
        System.out.println(pop.totalFittnes);
        Individual[] newPop=pop.population;

        if (newPop[0].fitness==11){
            return;
        }

        totalFittnes=0;

        for (int i = 0; i < popSize; i++) {   
            newPop[i].setChromosome(mutation(baby(IDtoChrom(DaddyNMommy(tempBest)).getChromosome(), IDtoChrom(DaddyNMommy(tempBest)).getChromosome())));
            //newPop[i].ID=i+1;
            newPop[i].setFitness(0);
            newPop[i].calculateFittnes(newPop[i]); 
            totalFittnes+=newPop[i].getFitness();   
        }
        pop.population=newPop;
       generation++; 
       if(HTotalFittnes<totalFittnes){
        HTotalFittnes=totalFittnes;
       }
       
    }
    public char[] baby(char[] p1, char[] p2){
        char[] baby =new char[11];
        int min=0;
        int max= 11;
        int midpoint= min+(int)(Math.random()*((max-min)+1));
        for (int i = 0; i < baby.length; i++) {
            if(i<midpoint){
                baby[i]=p1[i];
            }
            else{
                baby[i]=p2[i];
            }
        }
        return baby;
    }
    public char[] mutation(char[] baby){
        for (int i = 0; i < baby.length; i++) {
            if(Math.random()<=mutationRate){
                baby[i]=Practical2.alphabet[generator.nextInt(Practical2.alphabet.length)];
            }
        }
        return baby;
    }
    public int DaddyNMommy(int[] candidates){
      Random ran = new Random();
       int rndParent=ran.nextInt(0,candidates.length-1);
      
       return candidates[rndParent];
    }
    public int populationSize(){
        return population.length;
    }
    public Individual IDtoChrom(int ID){
        for (int i = 0; i < population.length; i++) {
            if (population[i].ID==ID) {
                return population[i];
            }
        }
        return new Individual(null);
    }
}
