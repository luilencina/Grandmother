import java.io.IOException;
import java.util.Random;

public class Genetic {

    private static Chromossome[] population; // list crhomossomes
    private static City[] cities; // list cities
    private static Chromossome better;
    private static Random rnd;

    public Genetic(City[] city, Chromossome[] population) throws IOException {
        // this.population = new Chromossome[0];
        this.cities = new City[0];
    }

    public void start() throws IOException {
        ReaderFile reader = new ReaderFile(cities);
        cities = reader.readerFile();
        evolue();
    }

    // cria a populacao
    // public void population() throws IOException {
    // population = new Chromossome[cities.length];
    // better = new Chromossome(null, 999999999999.99999999999);

    public static void evolue() throws IOException {
        Chromossome ch = chromossome();
        better = ch;
        while (true) {
            ch = mutation(ch);
            better = lessDistance(ch) ? ch : better;
            System.out.println(better.distance);
        }
    }

    public static Chromossome mutation(Chromossome ch) throws IOException {
        int i1 = (int) (Math.random() * ch.chromossome.length);
        int i2 = (int) (Math.random() * ch.chromossome.length);

        ch.crossover(i1, i2);
        System.out.println(i2 + " " + i1);
        return ch;
    }

    public static Chromossome cross(Chromossome ch) {
        int i = (int) (Math.random() * ch.chromossome.length);
        int index = 0, prev = 0;

        index = eletismSmallest(ch);
        while (true) {
            i--;
            if (index == prev)
                index = 1 + (int) (Math.random() * ch.chromossome.length - 2);
            for (int j = 0; j < ch.chromossome.length / 3; j++)
                ch.chromossome[rnd.nextInt(ch.chromossome.length - 2)] = getRandom();
            prev = index;
            return ch;
        }

    }

    private static int getRandom() {
        return -1 + (2) * rnd.nextInt();
    }

    public static int eletismSmallest(Chromossome ch) {
        int score = ch.chromossome.length - 1;
        double smallest = ch.chromossome[0];
        int index = 0;

        for (int i = 0; i < ch.chromossome.length; i++) {
            if (smallest > ch.chromossome[score]) {
                smallest = ch.chromossome[score];
                index = i;
            }
        }

        return index;
    }

    // cria o cromossomo
    public static Chromossome chromossome() throws IOException {
        int[] ch = new int[cities.length];

        for (int i = 0; i < cities.length; i++)
            ch[i] = i;

        Chromossome chromossome = new Chromossome(ch, 0);
        calcChromossome(chromossome);
        return chromossome;
    }

    // method while true
    // criar novo cromossomo > ordem das cidades iguais
    // primeiro cromossomo = mae - filho = igual porem nao
    // colocar dois valores aleatorios da cidades de lugar
    // dist < mae : substitui a mae

    // calcula distancia total
    public static void calcChromossome(Chromossome ch) throws IOException {
        for (int i = 0; i < cities.length - 1; i++) {
            if (ch.chromossome[i] == cities[i].id) {
                ch.distance += calcEuclid(cities[i].x, cities[i].y, cities[i + 1].x, cities[i + 1].y);
            }
        }
    }

    // calucla distancia entre x e y
    public static double calcEuclid(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // qual tem a menor distancia?
    public static boolean lessDistance(Chromossome ch) {
        if (ch.distance < better.distance)
            return true;
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
