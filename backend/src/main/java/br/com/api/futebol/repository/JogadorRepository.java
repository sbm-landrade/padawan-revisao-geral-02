package br.com.api.futebol.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.api.futebol.model.Jogador;

@Repository
public class JogadorRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final class JogadorRowMapper implements RowMapper<Jogador> {
		@Override
		public Jogador mapRow(ResultSet rs, int rowNum) throws SQLException {
			Jogador jogador = new Jogador();
			jogador.setId(rs.getLong("id"));
			jogador.setNome(rs.getString("nome"));
			jogador.setTime(rs.getString("time"));
			jogador.setIdade(rs.getInt("idade"));
			jogador.setPosicao(rs.getString("posicao"));
			return jogador;
		}
	}

	public List<Jogador> findAll() {
		String sql = "SELECT * FROM jogador";
		return jdbcTemplate.query(sql, new JogadorRowMapper());
	}

	public Jogador findById(Long id) {
		String sql = "SELECT * FROM jogador WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new JogadorRowMapper(), id);
	}

	public int save(Jogador jogador) {
		String sql = "INSERT INTO jogador (nome, time, idade, posicao) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, jogador.getNome(), jogador.getTime(), jogador.getIdade(), jogador.getPosicao());
	}

	public int update(Jogador jogador) {
		String sql = "UPDATE jogador SET nome = ?, time = ? WHERE id = ?";
		return jdbcTemplate.update(sql, jogador.getNome(), jogador.getTime(), jogador.getId());
	}

	public int deleteById(Long id) {
		String sql = "DELETE FROM jogador WHERE id = ?";
		return jdbcTemplate.update(sql, id);
	}

	public List<Jogador> findByPosicao(String posicao) {
		String sql = "SELECT * FROM jogador WHERE posicao = ?";
		return jdbcTemplate.query(sql, new JogadorRowMapper(), posicao);
	}

	public List<Jogador> findByIdade(int idade) {
		String sql = "SELECT * FROM jogador WHERE idade = ?";
		return jdbcTemplate.query(sql, new JogadorRowMapper(), idade);
	}
}