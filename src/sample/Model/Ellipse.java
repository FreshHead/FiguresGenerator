package sample.Model;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by san on 1/17/17.
 */
public class Ellipse extends Figure {

  int radius, secondRadius;

  public Ellipse() {
    this(getRandomRadius(), getRandomRadius());
  }

  public Ellipse(int radius, int secondRadius) {
    super();
    this.radius = radius;
    this.secondRadius = secondRadius;
  }

  static int getRandomRadius() {
    return new Random().nextInt(100) + 10;
  }

  @Override
  public void draw(GraphicsContext gc) {
    gc.strokeOval(this.location.getX(), this.location.getY(), this.radius, this.secondRadius);
  }

  @Override
  public String toString() {
    return super.toString() + " radius: " + radius + " secondRadius: " + secondRadius;
  }

  public int getRadius() {
    return radius;
  }

  public int getSecondRadius() {
    return secondRadius;
  }

  public void setRadiuses(int radius, int secondRadius) {
    this.radius = radius;
    this.secondRadius = secondRadius;
  }

}
