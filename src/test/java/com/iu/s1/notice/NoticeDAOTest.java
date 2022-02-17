package com.iu.s1.notice;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyjuintTest;

public class NoticeDAOTest extends MyjuintTest {
	
	@Autowired
	private NoticeDAO noticeDAO;

	@Test
	public void cheak() {
		assertNotNull(noticeDAO);
	}
	
	// List
	@Test
	public void listTest() throws Exception {
		List<NoticeDTO> ar = noticeDAO.list();
		assertNotEquals(0, ar.size());
	}
	
}
