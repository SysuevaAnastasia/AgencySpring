package service_test;

import entity.KpopGroup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import repository.KpopGroupRepository;
import service.KpopGroupService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class KpopGroupServiceTest {

    private static final Long ID = 5L;
    public static final String GROUP_NAME = "RWK";
    public static final LocalDate DATA_START_CONTRACT = LocalDate.parse("2000-09-12");
    public static final LocalDate DATA_END_CONTRACT = LocalDate.parse("2006-09-12");
    public static final String MANAGER_NAME = "Ret Hul";
    public static final long AGENCY_ID_FK = 3L;
    private static final KpopGroup KPOPGROUP = new KpopGroup(ID, GROUP_NAME, DATA_START_CONTRACT, DATA_END_CONTRACT, MANAGER_NAME, AGENCY_ID_FK);
    public static final String UPDATE_SUCCESS = "update success";
    private static final String DELETE_SUCCESS = "delete success";


    @Test
    public void getById() {
        KpopGroupRepository kpopGroupRepository = Mockito.mock(KpopGroupRepository.class);
        when(kpopGroupRepository.getById(ID)).thenReturn(KPOPGROUP);
        KpopGroupService kpopGroupService = new KpopGroupService(kpopGroupRepository);
        KpopGroup kpopGroup = kpopGroupService.getById(ID);
        assertEquals(GROUP_NAME, kpopGroup.getGroupName());
        assertEquals(DATA_START_CONTRACT, kpopGroup.getDataStartContract());
        assertEquals(DATA_END_CONTRACT, kpopGroup.getDataEndContract());
        assertEquals(MANAGER_NAME, kpopGroup.getManagerName());
        assertEquals(AGENCY_ID_FK, kpopGroup.getAgencyIdFk());
    }

    @Test
    public void insert() {
        KpopGroupRepository kpopGroupRepository = Mockito.mock(KpopGroupRepository.class);
        when(kpopGroupRepository.insert(KPOPGROUP)).thenReturn(ID);
        KpopGroupService kpopGroupService = new KpopGroupService(kpopGroupRepository);
        Long id = kpopGroupService.insert(KPOPGROUP);
        assertEquals(id, ID);
    }

    @Test
    public void update() {
        KpopGroupRepository kpopGroupRepository = Mockito.mock(KpopGroupRepository.class);
        when(kpopGroupRepository.update(KPOPGROUP)).thenReturn(UPDATE_SUCCESS);
        KpopGroupService kpopGroupService = new KpopGroupService(kpopGroupRepository);
        String resultString = kpopGroupService.update(KPOPGROUP);
        assertEquals(resultString, UPDATE_SUCCESS);
    }

    @Test
    public void delete() {
        KpopGroupRepository kpopGroupRepository = Mockito.mock(KpopGroupRepository.class);
        when(kpopGroupRepository.delete(ID)).thenReturn(DELETE_SUCCESS);
        KpopGroupService kpopGroupService = new KpopGroupService(kpopGroupRepository);
        String resultString = kpopGroupService.delete(ID);
        assertEquals(resultString, DELETE_SUCCESS);
    }
}
