package service;

import dao.MemberDAO;
import entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberDAO memberDAO;

    @Autowired
    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public List<Member> getAll() {
        return memberDAO.getAll();
    }

    public Member getById(Long memberId) {
        return memberDAO.getById(memberId);
    }

    public Long insert(Member member) {
        return memberDAO.insert(member);
    }

    public String update(Member member) {
        return memberDAO.update(member);
    }

    public String delete(Long memberId) {
        return memberDAO.delete(memberId);
    }
}
