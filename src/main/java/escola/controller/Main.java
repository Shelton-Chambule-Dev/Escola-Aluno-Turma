package escola.controller;
import escola.models.AlunoModel;
import escola.models.DisciplinasModel;
import escola.services.DisciplinaServices;
import escola.services.TurmaServices2;

public class Main {
    static void main() {

        TurmaServices2 turmaServices = new TurmaServices2();
        DisciplinaServices disciplinaServices = new DisciplinaServices();
        DisciplinasModel disciplinasModel = new DisciplinasModel(4,"Logica de Programacao");
        AlunoModel alunoModel = new AlunoModel();

             alunoModel.setNome("Shelton Chambule");
             alunoModel.setCurso("Programacao informatica");
             alunoModel.setAnoCurso(1);
             alunoModel.setMediaAtual(0.0);
            alunoModel.setId_disciplina(1);
            alunoModel.setNomeDisciplina("Introducao a  base de dados");
            alunoModel.setId_aluno(3);
            turmaServices.update(alunoModel);

//                int alunoModel1 = turmaServices.numeroTotalAluno();
//                System.out.println("Numero total de Alunos: "+alunoModel1);
//
//                Set<AlunoModel> alunoNotas = turmaServices.mediaSuperior(12.5);
//                for(AlunoModel que: alunoNotas){
//                    System.out.println("Codigo_aluno: "+que.getCodigoAluno());
//                    System.out.println("Media_atual: "+que.getMediaAtual());
//                }

//        List<DisciplinasModel> disciplina = disciplinaServices.findAll();
//        for(DisciplinasModel que: disciplina){
//            System.out.println("Id: "+que.getId_disciplina());
//            System.out.println("Nome disciplina: "+que.getNomeDisciplina());
//            System.out.println("===================================");
//        }

        //System.out.println(" codigo_disciplina");
       // turmaServices.alterarNomeAluno(alunoModel);
                                 // alterar  media
//                            alunoModel.setId(2);
//                            alunoModel.setMediaAtual(16);
//                             turmaServices.alterarMedia(alunoModel);

               //  Para fazer impressao de todoas informacoes
//        Set<AlunoModel> alunoModelSet = turmaServices.findAll();
//        for(AlunoModel alunoModel1: alunoModelSet){
//            System.out.println("Id: "+alunoModel1.getId_aluno());
//            System.out.println("Nome: "+alunoModel1.getNome());
//            System.out.println("Curso: "+alunoModel1.getCurso());
//            System.out.println("Ano Curso: "+alunoModel1.getAnoCurso());
//            System.out.println("Media Atual: "+alunoModel1.getMediaAtual());
//            System.out.println("ID Disciplina: "+alunoModel1.getId_disciplina());
//            System.out.println("Nome Disciplina: "+alunoModel1.getNomeDisciplina());
//            System.out.println("================================");
//        }
//        Optional<AlunoModel> alunoModels = turmaServices.findById(4);
//        if(alunoModels.isPresent()){
//            AlunoModel  aluno = alunoModels.get();
//            System.out.println("Id: "+aluno.getId_aluno());
//            System.out.println("Nome: "+aluno.getNome());
//            System.out.println("Curso: "+aluno.getCurso());
//            System.out.println("Ano Curso: "+aluno.getAnoCurso());
//            System.out.println("Media Atual: "+aluno.getMediaAtual());
//        }
    }
}
