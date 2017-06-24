package br.com.tutorial.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class QueryForListReturnListDAO extends JdbcDaoSupport{

	@Autowired
	public QueryForListReturnListDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public List<String> getNomes(){
		String sql = "select p.nome from Pessoa p";
		return this.getJdbcTemplate().queryForList(sql, String.class);
	}
	
	public List<String> getNomes(String nome){
		String sql = "select p.nome from Pessoa p where p.nome like ?";
		String filtro = "%" + nome + "%";
		return this.getJdbcTemplate().queryForList(sql, String.class, filtro);
	}
}
