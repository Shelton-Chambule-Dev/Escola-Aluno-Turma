package escola.services;
import escola.exceptions.TurmaException;
import escola.models.AlunoModel;
import escola.repository.TurmaRepository;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
public class TurmaServices2 implements TurmaRepository {

    private EntityManager em;

    public TurmaServices2(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(AlunoModel alunoModel) {
        try{
            em.getTransaction().begin();
            em.persist(alunoModel);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw new TurmaException(e.getMessage());
        }
    }

    @Override
    public Optional<AlunoModel> findById(Integer codigoAluno) {
        try{
            em.getTransaction().begin();
            AlunoModel alunoModel = em.find(AlunoModel.class, codigoAluno);
            if(alunoModel != null){
                em.find(AlunoModel.class,alunoModel);
                em.getTransaction().commit();
            }
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw new TurmaException(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public void update(AlunoModel alunoModel) {
        try{
            em.getTransaction().begin();
            em.merge(alunoModel);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw new TurmaException(e.getMessage());
        }
    }

    @Override
    public Optional<AlunoModel> removeById(Integer codigo) {
//        try{
//
//        }
        return Optional.empty();
    }

    @Override
    public int numeroTotalAluno() {
        return 0;
    }

    @Override
    public Set<AlunoModel> findAll() {
        return Set.of();
    }

    @Override
    public Set<AlunoModel> mediaSuperior(double media) {
        return Set.of();
    }

    @Override
    public void alterarNomeAluno(AlunoModel alunoModel) {

    }

    @Override
    public Boolean alterarMedia(AlunoModel alunoModel) {
        return null;
    }
}
