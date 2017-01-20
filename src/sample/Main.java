package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Main extends Application {

  public static GraphicsContext gc;

  public static void main(String[] args) {
    launch(args);
  }

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

}
