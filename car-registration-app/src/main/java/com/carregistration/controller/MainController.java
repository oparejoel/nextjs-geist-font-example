package com.carregistration.controller;

import com.carregistration.dao.CarDAO;
import com.carregistration.model.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    
    @FXML private TableView<Car> carsTable;
    @FXML private TableColumn<Car, Integer> idColumn;
    @FXML private TableColumn<Car, String> makeColumn;
    @FXML private TableColumn<Car, String> modelColumn;
    @FXML private TableColumn<Car, Integer> yearColumn;
    @FXML private TableColumn<Car, String> licensePlateColumn;
    @FXML private TableColumn<Car, String> ownerNameColumn;
    @FXML private TableColumn<Car, String> registrationDateColumn;
    @FXML private TableColumn<Car, String> colorColumn;
    @FXML private TableColumn<Car, String> vinColumn;
    @FXML private TableColumn<Car, Void> actionsColumn;
    
    @FXML private TextField searchField;
    @FXML private Label statusLabel;
    @FXML private Label totalCarsLabel;
    
    private final CarDAO carDAO = new CarDAO();
    private final ObservableList<Car> carsList = FXCollections.observableArrayList();
    
    @FXML
    public void initialize() {
        setupTableColumns();
        setupActionsColumn();
        loadCars();
    }
    
    private void setupTableColumns() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        makeColumn.setCellValueFactory(new PropertyValueFactory<>("make"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        licensePlateColumn.setCellValueFactory(new PropertyValueFactory<>("licensePlate"));
        ownerNameColumn.setCellValueFactory(new PropertyValueFactory<>("ownerName"));
        registrationDateColumn.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        vinColumn.setCellValueFactory(new PropertyValueFactory<>("vin"));
    }
    
    private void setupActionsColumn() {
        actionsColumn.setCellFactory(param -> new TableCell<>() {
            private final Button editButton = new Button("Edit");
            private final Button deleteButton = new Button("Delete");
            private final HBox buttonsBox = new HBox(5, editButton, deleteButton);
            
            {
                editButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
                deleteButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
                
                editButton.setOnAction(event -> {
                    Car car = getTableView().getItems().get(getIndex());
                    handleEditCar(car);
                });
                
                deleteButton.setOnAction(event -> {
                    Car car = getTableView().getItems().get(getIndex());
                    handleDeleteCar(car);
                });
            }
            
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(buttonsBox);
                }
            }
        });
    }
    
    private void loadCars() {
        carsList.setAll(carDAO.getAllCars());
        carsTable.setItems(carsList);
        updateStatus();
    }
    
    private void updateStatus() {
        totalCarsLabel.setText("Total Cars: " + carsList.size());
        statusLabel.setText("Loaded " + carsList.size() + " cars");
    }
    
    @FXML
    private void handleNewRegistration() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/carregistration/view/car-form.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setTitle("New Car Registration");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            
            loadCars();
        } catch (IOException e) {
            showAlert("Error", "Failed to open registration form: " + e.getMessage());
        }
    }
    
    @FXML
    private void handleEditCar() {
        Car selectedCar = carsTable.getSelectionModel().getSelectedItem();
        if (selectedCar != null) {
            handleEditCar(selectedCar);
        } else {
            showAlert("Warning", "Please select a car to edit");
        }
    }
    
    private void handleEditCar(Car car) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/carregistration/view/car-form.fxml"));
            Parent root = loader.load();
            
            CarFormController controller = loader.getController();
            controller.setCar(car);
            
            Stage stage = new Stage();
            stage.setTitle("Edit Car Registration");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            
            loadCars();
        } catch (IOException e) {
            showAlert("Error", "Failed to open edit form: " + e.getMessage());
        }
    }
    
    @FXML
    private void handleDeleteCar() {
        Car selectedCar = carsTable.getSelectionModel().getSelectedItem();
        if (selectedCar != null) {
            handleDeleteCar(selectedCar);
        } else {
            showAlert("Warning", "Please select a car to delete");
        }
    }
    
    private void handleDeleteCar(Car car) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Delete");
        alert.setHeaderText("Delete Car Registration");
        alert.setContentText("Are you sure you want to delete the registration for " + 
                           car.getMake() + " " + car.getModel() + " (" + car.getLicensePlate() + ")?");
        
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                if (carDAO.deleteCar(car.getId())) {
                    showAlert("Success", "Car registration deleted successfully");
                    loadCars();
                } else {
                    showAlert("Error", "Failed to delete car registration");
                }
            }
        });
    }
    
    @FXML
    private void handleSearch() {
        String keyword = searchField.getText().trim();
        if (keyword.isEmpty()) {
            loadCars();
        } else {
            carsList.setAll(carDAO.searchCars(keyword));
            updateStatus();
            statusLabel.setText("Found " + carsList.size() + " cars matching '" + keyword + "'");
        }
    }
    
    @FXML
    private void handleRefresh() {
        loadCars();
        searchField.clear();
        statusLabel.setText("Data refreshed");
    }
    
    @FXML
    private void handleExportData() {
        showAlert("Info", "Export functionality will be implemented in future versions");
    }
    
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Car Registration System");
        alert.setContentText("Version 1.0\n\nA JavaFX application for managing car registrations.\n\nFeatures:\n- Add new car registrations\n- Edit existing registrations\n- Delete registrations\n- Search functionality\n- SQLite database storage");
        alert.showAndWait();
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
