package com.escola.chambule.repository;
import com.escola.chambule.models.AlunoModel;

import java.util.Optional;
import java.util.Set;
public interface TurmaRepository {

    public Boolean save(AlunoModel alunoModel);
    public Optional<AlunoModel> findById(Integer codigoAluno);
    public AlunoModel update(AlunoModel alunoModel);
    public Optional<AlunoModel> remove(Integer codigo);
    public int numeroTotalAluno();
    public Set<AlunoModel> findAll();
    public Set<AlunoModel> mediaSuperior(double media);

    public void alterarNomeAluno(AlunoModel alunoModel);
    public Boolean alterarMedia(AlunoModel alunoModel);
    public Set<AlunoModel> disciplinasInscritas(Integer codigoAluno);

    // Metodo que ira exibir numero de disciplinas que o aluno esta a fazer
    // ex: aluno esta a fazer 5 disciplinas
    public Set<AlunoModel> exibirDiscplinasInscritas();

}
