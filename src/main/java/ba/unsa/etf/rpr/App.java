package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.PlaysDao;
import ba.unsa.etf.rpr.dao.PlaysDaoSQLimpl;
import ba.unsa.etf.rpr.domain.Plays;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    private static void testiranje(){
      try{  Plays play=new Plays();
         List<String> p=new ArrayList<>();
        p=(play.getAllGenres());
        for(int i=0;i<p.size();i++)
            System.out.println(p.get(i).toString());
      }
      catch (Exception e)
      {
          System.out.println(e);
      }
    }
    public static void main( String[] args )
    {
        testiranje();
    }
}
