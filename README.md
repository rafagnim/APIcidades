<h2>Sistema de gerenciamento de pessoas em API REST com Spring Boot</h2>

Este  API foi desenvolvido em aula proporcionada pela Digital Innovation One, através do desenvolvedor André Gomes.

Em relação ao projeto desenvolvido em aula, fiz os seguintes acréscimos:

- ---

Acrescentei uma camada de serviço para todas as chamadas da Controller;

Simplifiquei os métodos apresentados (GETs), com a finalidade de melhor compreensão do processo de desenvolvimento da API, sem prejudicar nenhuma funcionalidade;

Acrescentei filtros de busca por nome de cidade, com a possibilidade de filtro pela própria aplicação e também com query do próprio banco de dados Postgre, como forma de exercitar as duas opções, sabendo-se que a opção de fazê-lo pelo banco de dados é mais eficiente pois não há necessidade de carregar a tabela completa de cidades para então filtrar a lista;

Na opção de cálculo da distância, refatorei o método para retornar apenas pelo modelo matemático e em quilômetros a distância entre duas cidades, aproveitando o método já criado para busca por Id, dentro do próprio Service (AcessoDB);

As tabelas para popular o banco de dados podem ser encontradas no repositório a seguir:

https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL

Para popular a tabela de cidades, sugiro utilizar o pgAdmin, clicando com o botão direito do mouse na tabela e na opção Importar. Os dados devem estar salvos em .CSV ou text (Encoding UTF8 funcionou perfeitamente).

O desenvolvimento desta API trouxe vários desafios e aprendizado, aprimorando o conhecimento de JPA, conexão com o banco de dados Postgre, utilização de Queries, importação de dados de arquivos e API Rest.

-------------

Pré-requisitos para a execução do projeto:

* Java 11 ou versões superiores.
* Gradle 
* Intellj IDEA Community Edition ou outra IDE.
* Postgre instalado ou no Docker e rodando no localhost
