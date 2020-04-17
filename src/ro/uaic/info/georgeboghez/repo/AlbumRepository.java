package ro.uaic.info.georgeboghez.repo;

import ro.uaic.info.georgeboghez.entity.Album;
import ro.uaic.info.georgeboghez.entity.Artist;
import ro.uaic.info.georgeboghez.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;

/**
 * The class which ensures the ability to interact with the database in order to create or retrieve Album objects
 */
public class AlbumRepository {
    EntityManagerFactory factory;
    /**
     * The entitymanager object creates entitytransaction instance for transaction management. By using entitymanager object, we can persist entities into database.
     */
    EntityManager em;

    public AlbumRepository() {
        factory = PersistenceUtil.createEntityManagerFactory();
        em = factory.createEntityManager();
    }

    /**
     * Receives an Album entity and saves it into the database
     * @param album an Album object
     */
    public void create(Album album) {
        em.getTransaction().begin();
        em.persist(album);
        em.getTransaction().commit();
        System.out.println("Successfully inserted album " + album + " into the database");
    }

    /**
     * Returns an Album entity based on its primary key
     * @param id the id of the album
     * @return an Album object
     */
    public Album findById(Long id) {
        em.getTransaction().begin();
        Album album = em.find(Album.class, id);
        em.getTransaction().commit();
        return album;
    }

    /**
     * Returns an Album entity based on its name
     * @param name the name of the album
     * @return an Album object
     */
    public Album findByName(String name) {
        em.getTransaction().begin();
        Album album = em.find(Album.class, name);
        em.getTransaction().commit();
        return album;
    }

//    public ArrayList<Album> findByArtist(Artist artist) {
//        ArrayList<Album> albums = new ArrayList<Album>();
//
//        EntityManager em = factory.createEntityManager();
//        em.getTransaction().begin();
//
//        albums = (ArrayList<Album>) em.createNamedQuery("Album.findByName")
//                .setParameter("name", artist.getName())
//                .setParameter("id",artist.getId())
//                .setParameter("country", artist.getCountry());
//
//        em.close();
//        return albums;
//    }

    /**
     * Closes both the entityManagerFactory and the entityManager
     */
    public void close() {
        factory.close();
        em.close();
    }

}
