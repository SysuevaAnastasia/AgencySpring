package service_test;

import entity.Agency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import repository.AgencyRepository;
import service.AgencyService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AgencyServiceTest {

    public static final String AGENCY_NAME = "WerNy";
    public static final String DIRECTOR_NAME = "Fy Ty";
    public static final String TELEPHONE = "123";
    public static final String ADDRESS = "Tokyo City";
    public static final Long ID = 5L;
    public static final Agency AGENCY = new Agency(ID, AGENCY_NAME, DIRECTOR_NAME, TELEPHONE, ADDRESS);
    public static final String UPDATE_SUCCESS = "update success";
    private static final String DELETE_SUCCESS = "delete success";

    @Test
    public void getById() {
        AgencyRepository agencyRepository = Mockito.mock(AgencyRepository.class);
        when(agencyRepository.getById(ID)).thenReturn(AGENCY);
        AgencyService agencyService = new AgencyService(agencyRepository);
        Agency agency = agencyService.getById(ID);
        assertEquals(AGENCY_NAME, agency.getAgencyName());
        assertEquals(DIRECTOR_NAME, agency.getDirectorName());
        assertEquals(TELEPHONE, agency.getTelephoneNumber());
        assertEquals(ADDRESS, agency.getAddress());
    }

    @Test
    public void insert() {
        AgencyRepository agencyRepository = Mockito.mock(AgencyRepository.class);
        when(agencyRepository.insert(AGENCY)).thenReturn(ID);
        AgencyService agencyService = new AgencyService(agencyRepository);
        Long id = agencyService.insert(AGENCY);
        assertEquals(id, ID);
    }

    @Test
    public void update() {
        AgencyRepository agencyRepository = Mockito.mock(AgencyRepository.class);
        when(agencyRepository.update(AGENCY)).thenReturn(UPDATE_SUCCESS);
        AgencyService agencyService = new AgencyService(agencyRepository);
        String resultString = agencyService.update(AGENCY);
        assertEquals(resultString, UPDATE_SUCCESS);
    }

    @Test
    public void delete() {
        AgencyRepository agencyRepository = Mockito.mock(AgencyRepository.class);
        when(agencyRepository.delete(ID)).thenReturn(DELETE_SUCCESS);
        AgencyService agencyService = new AgencyService(agencyRepository);
        String resultString = agencyService.delete(ID);
        assertEquals(resultString, DELETE_SUCCESS);
    }
}
