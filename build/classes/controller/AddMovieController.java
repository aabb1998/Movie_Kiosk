
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


public class AddMovieController extends Controller<Kiosk> {


    
    public final Kiosk getKiosk() {
        return model;
    }
  
      
    @FXML private TextField movieTitleTf;
    @FXML private TextField movieYearTf;
    @FXML private TextField movieGenreTf;
    @FXML private TextField moviePriceTf;
    @FXML private Label success;
    @FXML private Button addMovieBtn;
    @FXML private Button closeBtn;
    
    
    @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
    
    private String getMovieTitle() {
        return movieTitleTf.getText();
    }
    
    private int getMovieYear() {
        return Integer.parseInt(movieYearTf.getText());
    }
    
    private String getMovieGenre() {
        return movieGenreTf.getText();
    }
    
    private int getMoviePrice() {
        return Integer.parseInt(moviePriceTf.getText());
    }
    
    @FXML private void handleAddMovie(ActionEvent event) throws Exception {
        try {
            getKiosk().getCatalogue().addMovie(getMovieTitle(), getMovieYear(), getMovieGenre(), getMoviePrice());
            success.setText("Movie added to Catalogue.");
        } catch (Exception e) {
            success.setText("Invalid information. Try again.");
        }
        
    }
    
    
}
