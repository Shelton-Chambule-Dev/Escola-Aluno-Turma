package escola.jpaConfig;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaConnection {

  private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Escola");

  public static EntityManagerFactory getEntityManagerFactory(){
      return emf;
  }
}
