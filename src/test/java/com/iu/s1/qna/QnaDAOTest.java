package com.iu.s1.qna;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyjuintTest;

public class QnaDAOTest extends MyjuintTest {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void check() {
		assertNotNull(qnaDAO);
	}

}
