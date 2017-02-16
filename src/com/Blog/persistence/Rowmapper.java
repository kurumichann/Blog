package com.Blog.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

abstract class Rowmapper implements RowMapper<article>{

	@Override
	public abstract article mapRow(ResultSet rs, int rowNum) throws SQLException;
	
}
