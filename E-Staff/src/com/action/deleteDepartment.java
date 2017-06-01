package com.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.model.Department;
import com.model.Staff;
import com.opensymphony.xwork2.ActionSupport;
import com.service.DepartmentService;
import com.service.StaffService;
import com.tool.JSONUtils;

public class deleteDepartment extends ActionSupport{
	private String[] departmentID;
	private DepartmentService departmentService;
	private StaffService staffService;
	public StaffService getStaffService() {
		return staffService;
	}
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {	
		 Map<String, Object> map = new HashMap<String, Object>();
		         try {
		             
		             departmentService.deleteDepartment(departmentID);
		             for(int i=0;i<departmentID.length;i++)
		             {
		            	 List<Staff> stafflist=staffService.findByDeid(departmentID[i]);
		            	 for(int j=0;j<stafflist.size();j++)
		            	 {
		            		 stafflist.get(i).setDeid("000");
		            		 staffService.save(stafflist.get(i));
		            	 }
		             }
		             map.put("status", true);
		   		  JSONUtils.toJson(ServletActionContext.getResponse(), map);
		             return SUCCESS;
		         } catch (Exception e) {
		             // TODO Auto-generated catch block
		             e.printStackTrace();
		             map.put("status", false);
		    	     JSONUtils.toJson(ServletActionContext.getResponse(), map);
		    	     return ERROR;
		         }
		   
	}
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public String[] getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String[] departmentID) {
		this.departmentID = departmentID;
	}

}
