# O que é java

# Primeiros passos:

Vamos iniciar o nosso projeto criando o arquivo Spring-Boot.Configure os metadados básicos do seu projeto, quais dependências do Spring nós vamos utilizar (Web no caso) e pronto!
Baixe o código do Spring-Boot configurado Acesse https://start.spring.io/
Maven
Spring Boot estável
group> br.com.aes
Artifact (nome do projeto): simple-db Name: dslist
Packaging (linguagem java): jar versão: 17 (LTS)
Adicionar dependências: 4
Spring Web WEB Build web
Spring Data JPA SQL (banco de dados)
H2 Database SQL (banco de dados em memória para testes)
PostgreSQL Driver SQL (banco de dados na nuven) A JDBC and R2DBC driver that allows
lombok
Generate Project

# módulo typescript:

npm i typescript -D
dependência de desenvolvimento

configurar o typescript:
npx typescript --init
ou
npx tsc --init

configurar tsconfig.json:

"target": "ES6",  
"outDir": "./dist",

# diretorio src:

Visando uma boa organização da aplicação, criaremos uma pasta chamada src contendo um arquivo de nome server.js.

criar a pasta src > index.ts
codígo que iniciará aplicação

Descompacte o arquivo ZIP localmente

# gitignore

# arquivo de incialização:

vá até o arquivo: src/main/java/br/com/aes/simpledb/SimpleDbApplication.java

Com o projeto criado, vá no vscode e abra a pasta que acabamos de criar. O vscode irá tentar inicializar as extensões, e atualizar as dependências Maven suportar o projeto, então, aguarde até que o processo termine antes de continuar:

atualização no menu inferior do vscode

# SERVIDOR:

As configurações básicas para “erguer” um servidor já foram realizadas:

clique em run na barra supeior clique em run no codigo

Tomcat initialized with port(s): 8080 (http)

rodar:
http://localhost:8080/

as configurações de desenvolvedro já foram realizadas:
para rodar:
run
nodemon?
ts-node?
scripts

# Criação da sua primeira classe para subir no browser

src/main/java/br/com/aes/simpledb/ontroller/controller.java

criamos a pasta controller e o arquivo HelloController.java

criará:
package br.com.aes.simpledb.controller;

public class HelloController {

}

agora precisamos adicionar ao código:

# incluindo numa rota

@Rest - clique em control espaço para o intelicence
@RestController
public class HelloController {

podemos agora criar métodos para get, post delete...

GetMapping - clique em control espaço para o intelicence

@GetMapping(value = "/")
public String getMethodName() {
return "Olá Mundo";
}

dev-se retornar no SimpleDbApplication.java e executar: run
Visualização no browser:

vá até o browser: http://localhost:8080/

# BANCO DE DADOS

# Como conectar com o MySQL: criando a dependẽncia

Considerando o seu conhecimento em Maven, basta adicionar as seguintes dependências no seu projeto.
jpa:

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>

org.springframework.boot:spring-boot-starter-data-jpa: Essa dependência fornece as bibliotecas necessárias para usar o Spring Data JPA em um projeto Spring Boot. O Spring Data JPA é uma camada de abstração que facilita o acesso e a manipulação de dados em bancos de dados relacionais usando a tecnologia Java Persistence API (JPA). Ele oferece uma maneira conveniente de escrever consultas e realizar operações de CRUD (Create, Read, Update, Delete) no banco de dados.

mysql:mysql-connector-java: Essa dependência é necessária para conectar um aplicativo Java ao banco de dados MySQL. O MySQL Connector/J é o driver JDBC (Java Database Connectivity) para o MySQL, que permite a comunicação entre o aplicativo Java e o banco de dados MySQL. Com essa dependência, você pode estabelecer conexões, executar consultas e realizar outras operações relacionadas ao banco de dados MySQL em seu aplicativo Java.

Ao adicionar essas dependências ao arquivo pom.xml (arquivo de configuração do Maven), o Maven cuidará de baixar as bibliotecas necessárias e gerenciar as dependências do seu projeto automaticamente. Isso facilita a construção e a execução de aplicativos Java com Spring Boot e Spring Data JPA, utilizando um banco de dados MySQL.

## Realizar a configuração para conexão

Configuraçẽos do banco de dados de teste: application-test.properties
Configurando o MySQL em projetos Spring Boot

Após efetuar o download das dependências, vamos configurar as propriedades do MySQL e do JPA no projeto.

// Criar a conexão com banco de dados MySQL
host: "localhost",
user: "root",
password: "root",
database: "db-java-databases",

<!-- server host: localhost
port 3306
database: database
nome de uusário: root
senha: root -->

Para isso edite o arquivo de configuração application.properties e adicione o seguinte conteúdo:

codigo base:----

# usuário e senha de conexão com o banco de dados

spring.datasource.username=root
spring.datasource.password=root

# url de conexão do banco de dados

banco de dados: db-java-databases

spring.datasource.url=jdbc:mysql://localhost:3306/db-java-databases

<!-- spring.datasource.url=jdbc:mysql://localhost:3306/db-java-databases?allowPublicKeyRetrieval=true&rewriteBatchedStatements=true&useSSL=false&useUnicode=yes&characterEncoding=UTF-8&useLegacyDatetimeCode=true&createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC -->

# deixamos o hibernate responsável por ler nossas entidades e criar as tabelas do nosso banco de dados automaticamente

spring.jpa.hibernate.ddl-auto=create

# altera a estrtura da tabela caso a entidade tenha mudanças

 <!-- spring.jpa.hibernate.ddl-auto=update -->

# codigo adicional:

# apontamos para o JPA e Hibernate qual é o Dialeto do banco de dados

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

# configuração do Hibernate para reconhecer o nome de tabelas em caixa alta

spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl

# configurações de log

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true

----fim do codigo.

# Configurando o modelo para gerar uma tabela no banco de dados

Vamos criar uma entidade que será convertida em tabela no nosso mysql.
As entidades para representar o relacionamento de tabelas de uma Livaria. Onde teremos a tabela Book

Mapeamento das tabelas em classes

Aqui vamos aplicar a técnica de Mapeamento objeto-relacional (ORM), que é utilizada para reduzir a impedância da programação orientada aos objetos utilizando bancos de dados relacionais.

## criando uma classe Entity

src/main/java/br/com/aes/simpledb/entities/Book.java

atributos: variáveis e os tipos
construtor sem argumento public Book() { }
construtor com argumento public Book() { }
métodos getter e setter para encapsulamento
métodos hascode e equals para comparar 2 objetos (comparar se 2 gamers são iguais ou não dentro de uma lista)

# ORM - Mapeamento objeto relacional

Para fazer o mapeamento relacional para que tenhas o registro na tabela é necessários algumas configurações:

É necessário: nome da tabela, os campos, os tipos, chave primaria

        // anotations
        //Entity: especifica a criação da tabela
        @Entity
        @Table(name = "tb_book")
        public class Book { ...

    Em cima do nome da classe: anotation @Entity (anotation vai configurar o classe java para que ela seja equivalente a uma tabela do banco de dados)
    Em cima do nome da classe tem como customizar o nome da tabela do banco: @Table(name = "tb_book")
    Em cima do atributo tem como configurar a chave primária e autoincremental:
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Modificando um nome de uma coluna:
    @Column(name = "game_year") private Integer year;
    Modificandoo tipo de uma coluna: @Column(columnDefinition = "TEXT") private String shortDescription

    todo atributo tem que ter o getter e setter: selecione o atributo e clique na lampada e peça para gersra o get e set

# Testando a criação da tabela

run
utilize o spring boot dashboard

# Criar nosso repositório

Camada de persistencias: parte do projeto onde podemos realizar ações no banco de dados (cadastros/seleções/atualizações/exclusões)

vamos criar algumas interfaces que serão responsáveis por todas as operações das nossas tabelas com o banco de dados.

repositories:
src/main/java/br/com/aes/simpledb/repositories/BookRepository.java

public interface BookRepository extends JpaRepository<Book, Long> {

}

Ao herdarmos JpaRepository o Spring Data será responsável por criar uma implementação das nossas interfaces em tempo de execução, e com isso ganhamos produtividade, pois essas interfaces vão prover inúmeros métodos para manipular os objetos diretamente no banco de dados.

# Interagindo com o banco de dados

Agora vamos criar uma classe que vai popular nosso banco de dados e por fim realizar algumas consultas.

# Controller

anotation @Autowired: é um atalho onde não há necessiadde de isntanciar objetos (injeção de dependências)

src/main/java/br/com/aes/simpledb/controllers/BookController.java

@RestController
@RequestMapping(value = "/book")
public class BookController {

@Autowired
private BookRepository bookRepository;

// @GetMapping("getAll")
// public List<Book> getData() {
// return bookRepository.findAll();
// }

@GetMapping
public List<Book> findAll() {
List<Book> result = bookRepository.findAll();
return result;
}

}

ver:

17. Bora testar. Primeiro faça "clean package" pra garantir que está compilando. Depois vá para a pasta do seu projeto acesse o diretório target/ e faça java -jar testespring-0.0.1-SNAPSHOT.jar

18. Abra o endereço http://localhost:8080/swagger-ui.html

Pronto! Você criou uma serviço rest com conexão ao banco de dados MySQL.

https://pt.linkedin.com/pulse/spring-boot-e-data-conex%C3%A3o-ao-banco-de-dados-denis-cabral-lopes

Ainda em implementação:

# Service

src/main/java/br/com/aes/simpledb/services/BookService.java

public class BookService {

}

Componente responsável por implementar lógica de negócio(regras)

Registrar os componentes: @Component ou apelido: @Service

public retorno função(){

}

public List findAll() {

}

é necessário injetar a dependência para acessar os métodos do repository (puxando uma isntância)

@Autowired private GameRepository gameRepository;

trazer a lista do banco dedados

public List findAll() { List result = gameRepository.findAll(); return result; }

# Testar a classe: run

fonte
https://www.gasparbarancelli.com/post/banco-de-dados-mysql-com-spring-boot
