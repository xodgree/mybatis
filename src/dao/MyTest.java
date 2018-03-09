package dao;

import java.util.List;

import model.BoardDataBean;



public class MyTest {
	public static void main(String[] args) {
		List<BoardDataBean> li = MybatisDao.getInstance().selectBoard("1");
		for(BoardDataBean at : li) {
			System.out.println(at.getWriter()+","+at.getNum()+":"+at.getBoardid());
		}
	}
}
