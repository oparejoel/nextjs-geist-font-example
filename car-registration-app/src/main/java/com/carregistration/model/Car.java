package com.carregistration.model;

import java.time.LocalDate;

public class Car {
    private int id;
    private String make;
    private String model;
    private int year;
    private String licensePlate;
    private String ownerName;
    private LocalDate registrationDate;
    private String color;
    private String vin;
    private String ownerPhone;
    private String ownerEmail;
    private String ownerAddress;

    public Car() {
        this.registrationDate = LocalDate.now();
    }

    public Car(String make, String model, int year, String licensePlate, 
               String ownerName, String color, String vin) {
        this();
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.color = color;
        this.vin = vin;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }

    public String getOwnerPhone() { return ownerPhone; }
    public void setOwnerPhone(String ownerPhone) { this.ownerPhone = ownerPhone; }

    public String getOwnerEmail() { return ownerEmail; }
    public void setOwnerEmail(String ownerEmail) { this.ownerEmail = ownerEmail; }

    public String getOwnerAddress() { return ownerAddress; }
    public void setOwnerAddress(String ownerAddress) { this.ownerAddress = ownerAddress; }

    public String getFullCarName() {
        return year + " " + make + " " + model;
    }

    public boolean isValidForRegistration() {
        return make != null && !make.trim().isEmpty() &&
               model != null && !model.trim().isEmpty() &&
               year > 1900 && year <= LocalDate.now().getYear() + 1 &&
               licensePlate != null && !licensePlate.trim().isEmpty() &&
               ownerName != null && !ownerName.trim().isEmpty() &&
               vin != null && !vin.trim().isEmpty();
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", licensePlate='" + licensePlate + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", registrationDate=" + registrationDate +
                ", color='" + color + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }
}
