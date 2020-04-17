package ro.uaic.info.georgeboghez.app;

import ro.uaic.info.georgeboghez.entity.Album;
import ro.uaic.info.georgeboghez.entity.Artist;
import ro.uaic.info.georgeboghez.repo.AlbumRepository;
import ro.uaic.info.georgeboghez.repo.ArtistRepository;

/**
 * Class created to test the application
 */
public class Main {
    public static void main(final String[] args) {
        AlbumRepository albumRepository = new AlbumRepository();
        ArtistRepository artistRepository = new ArtistRepository();

        Artist artist = new Artist();
        artist.setId(20L);
        artist.setName("Twenty One Pilots");
        artist.setCountry("USA");

        artistRepository.create(artist);

        Album album = albumRepository.findById(2L);
        artist = artistRepository.findById(11L);

        System.out.println("Found album (for findById(2L)): " + album);
        System.out.println("Found artist (for findById(11L)): " + artist);

        artist = artistRepository.findById(20L);

        System.out.println("Found artist (for findById(20L)): " + artist);

        albumRepository.close();
        artistRepository.close();
    }
}