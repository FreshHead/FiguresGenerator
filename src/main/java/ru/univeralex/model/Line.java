package ru.univeralex.model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * Created by Татьяна on 18.01.2017.
 */
public class Line extends Figure {
  Point2D endLocation;

  public Line() {
    this(getRandomPoint());
  }

  Line(Point2D endLocation) {
    super();
    this.endLocation = endLocation;
  }

  public void moveBy(Point2D shift) {
    super.moveBy(shift);
    endLocation = endLocation.add(shift);
  }

  @Override
  public void draw(GraphicsContext gc) {
    gc.strokeLine(location.getX(), location.getY(), endLocation.getX(), endLocation.getY());
  }

  @Override
  public String toString() {
    return super.toString() + " end x: " + endLocation.getX() + " end y: " + endLocation.getY();
  }
}
