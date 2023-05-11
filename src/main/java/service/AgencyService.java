package service;

import dao.AgencyDAO;
import entity.Agency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyService {
    private final AgencyDAO agencyDAO;

    @Autowired
    public AgencyService(AgencyDAO agencyDAO) {
        this.agencyDAO = agencyDAO;
    }

    public List<Agency> getAll() {
        return agencyDAO.getAll();
    }

    public Agency getById(Long agencyId) {
        return agencyDAO.getById(agencyId);
    }

    public Long insert(Agency agency) {
        return agencyDAO.insert(agency);
    }

    public String update(Agency agency) {
        return agencyDAO.update(agency);
    }

    public String delete(Long agencyId) {
        return agencyDAO.delete(agencyId);
    }
}
