# CRUD Básico com Java, PostgreSQL, Docker e Maven

Este projeto é um exemplo básico de CRUD (Create, Read, Update, Delete) utilizando Java, PostgreSQL e Docker. Ele oferece as operações essenciais para a manipulação de entidades em um banco de dados e utiliza o Maven como gerenciador de dependências. No futuro, o projeto incluirá uma interface gráfica construída com Java Swing para facilitar a interação do usuário com o sistema.

## Requisitos

Certifique-se de ter as seguintes ferramentas instaladas no seu ambiente de desenvolvimento:

- Docker
- Maven
- Java 17+
- PostgreSQL (via Docker)

## Clone o repositório

   Primeiro, clone o repositório para sua máquina:

```bash
git clone https://github.com/PedroBittencourtCosta/crud-basico.git
```
## Configuração do Ambiente


Para garantir que sua aplicação funcione corretamente, você precisa criar um arquivo `.env` na raiz do projeto. Esse arquivo conterá as variáveis de ambiente necessárias para a conexão com o banco de dados PostgreSQL. Siga os passos abaixo:

1. Na raiz do seu projeto, crie um arquivo chamado `.env`.
2. Cole o seguinte conteúdo no arquivo:

```env
POSTGRES_USER=postgres
POSTGRES_PASSWORD=password
POSTGRES_DB=crud-basico
JDBCURL=jdbc:postgresql://localhost:5432/crud-basico
```

Essas variáveis de ambiente serão utilizadas pela sua aplicação para se conectar ao banco de dados.

## Configuração do Maven

No arquivo pom.xml, estou utilizando a seguinte dependência para conectar seu projeto Java ao banco de dados PostgreSQL:

```xml
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.7.4</version>
    </dependency>
```

Caso deseje utilizar outro banco de dados, basta substituir a dependência acima pela dependência específica do banco que você preferir e garantir que o banco esteja configurado em sua máquina ou rodando em um contêiner Docker. Certifique-se de ajustar também as configurações de conexão no arquivo de propriedades da aplicação.

## Docker compose

Para criar o banco de dados PostgreSQL utilizando Docker, execute o seguinte comando no terminal na raiz do projeto:

```bash
  docker compose up -d
```
Este comando criará e iniciará o contêiner do PostgreSQL, permitindo que o banco de dados seja acessado e manipulado pelo projeto.

## Instale as dependências do Maven

Execute o seguinte comando para baixar as dependências do projeto:

```bash
  mvn install
```

[//]: # (## Funcionalidades do Projeto)

[//]: # (O projeto oferece as seguintes operações básicas:)

[//]: # ()
[//]: # (- Criar: Inserir novos registros no banco de dados.)

[//]: # (- Buscar: Consultar registros existentes.)

[//]: # (- Alterar: Atualizar informações de registros.)

[//]: # (- Deletar: Remover registros do banco de dados.)

[//]: # ()
[//]: # (Em breve, uma interface gráfica será implementada utilizando Java Swing, o que facilitará a interação com o sistema de CRUD.)
