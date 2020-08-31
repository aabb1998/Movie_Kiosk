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

public class ShowMoviesByGenreController extends Controller<Kiosk> {

    @FXML private ListView<Genre> genreLv;
    @FXML private TableView<Movie> genreTv;
    @FXML private Button displayBtn;
    
    @FXML private void initialize() {
                genreLv.setItems(getGenre());
                genreLv.getSelectionModel().selectedItemProperty().addListener((o, oldText, newText) -> 
                displayBtn.setDisable(false));

    }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private ObservableList<Genre> getGenre() {
        return getKiosk().getCatalogue().getGenres();
    }
    
    private Genre getSelectedGenre() {
        return genreLv.getSelectionModel().getSelectedItem();
    }
    
    private ObservableList<Movie> getMovies() {
        return getKiosk().getCatalogue().getMoviesInGenre(getSelectedGenre());
    }
    
    
    @FXML private void handleGenre(ActionEvent event) throws Exception {
        genreTv.setItems(getMovies());
    }
    
    @FXML private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }
    
}
