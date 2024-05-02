package ru.myApp;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;

@Component
public class JewelDao {
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Jewel> findAll(){
		List<Jewel> jewels = jdbcTemplate.query("select * from jewel", new BeanPropertyRowMapper<>(Jewel.class));
		return jewels;
	}
	
	public int insert(Jewel jewel){
		return jdbcTemplate.update("insert into jewel " + "(id, size, price, type, metal, stone)" + "values (?,?,?,?,?,?)",
		new Object[] {
				jewel.getId(), jewel.getSize(),
				jewel.getPrice(), jewel.getType(), jewel.getMetal(), jewel.getStone()
		});
	}
	public void update(int id, Jewel updatedJewel) {
		jdbcTemplate.update("UPDATE jewel SET size=?, price=?, type=?, metal=?, stone=? WHERE id=?", updatedJewel.getSize(),
				updatedJewel.getPrice(), updatedJewel.getType(), updatedJewel.getMetal(), updatedJewel.getStone(), id);
	}
	
	public void delete(int id) {
		jdbcTemplate.update("DELETE FROM jewel WHERE id=?", id);
	}
	
	public List<Jewel> searchUpTo(int upToPrice){
		List<Jewel> jewels = jdbcTemplate.query("select * from jewel WHERE price <= ?", new BeanPropertyRowMapper<>(Jewel.class), upToPrice);
		return jewels;
	}
}