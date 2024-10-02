package org.example.daos;

import org.example.db.ConectionDB;
import org.example.model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO implements GenericDAO<Usuario>{

    public UsuarioDAO() {
        try (Connection conn = ConectionDB.getConnection()) {
            String sqlCreateTable = """
                    create table IF NOT EXISTS usuario(
                        id serial primary key,
                        nome varchar(255) not null,
                        email varchar(255) not null unique,
                        dtinsercao date default CURRENT_TIMESTAMP,
                        endereco varchar(255) not null,
                        telefone varchar(255) not null,
                        profissao varchar(255) not null) """;
            Statement stmt = conn.createStatement();
            stmt.execute(sqlCreateTable);
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }

    @Override
    public void create(Usuario obj) {

    }

    @Override
    public Usuario get(int id) {
        return null;
    }

    @Override
    public void update(int id, Usuario obj) {

    }

    @Override
    public void delete(int id) {

    }
}
