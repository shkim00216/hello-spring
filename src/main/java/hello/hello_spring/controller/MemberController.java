package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberSerivce memberSerivce;

    @Autowired
    public MemberController(MemberSerivce memberSerivce) {
        this.memberSerivce = memberSerivce;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    } //조회 - get

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberSerivce.join(member);

        return "redirect:/";
    } //등록 - post

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberSerivce.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
