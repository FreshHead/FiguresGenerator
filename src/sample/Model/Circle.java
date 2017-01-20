package sample.Model;

/**
 * Created by san on 1/17/17.
 */
public class Circle extends Ellipse {

  public Circle () {
    this(getRandomRadius());
  }

  public Circle(int radius) {
    super(radius, radius);
  }

  public void setRadiuses(int radius, int secondRadius) {
    this.radius = radius;
    this.secondRadius = radius;
  }

}
