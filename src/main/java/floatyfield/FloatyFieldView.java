package floatyfield;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class FloatyFieldView implements Initializable {

    private static final String ACTIVE_FLOATY_FIELD = "floaty-field-active";

    private static final String INACTIVE_FLOATY_FIELD = "floaty-field-inactive";

    @FXML
    private Label label;
    @FXML
    private TextField field;

    public void initialize(URL url, ResourceBundle r) {
        BooleanBinding textNotEmpty = field.textProperty().isEqualTo("").not();

        BooleanBinding labelActive = textNotEmpty.or(field.focusedProperty());

        BooleanBinding fieldActive = textNotEmpty.and(field.focusedProperty());

        labelActive.addListener(new LabelFadeIn());

        fieldActive.addListener(new FieldActiveStyler());

        label.setVisible(false);
        label.visibleProperty().bind(labelActive);
        label.textProperty().bind(field.promptTextProperty());
    }

    public final StringProperty promptTextProperty() {
        return field.promptTextProperty();
    }

    public final StringProperty textProperty() {
        return field.textProperty();
    }
    
    public final BooleanProperty disableProperty() {
        return field.disableProperty();
    }

    private final class LabelFadeIn implements ChangeListener<Boolean> {
        public void changed(ObservableValue<? extends Boolean> o, Boolean ob, Boolean nb) {
            if (nb) {
                FadeTransition ft;
                TranslateTransition tt;
                
                ft = new FadeTransition(Duration.millis(350), label);
                ft.setFromValue(0d);
                ft.setToValue(1d);
                ft.play();

                double y = label.localToParent(0d, 0d).getY();
                
                tt = new TranslateTransition(Duration.millis(500), label);
                tt.setFromY(y + 5);
                tt.setToY(y);
                tt.setCycleCount(1);
                tt.setAutoReverse(true);

                // if this doesn't happen then the translate property quickly becomes out of sync
                // when rapidly tabbing
                tt.setOnFinished((e) -> { label.setTranslateY(0d); });
                
                tt.play();
            }
        }
    }

    private final class FieldActiveStyler implements ChangeListener<Boolean> {
        public void changed(ObservableValue<? extends Boolean> o, Boolean ob, Boolean nb) {
            if (nb) {
                label.getStyleClass().remove(INACTIVE_FLOATY_FIELD);
                label.getStyleClass().add(ACTIVE_FLOATY_FIELD);
            } else {
                label.getStyleClass().remove(ACTIVE_FLOATY_FIELD);
                label.getStyleClass().add(INACTIVE_FLOATY_FIELD);
            }
        }
    }

}
