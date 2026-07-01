# Escola

Projeto de estudo em Java com foco em persistência de dados utilizando **JDBC puro**, como preparação para a futura migração para **JPA/Hibernate**. A aplicação simula o gerenciamento de alunos (turma) e disciplinas de uma escola, implementando as operações básicas de CRUD (Create, Read, Update, Delete) diretamente sobre um banco de dados MySQL.

## ✨ Objetivo

Este repositório foi criado como prática de:

- Conexão com banco de dados via JDBC (`DriverManager`, `Connection`, `PreparedStatement`, `ResultSet`).
- Organização em camadas (Model, Repository, Service).
- Tratamento de exceções customizadas.
- Gerenciamento de dependências com Maven.
- Primeiros passos rumo à persistência de dados com JPA/Hibernate.

## 🛠️ Tecnologias

- **Java 25**
- **Maven** (gerenciamento de dependências e build)
- **MySQL** (banco de dados relacional)
- **MySQL Connector/J** `8.0.33`

## 📁 Estrutura do projeto

```
com.escola.chambule
├── controller
│   └── Main.java
├── DataBase
│   └── DataBaseConnetiom.java     # Conexão Singleton com o banco
├── exceptions
│   └── TurmaException.java        # Exceção customizada (RuntimeException)
├── models
│   ├── AlunoModel.java
│   └── DisciplinasModel.java
├── repository
│   ├── TurmaRepository.java       # Interface CRUD de Aluno/Turma
│   └── DisciplinaRepository.java  # Interface CRUD de Disciplina
└── services
    ├── TurmaServices2.java        # Implementação JDBC de TurmaRepository
    └── DisciplinaServices.java    # Implementação JDBC de DisciplinaRepository
```

## 🗄️ Modelo de dados

O banco de dados é composto por duas tabelas relacionadas: `turma` (alunos) e `disciplina`, com uma chave estrangeira ligando cada aluno à disciplina em que está matriculado.

```sql
CREATE TABLE disciplina(
    Id_disciplina SERIAL PRIMARY KEY,
    nome_disciplina VARCHAR(50) NOT NULL
);

CREATE TABLE turma(
    id_aluno SERIAL PRIMARY KEY,
    nome_aluno VARCHAR(50) NOT NULL,
    nome_curso VARCHAR(50) NOT NULL,
    ano_curso INT NOT NULL,
    media_atual INT NOT NULL,
    disciplina_Id BIGINT UNSIGNED,
    nome_disciplna VARCHAR(50) NOT NULL,
    FOREIGN KEY (disciplina_Id) REFERENCES disciplina(Id_disciplina)
);
```

> ⚠️ Atenção: crie primeiro a tabela `disciplina` e depois `turma`, já que esta última depende da chave estrangeira `disciplina_Id`.

⚙️ Configuração

1. Pré-requisitos

- JDK 25 instalado
- Maven instalado
- MySQL Server em execução (porta padrão `3306`)

2. Criar o banco de dados

```sql
CREATE DATABASE escola;
USE escola;
-- depois execute os CREATE TABLE acima
```

3. Configurar a conexão

A classe `DataBaseConnetiom` centraliza a conexão com o banco através do padrão **Singleton**:

```java
private String url = "jdbc:mysql://localhost:3306/escola";
private String user = "root";
private String password = "1234";
```

Ajuste `url`, `user` e `password` de acordo com o seu ambiente local.

4. Dependência Maven

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
    <scope>compile</scope>
</dependency>
```

5. Executar

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.escola.chambule.controller.Main"
```

🚀 Funcionalidades

### Aluno / Turma (`TurmaRepository`)

| Método | Descrição |
|---|---|
| `save(AlunoModel)` | Cadastra um novo aluno na turma |
| `findById(Integer)` | Busca um aluno pelo código |
| `update(AlunoModel)` | Atualiza todos os dados de um aluno |
| `remove(Integer)` | Remove um aluno pelo código |
| `numeroTotalAluno()` | Retorna o total de alunos cadastrados |
| `findAll()` | Lista todos os alunos |
| `mediaSuperior(double)` | Filtra alunos com determinada média |
| `alterarNomeAluno(AlunoModel)` | Atualiza apenas o nome do aluno |
| `alterarMedia(AlunoModel)` | Atualiza apenas a média do aluno |

### Disciplina (`DisciplinaRepository`)

| Método | Descrição |
|---|---|
| `save(DisciplinasModel)` | Cadastra uma nova disciplina |
| `deleteById(Integer)` | Remove uma disciplina pelo código |
| `update(DisciplinasModel)` | Atualiza o nome de uma disciplina |
| `findAll()` | Lista todas as disciplinas |

🧩 Tratamento de erros

Todas as exceções de banco de dados (`SQLException`) são capturadas e relançadas como `TurmaException`, uma `RuntimeException` customizada, mantendo a camada de serviço desacoplada de detalhes do JDBC.

👤 Autor

Projeto de estudo desenvolvido para prática de persistência de dados em Java.

## 📄 Licença

Este projeto está sob a licença definida no arquivo `LICENSE`.


