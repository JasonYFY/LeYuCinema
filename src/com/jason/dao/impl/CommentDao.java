package com.jason.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jason.dao.ICommentDao;
import com.jason.domain.Comment;
import com.jason.domain.PageModel;
@Repository
public class CommentDao extends HibernateDaoSupport implements ICommentDao {
	
	@Autowired
	public void setMySessionFactory(SessionFactory sf) {
		super.setSessionFactory(sf);
	}

	@Override
	public List<Comment> queryByPage(Comment comment, PageModel pageModel) {
		/*List<Comment> list = getHibernateTemplate().findByExample(comment, pageModel.startRowNum(), pageModel.getPageSize());
		return list;*/
		String hql = "from Comment c where c.movieId=? order by c.createDate desc";
		return getHibernateTemplate().execute(new HibernateCallback<List<Comment>>() {
			@Override
			public List<Comment> doInHibernate(Session session) throws HibernateException {
				List<Comment> list = session.createQuery(hql).
						setParameter(0, comment.getMovieId()).
						setFirstResult(pageModel.startRowNum()).
						setMaxResults(pageModel.getPageSize()).
						list();
				return list;
			}
		});
	}

	@Override
	public Long getCount(Comment comment) {
		List<Long> list = (List<Long>) getHibernateTemplate().find("select count(*) from Comment c where c.movieId=?", comment.getMovieId());
		return list.get(0);
	}

	@Override
	public void insert(Comment comment) {
		getHibernateTemplate().save(comment);

	}

}
