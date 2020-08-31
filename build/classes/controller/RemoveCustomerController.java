package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class RemoveCustomerController extends Controller<Kiosk> {

    @FXML private TableView<Customer> customerTv;
    
    @FXML private void initialize() {
        customerTv.setItems(getCustomer());
    }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private Customer getSelectedCustomer() {
        return customerTv.getSelectionModel().getSelectedItem();
    }
    
    private ObservableList<Customer> getCustomer() {
        return getKiosk().getCustomers();
    }
    
    @FXML private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }
    
    @FXML private void handleRemove(ActionEvent event) throws Exception {
        getKiosk().removeCustomer(getSelectedCustomer());
    }

}
