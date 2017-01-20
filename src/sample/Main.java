package sample;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sample.Model.Circle;
import sample.Model.Figure;

public class Main extends Application {

  //public static Group figures = new Group();
  public static GraphicsContext gc;

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent fxmlParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
    Canvas canvas = new Canvas(900, 768);
    gc = canvas.getGraphicsContext2D();
    Group root = new Group(fxmlParent, canvas);
    primaryStage.setTitle("Figures generator");
    primaryStage.setScene(new Scene(root, 1280, 768));

    primaryStage.show();

  }

  public static void main(String[] args) {
    launch(args);
  }
}
