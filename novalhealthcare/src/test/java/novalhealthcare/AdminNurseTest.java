package novalhealthcare;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dotridge.dao.NurseDao;
import com.dotridge.dao.NurseDaoImpl;
import com.dotridge.domain.Nurse;
import com.dotridge.util.SessionFactoryUtil;

public class AdminNurseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	creatrNurse();
	}
		private static void creatrNurse() {
		// TODO Auto-generated method stub
		

		SessionFactory factory=SessionFactoryUtil.getfactory();
		Session session=factory.openSession();
		Transaction ts=session.beginTransaction();
		Nurse nurse=new Nurse();
		nurse.setFirstName("Hema");
		nurse.setMiddleName("");
		nurse.setLastName("Govardhan");
		nurse.setEmail("govardhan7298@gmail.com");
		nurse.setPassword("Hema@321");
		nurse.setPhone(8977885422L);
		NurseDao nurseDao=new NurseDaoImpl();
		 Nurse nurse1=nurseDao.createNurse(nurse);
		 System.out.println("nurse added sucessfully");
		
	}

}
