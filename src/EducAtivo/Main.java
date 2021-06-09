package EducAtivo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

  
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
     Main.class.getResource("View/fx.fxml");
       Parent root = FXMLLoader.load(getClass().getResource("/View//fx.fxml"));
       //root.getChildren().add(btn);
       Scene scene = new Scene(root);
       stage.setResizable(false);
       stage.setScene(scene);
       stage.initStyle(StageStyle.DECORATED);
       stage.show();
    }
    
}
