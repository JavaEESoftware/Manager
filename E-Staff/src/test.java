
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.action.addDepartment;
import com.model.*;
import com.opensymphony.xwork2.ActionContext;
import com.service.*;




public class test {
	 @Test  
	 /*
	  * ����DAO��
	  */
	    public void testUserDao() throws Exception{  
	    	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	    	AdminDAO dao =  (AdminDAO)ctx.getBean("adminDAO");
	        List<Admin> adminlist= dao.findByAdid("123");   
	    	 System.out.println("dao"+adminlist.get(0).getAdid());
	    }
	 @Test  
	 /*
	  * ����Service��
	  */
	    public void testUserService() throws Exception{  
	    	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	    	 	AdminService ser =  (AdminService)ctx.getBean("adminService");	    	 
	    	 	  List<Admin> adminlist= ser.findByAdid("123"); 
	    	 	 System.out.println("service"+adminlist.get(0).getAdid());
	    }
	 @Test  
	 /*
	  * ����action
	  */
	    public void testUserAction() throws Exception{  
		
		 ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
    	 addDepartment ser =  (addDepartment)ctx.getBean("addDepartment"); 
	    	
	    	Admin a=new Admin();
	    	a.setAdid("123");
	        ser.setAdmin(a);
	    	
			
			Department department = new Department();
	    	department.setName("���۲�");
	    	ser.setDepartment(department);
	    	
	    	//String str=ser.test();
	    	 
	    }

}