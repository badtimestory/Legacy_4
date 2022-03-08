package com.iu.s1.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyjuintTest;
import com.iu.s1.board.notice.NoticeDAO;
import com.iu.s1.board.notice.NoticeDTO;

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
	
	// Detail
	@Test
	public void detailTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1);
		noticeDTO = noticeDAO.detail(noticeDTO);
		assertNotNull(noticeDTO);
	}
	
	// insert
	@Test
	public void add() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("통장테스트");
		noticeDTO.setContents("테스트통장입니다.");
		noticeDTO.setWriter("유재석");
		noticeDTO.setRegDate("2020-02-17");
		noticeDTO.setHit(300);
		
		int result = noticeDAO.add(noticeDTO);
		assertEquals(1, result);
	}
	
	// delete
	@Test
	public void delete() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(5);
		int result = noticeDAO.delete(noticeDTO);
		assertEquals(1, result);
	}
}
