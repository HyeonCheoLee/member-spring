package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import hello.hellospring.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * packageName    : hello.hellospring.controller
 * fileName       : MemberController
 * author         : hyunc
 * date           : 2022-11-13
 * description    : MemberController
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-11-13        hyunc       최초 생성
 */

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    private MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createMember() {
        return "members/createMember";
    }

    @PostMapping("/members/new")
    public String create(MemberVo memberVo) {
        Member member = new Member();
        member.setName(memberVo.getName());

        memberService.joinMember(member);

        return "redirect:/";
    }

    @GetMapping("members/memberList")
    public ModelAndView memberList(ModelAndView mv) {
        List<Member> members = memberService.findMembers();

        mv.addObject("members", members);
        mv.setViewName("members/memberList");
        return mv;
    }

    @GetMapping("members/selectMember")
    public ModelAndView selectMember(MemberVo memberVo, ModelAndView mv) {
        Member oneMember = memberService.findOneMember(memberVo.getId());
        mv.addObject("member", oneMember);
        mv.setViewName("home");
        return mv;
    }
}
