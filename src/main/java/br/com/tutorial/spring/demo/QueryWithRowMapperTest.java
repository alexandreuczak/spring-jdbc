package br.com.tutorial.spring.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.tutorial.spring.config.AppConfiguration;
import br.com.tutorial.spring.dao.QueryWithRowMapperDAO;
import br.com.tutorial.spring.model.Pessoa;

public class QueryWithRowMapperTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		QueryWithRowMapperDAO dao = context.getBean(QueryWithRowMapperDAO.class);
		List<Pessoa> pessoas = dao.listPessoas();
		
		for(Pessoa pessoa : pessoas){
			System.out.println(pessoa);
		}
		
		context.close();
	}

}
