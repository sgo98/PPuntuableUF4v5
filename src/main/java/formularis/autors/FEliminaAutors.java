package formularis.autors;

import classes.Autor;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class FEliminaAutors {


    // <editor-fold defaultstate="collapsed" desc="Components FXML">


    @FXML
    private AnchorPane FEliminaAutors;
    @FXML
    private AnchorPane APElimina;
    @FXML
    private TextField TFNom;
    @FXML
    private TextField TFCognom;
    @FXML
    private TextField TFEditorial;
    @FXML
    private Button BElimina;
    @FXML
    private AnchorPane APCerca;
    @FXML
    private Button BCerca;
    @FXML
    private TextField TFCerca;

    //</editor-fold>
    @FXML
    protected void initialize() throws IOException, ClassNotFoundException, InterruptedException {


    }

    Autor autCerca = new Autor();
    String nomAutor;




    /**
     * Botó cerca del formulari
     * Cerquem dintre del fitxer d'autors si hi ha l'autor amb nom passat pel textField
     * @throws InterruptedException Excepció
     * @throws IOException Excepció
     * @throws ClassNotFoundException Excepció
     */
    public void cerca() throws InterruptedException, IOException, ClassNotFoundException {
        // variables necessàries

        autCerca=new Autor();	           // definir aquesta variable com a global, així estarà disponible als 2 botons

        // busquem l'autor al fitxer. Si el trobem guardem l'objecte en autCerca
        autCerca=autCerca.cercarAutor(nomAutor);	// Si l’autor “nomAutor” no existeix, autCerca=null
        // Si ‘autor “nomAutor” existeix autCerca=objecteAutorDelFitxer
        // si hem trobat el autor a la llista. Habilitem els panells
        // sinó, avisem a l’usuari amb missatge error que no existeix l’autor al fitxer
    }

    /**
     * Botó per guardar la  informació dels text Fields
     * @throws IOException execepció d'entrada sortida
     */
    @FXML
    public void elimina() throws IOException {

        // recollim dades dels textfields
        String nomAutor = TFCerca.getText();

        // construïm objecte a partir d’aquestes dades

        // utilitzem el mètode de llibre per eliminar l'objecte al fitxer

        // buidem els TextBox

        // tornem a carregar la llista (ja que hem modificat)

        // deshabilitem panell de modificar i habilitem el de cercar
    }



    public void buidaCamps() {
        //Buidem camps
        TFNom.setText("");
        TFCognom.setText("");
        TFEditorial.setText("");
    }


}
