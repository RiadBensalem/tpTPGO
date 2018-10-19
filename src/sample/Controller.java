package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class Controller {

    public void tp1() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/graphique/tp1/tp1.fxml"));
        Main.myStage.setTitle("TP1");
        Scene scene=new Scene(root, 487, 400);
        Main.myStage.setScene(scene);
        Main.myStage.show();
    }
    public void tp2() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/graphique/tp2/tp2.fxml"));
        Main.myStage.setTitle("TP2");
        Scene scene=new Scene(root, 487, 400);
        Main.myStage.setScene(scene);
        Main.myStage.show();
    }
}
