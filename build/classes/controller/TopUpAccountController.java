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

public class TopUpAccountController extends Controller<Kiosk> {
    @FXML private TextField customerIdTf;
    @FXML private TextField customerBalTf;
    @FXML private Label success;
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private int getCustomerID() {
        return Integer.parseInt(customerIdTf.getText());
    }
    
    private Customer getCustomer() {
        return getKiosk().getCustomer(getCustomerID());
    }
    
    private int getCustomerBal() {
        return Integer.parseInt(customerBalTf.getText());
    }
    
    @FXML private void handleCloseBtn(ActionEvent event) {
        stage.close();
    }
    
    @FXML private void handleTopUp(ActionEvent event) {
        int amount = getCustomerBal();
        int id = getCustomerID();
        
        try {
            getKiosk().topUpAccount(getCustomer(), getCustomerBal());
            success.setText("Transaction Complete.");
        } catch (Exception e) {
            success.setText("Invalid ID. Try again.");
        }
     
            
    }
    
}
