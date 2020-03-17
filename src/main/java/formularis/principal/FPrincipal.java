package formularis.principal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FPrincipal {


    // <editor-fold defaultstate="collapsed" desc="components Formulari">
    @FXML
    private MenuItem MIAfegirLlibres;
    @FXML
    private MenuItem MIMostrarLlibres;
    @FXML
    private MenuItem MIAfegirAutors;
    @FXML
    private MenuItem MIMostrarAutors;
    @FXML
    private MenuItem MIInformacio;
    @FXML
    private MenuItem MIEliminarAutors;
    @FXML
    private MenuItem MIEliminarLlibres;


    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mètodes del formulari">

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
    public void BTAfegirLlibres() {
        FGeneric("../llibres/FAfegeixLlibres.fxml", "Afegir Llibres");
    }
    @FXML
    public void BTLlistarLlibres() {
        FGeneric("../llibres/FMostrarLlibres.fxml", "Llistar llibres");
    }
    @FXML
    public void BTAfegirAutors() {
        FGeneric("../autors/FAfegeixAutors.fxml", "Afegir autors");
    }
    @FXML
    public void BTLlistarAutors() {
        FGeneric("../autors/FMostrarAutors.fxml", "Llistar autors");
    }
    @FXML
    public void BTEliminarAutors() {
        FGeneric("../autors/FEliminaAutors.fxml", "Eliminar Autors");
    }
    @FXML
    public void BTEliminarLlibres() {
        FGeneric("../llibres/FEliminaLlibres.fxml", "Eliminar Llibres");
    }


    //</editor-fold>

}
