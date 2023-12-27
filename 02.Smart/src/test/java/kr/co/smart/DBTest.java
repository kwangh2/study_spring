package kr.co.smart;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.smart.member.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class DBTest {
	@Autowired
	@Qualifier("hanul")
	private SqlSession sql;
	
//	암호화 시킬 클래스
	private BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
	
	@Test
	public void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 : " );
		String user_id = sc.next();
		System.out.println("비밀번호 : ");
		String user_pw = sc.next();
		
		MemberVO vo =  sql.selectOne("member.info" , user_id);
		if(vo == null) {
			System.out.println("아이디 불일치");
		}else {
			boolean match = pwEncoder.matches(user_pw, vo.getUser_pw());
			if(match) {
				System.out.println(vo.getName() + "으로 로그인");
			}else {
				System.out.println("비번 불일치");
			}
		}
		
		
		sc.close();
	}
	

	@Test
	public void join() {
		//키보드로 회원가입에 필요한 정보 처리
		Scanner sc = new Scanner(System.in);
		MemberVO vo  = new MemberVO();
		System.out.print("이름:");
		vo.setName(sc.next()); 
		System.out.print("아이디:");
		vo.setUser_id(sc.next()); 
		System.out.print("비번:");
		vo.setUser_pw( pwEncoder.encode(sc.next()) ); 
		System.out.print("이메일:");
		vo.setEmail(sc.next()); 
		
		
		sc.close();
		int dml = sql.insert("member.joinTest" , vo);
		System.out.println(dml==1 ? "가입성공" : "가입실패");
	}
	
	
	@Test
	public void query_test() {
		String today = sql.selectOne("member.today");
		System.out.println("오늘: " + today);
	}
}