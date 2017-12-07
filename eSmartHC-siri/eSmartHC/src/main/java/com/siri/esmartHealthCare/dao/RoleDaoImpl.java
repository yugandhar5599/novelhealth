package com.siri.esmartHealthCare.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.siri.esmartHealthCare.domain.RoleDomaine;
@Repository
public class RoleDaoImpl implements RoleDaoI{

	@Autowired
	private SessionFactory sf;
	
		public RoleDomaine getRoleByName(String roleName){
			Session hsesson = sf.openSession();
			
			/*Criteria ct=hsesson.createCriteria(RoleDomaine.class,roleName);
			RoleDomaine roleDomaine=(RoleDomaine) ct.uniqueResult();*/
		    Query query = hsesson.createQuery("from RoleDomaine where roleName=?");
			query.setParameter(0,roleName);
			RoleDomaine roleDomaine = (RoleDomaine)query.uniqueResult();
			return roleDomaine;
		}

		@Override
		public RoleDomaine getRoleByName() {
			Session hsesson = sf.openSession();
			Query query = hsesson.createQuery("from RoleDomaine where roleName=?");
			query.setParameter(0,"outpatient");
			RoleDomaine roleDomaine = (RoleDomaine)query.uniqueResult();
			
			return roleDomaine;
		}

		@Override
		public List<String> getRoleByNames(String roleName) {
			Session hsesson = sf.openSession();
			Query query = hsesson.createQuery("select roleName from RoleDomaine");
			List<String> roleNames=query.list();
			return roleNames;
		}
	
}
