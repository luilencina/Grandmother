import java.io.IOException;
import java.util.Random;

public class Genetic {

    private static Chromossome[] population; // list crhomossomes
    private static City[] cities; // list cities
    private static Chromossome better;
    private static final Random random = new Random();

    public Genetic(City[] city, Chromossome[] population) throws IOException {
        this.cities = new City[0];
    }

    public void start() throws IOException {
        ReaderFile reader = new ReaderFile(cities);
        cities = reader.readerFile();
        evolue();
    }

    public static void evolue() throws IOException {
        Chromossome ch = chromossome();
        better = ch;
        while (true) {
            ch = mutation(better);
            better = lessDistance(ch) ? ch : better;
            if(better.distance < ch.distance) System.out.println(better.distance);
        }
    }

    public static Chromossome mutation(Chromossome ch) throws IOException {
        int[] chromossomeCities = new int[ch.getChromossome().length];
 
        for(int i = 0; i <ch.getChromossome().length; i++){
            chromossomeCities[i] = ch.getChromossome()[i];
        }

        Chromossome verifyMutation = new Chromossome(chromossomeCities, 0);

        int i1 = random.nextInt(ch.getChromossome().length);
        int i2 = random.nextInt(ch.getChromossome().length);

        if (i1 == i2) {
            i2 = random.nextInt(ch.getChromossome().length);
        }

        int aux = verifyMutation.getChromossome()[i1];
        verifyMutation.getChromossome()[i1] = verifyMutation.getChromossome()[i2];
        verifyMutation.getChromossome()[i2] = aux;
        calcChromossome(verifyMutation);
        return verifyMutation;
    }

    public static Chromossome chromossome() throws IOException {
        int[] ch = new int[cities.length];

        for (int i = 0; i < cities.length; i++)
            ch[i] = i;

        Chromossome chromossome = new Chromossome(ch, 0);
        calcChromossome(chromossome);
        return chromossome;
    }

    public static void calcChromossome(Chromossome ch) throws IOException {
        for (int i = 0; i < cities.length - 1; i++) {
            if (i == ch.getChromossome().length - 1) {
                ch.distance += calcEuclid(cities[ch.getChromossome()[0]].x, cities[ch.getChromossome()[0]].y,
                        cities[ch.getChromossome()[ch.getChromossome().length - 1]].x, cities[ch.getChromossome()[ch.getChromossome().length - 1]].y);
            } else {
                ch.distance += calcEuclid(cities[ch.getChromossome()[i]].x, cities[ch.getChromossome()[i]].y,
                        cities[ch.getChromossome()[i + 1]].x, cities[ch.getChromossome()[i + 1]].y);
            }
        }
    }

    public static double calcEuclid(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // qual tem a menor distancia?
    public static boolean lessDistance(Chromossome ch) {
        if (ch.distance < better.distance){
            // System.out.println(ch.distance);
            return true;
        }
        return false;
    }

    // torneio
    public static int tournament() {
        Random r = new Random();
        int line1 = r.nextInt(population.length - 1) + 1;
        int line2 = r.nextInt(population.length - 1) + 1;

        int retLine = line2;
        if (population[line1].distance < population[line2].distance)
            retLine = line1;

        return retLine;
    }

}
