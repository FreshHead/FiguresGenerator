package sample.Model;

import java.util.Random;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * Created by Татьяна on 18.01.2017.
 */
public class Rectangle extends Figure {

  int width, height;

  Rectangle() {
    this(getRandomLength(), getRandomLength());
  }

  Rectangle(int width, int height) {
    super();
    this.width = width;
    this.height = height;
  }

  @Override
  public void draw(GraphicsContext gc) {
    gc.strokeRect(this.location.getX(), this.location.getY(), width, height);
  }

  static int getRandomLength() {
    return new Random().nextInt(100);
  }

}
