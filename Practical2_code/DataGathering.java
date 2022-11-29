import java.io.File;
import java.io.FileNotFoundException;
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
    String filepath;
    File file;
    FileWriter fw;
    PrintWriter pw;

public DataGathering( int populationSize,Population population, int mutationRate, boolean crossover, String fileName,String filePath)throws IOException{
    this.filepath=filePath;  
    this.file= new File(filepath+"\\"+fileName);
    this.fw = new FileWriter(file);
    this.pw = new PrintWriter(file);
    generation=0;
    this.populationSize=populationSize;
    this.population=population;
    this.mutationRate=mutationRate;
    this.crossover=crossover;
    this.fileName=fileName;
    
}
   public void Header() throws IOException{
     pw.println("| size: " +populationSize+"| mutation rate: " +mutationRate+ "| Crossover:"+crossover); 
   }


   public void saveResults() throws IOException{
     pw.println("Generation:" +generation);
     for(int i = 0; i < population.populationSize(); i++) {
        pw.println(i+" | "+population.population[i].getFitness());
    }
    generation++;
   }
 
   public void closeWriter(){
    pw.close();
   }
}