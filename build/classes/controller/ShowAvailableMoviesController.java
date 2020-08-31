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


public class ShowAvailableMoviesController extends Controller<Kiosk> {
    
    @FXML private TableView<Movie> moviesAvailableTv;
    
    @FXML private void initialize() {
        moviesAvailableTv.setItems(getAvailableMovie());
    }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private ObservableList<Movie> getAvailableMovie() {
        return getKiosk().getCatalogue().getAvailableMovies();
    }
    
    @FXML private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }

}
