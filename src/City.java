public class City {
  public double x; // lagitude
  public double y; //longitude
  public String city; //name city
  public int id;

  public City(double x, double y, String city, int id) {
      this.x = x;
      this.y = y;
      this.city = city;
      this.id = id;
  }

  public void update(double x, double y, String city) {
    this.x = x;
    this.y = y;
    this.city = city;
  }
}
