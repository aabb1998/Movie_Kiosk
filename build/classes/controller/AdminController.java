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

public class AdminController extends Controller<Kiosk>{
    
    
    
    public final Kiosk getKiosk() {
        return model;
    }
    
   @FXML private void handleViewAllCustomer(ActionEvent event) throws Exception {
       ViewLoader.showStage(getKiosk(), "/view/ShowAllCustomers.fxml", "View All", new Stage());
   }
   
   @FXML private void handleViewAllMovies(ActionEvent event) throws Exception {
       ViewLoader.showStage(getKiosk(), "/view/ShowAllMovies.fxml", "View All Movies",new Stage());
   }
   
   @FXML private void handleAddCustomer(ActionEvent event) throws Exception {
       ViewLoader.showStage(getKiosk(), "/view/AddCustomer.fxml", "Add Customer",new Stage());
   }
   
   @FXML private void handleAddMovies(ActionEvent event) throws Exception {
       ViewLoader.showStage(getKiosk(), "/view/AddMovie.fxml","Add Movie", new Stage());
   }
    
    @FXML private void handleRemoveMovies(ActionEvent event) throws Exception {
       ViewLoader.showStage(getKiosk(), "/view/RemoveMovie.fxml","Remove Movie", new Stage());
   }
   
    @FXML private void handleRemoveCustomer(ActionEvent event) throws Exception {
       ViewLoader.showStage(getKiosk(), "/view/RemoveCustomer.fxml","Remove Customer", new Stage());
   }
    
    @FXML private void handleQuit(ActionEvent event) throws Exception {
        stage.close();
    }
    
}
