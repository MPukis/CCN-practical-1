import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class test {
    public static void main(String[] args) throws IOException {
       int[] tet ={};
       char[] bruh ={'a','a','d'};
       Population ind= new Population(100);
       ind.initialize();
       for (int i = 0; i < ind.populationSize(); i++) {
        ind.population[i].setFitness(1);
       }
       DataGathering reader = new DataGathering(100, ind , 0, false, "results.txt", "C:\\Users\\marti\\Desktop\\Data");
       reader.Header();
       reader.saveResults();
       reader.saveResults();
       reader.closeWriter();
  
      // System.out.println( reader.file.getName());
    //   File file= new File("C:\\Users\\marti\\Desktop\\Data\\results.txt");
    //   FileWriter fw = new FileWriter(file);
    //   PrintWriter pw = new PrintWriter(file);
    //   pw.println("xdddddd");
    //   pw.close();
      
    }
}
