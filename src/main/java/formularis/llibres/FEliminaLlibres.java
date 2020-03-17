package formularis.llibres;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.awt.*;
import java.io.IOException;
import javafx.scene.control.TextArea;

public class FEliminaLlibres {


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
    private TextArea TAAutors;
    @FXML
    private Button BElimina;
    @FXML
    private javafx.scene.control.Button BCerca;

    //</editor-fold>

    @FXML
    protected void initialize() throws IOException, ClassNotFoundException, InterruptedException {


    }
}
