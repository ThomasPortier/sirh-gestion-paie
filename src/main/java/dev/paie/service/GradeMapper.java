package dev.paie.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.paie.entite.Grade;

public class GradeMapper implements RowMapper<Grade> {

	@Override
	public Grade mapRow(ResultSet rs, int RowNum) throws SQLException {
		Grade g = new Grade(rs.getString("code"), rs.getBigDecimal("nbHeuresBase"), rs.getBigDecimal("tauxBase"));
		g.setId(rs.getInt("id"));
		return g;
	}

	/*
	 * publicPizza mapRow(ResultSetrs, introwNum) throws SQLException{ Pizza p =
	 * new Pizza(); p.setId(rs.getInt("ID"));
	 * p.setPizzaName(rs.getString("PIZZA_NAME")); return p;
	 */
	// }
}