package formularis.autors;

import classes.Autor;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.List;


public class FMostrarAutors {


    // <editor-fold defaultstate="collapsed" desc="Components FXML">

    @FXML
    private TextArea TAPantalla;


    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Variables globals">

    // variable global fitxer
    //private final String rutaFitxerText = "llibres.txt";

    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mètodes">

    @FXML
    protected void initialize() throws IOException, ClassNotFoundException, InterruptedException {

        Autor a= new Autor();
        TAPantalla.setText("");
        List<Autor> LAutors=a.retornaAutorsEnLlista();

        mostraAutors(LAutors);
    }




    /**
     * Mostrarà en el RichTextBox
     * El contingut de tot el vector de tipus Llibre
     * extret del fitxer on estan tots els llibres guardats
     * que li passarem per paràmetre
     *
     * @param aut Llista de tipus autors
     */
    private void mostraAutors(List<Autor> aut) {
        int i;
        for (i = 0; i < aut.size(); i++) {
            TAPantalla.setText(TAPantalla.getText() +
                    "\nNom: " + aut.get(i).getNom() +
                    "\nCognom: " + aut.get(i).getCognom() +
                    "\nEdat: " + aut.get(i).getEditorial() + "\n\n*******\n\n ");
        }
    }


    //</editor-fold>

}
