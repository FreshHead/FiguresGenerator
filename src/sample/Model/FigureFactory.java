package sample.Model;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Created by san on 1/18/17.
 */
public final class FigureFactory {
  public static HashMap<String, String> figuresMap = new HashMap<>();

  static {
    figuresMap.put("Круг", "Circle");
    figuresMap.put("Эллипс", "Ellipse");
    figuresMap.put("Квадрат", "Square");
    figuresMap.put("Прямоугольник", "Rectangle");
    figuresMap.put("Линия", "Line");
    figuresMap.put("Случайная фигура", "RandomFigure");
  }

  public static Figure createFigure(String figureType) {
    try {
      return (Figure) Class.forName(Figure.class.getCanonicalName().split(Figure.class.getSimpleName())[0] + figuresMap.get(figureType)).getConstructor().newInstance();
    }
    catch (InstantiationException e) {
      e.printStackTrace();
    }
    catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

}
