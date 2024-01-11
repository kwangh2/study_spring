package kr.co.budget.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements MemberService{


    @Override
    public int join(MemberVO vo) {
        return 0;
    }

    @Override
    public int modify(MemberVO vo) {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }

    @Override
    public int login(String user_id, String user_pw) {
        return 0;
    }
}
