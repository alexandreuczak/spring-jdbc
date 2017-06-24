package br.com.tutorial.spring.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.tutorial.spring.config.AppConfiguration;
import br.com.tutorial.spring.dao.QueryForListReturnListDAO;

public class QueryForListReturnListTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		QueryForListReturnListDAO dao = context.getBean(QueryForListReturnListDAO.class);
		List<String> nomes = dao.getNomes();
		
		for(String nome : nomes){
			System.out.println("Nome: " + nome);
		}
		context.close();
	}
	
}
