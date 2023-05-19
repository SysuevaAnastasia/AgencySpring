package service;

import entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MemberRepository;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAll() {
        return memberRepository.getAll();
    }

    public Member getById(Long memberId) {
        return memberRepository.getById(memberId);
    }

    public Long insert(Member member) {
        return memberRepository.insert(member);
    }

    public String update(Member member) {
        return memberRepository.update(member);
    }

    public String delete(Long memberId) {
        return memberRepository.delete(memberId);
    }
}