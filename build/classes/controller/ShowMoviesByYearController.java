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

public class ShowMoviesByYearController extends Controller<Kiosk> {

    @FXML private ListView<Integer> yearLv;
    @FXML private TableView<Movie> moviesTv;
    @FXML private Button displayBtn;
    
    @FXML private void initialize() {
        yearLv.setItems(getMovieYears());
        yearLv.getSelectionModel().selectedIndexProperty().addListener((o, oldText, newText) -> 
        displayBtn.setDisable(false));
    }
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    private ObservableList<Integer> getMovieYears() {
        return getKiosk().getCatalogue().getYears();
    }
    
    private Integer getSelectedYear() {
        return yearLv.getSelectionModel().getSelectedItem();
    }
    
    private ObservableList<Movie> getMovies() {
        return getKiosk().getCatalogue().getMoviesByYear(getSelectedYear());
    }
    
    
    
    @FXML private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }
    
        
    @FXML private void handleYear(ActionEvent event) throws Exception {
        moviesTv.setItems(getMovies());
    }
    
    
}
