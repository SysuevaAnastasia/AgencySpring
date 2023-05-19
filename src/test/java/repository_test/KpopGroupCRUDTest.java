package repository_test;

import configuration.Config;
import data.KpopAgencyTestsData;
import entity.Agency;
import entity.KpopGroup;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import repository.AgencyRepository;
import repository.KpopGroupRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = {Config.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class KpopGroupCRUDTest {
    @Autowired
    private AgencyRepository agencyRepository;
    @Autowired
    private KpopGroupRepository kpopGroupRepository;

    @Test
    public void getById() {
        //given
        Long agencyId = agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        KpopAgencyTestsData.TXT.setAgencyIdFk(agencyId);
        Long groupId = kpopGroupRepository.insert(KpopAgencyTestsData.TXT);
        KpopAgencyTestsData.TXT.setGroupId(groupId);
        String expectedSelectQuery = KpopAgencyTestsData.TXT.toString();
        //when
        String actualSelectQuery = kpopGroupRepository.getById(groupId).toString();

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        kpopGroupRepository.delete(groupId);
        agencyRepository.delete(agencyId);
    }
    @Test
    public void insert() {
        Agency agency = agencyRepository.getById(agencyRepository.insert(KpopAgencyTestsData.SUNNY));
        KpopAgencyTestsData.TXT.setAgencyIdFk(agency.getAgencyId());
        //when
        Long actualSelectQuery = kpopGroupRepository.insert(KpopAgencyTestsData.TXT);
        KpopGroup kpopGroup = kpopGroupRepository.getById(actualSelectQuery);
        Long id = kpopGroup.getGroupId();
        //given
        Long expectedSelectQuery = id;

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        kpopGroupRepository.delete(id);
        agencyRepository.delete(agency.getAgencyId());
    }
    @Test
    public void update() {
        //given
        String expectedSelectQuery = "update success";
        Agency agency = agencyRepository.getById(agencyRepository.insert(KpopAgencyTestsData.SUNNY));
        KpopAgencyTestsData.TXT.setAgencyIdFk(agency.getAgencyId());
        KpopGroup kpopGroup = kpopGroupRepository.getById(kpopGroupRepository.insert(KpopAgencyTestsData.TXT));
        //when
        String actualSelectQuery = kpopGroupRepository.update(kpopGroup);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
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
        //when
        String actualSelectQuery = kpopGroupRepository.delete(kpopGroup.getGroupId());

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        agencyRepository.delete(agency.getAgencyId());
    }
}
