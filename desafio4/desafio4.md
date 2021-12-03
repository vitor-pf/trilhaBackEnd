# O que é JDBC?
A JDBC (Java Database Connectivity) é uma API que tem como principal objetivo facilitar o acesso de aplicação Java ao banco de dados.
A API contém um adaptador (driver), sendo possível se conectar em vários bancos de dados e com poucas configurações conseguimos inserir comando SQL.
O driver é o principal responsável pela comunicação com o banco. Existem tipos de driver JDBC, o Ponte JDBC-ODBC, Driver API-Nativo, Driver Nativo e o Driver de Protocolo de Rede.

# O que é ORM, cite 3 exemplos?
O ORM (Object Relational Mapper), é uma técnica de mapeamento objeto relacional que permite fazer uma relação das classes (Orientado Objeto) com as tabelas (banco de dados). Essa técnica nos permite criar instruções entre classes diretas para tabela do banco de dados, sendo assim, ganhando produtividade e segurança, pois deixa de digitar comando SQL.

# O que é JPA e qual é a sua relação com os ORM’s?
A JPA (Java Persistence API), não é um framework de ORM, mas foi a partir dele que surgiu as especificações para os ORMs. A JPA é uma série de regras para implementar em um projeto com ORM, ou seja, um padrão para os frameworks.
Os frameworks de ORMs, como o Hibernate e Eclipse Link:
O Hibernate foi o primeiro ORM do mercado e é mais utilizado no momento. Mas surgiu outros, como o Eclipse Link, todos com as mesmas especificações do JPA.

# O que é Spring Data?
O Spring Data, é um projeto que facilita e incorporar uma série funcionalidades para aplicação com banco de dados.
Em termos práticos, o projeto Spring Data vem para facilitar e dar produtividade em funcionalidade básica de uma aplicação como CRUD (Create-Read-Update-Delete). Além de implementações específicas para cada banco de dados, também conta com uma funcionalidade de ordenação, paginação e um métodos para pesquisa.

# O que caracteriza um projeto “CRUD básico”?
O CRUD (Create, Read, Update, Delete) é abreviação das palavras de operações básicas do banco de dados, normalmente essas operações não envolvem processos matemáticos, mas facilita a aplicação final.
C: Create - criar um novo registro.
R: Read - ler as informações de um registro.
U: Update - atualizar os dados do registro.
D: Delete - apagar um registro. 

Também é possível criar uma exclusão reversível, onde a informação não é deletada, mas sim, criado de segurança uma cópia ou mudado seu status.