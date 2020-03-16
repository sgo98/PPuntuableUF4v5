package formularis.autors;

import classes.Autor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.io.IOException;

public class FAfegeixAutors {


    // <editor-fold defaultstate="collapsed" desc="Components FXML">
    @FXML
    private AnchorPane FAfegeixLlibre;
    @FXML
    private TextField TFNom;
    @FXML
    private TextField TFCognom;
    @FXML
    private TextField TFEditorial;
    @FXML
    private Button BGuarda;


    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Variables globals">

    // variable global fitxer

    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mètodes">

    /**
     * Inicialització de les variables  del formulari
     * @throws IOException excepció d'entrada/sortida
     */
    @FXML
    protected void initialize() throws IOException {

    }

    /**
     * Botó per guardar la  informació dels text Fields
     * @throws IOException execpció d'entrada sortida
     */
    @FXML
    public void BtGuarda() throws IOException {
        // recollim dades:
        try {
            String nom = TFNom.getText();
            String editorial = TFEditorial.getText();
            String cognom = TFCognom.getText();



            // construïm objecte
        Autor au = new Autor(nom,cognom,editorial);

        // utilitzem el mètode de llibre per escriure l'objecte al fitxer
        au.escriuObjecteEnFitxerBinari();

        // buidem els TextBox
        buidaCamps();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Algun camp no ha sigut introduït correctament","ERROR",0);
        }
    }

    /**
     * Buidem els comboBox del formulari
     */
    public void buidaCamps() {
        //Buidem camps
        TFNom.setText("");
        TFCognom.setText("");
        TFEditorial.setText("");
    }




    //</editor-fold>

}
