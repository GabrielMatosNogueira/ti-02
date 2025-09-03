package br.com.exercicio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.exercicio.factory.ConnectionFactory;
import br.com.exercicio.model.Usuario;

public class UsuarioDAO {
    public void inserir(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, senha, sexo) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setString(3, String.valueOf(usuario.getSexo()));
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT id, nome, senha, sexo FROM usuarios ORDER BY id";
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                if (rs.getString("sexo") != null && !rs.getString("sexo").isEmpty()) {
                    usuario.setSexo(rs.getString("sexo").charAt(0));
                }
                usuarios.add(usuario);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return usuarios;
    }

    public void atualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, senha = ?, sexo = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setString(3, String.valueOf(usuario.getSexo()));
            pstmt.setInt(4, usuario.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}