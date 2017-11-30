package com.jason.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jason.dao.IMTVDao;
import com.jason.domain.Category;
import com.jason.domain.Movie;
@Repository
public class MTVDao extends HibernateDaoSupport implements IMTVDao {
	
	private Category mtvCategory;
	
	@Autowired
	public void setMySessionFactory(SessionFactory sf) {
		super.setSessionFactory(sf);
	}

	@Override
	public List<Movie> getMTVToIndex(Integer nowPage) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Movie>>() {

			@Override
			public List<Movie> doInHibernate(Session session) throws HibernateException {
				List<Movie> list = session.createQuery("from Movie m where m.category=?").
					setParameter(0, mtvCategory).setFirstResult(nowPage).
					setMaxResults(11).list();
				return list;
			}
		});
	}

	@Override
	public Integer getMTVCount() {
		Category mtv = getMTVCategory();
		if(mtv!=null) {
			List<Long> list = (List<Long>) getHibernateTemplate().find("select count(*) from Movie m where m.category=?", mtv);
			Long lon = list.get(0);
			Integer count = Integer.parseInt(lon+"");
			return count;
		}
		return null;
	}

	@Override
	public Category getMTVCategory() {
		if(this.mtvCategory==null) {
			//获取MTV类别
			List<Category> list = (List<Category>) getHibernateTemplate().find("from Category c where c.id=? ", "3");
			if(list!=null&&list.size()>0) {
				Category mtv = list.get(0);
				if(mtv!=null) {
					this.mtvCategory=mtv;
				}
				return mtv;
			}
		}
		return this.mtvCategory;
	}

	@Override
	public List<Movie> getMTVRanking(Integer count) {
		if(this.mtvCategory==null) {
			 getMTVCategory();
		}
		return getHibernateTemplate().execute(new HibernateCallback<List<Movie>>() {

			@Override
			public List<Movie> doInHibernate(Session session) throws HibernateException {
				List<Movie> list = session.createQuery("from Movie m where m.category=? order by m.playTimes desc").
					setParameter(0,mtvCategory).setFirstResult(0).
					setMaxResults(count).list();
				return list;
			}
		});
	}

}
