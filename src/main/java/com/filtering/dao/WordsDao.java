package com.filtering.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class WordsDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<String> getAllWords()
	{
		List<String> list =jdbcTemplate.query("select word from words", new RowMapper<String>()
				{

					public String mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						return rs.getString(1);
					}
			
				});
		return list;
	}
	
	public int checkFrequency(String text, String category)
	{	
		try
		{
			String sql = "SELECT frequency FROM wordFrequency WHERE word = ? and category = ?";
			int count = jdbcTemplate.queryForObject(sql, new Object[] { text, category }, Integer.class);
			return (count);
		}
		catch(EmptyResultDataAccessException e)
		{
			return 0;
		}
	}
	
	public int totalWords(String category)
	{	
		String sql = "SELECT count(*) FROM wordFrequency WHERE category = ?";
		int count = jdbcTemplate.queryForObject(sql, new Object[] {category}, Integer.class);
		return count;
	}
	
	
	
	

}
