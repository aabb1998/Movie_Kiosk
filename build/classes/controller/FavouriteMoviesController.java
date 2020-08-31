
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


public class FavouriteMoviesController extends Controller<Kiosk> {

    @FXML private TextField customerIdTf;
    @FXML private Button selectCusBtn;
    @FXML private Button closeBtn;
    @FXML private TableView<Movie> favouriteTv;
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    @FXML private void initialize() {
        customerIdTf.textProperty().addListener((o, oldText, newText) -> 
            selectCusBtn.setDisable(getCustomer()==null));
    }
    
    private int getCustomerId() {
        return Integer.parseInt(customerIdTf.getText());
    }
    
    private Customer getCustomer() {
        return getKiosk().getCustomer(getCustomerId());
    }
    
    private ObservableList<Movie> getMovie() {
        return getKiosk().getCatalogue().getCustomer(getCustomerId()).favouriteMovies();
    }
    
    @FXML private void handleSelectedCustomer(ActionEvent event) throws Exception {
        favouriteTv.setItems(getMovie());
    }
    
    
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
    
}
