package repository_test;

import configuration.Config;
import data.KpopAgencyTestsData;
import entity.Agency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import repository.AgencyRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = Config.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AgencyCRUDTest {
    @Autowired
    private AgencyRepository agencyRepository;

    @Test
    public void getById() {
        Long id = agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        KpopAgencyTestsData.SUNNY.setAgencyId(id);
        //given
        String expectedSelectQuery = KpopAgencyTestsData.SUNNY.toString();
        //when
        String actualSelectQuery = agencyRepository.getById(id).toString();

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        agencyRepository.delete(id);

    }

    @Test
    public void insert() {
        //when
        Long actualSelectQuery = agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        Agency agency = agencyRepository.getById(actualSelectQuery);
        //given
        Long id = agency.getAgencyId();

        //then
        assertEquals(id, actualSelectQuery);
        agencyRepository.delete(id);
    }

    @Test
    public void update() {
        //given
        String expectedSelectQuery = "update success";
        Agency agency = agencyRepository.getById(agencyRepository.insert(KpopAgencyTestsData.SUNNY));
        //when
        String actualSelectQuery = agencyRepository.update(agency);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        agencyRepository.delete(agency.getAgencyId());
    }

    @Test
    public void delete() {
        //given
        String expectedSelectQuery = "delete success";
        Agency agency = agencyRepository.getById(agencyRepository.insert(KpopAgencyTestsData.SUNNY));
        //when
        String actualSelectQuery = agencyRepository.delete(agency.getAgencyId());

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
    }
}
