package fr.formation.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.annotation.Resource;

import fr.formation.dao.entity.User;

@Repository(value="userDAO")
public class UserDAOImpl implements IUserDAO {
	
	@Resource(name="hibernate5AnnotatedSessionFactory")
	private SessionFactory sessionFactory;
	@Override
	public User getUser(User u) {
		Session session = sessionFactory.openSession();
		User pResult=null;
		if(u.getId()!=0) {
			pResult=(User) session.get(User.class,u.getId());
		}else {
			pResult = (User) session.createQuery("FROM User WHERE lower(login) =:param")
					.setParameter("param",u.getLogin().toLowerCase())
					.uniqueResult();
		}
		session.close();
		return pResult;
	}
	@Override
	public List<User> getAllUser() {
		Session session = sessionFactory.openSession();
		List<User> listU = (List<User>) session.createQuery("from User").list();
		session.close();
		return listU;
	}
	@Override
	public void addUser(User u) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();
		session.close();
	}
	@Override
	public void modifyUser(User u) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(u);
		tx.commit();
		session.close();
	}
	@Override
	public void deleteUser(User u) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(u);
		tx.commit();
		session.close();
	}
	@Override
	public User getUserById(int id) {
		Session session = sessionFactory.openSession();
		User u = (User) session.get(User.class, id);
		session.close();
		return u;
	}

}
