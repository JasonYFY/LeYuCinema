package com.jason.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jason.dao.IFilmDao;
import com.jason.domain.Category;
import com.jason.domain.Movie;
@Repository
public class FilmDao extends HibernateDaoSupport implements IFilmDao {
	
	private Category filmCategory;
		
	@Autowired
	public void setMySessionFactory(SessionFactory sf) {
		super.setSessionFactory(sf);
	}
	
	@Override
	public List<Movie> getFilmToIndex(Integer nowPage) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Movie>>() {

			@Override
			public List<Movie> doInHibernate(Session session) throws HibernateException {
				List<Movie> list = session.createQuery("from Movie m where m.category=?").
					setParameter(0, filmCategory).setFirstResult(nowPage).
					setMaxResults(5).list();
				return list;
			}
		});
			
	}

	@Override
	public Integer getFilmCount() {
		Category cg = getFilmCategory();
		if(cg!=null) {
			List<Long> list = (List<Long>) getHibernateTemplate().find("select count(*) from Movie m where m.category=?", filmCategory);
			Long lon = list.get(0);
			Integer count = Integer.parseInt(lon+"");
			return count;
		}
		return null;
	}

	@Override
	public Category getFilmCategory() {
		if(this.filmCategory==null) {
			//获取电影类别
			List<Category> list = (List<Category>) getHibernateTemplate().find("from Category c where c.id=? ", "1");
			if(list!=null&&list.size()>0) {
				Category filmCategory = list.get(0);
				if(filmCategory!=null) {
					this.filmCategory=filmCategory;
				}
				return filmCategory;
			}
		}
		
		return this.filmCategory;
	}
	

}
