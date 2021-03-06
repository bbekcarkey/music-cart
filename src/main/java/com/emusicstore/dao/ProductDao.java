package com.emusicstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.daointer.ProductDaoInter;
import com.emusicstore.model.Product;



@Transactional
@Repository("productdao")
public class ProductDao implements ProductDaoInter {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
public  void addProduct(Product product)
{
		
	Session session = sessionFactory.getCurrentSession();
	session.saveOrUpdate(product);
	session.flush();
	
}

	
	@Override
public Product getProductbyId(String productId) 
{
	Session session = sessionFactory.getCurrentSession();
	Product product = (Product) session.get(Product.class,productId);
	return product;
}

	
	@Override
public List<Product> getAllProduct(){
	Session session = sessionFactory.getCurrentSession();
	
	Criteria cr = session.createCriteria(Product.class);
	cr.add(Restrictions.eq("productStatus","active"));
	List<Product>products =cr.list();
	session.flush();
	return products;

}

	

	
	@Override
public void deleteProduct(String productId)
{
	Session session = sessionFactory.getCurrentSession();
	session.delete(getProductbyId(productId));
	session.flush();

	
}

	@Override
	public List<Product> getAllProductAdmin() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product");
		List<Product>products =query.list();
		session.flush();
		return products;
	}


}