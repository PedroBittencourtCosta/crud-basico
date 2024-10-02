# CRUD Básico com Java, PostgreSQL, Docker e Maven

Este projeto é um exemplo básico de CRUD (Create, Read, Update, Delete) utilizando Java, PostgreSQL e Docker. Ele oferece as operações essenciais para a manipulação de entidades em um banco de dados e utiliza o Maven como gerenciador de dependências. No futuro, o projeto incluirá uma interface gráfica construída com Java Swing para facilitar a interação do usuário com o sistema.

## Requisitos

Certifique-se de ter as seguintes ferramentas instaladas no seu ambiente de desenvolvimento:

- Docker
- Maven
- Java 17+
- PostgreSQL (via Docker)
- 
## Configuração do Docker

Para configurar o banco de dados PostgreSQL utilizando Docker, execute o seguinte comando no terminal na raiz do projeto:

```bash
docker compose up -d
```
Este comando criará e iniciará o contêiner do PostgreSQL, permitindo que o banco de dados seja acessado e manipulado pelo projeto.

## Configuração do Maven

No arquivo pom.xml, adicione a seguinte dependência para conectar seu projeto Java ao banco de dados PostgreSQL:

```xml
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.7.4</version>
    </dependency>
```

Essa dependência é essencial para que sua aplicação Java possa se comunicar com o banco de dados PostgreSQL.

## Funcionalidades do Projeto
O projeto oferece as seguintes operações básicas:

- Criar: Inserir novos registros no banco de dados.
- Buscar: Consultar registros existentes.
- Alterar: Atualizar informações de registros.
- Deletar: Remover registros do banco de dados.

Em breve, uma interface gráfica será implementada utilizando Java Swing, o que facilitará a interação com o sistema de CRUD.
