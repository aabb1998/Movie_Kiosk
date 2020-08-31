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

public class RemoveMovieController extends Controller<Kiosk> {

    @FXML private TableView<Movie> removeMovieTv;
    
    @FXML private void initialize() {
        removeMovieTv.setItems(getMovie());
    }
    
    private Movie getSelectedMovie() {
        return removeMovieTv.getSelectionModel().getSelectedItem();
    }
    
    private ObservableList<Movie> getMovie() {
        return getKiosk().getCatalogue().getAvailableMovies();
    }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    @FXML private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }
    
    @FXML private void handleRemove(ActionEvent event) throws Exception {
        getKiosk().getCatalogue().removeMovie(getSelectedMovie());
    }
    
}
