package kr.co.budget.member;

import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    public String login(MemberVO vo);
    public int join(MemberVO vo);
}
