package SpringJDBC.DAO;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class HibernateDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public int getCircleCount(){
			String hql="Select Count(*) from Circle";
			Query query=getSessionFactory().openSession().createQuery(hql);
			return ((Long)query.uniqueResult()).intValue();
	}
	
}
