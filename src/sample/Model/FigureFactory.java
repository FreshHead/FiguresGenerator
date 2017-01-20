package sample.Model;

import java.util.Random;

import javafx.geometry.Point2D;

/**
 * Created by san on 1/18/17.
 */
public final class FigureFactory {

  public static Figure createFigure(String figureType) {
    switch (figureType) {
      case "Круг":
        return new Circle();
      case "Эллипс":
        return new Ellipse();
      case "Квадрат":
        return new Square();
      case "Прямоугольник":
        return new Rectangle();
      case "Линия":
        return new Line();
    }
    return null;
  }

}
