package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

  public static GraphicsContext gc;

  boolean goNorth, goSouth, goEast, goWest;

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
    Scene scene = new Scene(root, 1280, 768);
    primaryStage.setScene(scene);
    primaryStage.show();
    startListener(scene);
  }

  private void startListener(Scene scene) {
    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
      @Override
      public void handle(KeyEvent event) {
        switch (event.getCode()) {
          case UP:
            goNorth = true;
            break;
          case DOWN:
            goSouth = true;
            break;
          case LEFT:
            goWest = true;
            break;
          case RIGHT:
            goEast = true;
            break;
        }
      }
    });

//    scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
//      @Override
//      public void handle(KeyEvent event) {
//        switch (event.getCode()) {
//          case UP:
//            goNorth = false;
//            break;
//          case DOWN:
//            goSouth = false;
//            break;
//          case LEFT:
//            goWest = false;
//            break;
//          case RIGHT:
//            goEast = false;
//            break;
//        }
//      }
//    });

    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        if (Controller.selectedFigure != null) {
          int dx = 0, dy = 0;

          if (goNorth) {
            System.out.println("Going north!");
            dy -= 1;
          }
          if (goSouth) dy += 1;
          if (goEast) dx += 1;
          if (goWest) dx -= 1;

          Controller.selectedFigure.moveBy(new Point2D(dx, dy));
        }
      }
    };
    timer.start();
  }
}
