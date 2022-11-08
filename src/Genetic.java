import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.CookieStore;
import java.util.Arrays;
import java.util.Scanner;

public class Genetic{

    private static Chromossome[] population; //list crhomossomes
    private static City[] cities; //list cities

    public Genetic(City[] city, Chromossome[] population) throws IOException {
        this.population = new Chromossome[0];
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

    public City[] start() throws IOException {
        readerFile();
        population();
        return null;
    }

    // cria a populacao 
    public void population() throws IOException {
        population = new Chromossome[cities.length];
        
        for (int i = 0; i < cities.length; i++) {
            population[i] = chromossome();
        }
    }

    //cria o cromossomo
    public Chromossome chromossome() throws IOException {
        int[] ch = new int[cities.length];
        
        for (int i = 0; i < cities.length; i++) {
            ch[i] = i;
        }
        
        Chromossome chromossome = new Chromossome(ch, 0);
        calcChromossome(chromossome);
        return chromossome;
    }
    
    //calcula distancia total
    public void calcChromossome(Chromossome ch){
        for (int i = 0; i < cities.length - 1; i++) {
            if(ch.chromossome[i] == cities[i].id) {
                ch.distance += calcEuclid(cities[i].x, cities[i].y, cities[i+1].x, cities[i+1].y);
            };
        }
    }

    // calucla distancia entre x e y
    public static double calcEuclid(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public void mutation(){

    }

    
}
