public class Chromosome {
  public double x; // lagitude
  public double y; //longitude
  public String city; //name city
  public double better;

  public Chromosome(double x, double y, String city, double beteer) {
      this.x = x;
      this.y = y;
      this.city = city;
      this.better = better;
  }

  public void update(double x, double y, String city, double better) {
    this.x = x;
    this.y = y;
    this.city = city;
    this.better = better;
  }
}
