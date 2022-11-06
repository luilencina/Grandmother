import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Way{

    // private static Coordinates coordinates;
    private static Coordinates[] coList;

    public Way(Coordinates[] assumption) throws IOException {
        // this.coordinates = new Coordinates(0, 0, null);
        this.coList = new Coordinates[0];
    }

    public Coordinates[] start() throws IOException {
        readerFile();
        assumpCoordinates();
        return null;
    }

    public static Coordinates[] readerFile() {
        try(BufferedReader file = new BufferedReader(new FileReader("../places/data.txt"))){ 
                String l =  file.readLine();
                int length = Integer.parseInt(l);
                coList = new Coordinates[length];
                try (Scanner in = new Scanner(file)) {
                    int i = 0;
                    in.nextLine();
                    while (in.hasNextLine()) {
                        String line = in.nextLine();
                        String[] split = line.trim().split("\\s+");
                        coList[i] = new Coordinates(Double.parseDouble(split[0]), Double.parseDouble(split[1]),
                                split[2], 0);
                        i++;
                    }
            }
        } catch(IOException e){
            System.out.println("Arquivo não encontrado, por favor tente novamente!");
        }
        return coList;
    }

    public void assumpCoordinates() throws IOException {
        Coordinates[] a = new Coordinates[5];
        Coordinates[] b = new Coordinates[5];

        for (int i = 0; i < a.length; i++) {
            a[i] = coList[i];
            b[i] = coList[i + b.length];
        }
    }

    public void croosover(Coordinates[] assumption) {

    }

    public static double calcEuclid(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void printer(Coordinates[] way) throws IOException {
        for (int i = 0; i < way.length; i++) {
            System.out.print("x: " + way[i].x + " " + "y: " + way[i].y + " " + "City: " + way[i].city);
            System.out.println("  ");
        }
    }
}
