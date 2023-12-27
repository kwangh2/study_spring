package kr.co.smart.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired @Qualifier("hanul") private SqlSession sql;
	//회원가입시 회원정보 신규 삽입 저장
	public int member_join(MemberVO vo) {
		return 0;
	}
	//회원목록조회
	public List<MemberVO> member_list() {
		return null;
	}
	public MemberVO member_info(String user_id) {
		
		return sql.selectOne("member.info",user_id);
	}
	//회원정보변경저장
	public int member_update(MemberVO vo) {
		return 0;	
	}
	//회원탈퇴시 회원정보 삭제
	public int member_delete(String user_id) {
		return 0;
	}
	
	public MemberVO member_userid_email(MemberVO vo) {
		return sql.selectOne("member.useridEmail",vo);
	}
	
	public int member_resetPassword(MemberVO vo) {
		return sql.update("member.resetPassword", vo);
	}
	
	
}
