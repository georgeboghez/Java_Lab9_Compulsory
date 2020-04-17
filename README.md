# Java_Lab9_Compulsory

## Persistence
Continue the application from lab 8, creating an object-oriented model and using JPA (Java Persistence API) in order to communicate with the relational database.

The main specifications of the application are:

## Compulsory

- Create a persistence unit with the name "MusicAlbumsPU" (use EclipseLink or Hibernate or other JPA implementation).
Verify the presence of the persistence.xml file in your project. Make sure that the driver for EclipseLink or Hibernate was added to to your project classpath (or add it yourself).
- Create the package entity in your project and define the entity classes Artist and Album. You may use the IDE support in order to generate entity classes from database tables.
- Create the package util containing a class called PersistenceUtil. This class must contain a method for creating/returning an EntityManagerFactory object. Implement the Singleton desing pattern.
- Create the package repo in your project and define the classes ArtistRepository and AlbumRepository. Both classes must have the methods:
  - create that receives an entity and saves it into the database;
  - findById that returns an entity based on its primary key;
  - findByName that returns a list of entities that match a given name pattern. Use a named query in order to implement this method.
- The AlbumRepository class must also have the method findByArtist, that returns the list of albums of a given artist. Use a named query in order to implement this method.
- Create the package app and the main class AlbumManager in order to test your application.

![Screenshot](https://raw.githubusercontent.com/georgeboghez/Java_Lab9_Compulsory/master/Screenshot%20(1).png)
