package com.siri.esmartHealthCare.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.siri.esmartHealthCare.beans.ManageUserProfileBean;
import com.siri.esmartHealthCare.beans.SignupBean;
import com.siri.esmartHealthCare.domain.ManageUserProfileDomain;
import com.siri.esmartHealthCare.domain.SignupDomain;
@Repository
public class SignupDaoImpl implements SignupDaoI{

	@Autowired
	private SessionFactory sf;
	
	String msg = "";
	
	//String emailMsg = "";
	@Override
	public List<String> getRoleList() {
		Session hSession = sf.openSession();
		Query query = hSession.createQuery("select roleName from UserRoles"); 
		List<String> listOfRoleNames = query.list();
		//List<DepartmentBean> listofdeptbeans=new ArrayList<DepartmentBean>();
		
		return listOfRoleNames;
	}
	
	
	@Override
	public List<String> getDepList(String role) {
		Session hSession = sf.openSession();
		Query query = hSession.createQuery("select deptName from DepartmentDomine where roleId=(select roleId from UserRoles where roleName=?)");
		query.setParameter(0, role);
		List<String> listOfDeptNames = query.list();
		for(String s:listOfDeptNames){
			System.out.println("listOfDeptNames:  "+s);
		}
		
		
		return listOfDeptNames;
	}
	@Override
	public String saveDetails(ManageUserProfileDomain userProfDomaine) {
		//ManageUserProfileDomain userProfDomaine = new ManageUserProfileDomain();		
		//System.out.println("roleid is:   "+userProfDomaine.getRole().getRoleId());
		Session hSession = sf.openSession();	
		Query query = hSession.createQuery("select profileId from ManageUserProfileDomain where email=?");
		query.setParameter(0, userProfDomaine.getEmail());
		List<Integer> signupIdsList= query.list();
		System.out.println("email list size:"+signupIdsList.size());
		
		if(signupIdsList.size()>=1){
			msg = "mailExist";
			System.out.println("message:  "+msg);
			return msg;
		}else{
			//System.out.println("else is called...");
			Query query1 = hSession.createQuery("select profileId from ManageUserProfileDomain where userId=?");
			//System.out.println(signupBean.getUserid());
			query1.setParameter(0, userProfDomaine.getUserId());
			//System.out.println(signupBean.getUserid());
			List<Integer> signupIdsList1= query1.list();
			System.out.println("users list size:"+signupIdsList1.size());
			if(signupIdsList1.size()>=1){
				System.out.println("user allready existed..");
				msg = "uIdexist";
				System.out.println("message:  "+msg);
				return msg;
			}else{
			
			Integer serIdValue = (Integer)hSession.save(userProfDomaine);
			System.out.println("value is "+serIdValue);
			//txn.commit();
			
			if(serIdValue>0){
				msg = "success";
				System.out.println("message:  "+msg);
			}else{
				System.out.println("message:  "+msg);
				msg = "fail";
			}
			hSession.close();
			return msg;
		}
		}
		//Transaction txn  = hSession.beginTransaction();
		
	}
	@Override
	public String checkEmailExist(String emiailId) {
		
		Session hSession = sf.openSession();		
		Query query = hSession.createQuery("select signid from SignupDomain where email=?");
		query.setParameter(0, emiailId);
		List<Integer> signupIdsList= query.list();
		System.out.println("list size:"+signupIdsList.size());
		if(signupIdsList.size()>=1){
			msg = "mail id allready existed";
		}else{
			
		}
		return null;
	}


	@Override
	public Integer getRoleId() {
		Session hSession = sf.openSession();		
		Query query = hSession.createQuery("select roleId from RoleDomaine where roleName='outpatient'");
		Integer roleId = (Integer)query.uniqueResult();
		System.out.println("role id -----"+roleId);
		return roleId;
	}
	
	
}
