package org.example.daos;

import org.example.db.ConectionDB;
import org.example.model.Pedido;
import org.example.model.Usuario;

import java.sql.*;

public class PedidoDAO implements GenericDAO<Pedido>{

    public PedidoDAO() {
        try (Connection conn = ConectionDB.getConnection()) {
            String sqlCreateTable = """
                    create table pedido(
                            id serial primary key,
                            numero int not null,
                            id_usuario int not null,
                            dtinsercao date default CURRENT_TIMESTAMP,
                            total real not null,
                            status boolean not null default true,
                            foreign key (id_usuario) references usuario(id) ON DELETE CASCADE
                    ); """;
            Statement stmt = conn.createStatement();
            stmt.execute(sqlCreateTable);
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }


    @Override
    public void create(Pedido pedido) {

        String sqlInsert = "INSERT INTO pedido(numero, id_usuario, total) VALUES(?, ?, ?)";
        try (Connection conn = ConectionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {

            checksExistUsuario(pedido.getIdUsuario());

            pstmt.setInt(1, pedido.getNumero());
            pstmt.setInt(2, pedido.getIdUsuario());
            pstmt.setDouble(3, pedido.getTotal());

            pstmt.executeUpdate();
            System.out.println("Pedido cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar pedido: " + e.getMessage());
        }
    }

    @Override
    public Pedido get(int id) {
        String sqlSelect = "SELECT * FROM pedido WHERE id = ?";
        try (Connection conn = ConectionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlSelect)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Pedido(
                        rs.getInt("id"),
                        rs.getInt("numero"),
                        rs.getInt("id_usuario"),
                        rs.getDate("dtinsercao"),
                        rs.getDouble("total"),
                        rs.getBoolean("status")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar o pedido: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void update(int id, Pedido obj) {

    }

    @Override
    public void delete(int id) {

    }

    public void checksExistUsuario(int id) throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.get(id);
        if(usuario == null){
            throw new Exception("Usuario não encontrado");
        }
    }
}
