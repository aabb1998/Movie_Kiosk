
package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class CustomerRecordController extends Controller<Kiosk> {

    @FXML private TableView<Movie> customerRentedTv;
    @FXML private TableView<Movie> customerRentingTv;
    @FXML private Button selectCusBtn;
    @FXML private TextField customerIdTf;
    @FXML private Label customerLbl;
    
    @FXML private void initialize() {
        customerIdTf.textProperty().addListener((o, oldText, newText) -> 
            selectCusBtn.setDisable(getCustomer() == null));
    }
    
    
    
    private int getCustomerId() {
        return Integer.parseInt(customerIdTf.getText());
    }
    
    private Customer getCustomer() {
        return getKiosk().getCustomer(getCustomerId());
    }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private ObservableList<Movie> getRentedMovie() {
        return getKiosk().getCatalogue().getCustomer(getCustomerId()).currentlyRented();
    }
    
    private ObservableList<Movie> getRentHistoryMovie() {
        return getKiosk().getCatalogue().getCustomer(getCustomerId()).rentingHistory();
    }

    
    @FXML private void handleCusBtn(ActionEvent event) throws Exception {
        customerRentedTv.setItems(getRentedMovie());
        customerRentingTv.setItems(getRentHistoryMovie());
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
    
}
