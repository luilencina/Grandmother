public class Coordinates {
  public double x; // lagitude
  public double y; //longitude
  public String city; //name city

  public Coordinates(double x, double y, String city){
      this.x = x;
      this.y = y;
      this.city = city;
  }

  public void update(double x, double y, String city){
    this.x = x;
    this.y = y;
    this.city = city;
  }
}
