import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Way{

    private static Coordinates coordinates;

    public Way(Coordinates coordinates) throws IOException{
        this.coordinates = new Coordinates(0, 0, null);
    }

    public static Coordinates[] coordinates() {
        Coordinates[] array = new Coordinates[0];
        try(BufferedReader file = new BufferedReader(new FileReader("../places/data.txt"))){ 
                String l =  file.readLine();
                int length = Integer.parseInt(l);
                array = new Coordinates[length];
                try (Scanner in = new Scanner(file)) {
                    int i = 0;
                    in.nextLine();
                    while (in.hasNextLine()) {
                        String line = in.nextLine();
                        String[] split = line.trim().split("\\s+");
                        array[i] = new Coordinates(Double.parseDouble(split[0]), Double.parseDouble(split[1]), split[2]);
                        i++;
                    }
            }
        } catch(IOException e){
            System.out.println("Arquivo não encontrado, por favor tente novamente!");
        }
    
        return array;
    }
}
