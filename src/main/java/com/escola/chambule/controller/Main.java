package com.escola.chambule.controller;
import com.escola.chambule.models.AlunoModel;
import com.escola.chambule.services.TurmaServices2;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
public class Main {
    static void main() {

        AlunoModel alunoModel = new AlunoModel();
        TurmaServices2 turmaServices = new TurmaServices2();

//         alunoModel.setNomeDisciplina("Logica de programacao");
//         alunoModel.setCodigoDisciplina(12);
            alunoModel.setId(2);
             alunoModel.setCodigoAluno(2025053);
             alunoModel.setNome("Belga  Chambule");
            alunoModel.setCurso("Programacao informatica");
            alunoModel.setAnoCurso(1);
            alunoModel.setMediaAtual(16);
            //turmaServices.remove(4);
          //  turmaServices.update(alunoModel);

//                int alunoModel1 = turmaServices.numeroTotalAluno();
//                System.out.println("Numero total de Alunos: "+alunoModel1);
//
//                Set<AlunoModel> alunoNotas = turmaServices.mediaSuperior(12.5);
//                for(AlunoModel que: alunoNotas){
//                    System.out.println("Codigo_aluno: "+que.getCodigoAluno());
//                    System.out.println("Media_atual: "+que.getMediaAtual());
//                }
        alunoModel.setId(2);
        alunoModel.setNome("Ruth  Chambule");
        turmaServices.alterarNomeAluno(alunoModel);
                                 // alterar  media
//                            alunoModel.setId(2);
//                            alunoModel.setMediaAtual(16);
//                             turmaServices.alterarMedia(alunoModel);

                // Para fazer impressao de todoas informacoes
//        Set<AlunoModel> alunoModelSet = turmaServices.findAll();
//        for(AlunoModel alunoModel1: alunoModelSet){
//            System.out.println("Id: "+alunoModel1.getId());
//            System.out.println("Codigo_Aluno: "+alunoModel1.getCodigoAluno());
//            System.out.println("Nome: "+alunoModel1.getNome());
//            System.out.println("Curso: "+alunoModel1.getCurso());
//            System.out.println("Ano Curso: "+alunoModel1.getAnoCurso());
//            System.out.println("Media Atual: "+alunoModel1.getMediaAtual());
//            System.out.println("================================");
//        }
//        Optional<AlunoModel> alunoModels = turmaServices.findById(3);
//        if(alunoModels.isPresent()){
//            AlunoModel  aluno = alunoModels.get();
//            System.out.println("Id: "+aluno.getId());
//            System.out.println("Codigo_Aluno: "+aluno.getCodigoAluno());
//            System.out.println("Nome: "+aluno.getNome());
//            System.out.println("Curso: "+aluno.getCurso());
//            System.out.println("Ano Curso: "+aluno.getAnoCurso());
//            System.out.println("Media Atual: "+aluno.getMediaAtual());
//        }
    }
}
