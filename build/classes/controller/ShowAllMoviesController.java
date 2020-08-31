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

public class ShowAllMoviesController extends Controller<Kiosk>{

    @FXML private TableView<Movie> allMoviesTv;
    
    
    @FXML private void initialize() {
        allMoviesTv.setItems(getMovie());
    }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private ObservableList<Movie> getMovie() {
        return getKiosk().getCatalogue().getAllMovies();
    }
    
    
    
    @FXML private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }
    
}
