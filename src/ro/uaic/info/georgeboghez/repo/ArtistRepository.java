package ro.uaic.info.georgeboghez.repo;

import ro.uaic.info.georgeboghez.entity.Artist;
import ro.uaic.info.georgeboghez.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * The class which ensures the ability to interact with the database in order to create or retrieve Artist objects
 */
public class ArtistRepository {
    EntityManagerFactory factory;
    /**
     * The entitymanager object creates entitytransaction instance for transaction management. By using entitymanager object, we can persist entities into database.
     */
    EntityManager em;

    public ArtistRepository() {
        factory = PersistenceUtil.createEntityManagerFactory();
        em = factory.createEntityManager();
    }

    /**
     * Receives an entity and saves it into the database
     * @param artist an Artist object
     */
    public void create(Artist artist) {
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
        System.out.println("Successfully inserted artist " + artist + " into the database");
    }

    /**
     * Returns an Artist entity based on its primary key
     * @param id the id of the artist
     * @return an Artist object
     */
    public Artist findById(Long id) {
        em.getTransaction().begin();
        Artist artist = em.find(Artist.class, id);
        em.getTransaction().commit();
        return artist;
    }

    /**
     * Returns an Artist entity based on its name
     * @param name the name of the artist
     * @return an Artist object
     */
    public Artist findByName(String name) {
        em.getTransaction().begin();
        Artist artist = em.find(Artist.class, name);
        em.getTransaction().commit();
        return artist;
    }

    /**
     * Closes both the entityManagerFactory and the entityManager
     */
    public void close() {
        factory.close();
        em.close();
    }
}
