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

# Como conectar o Node.js com o MySQL

## Instalar o MySQL

O que é o Mysql?
O Mysql é um sistema de gerenciamento de banco de dados que utiliza a linguagem sql, pertence à empresa Oracle e pode ser executado tanto via linha de comando no terminal (caso esteja instalado) quanto em softwares auxiliares que facilitem a interação com o mesmo.

###o mysql2

npm install mysql2
módulo para conecar no mysql

criar o aquivo database.ts

isntalrt o mudlo promises:
npm install types/mysql2

## Realizar a configuração para conexão

Podemos começar a configurar a conexão com o nosso banco de dados MySQL por meio da biblioteca MySQL2. Para tal, iremos criar um arquivo específico para esta implementação chamado connection. Nele, haverá uma constante que receberá a importação de “mysql2/promise” (o uso do “promise” é necessário porque consultas a bancos de dados externos envolvem tratamentos por assincronicidade e, para utilizarmos async e await com a biblioteca, precisamos realizar a importação da forma como foi explicado).

No arquivo database.ts:

// Criar a conexão com banco de dados MySQL
const connection = mysql.createConnection({
host: "localhost",
user: "root",
password: "root",
database: "database",
});

// Verificar a conexão do Node.js com banco de dados
connection.connect(function (err) {
console.log("Conexão com o banco de dados realizado com sucesso!");
});

Note que o objeto passado como parâmetro da função createPool possui uma série de chaves necessárias para a conexão:

Host - O endereço IP do MySQL: no nosso caso podemos utilizar o “localhost” ao invés do IP sem problemas, já que o mesmo se refere ao endereço local que estamos utilizando para executar o nosso servidor Node.js na porta 3003;
Port - A porta que você escolheu para acessar o MySQL (se você instalou o MySQL utilizando as configurações padrões, a porta será a 3306);
User - O nome do usuário que acessaremos o Mysql;
Password - A senha que utilizaremos para acessar o Mysql;
Database - O nome do banco de dados no qual iremos nos conectar.

# Criação do banco de dados DBeaver:

crie uma conexao mysql
server host: localhost
port 3306
database: database
nome de uusário: root
senha: root

aparecerá database:

Certifique-se de substituir 'seu_usuario', 'sua_senha' e 'seu_banco_de_dados' pelas informações corretas do seu banco de dados MySQL.

# Criação da tabela:

cria a pasta sql e o arquivo sql.sql

CREATE DATABASE db-databases;

CREATE TABLE book(
id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(200) NOT NULL,
author VARCHAR(200) NOT NULL,
description TEXT NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DESCRIBE book;

no DBeaver , crie a tabela e rode o código:

CREATE TABLE book(
id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(200) NOT NULL,
author VARCHAR(200) NOT NULL,
description TEXT NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

acessar o mysql no terminal:

mysql -u root -p
senha: root

> show databases;

# inserir na tabela

INSERT INTO book (title, author, description, created_at)
VALUES ('Exemplo de Título', 'Exemplo de Autor', 'Exemplo de Descrição', CURRENT_TIMESTAMP);

Depois de configurar como deve ser feita a conexão por meio da função createPool, podemos fazer nossas primeiras interações com o Mysql.

# Interagindo com o banco de dados

# classe Book

import { connect } from "./database";
//import { minhaDatabase } from 'modulo-externo'

export default class Book {
database: any;
constructor() {
// this.database = minhaDatabase.inicia();
this.database = connect();
}

getBook() {
const listBook = this.database.query("select \* from book");
console.log(listBook);
}

// save() {
// this.database.save(this);
// }
}

# index.ts

instanciando a classe Book

const book = new Book();
console.log(book);

# incluindo numa rota

app.get("/book", function (req, res) {
const book = new Book();
console.log(book);
res.send(book);
});

# terminal mysql

??? rodar o create table
mysql -u root -p db-databases caminho-completo-para-o-arquivo/db.sql

# terminal mysql: gerenciamento avançado

mysql -u root -p
Visualizando as conexões ativas:
SHOW PROCESSLIST;
| 10 | root | localhost:56084 | db-databases | Sleep | 2 | | NULL
Ela retornará valores como PID (número do processo da conexão), a quantidade de conexões do seu usuário à base, a query que a conexão está rodando no momento ou se ela está ociosa (sleep).

Derrubando conexões e processos presos
KILL <numero_PID>;

máximo de conexão:
SHOW VARIABLES LIKE '%connection%';
