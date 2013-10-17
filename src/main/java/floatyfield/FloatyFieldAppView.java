package floatyfield;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class FloatyFieldAppView implements Initializable {
    @FXML
    private FloatyFieldView titleFieldController;
    @FXML
    private FloatyFieldView priceFieldController;
    @FXML
    private FloatyFieldView locationFieldController;
    @FXML
    private FloatyFieldView descriptionFieldController;
    
    private TextRewinder rewinder;

    public void initialize(URL url, ResourceBundle r) {
        titleFieldController.promptTextProperty().set("Title");
        priceFieldController.promptTextProperty().set("Price");
        locationFieldController.promptTextProperty().set("Specific Location (optional)");
        descriptionFieldController.promptTextProperty().set("Description");
        
        List<StringProperty> asList = Arrays.asList(
            titleFieldController.textProperty(), 
            priceFieldController.textProperty(), 
            locationFieldController.textProperty(), 
            descriptionFieldController.textProperty()
        );
        rewinder = new TextRewinder(asList);
    }
    
    public void onClearText() {
        rewinder.rewind();
    }
}
