package kr.co.budget.member;

public interface MemberService {
    //회원 가입, 수정, 탈퇴, 로그인

    int join(MemberVO vo);

    int modify(MemberVO vo);

    int delete();

    int login(String user_id, String user_pw);
}
