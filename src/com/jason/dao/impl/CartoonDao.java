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

import com.jason.dao.ICartoonDao;
import com.jason.dao.IFilmDao;
import com.jason.domain.Category;
import com.jason.domain.Movie;
@Repository
public class CartoonDao extends HibernateDaoSupport implements ICartoonDao {
	
	private Category cartoonCategory;
		
	@Autowired
	public void setMySessionFactory(SessionFactory sf) {
		super.setSessionFactory(sf);
	}
	
	@Override
	public List<Movie> getCartoonToIndex(Integer nowPage) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Movie>>() {

			@Override
			public List<Movie> doInHibernate(Session session) throws HibernateException {
				List<Movie> list = session.createQuery("from Movie m where m.category=?").
					setParameter(0, cartoonCategory).setFirstResult(nowPage).
					setMaxResults(10).list();
				return list;
			}
		});
			
	}

	@Override
	public Integer getCartoonCount() {
		Category cartoon = getCartoonCategory();
		if(cartoon!=null) {
			List<Long> list = (List<Long>) getHibernateTemplate().find("select count(*) from Movie m where m.category=?", cartoon);
			Long lon = list.get(0);
			Integer count = Integer.parseInt(lon+"");
			return count;
		}
		return null;
	}

	@Override
	public Category getCartoonCategory() {
		if(this.cartoonCategory==null) {
			//获取动漫类别
			List<Category> list = (List<Category>) getHibernateTemplate().find("from Category c where c.id=? ", "2");
			if(list!=null&&list.size()>0) {
				Category cartoonCategory = list.get(0);
				if(cartoonCategory!=null) {
					this.cartoonCategory=cartoonCategory;
				}
				return cartoonCategory;
			}
		}
		return this.cartoonCategory;
	}

	//排行榜
	@Override
	public List<Movie> getCartoonRanking(Integer count) {
		
		return getHibernateTemplate().execute(new HibernateCallback<List<Movie>>() {

			@Override
			public List<Movie> doInHibernate(Session session) throws HibernateException {
				List<Movie> list = session.createQuery("from Movie m where m.category=? order by m.playTimes desc").
					setParameter(0, cartoonCategory).setFirstResult(0).
					setMaxResults(count).list();
				return list;
			}
		});
	}
	

}
