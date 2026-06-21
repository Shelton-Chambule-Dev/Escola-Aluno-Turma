package com.escola.chambule.repository;
import com.escola.chambule.models.AlunoModel;
import com.escola.chambule.models.DisciplinasModel;
import java.util.List;
import java.util.Optional;
public interface DisciplinaRepository {

            public List<DisciplinasModel> saveDisciplin(DisciplinasModel disciplinasModel);
            public  void removeDisciplin(Integer codigo);
            public List<DisciplinasModel> updateDisciplin(DisciplinasModel disciplinasModel);
            public
}