import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        Way x = new Way(null);
        Coordinates[] y = x.coordinates();

        wayPrinter(y);
    }

    public static void wayPrinter(Coordinates[] way) throws IOException{
        for(int i=0; i < way.length - 1; i++){
            // for (int j = 0; j < way[0].length; j++)     {
                System.out.print("x: " + way[i].x + " " + "y: " + way[i].y + " " + "City: " + way[i].city);
            // }
            System.out.println("  ");
        }
     }
}