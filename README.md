# E-Commerce Platform REST API

This project is a Spring Boot-based REST API for an e-commerce platform. It provides endpoints for managing users, products, categories, messages, and more. The API is designed to be scalable, secure, and easy to integrate with front-end applications or other services.

## Features
- User registration, authentication, and profile management
- Product CRUD operations
- Category management
- Messaging system
- Password change functionality
- Database migration support (Flyway)
- DTOs and mappers for clean architecture

## Technologies Used
- Java 17+
- Spring Boot
- Spring Data JPA
- Flyway (database migrations)
- H2 (default dev database, can be switched to MySQL/PostgreSQL)
- Maven

## Getting Started

### Prerequisites
- Java 17 or higher installed ([Download here](https://adoptium.net/))
- Maven installed ([Download here](https://maven.apache.org/download.cgi))
- Git installed ([Download here](https://git-scm.com/downloads))

### Clone the Repository
```sh
git clone https://github.com/rahulkundu1209/E-Commerce_Platform_REST_API.git
cd spring-api-starter-main
```

### Database Setup
- By default, the project uses H2 in-memory database for development.
- To use MySQL/PostgreSQL, update `src/main/resources/application.yaml` with your database credentials.
- Database migrations are managed by Flyway (`src/main/resources/db/migration`).

### Running the Application
#### Using Maven Wrapper
```sh
./mvnw spring-boot:run
```
On Windows:
```cmd
mvnw.cmd spring-boot:run
```

#### Or Using Maven Directly
```sh
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

### API Documentation
- Endpoints are defined in the `controller` package.
- You can use tools like [Postman](https://www.postman.com/) or [curl](https://curl.se/) to test the API.
- (Optional) Integrate Swagger for interactive API docs.

### Running Tests
```sh
mvn test
```

## Project Structure
```
src/main/java/com/codewithmosh/store/
  controller/        # REST controllers
  dtos/              # Data Transfer Objects
  entities/          # JPA entities
  mappers/           # MapStruct mappers
  repositories/      # Spring Data JPA repositories
src/main/resources/
  application.yaml   # Main configuration
  db/migration/      # Flyway migration scripts
  static/            # Static resources
  templates/         # HTML templates
```

## Contributing
1. Fork the repository
2. Create your feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/YourFeature`)
5. Create a Pull Request

## License
This project is licensed under the MIT License.

## Contact
For questions or support, open an issue or contact the repository owner.
