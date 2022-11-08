import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.CookieStore;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Genetic{

    private static Chromossome[] population; //list crhomossomes
    private static City[] cities; //list cities

    public Genetic(City[] city, Chromossome[] population) throws IOException {
        this.population = new Chromossome[0];
        this.cities = new City[0];
    }

    public City[] start() throws IOException {
        ReaderFile reader = new ReaderFile(cities);
        cities = reader.readerFile();
        population();
        return null;
    }

    // cria a populacao 
    public void population() throws IOException {
        population = new Chromossome[cities.length];
        
        for (int i = 0; i < cities.length; i++) 
            population[i] = chromossome();

        tournament();
    }

    //cria o cromossomo
    public Chromossome chromossome() throws IOException {
        int[] ch = new int[cities.length];
        
        for (int i = 0; i < cities.length; i++) 
            ch[i] = i;
        
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

    //Torneio
    //qual tem a menor distancia?
    public static Chromossome tournament(){
        Chromossome better = new Chromossome(null, 9999999.999999999);
        for (int i = 0; i < population.length - 1; i++) {
            if(population[i].distance < better.distance) better = population[i];
        }

        System.out.println("Better: " + better + " com distancia total: " + better.distance);
        return better;
    }

    public static void croosover(){

    }

}
