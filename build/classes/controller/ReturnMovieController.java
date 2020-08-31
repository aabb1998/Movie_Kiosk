
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

public class ReturnMovieController extends Controller<Kiosk> {
    @FXML private TableView<Movie> returnTv;
    @FXML private TextField customerIdTf;
    @FXML private Button selectCusBtn;
    @FXML private Button closeBtn;
    @FXML private Button returnBtn;
    @FXML private Label customerLbl;
    
    public final Kiosk getKiosk() {
        return model;
    }

    @FXML private void initialize() {
        customerIdTf.textProperty().addListener((o, oldText, newText) -> 
                selectCusBtn.setDisable(getCustomer()==null));
        returnTv.getSelectionModel().selectedItemProperty().addListener((o, old, n) -> 
                returnBtn.setDisable(false));
        
    }
    
    private int getCustomerId() {
        return Integer.parseInt(customerIdTf.getText());
    }
    
    private Customer getCustomer() {
        return getKiosk().getCustomer(getCustomerId());
    }
    
    private Movie getSelectedMovie() {
        return returnTv.getSelectionModel().getSelectedItem();
    }
    
    private ObservableList<Movie> getMovie() {
        return getKiosk().getCustomer(getCustomerId()).currentlyRented();
    }
    
    @FXML private void handleSelectCustomer(ActionEvent event) throws Exception {
        returnTv.setItems(getMovie());
    }
    
    @FXML private void handleReturn(ActionEvent event) throws Exception {
        try {
            getKiosk().getCatalogue().returnMovieFromCustomer(getSelectedMovie(), getCustomer());
            customerLbl.setText("Movie Returned.");
        } catch (Exception e) {
            customerLbl.setText("Invalid.");
        }
                
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
    
}
