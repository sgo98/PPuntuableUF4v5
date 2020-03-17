package formularis.llibres;

import classes.Autor;
import classes.Llibre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.List;


public class FMostrarLlibres {


    // <editor-fold defaultstate="collapsed" desc="Components FXML">

    @FXML
    private TextArea TAPantalla;


    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Variables globals">

    ObservableList<String> LlistaDimensions = FXCollections.observableArrayList("60x60", "40x40");

    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mètodes">

    @FXML
    protected void initialize() throws IOException, ClassNotFoundException, InterruptedException {

        Llibre l = new Llibre();
        TAPantalla.setText("");
        List<Llibre> llibres = l.retornaLlibresEnLlista();

        mostraLlibre(llibres);
    }


    /**
     * Mostrarà en el RichTextBox
     * El contingut de tot el vector de tipus Llibre
     * extret del fitxer on estan tots els llibres guardats
     * que li passarem per paràmetre
     *
     * @param llibres Llista de tipus Llibre
     */
    private void mostraLlibre(List<Llibre> llibres) throws InterruptedException, IOException, ClassNotFoundException {

        int i, k;
        Llibre l;

        // mostrem tots els llibres
        for (i = 0; i < llibres.size(); i++) {

            // primer recuperem els autors del llibre en qüestió. Recordem que un llibre pot tenir més d'un autor
            // i estan guardats amb una referència a l'ID d'autor dintre de l'objecte llibre
            l = llibres.get(i);                     // creem un objecte amb l'element "i" de la llista
            Autor aut=new Autor();

            // AGAFEM LA LLISTA D'AUTORS GUARDADA PER CADA LLIBRE I BUSQUEM EL NOM DE L'AUTOR
            List<String> idAutors = l.getAuts();   // agafem la llista d'autors que hi ha a l'objecte
            String autors="";                     // ho convertirem a String per mostrar-ho per pantalla

            // CERQUEM ELS AUTORS A PARTIR DEL SEU IDENTIFICADOR
            for(k=0;k<idAutors.size();k++){
                autors=autors+"\n   "+aut.retornaNomCognomAutor(idAutors.get(k));
            }

            TAPantalla.setText(TAPantalla.getText() +
                    "\nTitol: " + l.getTitol() +
                    "\nN Pagines: " + l.getNumeroPagines() +
                    "\nDimensions: " + l.getDimensions() +
                    "\nAutor/s: " + autors +
                    "\nColor Portada: " + l.getColorPortada() +
                    "\nAny Edicio: " + l.getAnyEdicio() +
                    "\nContingut: " + l.getContingutLlibre() + "\n\n*******\n\n ");
        }
    }


    //</editor-fold>

}
