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

public class RentMovieController extends Controller<Kiosk> {

    @FXML private TableView<Movie> rentTv;
    @FXML private TextField customerIdTf;
    @FXML private Button selectCusBtn;
    @FXML private Button closeBtn;
    @FXML private Button rentBtn;
    @FXML private Label customerLbl;

    public final Kiosk getKiosk() {
        return model;
    }
    
    @FXML private void initialize() {
        customerIdTf.textProperty().addListener((o, oldText, newText) -> 
                selectCusBtn.setDisable(getCustomer() == null));
        rentTv.getSelectionModel().selectedItemProperty().addListener((o, old, n) -> 
                rentBtn.setDisable(false));
                
    }
    
    private int getCustomerId() {
        return Integer.parseInt(customerIdTf.getText());
    }
    
    private Customer getCustomer() {
        return getKiosk().getCustomer(getCustomerId());
    }
    
    private Movie getSelectedMovie() {
        return rentTv.getSelectionModel().getSelectedItem();
    }
    
    private ObservableList<Movie> getMovie() {
        return getKiosk().getCatalogue().getAvailableMovies();
    }
    
    @FXML private void handleSelectCustomer(ActionEvent event) throws Exception {
        rentTv.setItems(getMovie());
    }
    
    @FXML private void handleRent(ActionEvent event) throws Exception {
        try {
        getKiosk().getCatalogue().rentMovieToCustomer(getSelectedMovie(), getCustomer());
        customerLbl.setText("Movie rented.");
        } catch (Exception e) {
            customerLbl.setText("Invalid.");
        }
    }
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
    
    
    
}
