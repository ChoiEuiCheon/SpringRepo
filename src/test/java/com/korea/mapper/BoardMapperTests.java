package com.korea.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.korea.mapper.BoardMapper;
import com.korea.domain.BoardVO;
import com.korea.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

   @Autowired
   private BoardMapper mapper;

   
   @Test
   public void getListTest() {
      mapper.getList().forEach(baord->log.info(baord));
   }
   
   @Test
   public void insertTest() {
      //mapper의 insert를 이용하여 DB에 BoardVO 삽입하고
      //결과 스크린 샷으로 찍기
      BoardVO board = new BoardVO();
      board.setTitle("새 타이틀");
      board.setContent("새로 작성한 글");
      board.setWriter("새 작성자");
      mapper.insert(board);
      log.info(board);
      
   }
   
   @Test
   public void readTest() {
      //mapper의 read를 이용하여 DB에 게시물 하나를 받아와서
      //콘솔창에 결과 확인하고 스크린샷으로 찍기
      BoardVO board = mapper.read(50L);
      log.info(board);
   }
   
   
   @Test
   public void DeleteTest() {
      //mapper의 delete이용하여 DB에 특정 게시물 삭제하고 결과 스크린 샷으로 찍기
      int result = mapper.delete(60L);
      log.info("result : " + result);
   }
   
  
   @Test
   public void UpdateTest() {
      //mapper의 update를 이용하여 DB의 특정 게시물 수정하고
      //결과 스크린 샷으로 찍기
      BoardVO board = new BoardVO();
      board.setBno(70L);
      board.setTitle("제목 수정");
      board.setContent("내용 수정");
      board.setWriter("작성자 수정");
      mapper.update(board);
   }
   
   @Test
   public void getTotalCountTest() {
	      Criteria cri = new Criteria();
	      
	      
	      int result = mapper.getTotalCount(cri);
	      System.out.println("게시글 총 개수" + result);
	   
   }
   
   
}