package SpringJDBC.DAO;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SimpleDAOImpl extends SimpleJdbcDaoSupport {
	
	
	public int getCircleCount(){
		//Query to Run
		String sql="Select Count(*) from Circle";
		// Where to Run
			
		return this.getJdbcTemplate().queryForInt(sql);
	}
}
