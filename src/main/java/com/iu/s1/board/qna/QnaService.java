package com.iu.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.board.notice.NoticeFileDTO;
import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManager fileManager;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		
		pager.makeRow();
		
		pager.makeNum(qnaDAO.total(pager));
		
		return qnaDAO.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.detail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		int result = qnaDAO.add(boardDTO);
		
		// 1. HDD에 저장
		for (int i = 0; i < files.length; i++) {
			if(files[i].isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.save(files[i], "resources/upload/qna/");
			
			// 2. DB에 저장
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setNum(boardDTO.getNum());
			qnaFileDTO.setFileName(fileName);
			qnaFileDTO.setOriName(files[i].getOriginalFilename());
			result = qnaDAO.addFile(qnaFileDTO);
		}
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.delete(boardDTO);
	}
	
	public int reply(QnaDTO qnaDTO) throws Exception {
		// qnaDTO.num : 부모글의 글번호
		// qnaDTO.title : 폼에서 입력한 제목
		// qnaDTO.Writer : 폼에서 입력한 답글 작성자
		// qnaDTO.contents : 폼에서 입력한 답글 글내용
		// qnaDTO.regDate : NULL
		// qnaDTO.hit : NULL
		// qnaDTO.ref : NULL
		// qnaDTO.step : NULL
		// qnaDTO.depth : NULL
		
		// 1. 부모의 정보를 조회(ref, step, depth)
		BoardDTO boardDTO = qnaDAO.detail(qnaDTO);
		QnaDTO parent = (QnaDTO)boardDTO;
		
		// 2. 답글의 ref는 부모의 ref값
		qnaDTO.setRef(parent.getRef());
		
		// 3. 답글의 step은 부모의 step+1
		qnaDTO.setStep(parent.getStep()+1);
		
		// 4. 답글의 depth는 부모의 depth+1
		qnaDTO.setDepth(parent.getDepth()+1);
		
		// 5. step update
		int result = qnaDAO.stepUpdate(parent);
		
		// 6. 답글 insert
		result =  qnaDAO.reply(qnaDTO);
		
		return result;
		
	}
	
	public QnaFileDTO detailFile(QnaFileDTO qnaFileDTO) throws Exception {
		return qnaDAO.detailFile(qnaFileDTO);
	}

}
