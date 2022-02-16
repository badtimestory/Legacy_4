package com.iu.s1.dept;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyjuintTest;

public class DeptDAOTest extends MyjuintTest {
	
	@Autowired
	private DeptDAO deptDAO;
	
	@Test
	public void listTest() throws Exception {
		List<DeptDTO> ar = deptDAO.list();
		
		for(int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i).getDepartment_name());
		}
		
		// 최소 0이상 있을 것
		assertNotEquals(0, ar.size());
	}

}
