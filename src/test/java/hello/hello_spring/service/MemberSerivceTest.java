package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberSerivceTest {

    MemberSerivce memberSerivce = new MemberSerivce();
    private Member member1;

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberSerivce.join(member);

        //then
        Member findMember = memberSerivce.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when

        //then
    }

    @Test
    void findOne() {
    }
}