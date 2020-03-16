package formularis.llibres;

import classes.Autor;
import classes.Llibre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import pkgMissatgesJavaSwing.missatgesJavaSwing;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FAfegeixLlibres {


    // <editor-fold defaultstate="collapsed" desc="Components FXML">
    @FXML
    private AnchorPane FAfegeixLlibre;
    @FXML
    private TextField TFTitol;
    @FXML
    private TextField TFAny;
    @FXML
    private ComboBox CBAutor;
    @FXML
    private TextField TFColorP;
    @FXML
    private TextField TFContingut;
    @FXML
    private ComboBox CBDimensio;
    @FXML
    private TextField TFPagines;
    @FXML
    private Button BAfegeixAutor;
    @FXML
    private Button BGuarda;
    @FXML
    private TextArea TAAutors;




    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Variables globals">

    // variable global fitxer
    //private final String rutaFitxerText = "llibres.txt";
    ObservableList<String> LlistaDimensions = FXCollections.observableArrayList("60x60", "40x40");
    ObservableList<String> LlistaAutors = FXCollections.observableArrayList();
    List<String> LAutorsId=new ArrayList<>();      // per guardar una llista d'identificadors d'autors



    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mètodes">

    /**
     * Llegeix el fitxer d'autors
     * i ompli el nom dels autors en el combo box
     */
    private void carregaComboAutors() throws IOException, ClassNotFoundException, InterruptedException {
        Autor aut = new Autor();
        List<Autor> LAutors = aut.retornaAutorsEnLlista();

        // llegim els autors de la llista
        // i amb ells posem els noms a la llista observable
        for (Autor au : LAutors) {
            LlistaAutors.add(au.getNom());
        }


        CBAutor.setItems(LlistaAutors);             // plenem el combo amb la llista observable
        CBAutor.setValue(LlistaAutors.get(0));      // seleccionem el primer autor

    }

    /**
     * inicialitzar variables, combos, etc
     * en el moment d'arrancar el formulari
     *
     * @throws IOException
     */
    @FXML
    protected void initialize() throws IOException, ClassNotFoundException, InterruptedException {
        ///////////////////////////////
        // CARREGAR COMBO BOX'S
        // DIMENSIONS:
        CBDimensio.setValue(LlistaDimensions.get(0));
        CBDimensio.setItems(LlistaDimensions);
        //
        // AUTORS:
        carregaComboAutors();
        ///////////////////////////////


//        habilitaGuardar(true);
//        // llegim del fitxer i deixem les dades dintre d'una llista d'objectes llibre
//        LlegeixCharacterStream(rutaFitxer);
//        //List <Object>libs=LlegeixFitxerEnLlistaObject(rutaFitxer,";");
    }

    /**
     * Botó per guardar la  informació dels text Fields
     *
     * @throws IOException execpció d'entrada sortida
     */
    @FXML
    public void Guarda() throws IOException {

        // recollim dades:
        if(LAutorsId.size()>0){
        try {
            String titol = TFTitol.getText();
            int numeroPagines = Integer.parseInt(TFPagines.getText());
            String dimensions = CBDimensio.getValue().toString();
           // String autor = CBAutor.getValue().toString();
            String colorPortada = TFColorP.getText();
            int anyEdicio = Integer.parseInt(TFAny.getText());
            String contingutLlibre = TFContingut.getText();

            Llibre lli= new Llibre(titol, numeroPagines, dimensions,
                    colorPortada, anyEdicio, contingutLlibre,LAutorsId);

            // utilitzem el mètode de llibre per escriure l'objecte al fitxer
            lli.escriuObjecteEnFitxerBinari();

            // buidem els TextBox
            buidaCamps();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algun camp no ha sigut introduït correctament", "ERROR", 0);
        }
        }else{
            missatgesJavaSwing m=new missatgesJavaSwing();
            m.missatgeError("Has de posar algun autor com a mínim");
        }
    }

    /**
     * Afegeix autors del combo
     */
    public void AfegeixAutors() throws InterruptedException, IOException, ClassNotFoundException {
        // guardarem una llista d'identificadors d'autor, a partir del combo desplegable
        // i també posarem el nom de l'autor afegit en el label de baix

        String nomAutor;

        // obtenim l'autor
        Autor aut=new Autor();
        nomAutor=CBAutor.getValue().toString();
        aut=aut.cercarAutor(nomAutor);


        // afegim a la llista
        LAutorsId.add(aut.getId());

        // mostrem en la label:
        //TAAutors.setText(TAAutors.getText()+aut.getNom()+"\n");
        TAAutors.appendText(aut.getNom()+" "+aut.getCognom()+"\n");

    }

    /**
     * Buidem els comboBox del formulari
     */
    public void buidaCamps() {
        //Buidem camps
        TFTitol.setText("");
        TFPagines.setText("");
        CBDimensio.setValue(LlistaDimensions.get(0));
        CBAutor.setValue(LlistaAutors.get(0));
        TFColorP.setText("");
        TFAny.setText("");
        TFContingut.setText("");
        TAAutors.setText("");

        // I LA LLISTA D'AUTORS
        LAutorsId.clear();

    }


    //</editor-fold>

}
