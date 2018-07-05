package ru.univeralex.model;

import java.util.Random;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * Created by san on 1/17/17.
 */
public abstract class Figure{
  Point2D location;

  Figure() {
    this(getRandomPoint());
  }

  Figure(Point2D location) {
    this.location = location;
  }

  protected static Point2D getRandomPoint() {
    Random random = new Random();
    return new Point2D(random.nextInt(700), random.nextInt(660));
  }

  public void moveBy(Point2D shift) {
    this.location = this.location.add(shift);
  }

  public abstract void draw(GraphicsContext gc);

  public String toString() {
    return this.getClass().getSimpleName() + " x: " + location.getX() + " y: " + location.getY();
  }

}
