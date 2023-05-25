package repository_test;

import configuration.Config;
import data.KpopAgencyTestsData;
import entity.Agency;
import entity.KpopGroup;
import entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import repository.AgencyRepository;
import repository.KpopGroupRepository;
import repository.MemberRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = {Config.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberCRUDTest {
    @Autowired
    private AgencyRepository agencyRepository;
    @Autowired
    private KpopGroupRepository kpopGroupRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void getById() {
        //given
        Long agencyId = agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        KpopAgencyTestsData.TXT.setAgencyIdFk(agencyId);
        Long groupId = kpopGroupRepository.insert(KpopAgencyTestsData.TXT);
        KpopAgencyTestsData.FELIX.setGroupIdFk(groupId);
        Long memberId = memberRepository.insert(KpopAgencyTestsData.FELIX);
        KpopAgencyTestsData.FELIX.setMemberId(memberId);
        String expectedSelectQuery = KpopAgencyTestsData.FELIX.toString();
        //when
        String actualSelectQuery = memberRepository.getById(memberId).toString();

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        memberRepository.delete(memberId);
        kpopGroupRepository.delete(groupId);
        agencyRepository.delete(agencyId);
    }

    @Test
    public void insert() {
        Agency agency = agencyRepository.getById(agencyRepository.insert(KpopAgencyTestsData.SUNNY));
        KpopAgencyTestsData.TXT.setAgencyIdFk(agency.getAgencyId());
        KpopGroup kpopGroup = kpopGroupRepository.getById(kpopGroupRepository.insert(KpopAgencyTestsData.TXT));
        KpopAgencyTestsData.FELIX.setGroupIdFk(kpopGroup.getGroupId());
        //when
        Long actualSelectQuery = memberRepository.insert(KpopAgencyTestsData.FELIX);
        Member member = memberRepository.getById(actualSelectQuery);
        //given
        Long id = member.getMemberId();

        //then
        assertEquals(id, actualSelectQuery);
        memberRepository.delete(id);
        kpopGroupRepository.delete(kpopGroup.getGroupId());
        agencyRepository.delete(agency.getAgencyId());
    }

    @Test
    public void update() {
        //given
        String expectedSelectQuery = "update success";
        Agency agency = agencyRepository.getById(agencyRepository.insert(KpopAgencyTestsData.SUNNY));
        KpopAgencyTestsData.TXT.setAgencyIdFk(agency.getAgencyId());
        KpopGroup kpopGroup = kpopGroupRepository.getById(kpopGroupRepository.insert(KpopAgencyTestsData.TXT));
        KpopAgencyTestsData.FELIX.setGroupIdFk(kpopGroup.getGroupId());
        Member member = memberRepository.getById(memberRepository.insert(KpopAgencyTestsData.FELIX));

        //when
        String actualSelectQuery = memberRepository.update(member);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        memberRepository.delete(member.getMemberId());
        kpopGroupRepository.delete(kpopGroup.getGroupId());
        agencyRepository.delete(agency.getAgencyId());
    }

    @Test
    public void delete() {
        //given
        String expectedSelectQuery = "delete success";
        Agency agency = agencyRepository.getById(agencyRepository.insert(KpopAgencyTestsData.SUNNY));
        KpopAgencyTestsData.TXT.setAgencyIdFk(agency.getAgencyId());
        KpopGroup kpopGroup = kpopGroupRepository.getById(kpopGroupRepository.insert(KpopAgencyTestsData.TXT));
        KpopAgencyTestsData.FELIX.setGroupIdFk(kpopGroup.getGroupId());
        Member member = memberRepository.getById(memberRepository.insert(KpopAgencyTestsData.FELIX));

        //when
        String actualSelectQuery = memberRepository.delete(member.getMemberId());

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        kpopGroupRepository.delete(kpopGroup.getGroupId());
        agencyRepository.delete(agency.getAgencyId());
    }
}
