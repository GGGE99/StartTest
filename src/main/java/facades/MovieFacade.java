package facades;

import entities.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;

    private MovieFacade() {
    }

    public static MovieFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void addMovie(int year, String title, String[] actors) {
        Movie movie = new Movie(year, title, actors);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static Movie getMocieById(long id) {
        EntityManager em = emf.createEntityManager();
        Movie movie = null;
        try {
            movie = em.find(Movie.class, id);
        } finally {
            em.close();
        }
        return movie;
    }

    //TODO Remove/Change this before use
    public long getRenameMeCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long renameMeCount = (long) em.createQuery("SELECT COUNT(r) FROM RenameMe r").getSingleResult();
            return renameMeCount;
        } finally {
            em.close();
        }

    }

}
