package graphique.tp1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.control.ScrollPane;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.text.*;
import javafx.scene.Node;
import javafx.collections.ObservableList;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class remplirObjsController implements Initializable {
    public void start2(Stage primaryStage) throws Exception{
    final ScrollPane sc = new ScrollPane ();
        sc.setFitToHeight(true);
        sc.setFitToWidth(true);
        sc.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    GridPane root = new GridPane();

        root.setGridLinesVisible(false);
    final int numCols = 3 ;
    final int numRows = 20;
    Label lb1=new Label("Poid");
         lb1.setFont(new Font("Arial", 20));
        root.add(lb1,1,0);
        root.setHalignment(lb1,HPos.CENTER);
    Label lb2=new Label("Valeur");
        root.add(lb2,2,0);
        lb2.setFont(new Font("Arial", 20));
        root.setHalignment(lb2,HPos.CENTER);
        for (int i = 0; i < numCols; i++) {
        ColumnConstraints colConst = new ColumnConstraints();
        colConst.setPercentWidth(100.0 / numCols);
        root.getColumnConstraints().add(colConst);


    }
    int i;

        for (i = 0; i < numRows; i++) {
        RowConstraints rowConst = new RowConstraints();
        rowConst.setPercentHeight(100.0 / (numRows+2));
        root.getRowConstraints().add(rowConst);
        Label lb= new Label(" objet ".concat(String.valueOf(i+1)));
        root.setHalignment(lb,HPos.CENTER);
        lb.setFont(new Font("Arial", 20));
        root.add(lb,0,i+1);
        TextField tf11=new TextField();
        tf11.setPrefHeight(40);

        root.add(tf11,1,i+1);
        TextField tf12=new TextField();
        tf12.setPrefHeight(40);

        root.add(tf12,2,i+1);
        root.setHalignment(tf11,HPos.CENTER);
        root.setHalignment(tf12,HPos.CENTER);
    }
    RowConstraints rowConst = new RowConstraints();
        rowConst.setPercentHeight(100.0 / (numRows+1));
        root.getRowConstraints().add(rowConst);

        rowConst.setPercentHeight(100.0 / (numRows+1));
        root.getRowConstraints().add(rowConst);

    Button btn=new Button("Resoudre");
        btn.setPrefSize(100,35);
        root.add(btn,2,numRows+1);
        root.setHalignment(btn,HPos.CENTER);

        sc.setContent(root);
        Main.myStage.setScene(new Scene(sc, 500, 400));
        Main.myStage.show();
    ObservableList<Node> childrens = root.getChildren();

        for (Node node : childrens) {
        if ( node instanceof TextField) {
            if ( root.getColumnIndex(node) == 1) {

                int valeur=Integer.parseInt(((TextField) node).getText());
            }
            if ( root.getColumnIndex(node) == 2) {

                int poid=Integer.parseInt(((TextField) node).getText());
            }
            int numero =root.getRowIndex(node);
        }
    }

}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            start2(Main.myStage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
