package com.korea.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.korea.domain.BoardVO;
import com.korea.domain.Criteria;
import com.korea.domain.SampleDTO;

public interface BoardMapper {

	Class<?> Integer = null;

	@Select("select * from tbl_board2 where bno>0")
	public List<BoardVO> getList();
	@Insert
	("insert into tbl_board2(bno,title,content,writer) values(seq_board.nextval, #{title},#{content},#{writer})")
	public void insert(BoardVO board);
	@SelectKey
	(
			statement="select seq_board.currval from dual",
			keyProperty="bno",
			before=false,
			resultType=long.class
	)
	@Insert
	("insert into tbl_board2(bno,title,content,writer) values(seq_board.nextval, #{title},#{content},#{writer})")
	public long insertSelectKey(BoardVO board);	
	
	@Select("select * from tbl_board2 where bno=#{bno}")
	public BoardVO read(Long bno);
	
	@Delete("delete from tbl_board2 where bno=#{bno}")
	public int delete (Long bno);
	
	@Update
	("update tbl_board2 set title=#{title},content=#{content},writer=#{writer},updateDate=sysdate where bno=#{bno}")
	public int update(BoardVO board);
	
	@Select("select count(*) from tbl_board2 where bno>0")
	public int getTotalCount(Criteria cri);
}
