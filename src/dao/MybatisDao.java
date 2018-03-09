package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.BoardDataBean;

public class MybatisDao extends MybatisConnector{
	private final String namespace = "ldg.mybatis";
	private static MybatisDao instance = new MybatisDao();
	public static MybatisDao getInstance() {
		return instance;
	}
	SqlSession sqlSession;
	public List<BoardDataBean> selectBoard(){
		sqlSession = sqlSession();
		System.out.println("selectboard");
		try {
			return sqlSession.selectList(namespace + ".boardList");
		}finally {
			sqlSession.close();
		}
	}
	public List<BoardDataBean> selectBoard(int num){
		sqlSession = sqlSession();
		System.out.println("selectboard");
		Map map = new HashMap();map.put("num", num);
		try {
			return sqlSession.selectList(namespace + ".boardList",map);
		}finally {
			sqlSession.close();
		}
	}
	public List<BoardDataBean> selectBoard(String boardid){
		sqlSession = sqlSession();
		Map map = new HashMap();
		map.put("boardid", boardid);
		try {
				return sqlSession.selectList(namespace + ".boardList", map);
			}finally {
				sqlSession.close();
			}
		}
	}

