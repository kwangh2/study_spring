package kr.co.budget.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


public class MemberDAO implements MemberService{
    @Autowired
    SqlSession sql;

    @Override
    public String login(MemberVO vo) {
        return null;
    }

    @Override
    public int join(MemberVO vo) {
        return sql.insert("me.insert",vo);
    }

}
