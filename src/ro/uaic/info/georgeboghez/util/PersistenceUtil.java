package ro.uaic.info.georgeboghez.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Class which implements the Singleton desing pattern in order to uniquely create an object because we want a single EntityManagerFactory instance
 */
public class PersistenceUtil {
    /**
     * the unique object created when createEntityManagerFactory method is called
     */
    private static PersistenceUtil instance;
    /**
     * The main role of an EntityManagerFactory instance is to support instantiation of EntityManager instances. An EntityManagerFactory is constructed for a specific database, and by managing resources efficiently (e.g. a pool of sockets), it provides an efficient way to construct multiple EntityManager instances for that database.
     */
    private EntityManagerFactory entityManagerFactory;

    /**
     * In the constructor, the EntityManagerFactory object is created using the persistence unit MusicAlbumsPU mentioned inside the persistence.xml file
     */
    private PersistenceUtil() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    }

    /**
     * The method called to receive the unique EntityManagerFactory object
     * @return the uniquely created EntityManagerFactory object
     */
    public static EntityManagerFactory createEntityManagerFactory() {
        if(instance == null) {
            instance = new PersistenceUtil();
        }
        return instance.entityManagerFactory;
    }
}
