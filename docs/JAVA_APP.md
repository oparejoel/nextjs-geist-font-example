## Java Application: Car Registration

Package root: `com.carregistration`

### Model: `com.carregistration.model.Car`
- **Fields**
  - `int id`
  - `String make`
  - `String model`
  - `int year`
  - `String licensePlate`
  - `String ownerName`
  - `LocalDate registrationDate`
  - `String color`
  - `String vin`
  - `String ownerPhone`
  - `String ownerEmail`
  - `String ownerAddress`
- **Key methods**
  - `String getFullCarName()` – e.g., `2024 Honda Civic`
  - `boolean isValidForRegistration()` – basic validation for required fields and year range

#### Example: constructing and validating a Car
```java
Car car = new Car();
car.setMake("Honda");
car.setModel("Civic");
car.setYear(2024);
car.setLicensePlate("ABC-123");
car.setOwnerName("Alex Doe");
car.setVin("1HGCM82633A004352");
boolean ok = car.isValidForRegistration();
```

### DAO: `com.carregistration.dao.CarDAO`
- **insertCar(Car car): boolean** – Inserts and sets generated `id`
- **getAllCars(): List<Car>** – Returns all cars ordered by creation time
- **getCarById(int id): Car | null** – Fetches by primary key
- **updateCar(Car car): boolean** – Updates fields; touches `updated_at`
- **deleteCar(int id): boolean** – Deletes by id
- **searchCars(String keyword): List<Car>** – LIKE search across multiple fields
- **isLicensePlateExists(String licensePlate): boolean**
- **isLicensePlateExists(String licensePlate, int excludeId): boolean**
- **isVinExists(String vin): boolean**
- **isVinExists(String vin, int excludeId): boolean**

#### Example: creating and querying cars
```java
CarDAO dao = new CarDAO();
Car car = new Car("Honda", "Civic", 2024, "ABC-123", "Alex Doe", "Blue", "1HGCM82633A004352");
car.setOwnerEmail("alex@example.com");
car.setOwnerPhone("+1 (555) 010-1234");
car.setOwnerAddress("123 Main St, Springfield");

boolean saved = dao.insertCar(car);
if (saved) {
  Car fetched = dao.getCarById(car.getId());
}

List<Car> results = dao.searchCars("Honda");
```

### Database: `com.carregistration.util.DatabaseConnection`
- **getConnection(): Connection** – Lazy-creates an SQLite connection and initializes schema
- **closeConnection(): void** – Closes if open
- **Schema (created on first connection)**
  - `cars` table with indexes on `license_plate`, `vin`, and `owner_name`
  - `registrations` table referencing `cars(id)` with `ON DELETE CASCADE`

#### Example: manual transaction
```java
try (Connection conn = DatabaseConnection.getConnection()) {
  conn.setAutoCommit(false);
  // ... execute statements ...
  conn.commit();
} catch (SQLException ex) {
  ex.printStackTrace();
}
```

### Controllers

#### `com.carregistration.controller.MainController`
Public UI actions (wired via FXML):
- `handleNewRegistration()` – open modal to add a new registration
- `handleEditCar()` – edit selected table row
- `handleDeleteCar()` – delete selected table row
- `handleSearch()` – filter table by keyword
- `handleRefresh()` – reload table
- `handleExportData()` – placeholder for export
- `handleExit()` – exit application
- `handleAbout()` – show about dialog

Table setup and status management occur during `initialize()`.

#### `com.carregistration.controller.CarFormController`
- `setCar(Car car)` – injects model into form
- `isSaved(): boolean` – whether last action successfully saved
- `getCar(): Car` – returns backing model

Private FXML handlers perform validation and call DAO methods:
- `handleSave()` – validate, then insert or update
- `handleCancel()` – close window without saving

### Entry Point
- `com.carregistration.Main` extends `javafx.application.Application`
  - `start(Stage primaryStage)` – loads `/com/carregistration/view/main-view.fxml`
  - `main(String[] args)` – launches the JavaFX app