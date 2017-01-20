package sample.Model;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * Created by san on 1/17/17.
 */
public abstract class Figure{
  Point2D location;

  Figure() {
    this.location = getRandomPoint();
  }

  Figure(Point2D location) {
    this.location = location;
  }

  public void moveOn(Point2D shift) {
    this.location = this.location.add(shift);
  }

  public abstract void draw(GraphicsContext gc);

  public void setFill(GraphicsContext gc, Color color) {
    gc.setStroke(color);
  }

  protected static Point2D getRandomPoint() {
    Random random = new Random();
    return new Point2D(random.nextInt(700), random.nextInt(660));
  }

}
