
# Calculator Servlet Web Application

A simple Java Servlet-based web application that performs basic arithmetic operations (addition, subtraction, multiplication, division) on user-provided numbers.

## ✅ Quick Fix: Simplify `web.xml`

To streamline your configuration, remove all `<servlet>` and `<servlet-mapping>` entries from your `web.xml`. Since your servlets are annotated with `@WebServlet`, explicit declarations in `web.xml` are unnecessary.

### Updated `web.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                             http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <display-name>Calculator Servlet Application</display-name>
    <welcome-file-list>
        <welcome-file>index.html</welcome-file>
    </welcome-file-list>
</web-app>
```

## 📁 Project Structure

```
calculator-webapp/
├── src/
│   └── main/
│       ├── java/
│       │   ├── InputServlet.java
│       │   └── CalculateServlet.java
│       └── webapp/
│           ├── index.html
│           └── WEB-INF/
│               └── web.xml
└── pom.xml
```

## ⚙️ Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher
- **Apache Maven**: Version 3.6 or higher
- **Apache Tomcat**: Version 9.x installed locally and running on port 8080

## 📦 Maven Dependencies

Ensure the following dependencies are included in your `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>4.0.1</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

- **Download Link**: [javax.servlet-api 4.0.1](https://repo.maven.apache.org/maven2/javax/servlet/javax.servlet-api/4.0.1/)

## 🚀 Building and Deploying the Application

1. **Build the WAR File**:

   Open a terminal in the project directory and run:

   ```bash
   mvn clean package
   ```

   This will generate a WAR file in the `target/` directory.

2. **Deploy to Apache Tomcat**:

   - Copy the generated WAR file (`calculator-webapp-1.0-SNAPSHOT.war`) to the `webapps/` directory of your Tomcat installation.

   - Start Tomcat by executing the startup script:

     - On Windows:

       ```bash
       catalina.bat start
       ```

     - On Unix/Linux/Mac:

       ```bash
       ./catalina.sh start
       ```

   - Access the application in your browser at: [http://localhost:8080/calculator-webapp-1.0-SNAPSHOT/](http://localhost:8080/calculator-webapp-1.0-SNAPSHOT/)

## 📝 Notes

- Ensure that Apache Tomcat is running on port 8080. If it's running on a different port, adjust the URL accordingly.

- If you encounter a 404 error, verify that the WAR file is correctly deployed in the `webapps/` directory and that Tomcat has successfully unpacked it.

- The application uses `@WebServlet` annotations for servlet configuration, eliminating the need for explicit servlet declarations in `web.xml`.

---

Feel free to customize this `README.md` further to suit your project's specific needs. 