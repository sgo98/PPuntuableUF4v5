package formularis.principal;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class FInformacio {


    // <editor-fold defaultstate="collapsed" desc="Components FXML">
    @FXML
    private Hyperlink HLWeb;
    @FXML
    private Button BOk;



    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Variables globals">


    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mètodes">

    @FXML
    protected void initialize() throws IOException {
        ///////////////////////////////
        //
        ///////////////////////////////

    }

    /**
     * Obrirà un navegador web amb una url passada predefinida en el mateix procediment
     * @throws IOException
     * @throws URISyntaxException
     */
    @FXML
    public void BtObriWeb() throws IOException, URISyntaxException {
        String WEB="http://www.ies-eugeni.cat";
        URI u=new URI(WEB);
        java.awt.Desktop.getDesktop().browse(u);
    }

    /**
     * Botó que ens tornarà al formulari principal
     */
    @FXML
    public void BtOk() {
//        try{
//            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("FPrincipal.fxml"));
//            Parent root=(Parent) fxmlLoader.load();
//            Stage stage=new Stage();
//            stage.initStyle((StageStyle.TRANSPARENT));
//            stage.setTitle("Principal");
//            stage.setScene(new Scene(root));
//            stage.show();
//
//
//        }catch(Exception e){
//
//        }
        Stage stage = (Stage) BOk.getScene().getWindow();
        stage.close();
    }

    //</editor-fold>

}
