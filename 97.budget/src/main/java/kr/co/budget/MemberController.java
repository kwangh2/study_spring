package kr.co.budget;

import kr.co.budget.member.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @RequestMapping
    public String joinRequest(MemberVO vo){

        return "redirect:/";
    }
    @RequestMapping("/join")
    public String join(){

        return "member/join";
    }
}
