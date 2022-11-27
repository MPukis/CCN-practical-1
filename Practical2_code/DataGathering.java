import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DataGathering  {
    int generation;
    int populationSize;
    Population population;
    int mutationRate;
    boolean crossover;
    String fileName;

    File file;
    FileWriter fw;
    PrintWriter pw;
public DataGathering( int populationSize,Population population, int mutationRate, boolean crossover, String fileName,String filePath)throws IOException{
    File file= new File(filePath+fileName);
    FileWriter fw = new FileWriter(file);
    PrintWriter pw = new PrintWriter(file);
    generation=0;
    this.populationSize=populationSize;
    this.population=population;
    this.mutationRate=mutationRate;
    this.crossover=crossover;
    this.fileName=fileName;
}
   public void Header(){
    pw.println("| size: " +populationSize+"| mutation rate: " +mutationRate+ "Crossover?:"+crossover); 
   }
   public void saveResults(){
    pw.println("Generation: " +generation+'\n'+"induvidual in generation| fittnes value");
    for (int i = 0; i < population.populationSize(); i++) {
        pw.println(i+" | "+population.population[i].getFitness());
    }
    generation++;
   }
 public void close(){
    pw.close();
 }
   

}