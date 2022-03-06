package com.iu.s1.qna;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyjuintTest;

public class QnaDAOTest extends MyjuintTest {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	// @Test
	public void check() {
		assertNotNull(qnaDAO);
	}
	
	// list 
	// @Test
	public void list() throws Exception {
		List<QnaDTO> ar = qnaDAO.list();
		assertNotEquals(0, ar.size());
	}
	
	// add
	// @Test
	public void add() throws Exception {
		for (int i = 0; i < 100; i++) {
			QnaDTO qnaDTO = new QnaDTO();
			qnaDTO.setTitle("testcase"+ i);
			qnaDTO.setContents("testcontent" + i);
			qnaDTO.setWriter("운영자");
			int result = qnaDAO.add(qnaDTO);
			
			if(i % 10 == 0) {
				Thread.sleep(100);
			}
			assertEquals(1, result);
		}
		System.out.println("insert Finish");
	}
	
	// detail
	// @Test
	public void detailTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(100L);
		qnaDTO = qnaDAO.detail(qnaDTO);
		assertNotNull(qnaDTO);
	}
	
	// delete
	// @Test
	public void deleteTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(99L);
		int result = qnaDAO.delete(qnaDTO);
		assertEquals(1, result);
	}

}
