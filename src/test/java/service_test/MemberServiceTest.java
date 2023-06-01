package service_test;

import entity.Member;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import repository.MemberRepository;
import service.MemberService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class MemberServiceTest {
    private static final Long ID = 5L;
    public static final String NAME = "Gu";
    public static final String SURNAME = "Tu";
    public static final String NICKNAME = "Tiger";
    public static final String TELEPHONE_NUMBER = "123";
    public static final LocalDate BIRTH = LocalDate.parse("1983-03-03");
    public static final String POSITION = "dance";
    public static final long GROUP_ID_FK = 3L;
    private static final Member MEMBER = new Member(ID, NAME, SURNAME, NICKNAME, TELEPHONE_NUMBER, BIRTH, POSITION, GROUP_ID_FK);

    public static final String UPDATE_SUCCESS = "update success";
    private static final String DELETE_SUCCESS = "delete success";

    @Test
    void getById() {
        MemberRepository memberRepository = Mockito.mock(MemberRepository.class);
        when(memberRepository.getById(ID)).thenReturn(MEMBER);
        MemberService memberService = new MemberService(memberRepository);
        Member member = memberService.getById(ID);
        assertEquals(NAME, member.getName());
        assertEquals(SURNAME, member.getSurname());
        assertEquals(NICKNAME, member.getNickname());
        assertEquals(TELEPHONE_NUMBER, member.getTelephoneNumber());
        assertEquals(BIRTH, member.getBirth());
        assertEquals(POSITION, member.getPosition());
        assertEquals(GROUP_ID_FK, member.getGroupIdFk());
    }

    @Test
    void insert() {
        MemberRepository memberRepository = Mockito.mock(MemberRepository.class);
        when(memberRepository.insert(MEMBER)).thenReturn(ID);
        MemberService memberService = new MemberService(memberRepository);
        Long id = memberService.insert(MEMBER);
        assertEquals(id, ID);
    }

    @Test
    void update() {
        MemberRepository memberRepository = Mockito.mock(MemberRepository.class);
        when(memberRepository.update(MEMBER)).thenReturn(UPDATE_SUCCESS);
        MemberService memberService = new MemberService(memberRepository);
        String resultString = memberService.update(MEMBER);
        assertEquals(resultString, UPDATE_SUCCESS);
    }

    @Test
    void delete() {
        MemberRepository memberRepository = Mockito.mock(MemberRepository.class);
        when(memberRepository.delete(ID)).thenReturn(DELETE_SUCCESS);
        MemberService memberService = new MemberService(memberRepository);
        String resultString = memberService.delete(ID);
        assertEquals(resultString, DELETE_SUCCESS);
    }
}
