package com.tarik.cd;

import com.tarik.cd.model.CD;
import com.tarik.cd.services.CDService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CDController {
    private CDService cdService = new CDService();

    @FXML
    private TextField titleField;
    @FXML
    private TextField artistField;
    @FXML
    private TextField yearField;
    @FXML
    private ListView<CD> cdList;

    @FXML
    public void initialize() {
        refreshCDList();
    }

    @FXML
    private void addCD() {
        try {
            String title = titleField.getText();
            String artist = artistField.getText();
            int year = Integer.parseInt(yearField.getText());

            cdService.addCD(title, artist, year);
            refreshCDList();

            titleField.clear();
            artistField.clear();
            yearField.clear();
        } catch (NumberFormatException e) {
            showAlert("Invalid input", "Year must be a number.");
        }
    }

    @FXML
    private void updateCD() {
        CD selectedCD = cdList.getSelectionModel().getSelectedItem();
        if (selectedCD == null) {
            showAlert("No selection", "Please select a CD to update.");
            return;
        }

        try {
            String title = titleField.getText();
            String artist = artistField.getText();
            int year = Integer.parseInt(yearField.getText());

            cdService.updateCD(selectedCD.getId(), title, artist, year);
            refreshCDList();
        } catch (NumberFormatException e) {
            showAlert("Invalid input", "Year must be a number.");
        }
    }

    @FXML
    private void deleteCD() {
        CD selectedCD = cdList.getSelectionModel().getSelectedItem();
        if (selectedCD == null) {
            showAlert("No selection", "Please select a CD to delete.");
            return;
        }

        cdService.deleteCD(selectedCD.getId());
        refreshCDList();
    }

    private void refreshCDList() {
        cdList.getItems().clear();
        cdList.getItems().addAll(cdService.getCDs());
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}