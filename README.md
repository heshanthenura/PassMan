# <h1 align="center">PassMan</h1>
<h2 align="center">Password manager made using JavaFX</h1>
>Application is still under construction so there maybe security issues
---
## Menu

- [Features](#app-features)
- [Services](#services)
- [How to Build](#build)
- [How to use](#use)

---
## App Features <a name="app-features"></a>

### User Registration
- Register multiple users with unique usernames.

### Website User Details
- Add and manage website user details.
- Store website URLs, usernames, and passwords securely.
- Organize and categorize website user details. *(under implementation)*

### Card Details
- Add and manage card details. *(under implementation)*
- Store credit card information securely. *(under implementation)*
- Keep track of card numbers, expiration dates, and cardholder names. *(under implementation)*

### Private Notes
- Add and manage private notes. *(under implementation)*
- Securely store personal notes, reminders, or any other confidential information. *(under implementation)*

### User Management
- Easily switch between registered users.
- Manage and update user profiles. *(under implementation)*
---

## Services <a name="services"></a>

### H2 Databse service
- We store all data in H2 database service

### Maven
- We use maven for manage dependencies
---

## How to Build the Project <a name="build"></a>
### Make sure [Java](https://www.oracle.com/java/technologies/downloads/) and [Maven](https://maven.apache.org/download.cgi) is already installed and configured.

- Go to project directory and run
```
mvn clean install
```
- Above command will compile your JavaFX application, bundle it with its dependencies, and create an executable JAR file in the target/ directory.
```
java -jar target/my-javafx-app-1.0-SNAPSHOT.jar
```
- That's it! You've successfully built a JavaFX project using Maven. You can now distribute and run your JavaFX application using the generated JAR file.

## How to Use <a name="use"></a>

<img alt="Alt Text" src="/screenshots/img.png"/>


### If you are using this app for first time, click on register and register with a unique username and password
### And then login using username and password that you used to register
### Click on Add