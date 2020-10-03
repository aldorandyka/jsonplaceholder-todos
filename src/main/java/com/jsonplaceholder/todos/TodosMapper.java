package com.jsonplaceholder.todos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TodosMapper implements RowMapper<Todos> {
	
	public Todos mapRow(ResultSet rs, int arg1) throws SQLException {
		Todos todo = new Todos(rs.getLong("id"), rs.getInt("userId"), rs.getString("title"), rs.getBoolean("complete"));
		return todo;
	}
}