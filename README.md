# Homework Service

Homework: Service for managing persons

## Usage:

1. **Database Setup:**
    - Run `src/test/resources/data.sql` to create the database and insert some dummy data.
    - Adjust `application.properties` if needed to establish a database connection.
    
2. **Build and Run:**
    - Execute the following commands:
        ```bash
        mvn clean install
        mvn spring-boot:run
        ```
    - The application will be accessible at `http://localhost:8080`.

3. **Example Usage:**
    - **GET: http://localhost:8080/persons/get/all**
    - **GET: http://localhost:8080/persons/get/1**
    - **POST: http://localhost:8080/persons/add**
        - With a JSON Request Body:
            ```json
            {
                "firstName": "Andras",
                "lastName": "Kovacs",
                "addresses": [
                    {
                        "address": "1111 Budapest, Fo ut 1",
                        "addressType": "Permanent"
                    }
                ],
                "contacts": [
                    {
                        "contact": "+36301234567",
                        "contactType": "Phone"
                    }
                ]
            }
            ```
    - **PUT: http://localhost:8080/persons/update/1**
        - With a JSON Request Body: (see above example)
    - **DELETE: http://localhost:8080/persons/delete/1**

## Room for Improvement:

1. **Finish Integration Tests:**
    - Complete integration tests to automate sandbox database setup.

2. **Enhance Validation:**
    - Utilize Enumerated types for `addressType` or `contactType`.
    - Improve validation for permanent and temporary addresses.

3. **Containerization:**
    - Containerize the application using Docker for easier deployment and usage.

4. **Documentation:**
    - Add comments to classes and public methods for better code understanding.
