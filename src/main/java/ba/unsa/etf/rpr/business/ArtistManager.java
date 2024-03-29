package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Artists;
import ba.unsa.etf.rpr.exceptions.PlaysException;

import java.util.List;

/**
 * business class for Artists table
 * @author Adna Herak
 */
public class ArtistManager {
    public Artists searchByArtistName(String name) throws PlaysException{
        return DaoFactory.artistDao().searchByArtistName(name);
    }

    public List<Artists> getAll() throws PlaysException{
        return DaoFactory.artistDao().getAll();
    }
    public Artists add(Artists item) throws PlaysException{
        return DaoFactory.artistDao().add(item);
    }
    public Artists getById(int id) throws PlaysException {
        return DaoFactory.artistDao().getById(id);
    }
}
