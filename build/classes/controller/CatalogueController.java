
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
public class CatalogueController extends Controller<Kiosk>{


    
    public final Kiosk getKiosk() {
        return model;
    }
    
    @FXML private void handleQuit(ActionEvent event) {
        stage.close();
    }
    
    @FXML private void handleMovieGenre(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ShowMoviesByGenre.fxml", "Movies by Genre", new Stage());
    }
 
    @FXML private void handleShowAll(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ShowAllMovies.fxml", "All Movies",new Stage());
    }
    
    @FXML private void handleShowAvailable(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ShowAvailableMovies.fxml", "Available Movies",new Stage());
    }
    
    @FXML private void handleRent(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/RentMovie.fxml", "Rent a Movie", new Stage());
    }
    
    @FXML private void handleReturn(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ReturnMovie.fxml","Return a Movie", new Stage());
    }
    
    @FXML private void handleMovieYear(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/ShowMoviesByYear.fxml", "Movies by Genre", new Stage());
    }
    
}
