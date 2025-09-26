# Projeto de Streaming de Vídeos com Spring Data JPA

Este projeto é uma aplicação backend desenvolvida em Java com **Spring Boot** que simula as funcionalidades básicas de um sistema de streaming de vídeos. Ele utiliza o **Spring Data JPA** para mapear um modelo de dados relacional e realizar consultas complexas para buscar informações sobre vídeos, usuários e suas interações.

## Tecnologias Utilizadas
* Java 17+
* Spring Boot 3.x
* Spring Data JPA (Hibernate)
* MySQL
* Maven

## Requisitos Atendidos

O projeto implementa todos os requisitos solicitados, conforme detalhado abaixo:

-   [x] **Mapeamento de Entidades JPA:** Todas as tabelas do diagrama MER (`USUARIO`, `PERFIL`, `VIDEO`, `CATEGORIA`, `AVALIACAO`, `VISUALIZACAO`) foram mapeadas para entidades Java com seus respectivos atributos, chaves e relacionamentos.
-   [x] **Inserção de Registros via JPA:** A aplicação popula o banco de dados com uma massa de dados realista a cada execução, utilizando os repositórios JPA (`.save()` e `.saveAll()`) para persistir as informações.
-   [x] **Implementação de Consultas Complexas:** As seguintes consultas foram implementadas como *query methods* nos repositórios:
    -   Buscar vídeos por parte do título com ordenação alfabética.
    -   Listar todos os vídeos de uma determinada categoria, ordenados pelo título.
    -   Obter os 10 vídeos mais bem avaliados (com base na média de notas).
    -   Obter os 10 vídeos mais assistidos (com base no número de visualizações).
    -   Identificar o usuário que mais assistiu a vídeos.

## Como Executar o Projeto

#### 1. Pré-requisitos
* JDK 17 ou superior.
* Maven 3.8 ou superior.
* Um servidor MySQL em execução.

#### 2. Configuração do Banco de Dados
1.  No seu cliente MySQL (como o MySQL Workbench), crie o banco de dados que será utilizado pela aplicação:
    ```sql
    CREATE DATABASE trabalho_java;
    ```
2.  Abra o arquivo de configuração do projeto em `src/main/resources/application.properties`.
3.  Altere a propriedade `spring.datasource.password` para a senha do seu usuário `root` do MySQL:
    ```properties
    spring.datasource.password=SUA_SENHA_AQUI
    ```

#### 3. Execução
1.  Abra o projeto em sua IDE preferida (IntelliJ, Eclipse, VS Code).
2.  Execute a classe principal `JpaApplication.java`.
3.  O console da aplicação exibirá os logs de inicialização, a criação do banco de dados, a inserção dos dados e, por fim, os resultados de todas as 5 consultas solicitadas.

## Estratégia do Banco de Dados (`ddl-auto: create`)

Neste projeto, a propriedade `spring.jpa.hibernate.ddl-auto` foi intencionalmente definida como `create`.

Isso significa que, a cada execução da aplicação, o schema do banco de dados (tabelas, chaves, etc.) é completamente **apagado e recriado do zero**. Esta abordagem foi escolhida para garantir uma experiência de demonstração limpa e consistente. Ao executar o projeto, o avaliador terá a certeza de que o banco está em um estado conhecido e será populado com uma massa de dados completa e realista, permitindo que todas as consultas funcionem como esperado na primeira tentativa, sem o risco de erros de dados duplicados (`Duplicate entry`).

Essa estratégia é ideal para ambientes de desenvolvimento e demonstração. Para um ambiente de produção, o valor seria alterado para `update` ou `validate` para preservar os dados existentes.


## Diagrama 

![Diagrama](https://github.com/victoorzx/TrabalhoJavaJPA/blob/master/diagramajava.png)
