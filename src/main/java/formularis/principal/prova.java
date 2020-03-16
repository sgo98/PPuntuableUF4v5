package formularis.principal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class prova {



    @FXML
    private MenuItem MIAfegirAutor;



    /**
     * Obrim el formulari que passem per paràmetre. Amb el titol també passat per paràmetre
     * @param formulari Formulari a obrir
     * @param titol Títol del formulari
     */
    private void FGeneric(String formulari, String titol) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formulari));

            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root);

            Stage stage = new Stage();
            // stage.initStyle((StageStyle.TRANSPARENT));
            stage.setTitle(titol);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } catch (Exception e) {

        }
    }

    @FXML
    public void BTInformacio() {

        FGeneric("FInformacio.fxml", "Informació");
    }


    @FXML
    public void afegirAutor(){
        FGeneric("../formularis/autor/FAfegirAutor.fxml", "Afegir Autor");

    }

}
