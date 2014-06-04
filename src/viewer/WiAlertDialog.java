package viewer;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Wing
 */
public class WiAlertDialog  extends AnchorPane{
    @FXML
    Label alertMessage;
    @FXML
    TitledPane alertTitledPane;
    
    private static WiAlertDialog wiAlertDialog;
    private static Stage  newAlertDialog ;
    
    
    WiAlertDialog(String message) {
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("AlertDialog.fxml"));
        fXMLLoader.setRoot(WiAlertDialog.this);
        fXMLLoader.setController(WiAlertDialog.this);
        try {
            fXMLLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        alertTitledPane.setFocusTraversable(false);
        alertMessage.setText(message);
    }
    
    public static void showAlertDialog(String message) {
        newAlertDialog = new Stage(StageStyle.TRANSPARENT);
        newAlertDialog.setResizable(false);
        wiAlertDialog = new WiAlertDialog(message);
        newAlertDialog.setScene(new Scene(wiAlertDialog));
        newAlertDialog.show();
    }
    
    public static void hideAlertDialog() {
        if(newAlertDialog != null) {
            newAlertDialog.hide();
        }
    }

    @FXML
    private void onAlertOKClick(ActionEvent event) {
         WiAlertDialog.hideAlertDialog();
    }
}