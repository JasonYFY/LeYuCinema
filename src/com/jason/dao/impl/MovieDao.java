package com.jason.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jason.dao.IMovieDao;
import com.jason.domain.Movie;
import com.jason.domain.PageModel;
@Repository
public class MovieDao extends HibernateDaoSupport implements IMovieDao {

	@Autowired
	public void setMySessionFactory(SessionFactory sf) {
		super.setSessionFactory(sf);
	}
	
	@Override
	public List<Movie> queryMovie(Movie movie) {
		List<Movie> list = (List<Movie>) getHibernateTemplate().find("from Movie m where m.mvName like ?",
				"%"+movie.getMvName()+"%");
		return list;
	}

	@Override
	public void insert(Movie movie) {
		getHibernateTemplate().save(movie);
	}

	@Override
	public Movie getMovieById(String id) {
		Movie movie = getHibernateTemplate().get(Movie.class, id);
		return movie;
	}
	
	@Override
	public void update(Movie movie) {
		getHibernateTemplate().update(movie);
	}


	@Override
	public List<Movie> queryMovieByPage(Movie movie, PageModel pageModel) {
		final StringBuffer hqlBuf=new StringBuffer("from Movie m where 1=1");
		if(movie.getCategory()!=null) {
			hqlBuf.append(" and m.category=?");
		}
		
		if(movie.getMvName()!=null&&!movie.getMvName().trim().equals(""))
		{
			hqlBuf.append(" and m.mvName like '%"+movie.getMvName()+"%'");
		}
		/*List<Movie> list = (List<Movie>) getHibernateTemplate().find("from Movie m where m.mvName like ?",
				"%"+movie.getMvName()+"%");*/
		return getHibernateTemplate().execute(new HibernateCallback<List<Movie>>() {
			@Override
			public List<Movie> doInHibernate(Session session) throws HibernateException {
				List<Movie> list = null;
				if(movie.getCategory()!=null) {
					list = session.createQuery(hqlBuf.toString()).
							setParameter(0, movie.getCategory()).
							setFirstResult(pageModel.startRowNum()).
							setMaxResults(pageModel.getPageSize()).list();
				}else {
					list = session.createQuery(hqlBuf.toString()).
							setFirstResult(pageModel.startRowNum()).
							setMaxResults(pageModel.getPageSize()).list();
				}
				return list;
			}
		});
		
	}

	@Override
	public Integer getQueryCount(Movie movie) {
		List<Integer> list = null;
		StringBuffer hqlBuf=new StringBuffer("select count(*) from Movie m ");
		if(movie.getCategory()==null) {
			hqlBuf.append("where m.mvName like ?");
			list = (List<Integer>) getHibernateTemplate().find(hqlBuf.toString(),
					"%"+movie.getMvName()+"%");
		}else {
			hqlBuf.append("where m.category = ?");
			list = (List<Integer>) getHibernateTemplate().find(hqlBuf.toString(),
					movie.getCategory());
		}
		Integer i = Integer.parseInt(list.get(0)+"");
		return i;
	}

}
