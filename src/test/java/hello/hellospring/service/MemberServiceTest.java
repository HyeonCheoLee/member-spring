package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * packageName    : hello.hellospring.service
 * fileName       : MemberServiceTest
 * author         : hyunc
 * date           : 2022-11-13
 * description    : MemberServiceTest
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-11-13        hyunc       최초 생성
 */
class MemberServiceTest {

    //memoryMemberRepository를 하나만 생성하여 써야해서 MemberService생성할때 만들어둔 memoryMemberRepository를 넣어준다.
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
    MemberService memberService = new MemberService(memoryMemberRepository);

    //각 함수 동작전에 실행
    @BeforeEach
    public void beforeEach() {
        //memoryMemberRepository가 생성되기 전에 접근하면 NullPointerException 발생하므로 생성한후에 클리어를 해준다.
        memoryMemberRepository.clearStore();
    }

    //각 함수 동작후에 실행
    @AfterEach
    public void afterEach() {

    }


    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.joinMember(member);

        //then : 회원정보를 가져와서 등록한 이름과 일치하는지 확인한다.
        Member findMember = memberService.findOneMember(saveId);
        assertThat(member.getName()).isEqualTo(findMember.getName());
        assertThat(findMember.getName()).isEqualTo(member.getName());
    }

    @Test
    void 중복이름예외처리_잘되는지_확인() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.joinMember(member1);
        //memberService.joinMember(member2) 실행했을때 IllegalStateException 해당 익셉션을 띄우는지 확인(띄우면 중복)
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> memberService.joinMember(member2));

        assertThat(illegalStateException.getMessage()).isEqualTo("이미 존재하는 이름입니다.");
        //then

    }

    @Test
    void 멤버단일조회() {
    }
}