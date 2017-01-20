package sample.Model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

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

  @Override
  public void draw(GraphicsContext gc) {
    gc.strokeOval(this.location.getX(), this.location.getY(), this.radius, this.secondRadius);
  }

  public void setRadius(int radius, int secondRadius) {
    this.radius = radius;
    this.secondRadius = secondRadius;
  }

  static int getRandomRadius() {
    return new Random().nextInt(100);
  }

}
