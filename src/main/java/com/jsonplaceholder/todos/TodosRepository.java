package com.jsonplaceholder.todos;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class TodosRepository implements TodosService {
	
	public TodosRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}
	NamedParameterJdbcTemplate template;
	
	@Override
	public List<Todos> findAll() {
		return template.query("SELECT * FROM public.todos", new TodosMapper());
	}

	@Override
	public void insertTodo(Todos todo) {
		final String sql = "INSERT INTO public.todos(id, userId, title, complete) VALUES (:id, :userId, :title, :complete)";
		
		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("id", todo.getId())
				.addValue("userId", todo.getUserId())
				.addValue("title", todo.getTitle())
				.addValue("complete", todo.getComplete());
		template.update(sql, param, holder);
	}

	@Override
	public void updateTodo(Todos todo) {
		final String sql = "UPDATE public.todos SET userId=:userId, title=:title, complete=:complete WHERE id=:id";
		
		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("id", todo.getId())
				.addValue("userId", todo.getUserId())
				.addValue("title", todo.getTitle())
				.addValue("complete", todo.getComplete());
		template.update(sql, param, holder);
	}
}