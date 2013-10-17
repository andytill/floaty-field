package floatyfield;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FloatyFieldApp extends javafx.application.Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        URL resource = getClass().getResource("/floatyfield/floaty-field-app.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent root = (Parent) fxmlLoader.load();
        
        Scene scene;
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/floatyfield/floaty-field.css").toExternalForm());

        stage.setTitle("Floaty Field Demo");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}
