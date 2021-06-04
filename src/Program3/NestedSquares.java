package Program3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class NestedSquares extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        Pane pane = new Pane();
        Slider slide = new Slider();
        slide.setMax(10);
        slide.setMin(0);
        slide.setValue(0.0);
        slide.setMajorTickUnit(1);
        slide.showTickMarksProperty();
        slide.increment();
        slide.setBlockIncrement(1);
        slide.setMinorTickCount(0);
        slide.setShowTickMarks(true);
        slide.setShowTickLabels(true);
        slide.setSnapToTicks(true);
        slide.setOnMouseReleased(e -> {
            pane.getChildren().clear();
            addSquare((int)slide.getValue(), 0, 400, pane);
        });

        borderPane.setTop(slide);
        borderPane.setCenter(pane);


        Scene scene = new Scene(borderPane,600,600);
        primaryStage.setTitle("Nester Squares Recursion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void addSquare (int number, int rotation, double size, Pane p){
        if(number == 0) return;
        Rectangle rect = new Rectangle();
        rect.setWidth(size);
        rect.setHeight(size);
        rect.xProperty().bind(p.widthProperty().divide(2).subtract(size / 2));
        rect.yProperty().bind(p.heightProperty().divide(2).subtract(size / 2));
        rect.setFill(Color.rgb(((int)(Math.random() * 255)), ((int)(Math.random() * 255)), ((int)(Math.random() * 255))));
        rect.setRotate(rotation);
        p.getChildren().addAll(rect);
        addSquare(number - 1, rotation + 45, size * Math.sqrt(1.0/2), p);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
