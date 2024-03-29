package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Directors;
import ba.unsa.etf.rpr.exceptions.PlaysException;

import java.util.List;

public class DirectorsManager {
    public Directors searchByDirectorName(String name) throws PlaysException{
        return DaoFactory.directorsDao().searchByDirectorName(name);
    }

    public List<Directors> getAll() throws PlaysException{
        return DaoFactory.directorsDao().getAll();
    }
    public Directors add(Directors item) throws PlaysException{
        return DaoFactory.directorsDao().add(item);
    }
    public Directors getById(int id) throws PlaysException {
        return DaoFactory.directorsDao().getById(id);
    }
}
