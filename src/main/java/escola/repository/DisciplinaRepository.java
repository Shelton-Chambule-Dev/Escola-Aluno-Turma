package escola.repository;
import escola.models.DisciplinasModel;
import java.util.List;

public interface DisciplinaRepository {

            public void  save(DisciplinasModel disciplinasModel);
            public  void deleteById(Integer codigo);
            public Boolean update(DisciplinasModel disciplinasModel);
            public  List<DisciplinasModel> findAll();
}