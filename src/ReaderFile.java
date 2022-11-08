import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReaderFile {
  private static City[] cities; //list cities

  public ReaderFile(City[] city) throws IOException {
    this.cities = new City[0];
  }

   //le o arquivo 
   public static City[] readerFile() {
    try(BufferedReader file = new BufferedReader(new FileReader("../places/data.txt"))){ 
            String l =  file.readLine();
            int length = Integer.parseInt(l);
            cities = new City[length];
            try (Scanner in = new Scanner(file)) {
                int i = 0;
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    String[] split = line.trim().split("\\s+");
                    cities[i] = new City(Double.parseDouble(split[0]), Double.parseDouble(split[1]),
                            split[2], i);
                    i++;
                }
        }
    } catch(IOException e){
        System.out.println("Arquivo não encontrado, por favor tente novamente!");
    }
    return cities;
  }

}
