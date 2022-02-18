package com.iu.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyjuintTest;

public class BankBookDAOTest extends MyjuintTest {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	// @Test
	public void cheak() {
		assertNotNull(bankBookDAO);
	}
	
	// List
	// @Test
	public void listTest() throws Exception {
		List<BankBookDTO> ar = bankBookDAO.list();
		assertNotEquals(0, ar.size());
	}
	
	// Insert
	@Test
	public void addTest() throws Exception {
		for(int i = 0; i < 10; i ++) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookName("bookName" + i);
			bankBookDTO.setBookContents("Contents" + i);
			bankBookDTO.setBookRate(0.12 + i);
			bankBookDTO.setBookSale(1);
			int result = bankBookDAO.add(bankBookDTO);
		}
		System.out.println("Insert Finish");
		// 예상 값, 실제 값
		// assertEquals(1, result);
	}
	
	// Detail
	// @Test
	public void detailTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(4L);
		bankBookDTO = bankBookDAO.detail(bankBookDTO);
		assertNotNull(bankBookDTO);
	}
	
	// Delete
	// @Test
	public void deleteTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(3L);
		int result = bankBookDAO.delete(bankBookDTO);
		assertEquals(1, result);
	}
}