package SpringJDBC.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.JScrollBar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import SpringJDBC.Model.Circle;

@Component
public class Daoimpl {
	
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	/*public Circle getCircle(int circleId){
		
		 * JDBC Code to talk with DB
		 
		
		
		
		Connection conn=null;
		String driver="org.apache.derby.jdbc.ClientDriver";
		try{
			
			 * 
			 * Traditional JDBC Connection.
			 * It is extracted out of the class and it will be maintained in the spring.xml
			 * 
			 * Class.forName(driver).newInstance();
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
			
			
			 * The below line has replaced the two lines of code for fetching the connection
			 * information for any database (Earlier Code will fetch only the connection string 
			 * of only one database ). 
			 
			conn=dataSource.getConnection();
			
			
			PreparedStatement ps=conn.prepareStatement("Select * from Circle where id = ?");
			ps.setInt(1, circleId);
			Circle circle=null;
			
			ResultSet resultSet=ps.executeQuery();
			if(resultSet.next()){
				circle = new Circle(circleId, resultSet.getString("name"));
			}
			resultSet.close();
			ps.close();
			
			return circle;
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/
	

	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		System.out.println("Setter Data Source");
		this.dataSource = dataSource;
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int getCircleCount(){
		//Query to Run
		String sql="Select Count(*) from Circle";
		// Where to Run
			
		return jdbcTemplate.queryForInt(sql);
	}
	
	public String getCircleName(int circleId){
		String sql="Select name from circle where id = ?";
		
		/* 
		 * Query which is returning a single Column, on execution. 
		 * Returning the whole result as a Object
		 */
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, String.class);
	}
	public Circle getCircleforId(int circleId){
		String sql="Select * from Circle where id=?";
		return jdbcTemplate.queryForObject(sql,new Object[]{circleId}, new CircleMapper());
	}
	private static final class CircleMapper implements RowMapper<Circle>{

		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Circle circle=new Circle();
				circle.setId(resultSet.getInt("ID"));
				circle.setName(resultSet.getString("Name"));
				return circle;
		}
	}
	
	public List<Circle> getAllCircles(){
		String sql="Select * from Circle";
		return jdbcTemplate.query(sql,new CircleMapper());
	}
	
	public void insertCircle(Circle circle){
		String sql="insert into Circle(ID, Name) values (?,?)";
		jdbcTemplate.update(sql, new Object[]{circle.getId(),circle.getName()});
	}
	
	public void insertCircleNamed(Circle circle){
		String sql="insert into Circle(ID, Name) values (:id,:name)";
		/*
		 * Single Place Holder
		SqlParameterSource namedParameter= new MapSqlParameterSource("id",circle.getId());
		 */	
		SqlParameterSource namedParameter= new MapSqlParameterSource("id",circle.getId()).addValue("name", circle.getName());
		
		namedParameterJdbcTemplate.update(sql, namedParameter);
	}
	
	public void createTriangleTable(){
		String sql="Create Table triangle(Id integer, name varchar(30))";
		jdbcTemplate.execute(sql);
	}
	public void deleteCircle(int circleId){
		String sql="delete from circle where id=?";
		jdbcTemplate.update(sql, new Object[]{circleId});
	}
}
