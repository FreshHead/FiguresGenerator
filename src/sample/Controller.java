package sample;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import sample.Model.Circle;
import sample.Model.Ellipse;
import sample.Model.Figure;
import sample.Model.FigureFactory;

public final class Controller {


  public static final ObservableList<String> figureTypes =
      FXCollections.observableArrayList(
          "Круг",
          "Эллипс",
          "Квадрат",
          "Прямоугольник",
          "Линия"
      );

  ObservableList<String> figuresStringList = FXCollections.observableArrayList();

  public static ArrayList<Figure> figures = new ArrayList<>();

  Figure selectedFigure;

  @FXML
  private FlowPane moveToFlowPane, setRadiusFlowPane;

  @FXML
  private ComboBox figuresTypeComboBox, figuresComboBox;

  @FXML
  private TextField createCountTextField, xMoveOnTextField, yMoveOnTextField, radiusTextField, secondRadiusTextField;

  @FXML
  private void initialize() {
    figuresTypeComboBox.setItems(figureTypes);
    moveToFlowPane.setVisible(false);
    setRadiusFlowPane.setVisible(false);
  }

  @FXML
  private void createFigure() {
    int countFromTextfield = Integer.parseInt(createCountTextField.getText());
    if (countFromTextfield < 1) {
      createCountTextField.setText(String.valueOf(countFromTextfield));
      return;
    }
    for (int i = countFromTextfield; i > 0; i--) {
      Figure createdFigure = FigureFactory.createFigure(figuresTypeComboBox.getValue().toString());
      figures.add(createdFigure);
      createdFigure.draw(Main.gc);
    }
    populateFiguresComboBox();
  }

  private void populateFiguresComboBox() {
    figures.forEach(figure -> {
      if (!figuresStringList.contains(figure.toString())) {
        figuresStringList.add(figure.toString());
      }
    });
    figuresComboBox.setItems(figuresStringList);
  }

  @FXML
  private void selectFigure() {
    if(!figures.isEmpty() && figuresComboBox.getValue() != null) {
      for (Figure figure : figures) {
        if (figure.toString().equals(figuresComboBox.getValue().toString())) {
          selectedFigure = figure;
          this.redraw();
          moveToFlowPane.setVisible(true);
          if (figure instanceof Ellipse) {
            setRadiusFlowPane.setVisible(true);
            if (figure instanceof Circle) {
              secondRadiusTextField.setVisible(false);
            }
          }
          else {
            setRadiusFlowPane.setVisible(false);
          }
        }
      }
    }
  }

  @FXML
  private void eraseAll() {
    Main.gc.clearRect(0, 0, 900, 768);
    figuresStringList.clear();
    figures.clear();
  }

  @FXML
  private void moveOnPressed() {
    selectedFigure.moveOn(new Point2D(
        Double.parseDouble(xMoveOnTextField.getText()),
        Double.parseDouble(yMoveOnTextField.getText()))
    );
    this.redraw();
  }

  @FXML
  private void setRadiusOnPressed() {
      ((Ellipse) selectedFigure).setRadius(
          Integer.parseInt(radiusTextField.getText()),
          Integer.parseInt(secondRadiusTextField.getText())
      );
  }

  private void redraw() {
    Main.gc.clearRect(0, 0, 900, 768);
    figures.forEach(figure -> figure.draw(Main.gc));
  }
}