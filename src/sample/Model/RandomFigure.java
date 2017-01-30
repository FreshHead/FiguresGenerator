package sample.Model;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by san on 1/22/17.
 */
public class RandomFigure extends Figure {
  public RandomFigure() {
    Object[] classesArray = FigureFactory.figuresMap.values().toArray();
    Random indexGenerator = new Random();
    FigureFactory.createFigure((String) classesArray[indexGenerator.nextInt(classesArray.length)]);
  }

  @Override
  public void draw(GraphicsContext gc) {

  }

}
