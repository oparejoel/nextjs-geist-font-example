package com.carregistration.controller;

import com.carregistration.dao.CarDAO;
import com.carregistration.model.Car;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class CarFormController {
    
    @FXML private TextField makeField;
    @FXML private TextField modelField;
    @FXML private Spinner<Integer> yearSpinner;
    @FXML private TextField licensePlateField;
    @FXML private TextField vinField;
    @FXML private TextField ownerNameField;
    @FXML private TextField colorField;
    @FXML private TextField ownerPhoneField;
    @FXML private TextField ownerEmailField;
    @FXML private TextArea ownerAddressField;
    @FXML private DatePicker registrationDatePicker;
    @FXML private VBox errorMessages;
    @FXML private Button saveButton;
    @FXML private Button cancelButton;
    
    private final CarDAO carDAO = new CarDAO();
    private Car car;
    private boolean saved = false;
    
    @FXML
    public void initialize() {
        setupYearSpinner();
        setupButtons();
        registrationDatePicker.setValue(LocalDate.now());
    }
    
    private void setupYearSpinner() {
        int currentYear = LocalDate.now().getYear();
        SpinnerValueFactory<Integer> valueFactory = 
            new SpinnerValueFactory.IntegerSpinnerValueFactory(1900, currentYear + 1, currentYear);
        yearSpinner.setValueFactory(valueFactory);
    }
    
    private void setupButtons() {
        saveButton.setOnAction(event -> handleSave());
        cancelButton.setOnAction(event -> handleCancel());
    }
    
    public void setCar(Car car) {
        this.car = car;
        populateFields();
    }
    
    private void populateFields() {
        if (car != null) {
            makeField.setText(car.getMake());
            modelField.setText(car.getModel());
            yearSpinner.getValueFactory().setValue(car.getYear());
            licensePlateField.setText(car.getLicensePlate());
            vinField.setText(car.getVin());
            ownerNameField.setText(car.getOwnerName());
            colorField.setText(car.getColor());
            ownerPhoneField.setText(car.getOwnerPhone());
            ownerEmailField.setText(car.getOwnerEmail());
            ownerAddressField.setText(car.getOwnerAddress());
            registrationDatePicker.setValue(car.getRegistrationDate());
        }
    }
    
    @FXML
    private void handleSave() {
        if (validateInput()) {
            if (car == null) {
                car = new Car();
            }
            
            car.setMake(makeField.getText().trim());
            car.setModel(modelField.getText().trim());
            car.setYear(yearSpinner.getValue());
            car.setLicensePlate(licensePlateField.getText().trim().toUpperCase());
            car.setVin(vinField.getText().trim().toUpperCase());
            car.setOwnerName(ownerNameField.getText().trim());
            car.setColor(colorField.getText().trim());
            car.setOwnerPhone(ownerPhoneField.getText().trim());
            car.setOwnerEmail(ownerEmailField.getText().trim());
            car.setOwnerAddress(ownerAddressField.getText().trim());
            car.setRegistrationDate(registrationDatePicker.getValue());
            
            boolean success;
            if (car.getId() == 0) {
                success = carDAO.insertCar(car);
            } else {
                success = carDAO.updateCar(car);
            }
            
            if (success) {
                saved = true;
                closeWindow();
            } else {
                showError("Failed to save car registration. Please try again.");
            }
        }
    }
    
    @FXML
    private void handleCancel() {
        closeWindow();
    }
    
    private boolean validateInput() {
        errorMessages.getChildren().clear();
        boolean isValid = true;
        
        // Validate make
        if (makeField.getText() == null || makeField.getText().trim().isEmpty()) {
            addError("Make is required");
            isValid = false;
        }
        
        // Validate model
        if (modelField.getText() == null || modelField.getText().trim().isEmpty()) {
            addError("Model is required");
            isValid = false;
        }
        
        // Validate year
        int year = yearSpinner.getValue();
        int currentYear = LocalDate.now().getYear();
        if (year < 1900 || year > currentYear + 1) {
            addError("Year must be between 1900 and " + (currentYear + 1));
            isValid = false;
        }
        
        // Validate license plate
        String licensePlate = licensePlateField.getText().trim().toUpperCase();
        if (licensePlate.isEmpty()) {
            addError("License plate is required");
            isValid = false;
        } else if (!licensePlate.matches("^[A-Z0-9-]+$")) {
            addError("License plate can only contain letters, numbers, and hyphens");
            isValid = false;
        } else if (carDAO.isLicensePlateExists(licensePlate, car != null ? car.getId() : -1)) {
            addError("License plate already exists");
            isValid = false;
        }
        
        // Validate VIN
        String vin = vinField.getText().trim().toUpperCase();
        if (vin.isEmpty()) {
            addError("VIN is required");
            isValid = false;
        } else if (vin.length() != 17) {
            addError("VIN must be exactly 17 characters");
            isValid = false;
        } else if (!vin.matches("^[A-Z0-9]+$")) {
            addError("VIN can only contain letters and numbers");
            isValid = false;
        } else if (carDAO.isVinExists(vin, car != null ? car.getId() : -1)) {
            addError("VIN already exists");
            isValid = false;
        }
        
        // Validate owner name
        if (ownerNameField.getText() == null || ownerNameField.getText().trim().isEmpty()) {
            addError("Owner name is required");
            isValid = false;
        }
        
        // Validate email format
        String email = ownerEmailField.getText().trim();
        if (!email.isEmpty() && !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            addError("Invalid email format");
            isValid = false;
        }
        
        // Validate phone format
        String phone = ownerPhoneField.getText().trim();
        if (!phone.isEmpty() && !phone.matches("^\\+?[0-9\\s-()]+$")) {
            addError("Invalid phone format");
            isValid = false;
        }
        
        return isValid;
    }
    
    private void addError(String message) {
        Label errorLabel = new Label("• " + message);
        errorLabel.setStyle("-fx-text-fill: #f44336;");
        errorMessages.getChildren().add(errorLabel);
    }
    
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private void closeWindow() {
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }
    
    public boolean isSaved() {
        return saved;
    }
    
    public Car getCar() {
        return car;
    }
}
