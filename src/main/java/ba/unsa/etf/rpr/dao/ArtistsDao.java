package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.Artists;
import ba.unsa.etf.rpr.exceptions.PlaysException;


/**
 * Dao interface for Artist domain bean
 * @author Adna Herak
 */
public interface ArtistsDao extends Dao<Artists> {
    public Artists searchByArtistName(String name) throws PlaysException;
    public Artists searchById(int Id) throws PlaysException;
}
