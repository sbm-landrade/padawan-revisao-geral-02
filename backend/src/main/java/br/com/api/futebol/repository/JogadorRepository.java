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
//criar conexão
    @Autowired
    public JogadorRepository(Connection connection) {
        this.connection = connection;
    }
//findall= mapeia Todos Jogadores
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
//FindById seleciona jogadores por ID
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
//Insere um novo registro na tabela
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
//atualiza um registro existente
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
//Exclui um registro da tabela com base no id
    public int deleteById(Long id) {
        String sql = "DELETE FROM jogador WHERE id = ?";
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setLong(1, id);
            return pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//consulta a posicao
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
//Consulta a idade
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
    
 // Consulta por nome
    public List<Jogador> findByNome(String nome) {
        String sql = "SELECT * FROM jogador WHERE nome = ?";
        List<Jogador> jogadores = new ArrayList<>();

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, nome);
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

    // Consulta por time
    public List<Jogador> findByTime(String time) {
        String sql = "SELECT * FROM jogador WHERE time = ?";
        List<Jogador> jogadores = new ArrayList<>();

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, time);
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

    public List<Jogador> findByFields(String nome, String time, Integer idade, String posicao) {
        StringBuilder sql = new StringBuilder("SELECT * FROM jogador WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (nome != null && !nome.isEmpty()) {
            sql.append(" AND nome = ?");
            params.add(nome);
        }
        if (time != null && !time.isEmpty()) {
            sql.append(" AND time = ?");
            params.add(time);
        }
        if (idade != null) {
            sql.append(" AND idade = ?");
            params.add(idade);
        }
        if (posicao != null && !posicao.isEmpty()) {
            sql.append(" AND posicao = ?");
            params.add(posicao);
        }

        List<Jogador> jogadores = new ArrayList<>();

        try (PreparedStatement pstm = connection.prepareStatement(sql.toString())) {
            for (int i = 0; i < params.size(); i++) {
                pstm.setObject(i + 1, params.get(i));
            }

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
