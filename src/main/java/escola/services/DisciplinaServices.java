package escola.services;
import escola.jpaConfig.JpaConnection;
import escola.exceptions.TurmaException;
import escola.models.DisciplinasModel;
import escola.repository.DisciplinaRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
public class DisciplinaServices  implements DisciplinaRepository {

    private EntityManager em;

    public DisciplinaServices(EntityManager em) {
        this.em = em;
    }
    @Override
    public void  save(DisciplinasModel disciplinasModel) {
       try{
           em.getTransaction().begin();
           em.persist(disciplinasModel);
           em.getTransaction().commit();
       } catch (RuntimeException e) {
           throw new TurmaException(e.getMessage());
       }
    }

    @Override
    public void deleteById(Integer codigo) {

    }

    @Override
    public Boolean update(DisciplinasModel disciplinasModel) {
        return null;
    }

    @Override
    public List<DisciplinasModel> findAll() {
        return List.of();
    }
}