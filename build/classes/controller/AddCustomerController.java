
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


public class AddCustomerController extends Controller<Kiosk> {

    @FXML private TextField customerIdTf;
    @FXML private TextField customerNameTf;
    @FXML private TextField customerBalanceTf;
    @FXML private Label success;
    @FXML private Button addCustomerBtn;
    @FXML private Button closeBtn;
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private int getCustomerID() {
        return Integer.parseInt(customerIdTf.getText());
    }
    
    private String getCustomerName() {
        return customerNameTf.getText();
    }
    
    private int getCustomerBalance() {
        return Integer.parseInt(customerBalanceTf.getText());
    }
    
    @FXML private void handleAdd(ActionEvent event) throws Exception {
        try {
            getKiosk().addCustomer(getCustomerID(), getCustomerName(),getCustomerBalance());
            success.setText("Customer added to Kiosk.");
            } catch (Exception e) {
            success.setText("Invalid information. Try again.");
            }
        }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
    
}
