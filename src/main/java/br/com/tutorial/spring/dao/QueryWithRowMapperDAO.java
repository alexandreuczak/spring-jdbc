package br.com.tutorial.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import br.com.tutorial.spring.model.Pessoa;

@Repository
public class QueryWithRowMapperDAO extends JdbcDaoSupport{

	private static final String SQL_BASE = "select p.codigo, p.nome, p.apelido from Pessoa p ";
	
	@Autowired
	public QueryWithRowMapperDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<Pessoa> listPessoas(){
		return this.getJdbcTemplate().query(SQL_BASE, new PessoaMapper());
	}
	
	class PessoaMapper implements RowMapper<Pessoa>{

		@Override
		public Pessoa mapRow(ResultSet rs, int rowNum) throws SQLException {
			Integer codigo = rs.getInt("codigo");
			String nome = rs.getString("nome");
			String apelido = rs.getString("apelido");
			return new Pessoa(codigo, nome, apelido);
		}
		
	}
}
