package graphique.tp1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.Main;

import java.io.IOException;
import javafx.scene.control.TextField;
/**
 * Created by Ryad on 19/10/2018.
 */
public class tp1Controller {
    public static int nbObjts;
    public static int poidsMax;
    @FXML
    private TextField nbobj;
    @FXML
    private TextField poidMax;

    public void next() throws Exception {

       nbObjts=Integer.parseInt(nbobj.getText());
        poidsMax=Integer.parseInt(poidMax.getText());
      remplirObjsController.start2(Main.myStage);

    }
}
