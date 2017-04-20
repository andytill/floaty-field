package floatyfield;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FloatyFieldControl extends VBox {

    private final FloatyFieldView model;

    public FloatyFieldControl() {
        setPrefHeight(-1d);
        setPrefWidth(-1d);

        Label label;
        label = new Label();
        label.setMaxWidth(Double.MAX_VALUE);
        label.setId("label");
        label.getStyleClass().add("floaty-field-interactive");
        label.setFont(Font.font("System", FontWeight.BOLD, 10d));
        label.setText("Label");

        TextField field;
        field = new TextField();
        field.setId("field");
        field.setAlignment(Pos.TOP_LEFT);
        field.setMaxHeight(-1d);
        field.setMaxWidth(Double.MAX_VALUE);
        field.setPrefWidth(-1d);
        field.setPromptText("Field");
        field.setPadding(new Insets(0d));
        field.getStyleClass().addAll("floaty-field", "no-border");
        field.setText("");

        getChildren().addAll(label, field);

        model = new FloatyFieldView(label, field);
    }

    public FloatyFieldView getModel() {
        return model;
    }
}
