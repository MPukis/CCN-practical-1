public class DataCollection {
    public static void main(String[] args) {
        int runs=1000;
        long startTime=System.currentTimeMillis();
        long generationTime=0;
        int popSize=100;
        Population population1= new Population(popSize);
        population1.initialize();
        HeapSort.sort(population1.population);
        for (int i = 0; i < runs; i++) {
            while(Population.HighestFittnes<=10){
                population1.selection(population1);
                HeapSort.sort(population1.population);
            }
        }
    }
    
}
