package com.zhifan.junit;

import org.junit.Test;

import com.zhifan.domain.Employee;
import com.zhifan.service.NameListService;
import com.zhifan.service.TeamException;
/** For testing NameListService */
public class NameListServiceTest {
	
	@Test
	public void testGetAllEmployees(){
		NameListService listService = new NameListService();
		
		Employee[] employees = listService.getAllEmployees();
		
		for(int i = 0;i < employees.length;i++){
			System.out.println(employees[i]);
		}
	}

	@Test
	public void testGetEmployee(){
		int id = 2;
		NameListService listService = new NameListService();
		try {
			Employee emp = listService.getEmployee(id);
			System.out.println(emp);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
	}
	
}