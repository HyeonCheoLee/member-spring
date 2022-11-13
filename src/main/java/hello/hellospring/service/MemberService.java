package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Member service.
 */
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * Join member.
     * 회원가입
     *
     * @param member the member
     * @return the long
     */
    public Long joinMember(Member member) {
        //중복 체크
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    /**
     * Find members.
     * 전체 회원조회
     *
     * @return the list
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }


    /**
     * Find one member.
     * 회원 단일조회
     * @param memberId the member id
     * @return the member
     */
    public Member findOneMember(Long memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        });
    }
}
