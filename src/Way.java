import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.CookieStore;
import java.util.Scanner;

public class Way{

    private static Chromosome[] population;
    private static Chromosome[] chromosome;

    public Way(Chromosome[] chromosome, Chromosome[] population) throws IOException {
        this.population = new Chromosome[0];
        this.chromosome = new Chromosome[0];
    }

    private int cont = 0;

    public Chromosome[] start() throws IOException {
        readerFile();
        chromossome(cont);
        return null;
    }

    public static Chromosome[] readerFile() {
        try(BufferedReader file = new BufferedReader(new FileReader("../places/data.txt"))){ 
                String l =  file.readLine();
                int length = Integer.parseInt(l);
                chromosome = new Chromosome[length];
                try (Scanner in = new Scanner(file)) {
                    int i = 0;
                    in.nextLine();
                    while (in.hasNextLine()) {
                        String line = in.nextLine();
                        String[] split = line.trim().split("\\s+");
                        chromosome[i] = new Chromosome(Double.parseDouble(split[0]), Double.parseDouble(split[1]),
                                split[2], 0);
                        i++;
                    }
            }
        } catch(IOException e){
            System.out.println("Arquivo não encontrado, por favor tente novamente!");
        }
        return chromosome;
    }

    public void chromossome(int x) throws IOException {
        Chromosome[] a = new Chromosome[5]; // chromosome A
        // Chromosome[] b = new Chromosome[6]; // chromosome B
        population = new Chromosome[200];

        for (int i = x; i < 5; i++) {

            for (int j = x; j < 5; j++) {
                a[j] = chromosome[j];
                // b[i] = chromosome[i + b.length];
            }

            population[i] = a[i];
            x += 5;
        }
        printer(population);

    }

    public void createPopulation(Chromosome[] a) {

    }

    public static double calcEuclid(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void printer(Chromosome[] way) throws IOException {
        for (int i = 0; i < way.length; i++) {
            System.out.print("x: " + way[i].x + " " + "y: " + way[i].y + " " + "City: " + way[i].city);
            System.out.println("  ");
        }
    }
}
