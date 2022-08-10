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
      //mapper�� insert�� �̿��Ͽ� DB�� BoardVO �����ϰ�
      //��� ��ũ�� ������ ���
      BoardVO board = new BoardVO();
      board.setTitle("�� Ÿ��Ʋ");
      board.setContent("���� �ۼ��� ��");
      board.setWriter("�� �ۼ���");
      mapper.insert(board);
      log.info(board);
      
   }
   
   @Test
   public void readTest() {
      //mapper�� read�� �̿��Ͽ� DB�� �Խù� �ϳ��� �޾ƿͼ�
      //�ܼ�â�� ��� Ȯ���ϰ� ��ũ�������� ���
      BoardVO board = mapper.read(50L);
      log.info(board);
   }
   
   
   @Test
   public void DeleteTest() {
      //mapper�� delete�̿��Ͽ� DB�� Ư�� �Խù� �����ϰ� ��� ��ũ�� ������ ���
      int result = mapper.delete(60L);
      log.info("result : " + result);
   }
   
  
   @Test
   public void UpdateTest() {
      //mapper�� update�� �̿��Ͽ� DB�� Ư�� �Խù� �����ϰ�
      //��� ��ũ�� ������ ���
      BoardVO board = new BoardVO();
      board.setBno(70L);
      board.setTitle("���� ����");
      board.setContent("���� ����");
      board.setWriter("�ۼ��� ����");
      mapper.update(board);
   }
   
   @Test
   public void getTotalCountTest() {
	      Criteria cri = new Criteria();
	      
	      
	      int result = mapper.getTotalCount(cri);
	      System.out.println("�Խñ� �� ����" + result);
	   
   }
   
   
}