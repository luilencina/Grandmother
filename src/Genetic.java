import java.io.IOException;
import java.util.Random;

public class Genetic {
    private static City[] cities; // list cities
    private static Chromossome better;
    private static final Random random = new Random();
    public static int tam;

    public Genetic(City[] city, int tam) throws IOException {
        this.cities = new City[0];
        this.tam = tam;
    }

    public void start() throws IOException {
        ReaderFile reader = new ReaderFile(cities);
        cities = reader.readerFile();
        evolue();
    }

    public static void evolue() throws IOException {
        Chromossome ch = chromossome();
        better = ch;
        for (int i = 0; i < tam; i++) {
            ch = mutation(better);
            better = lessDistance(ch) ? ch : better;
            // if(better.distance < ch.distance) System.out.println(better.distance);
        }

        System.out.println(" ");
        System.out.println("Melhor caminho encontrado para o tamanho " + tam + ": ");
        mapsCities(better);
        System.out.println(" ");
        System.out.println("A distância de ida e volta:");
        System.out.println(better.distance);
        System.out.println(" ");
    }

    public static Chromossome mutation(Chromossome ch) throws IOException {
        int[] king = new int[ch.chromossome.length];

        int i1 = random.nextInt(ch.chromossome.length);
        int i2 = random.nextInt(ch.chromossome.length);

        while (i1 == i2)
            i2 = random.nextInt(ch.chromossome.length);

        for (int i = 0; i < ch.chromossome.length; i++) {
            king[i] = ch.chromossome[i];
        }

        Chromossome children = new Chromossome(king, 0);

        children.swap(i1, i2);
        calcChromossome(children);
        return children;
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
            if (i == ch.chromossome.length - 1) {
                ch.distance += calcEuclid(cities[ch.chromossome[0]].x, cities[ch.chromossome[0]].y,
                        cities[ch.chromossome[ch.chromossome.length - 1]].x,
                        cities[ch.chromossome[ch.chromossome.length - 1]].y);
            } else {
                ch.distance += calcEuclid(cities[ch.chromossome[i]].x, cities[ch.chromossome[i]].y,
                        cities[ch.chromossome[i + 1]].x, cities[ch.chromossome[i + 1]].y);
            }
        }
    }

    public static double calcEuclid(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static boolean lessDistance(Chromossome ch) {
        if (ch.distance < better.distance) {
            System.out.println(ch.distance);
            return true;
        }
        return false;
    }

    public static void mapsCities(Chromossome chromossome) {
        for (int i = 0; i < cities.length; i++) {
            // if (chromossome.chromossome[i] == cities[i].id) {
            System.out.print(cities[chromossome.chromossome[i]].city);
            System.out.print(" -> ");
            // }
        }
    }

}
