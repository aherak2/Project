package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Users;
import ba.unsa.etf.rpr.exceptions.PlaysException;

import java.util.List;

public class UsersManager {


    public Users searchByUsername(String user) throws PlaysException{
        return DaoFactory.usersDao().searchByUsername(user);
    }
    public static boolean validateUser(String correctName, String correctPass) {
        try {
        Users u= DaoFactory.usersDao().searchByUsername(correctName);
        if(u.getPassword()==correctPass)
                return true;
        } catch (PlaysException e) {
            return false;
        }
        return true;
    }
    public List<Users> getAll() throws PlaysException{
        return DaoFactory.usersDao().getAll();
    }
    public Users add(Users item) throws PlaysException{
        return DaoFactory.usersDao().add(item);
    }
    public Users getById(int id) throws PlaysException {
        return DaoFactory.usersDao().getById(id);
    }
}
