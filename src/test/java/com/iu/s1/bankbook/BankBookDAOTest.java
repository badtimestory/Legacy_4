package com.iu.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyjuintTest;
import com.iu.s1.util.Pager;

public class BankBookDAOTest extends MyjuintTest {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	// @Test
	public void cheak() {
		assertNotNull(bankBookDAO);
	}
	
	// List
	@Test
	public void listTest() throws Exception {
		Pager pager = new Pager();
		pager.setPerPage(5L);
		pager.makeRow();
		List<BankBookDTO> ar = bankBookDAO.list(pager);
		System.out.println(ar.get(0).getBookNumber());
		System.out.println(ar.get(4).getBookNumber());
		assertEquals(5, ar.size());
	}
	
	// Insert
	// @Test
	public void addTest() throws Exception {
		
		for(int i = 0; i < 200; i ++) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookName("bookName" + i);
			bankBookDTO.setBookContents("Contents" + i);
			
			double rate = Math.random();	// 0 이상 1 미만
			rate = rate*1000;	// 123.45678
			int r = (int)rate;	// 123
			rate = r/100.0;
			
			bankBookDTO.setBookRate(rate);	// 총 3자리, 소숫점 2자리
			bankBookDTO.setBookSale(1);
			int result = bankBookDAO.add(bankBookDTO);
			
			if(i % 10 == 0) {
				Thread.sleep(1000);	// 1초동안 멈춤
			}
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