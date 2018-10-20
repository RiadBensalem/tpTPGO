package graphique.tp1;

import elements.tp1.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Ryad on 19/10/2018.
 */
public class resoudreController implements Initializable {
    @FXML
    private Button resoudre;
    @FXML
    private Label gainMax;
    @FXML
    private Label gainMaxtext;
    @FXML
    private ListView listeObj;
    @FXML
    private Label msgobjpris;
    @FXML
    private Button retour;
    private ArrayList<Item> tabObj=remplirObjsController.listObj;
    public void solve()
    {
        resoudre.setVisible(false);
        int[][] solution=resoudre(tp1Controller.nbObjts,tp1Controller.poidsMax);
        gainMax.setVisible(true);
        gainMaxtext.setVisible(true);
        gainMax.setText(Integer.toString(solution[tp1Controller.nbObjts][tp1Controller.poidsMax]));



        int tmp_j=tp1Controller.poidsMax;
        ArrayList<Integer > list = new ArrayList< Integer >();
        for(int k=tp1Controller.nbObjts;k > 0;k--){
            if (solution[k][tmp_j]!=solution[k-1][tmp_j]){
                list.add(k);
                tmp_j=tmp_j-(int)tabObj.get(k-1).getPoid();
            }

        }
        ObservableList<Integer> items = FXCollections.observableArrayList (list);
        listeObj.setItems(items);
        msgobjpris.setVisible(true);
        listeObj.setVisible(true);
        retour.setVisible(true);
    }
    public void retour() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/sample.fxml"));
        Main.myStage.setTitle("TPGO");
        Main.myStage.setScene(new Scene(root, 480, 400));
        Main.myStage.show();
    }
    public static int[][] resoudre(int nbObj,int w)
    {
        ArrayList<Item> listObj=remplirObjsController.listObj;
/*
        for (int idx=0;idx<nbObj;idx++)
        {
            System.out.println("poid et gain de l objet "+idx+1);
            listObj.add(new Item(scanner.nextLong(),scanner.nextLong()));
        }
*/
        int ligne,colonne;
        int[][] matrice=new int[nbObj+1][w+1];
        for ( ligne=0;ligne<nbObj+1;ligne++)
        {
            for ( colonne=0;colonne<w+1;colonne++)
            {
                if ( (ligne==0) || (colonne==0) ) matrice[ligne][colonne]=0;
                else
                {
                    if( colonne < listObj.get(ligne-1).getPoid() )
                    {
                        matrice[ligne][colonne]=matrice[ligne-1][colonne];

                    }
                    else
                    {
                        matrice[ligne][colonne]=max(matrice[ligne-1][colonne],
                                matrice[ligne-1][colonne-( (int)listObj.get(ligne-1).getPoid() )]
                                        + ( (int)listObj.get(ligne-1).getGain() ) );
                    }
                }
            }
        }
        for(int i=0 ; i <= nbObj ; i++){

            for(int j=0;j<=w;j++){
                System.out.print( matrice[i][j] + " | ");
            }
            System.out.print(" \n ");
        }
        return matrice;
    }
    private static int max(int a, int b)
    {
        if (a>=b)
            return a;
        else
            return b;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gainMax.setVisible(false);
        gainMaxtext.setVisible(false);
        listeObj.setVisible(false);
        msgobjpris.setVisible(false);
        retour.setVisible(false);
    }
}
