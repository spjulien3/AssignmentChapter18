package Program2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ConvertToBinary extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Label decimal = new Label("Input Decimal: ");
        TextField decimalIn = new TextField();
        Label binary = new Label("Binary: ");
        TextField binaryOut = new TextField();
        HBox hBox = new HBox();
        hBox.getChildren().addAll(decimal,decimalIn,binary,binaryOut);
        hBox.setSpacing(10);
        decimalIn.setOnAction(e -> { binaryOut.setText(toBinary(Integer.parseInt(decimalIn.getText()))); });

        pane.getChildren().addAll(hBox);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public String toBinary (int x){
        if (x == 0)
            return String.valueOf(0);

        else

            return String.valueOf(x % 2 + (10 * Integer.parseInt(toBinary(x / 2))));

    }

    public static void main(String[] args) {
        launch(args);
    }
}
