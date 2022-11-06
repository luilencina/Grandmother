public class Coordinates {
  public double x; // lagitude
  public double y; //longitude
  public String city; //name city
  public float better;

  public Coordinates(double x, double y, String city, float beteer) {
      this.x = x;
      this.y = y;
      this.city = city;
      this.better = better;
  }

  public void update(double x, double y, String city){
    this.x = x;
    this.y = y;
    this.city = city;
    this.better = better;
  }
}
