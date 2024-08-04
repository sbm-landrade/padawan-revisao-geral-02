package br.com.api.futebol.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.api.futebol.model.Jogador;

@Repository
public class JogadorRepository {

    private final Connection connection;

    @Autowired
    public JogadorRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Jogador> findAll() {
        String sql = "SELECT * FROM jogador";
        List<Jogador> jogadores = new ArrayList<>();

        try (PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                Jogador jogador = new Jogador();
                jogador.setId(rs.getLong("id"));
                jogador.setNome(rs.getString("nome"));
                jogador.setTime(rs.getString("time"));
                jogador.setIdade(rs.getInt("idade"));
                jogador.setPosicao(rs.getString("posicao"));
                jogadores.add(jogador);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jogadores;
    }

    public Jogador findById(Long id) {
        String sql = "SELECT * FROM jogador WHERE id = ?";
        Jogador jogador = null;

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setLong(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    jogador = new Jogador();
                    jogador.setId(rs.getLong("id"));
                    jogador.setNome(rs.getString("nome"));
                    jogador.setTime(rs.getString("time"));
                    jogador.setIdade(rs.getInt("idade"));
                    jogador.setPosicao(rs.getString("posicao"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jogador;
    }

    public int save(Jogador jogador) {
        String sql = "INSERT INTO jogador (nome, time, idade, posicao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, jogador.getNome());
            pstm.setString(2, jogador.getTime());
            pstm.setInt(3, jogador.getIdade());
            pstm.setString(4, jogador.getPosicao());
            return pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int update(Jogador jogador) {
        String sql = "UPDATE jogador SET nome = ?, time = ? WHERE id = ?";
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, jogador.getNome());
            pstm.setString(2, jogador.getTime());
            pstm.setLong(3, jogador.getId());
            return pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM jogador WHERE id = ?";
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setLong(1, id);
            return pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Jogador> findByPosicao(String posicao) {
        String sql = "SELECT * FROM jogador WHERE posicao = ?";
        List<Jogador> jogadores = new ArrayList<>();

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, posicao);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    Jogador jogador = new Jogador();
                    jogador.setId(rs.getLong("id"));
                    jogador.setNome(rs.getString("nome"));
                    jogador.setTime(rs.getString("time"));
                    jogador.setIdade(rs.getInt("idade"));
                    jogador.setPosicao(rs.getString("posicao"));
                    jogadores.add(jogador);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jogadores;
    }

    public List<Jogador> findByIdade(int idade) {
        String sql = "SELECT * FROM jogador WHERE idade = ?";
        List<Jogador> jogadores = new ArrayList<>();

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, idade);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    Jogador jogador = new Jogador();
                    jogador.setId(rs.getLong("id"));
                    jogador.setNome(rs.getString("nome"));
                    jogador.setTime(rs.getString("time"));
                    jogador.setIdade(rs.getInt("idade"));
                    jogador.setPosicao(rs.getString("posicao"));
                    jogadores.add(jogador);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jogadores;
    }
}
