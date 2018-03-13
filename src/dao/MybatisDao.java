//서버에서 db에 있는 것을 가져오는걸 실행을 도와주는 것.
//자바의 4가지중 메소드 제일중요한게 리턴타입. object냐  collection이냐.
//object = setter getter. 가져와서 return. 하는게 큰 역할.
//하나의 object로 가져올것인지 collection으로 가져올것인지.
package dao;
//Connector가져와서 실행.
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
	//Connector 기능 
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

