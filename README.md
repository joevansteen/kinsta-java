![Photo by Tengyart on Unsplash](https://user-images.githubusercontent.com/2342458/202706389-501decaf-810e-4876-a749-7b9e593e67b1.png)

# EATSv5 - Hello World - Java
A first case example of how to set up a Java application for deployment on Kinsta App Hosting services.

---
Kinsta has created a developer-centric cloud host / PaaS, a Platform as a Service. They are striving to make it easier for developers to build and implement web projects. The intention is for developers to be able to focus on coding and building the application functionality, and for Kinsta to take care of deployment and provide fast, scalable hosting. + 24/7 expert-only support.

This is a scheme which has been a long time coming.  Previously the application developer, or an infrastructure support team, needed to be detail concerned about not only the application functionality, but also the infrastructure platform, and the interface of the application to the infrastructure platform, in a myriad of detail ways, before an application could be delivered and made available to users.  PaaS represents a near full cycle return to the glass house environment of the 1970s with a clean separation of responsibility and concern over technology details between application development and the operational demands of system implementation on a specified hardware platform.

- [Start your free trial](https://kinsta.com/signup/?product_type=app-db)
- [Application Hosting](https://kinsta.com/application-hosting)
- [Database Hosting](https://kinsta.com/database-hosting)

## Dependency Management

During the deployment process Kinsta will automatically install dependencies defined in your pom.xml file.

## Web Server Setup

### Port
Kinsta automatically sets the `PORT` environment variable. You should **not** define it yourself and you should **not** hard-code it into the application. Use 
`System.getenv("PORT")` in your code when referring to the server port. 

### Start Command
When deploying an application Kinsta will automatically create processes based on the Procfile in the root of the repository. Make sure to properly identify the POM artifactId and version in the  prodfile command to run your server.  For us this is: 

```
web: java -jar target/eatsv5-java-hello-world-1.0-SNAPSHOT.jar
```

Make sure that your main class is defined in the pom.xml file.
