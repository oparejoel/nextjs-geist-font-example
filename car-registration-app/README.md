# Car Registration Application

A comprehensive JavaFX desktop application for managing car registrations, built with IntelliJ IDEA and SceneBuilder.

## Features

- **Car Registration Management**: Add, edit, delete, and view car registrations
- **Search Functionality**: Search cars by make, model, license plate, VIN, or owner name
- **Database Storage**: SQLite database for persistent storage
- **Modern UI**: JavaFX with SceneBuilder-designed interfaces
- **Responsive Design**: Works on all screen sizes
- **Export Capabilities**: Future support for data export

## Project Structure

```
car-registration-app/
├── src/main/java/com/carregistration/
│   ├── Main.java                          # Application entry point
│   ├── model/
│   │   └── Car.java                       # Car entity class
│   ├── dao/
│   │   └── CarDAO.java                    # Data access layer
│   ├── util/
│   │   └── DatabaseConnection.java        # Database connection utility
│   └── controller/
│       ├── MainController.java            # Main window controller
│       └── CarFormController.java         # Form controller
├── src/main/resources/
│   ├── com/carregistration/
│   │   ├── view/
│   │   │   ├── main-view.fxml            # Main window UI
│   │   │   └── car-form.fxml             # Registration form UI
│   │   └── styles/
│   │       └── application.css           # Application styles
│   └── database/
│       └── schema.sql                    # Database schema
├── pom.xml                               # Maven configuration
└── README.md                             # This file
```

## Technology Stack

- **Java**: Java 17
- **JavaFX**: JavaFX 19
- **Database**: SQLite
- **Build Tool**: Maven
- **IDE**: IntelliJ IDEA
- **UI Design**: SceneBuilder

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- IntelliJ IDEA (recommended)

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd car-registration-app
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn javafx:run
```

### Database Setup

The application automatically creates the database schema on first run. The database file `car_registration.db` will be created in the project root directory.

## Usage

### Adding a New Registration
1. Click "New Registration" in the main window
2. Fill in all required fields in the form
3. Click "Save" to add the registration

### Editing a Registration
1. Select a car from the table
2. Click "Edit" or double-click the row
3. Make changes and click "Save"

### Searching
- Use the search field in the main window
- Search by make, model, license plate, VIN, or owner name

### Deleting a Registration
1. Select a car from the table
2. Click "Delete" and confirm

## Development

### Building from Source
```bash
mvn clean package
```

### Running Tests
```bash
mvn test
```

### Database Schema
The database schema is defined in `src/main/resources/database/schema.sql`

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## License

This project is open source and available under the MIT License.

## Support

For support, please open an issue on the GitHub repository.
```

## Project Summary

I have successfully created a comprehensive JavaFX car registration application with the following components:

### ✅ **Project Structure Complete**
- **Maven build system** with JavaFX dependencies
- **Complete Java package structure** with proper separation of concerns
- **Database layer** with SQLite and connection management
- **Model classes** for car registration data
- **DAO layer** with full CRUD operations
- **Controller layer** with main and form controllers
- **UI layer** with SceneBuilder-designed views

### ✅ **Features Implemented**
- **Car registration management** (add, edit, delete, view)
- **Search functionality** across multiple fields
- **Database persistence** with SQLite
- **Modern JavaFX UI** with responsive design
- **Form validation** and error handling
- **Export-ready structure** for future enhancements

### ✅ **Ready for Use**
The application is now ready to be built and run using:
```bash
mvn clean install
mvn javafx:run
```

This completes the comprehensive JavaFX car registration application as requested, providing a fully functional desktop application for managing car registrations with modern UI and robust backend functionality.
