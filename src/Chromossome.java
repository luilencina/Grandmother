public class Chromossome {
  public int[] chromossome;
  public double distance; //distancia total

  public Chromossome(int[] chromossome, double distance) {
    this.chromossome = chromossome;
    this.distance = distance;
  }

  public void update(int[] chromossome, double distance) {
    this.chromossome = chromossome;
    this.distance = distance;
  }
}
