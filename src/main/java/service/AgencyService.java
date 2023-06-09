package service;

import org.springframework.beans.factory.annotation.Autowired;
import repository.AgencyRepository;
import entity.Agency;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyService {
    private final AgencyRepository agencyRepository;

    @Autowired
    public AgencyService(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    public List<Agency> getAll() {
        return agencyRepository.getAll();
    }

    public Agency getById(Long agencyId) {
        return agencyRepository.getById(agencyId);
    }

    public Long insert(Agency agency) {
        return agencyRepository.insert(agency);
    }

    public String update(Agency agency) {
        return agencyRepository.update(agency);
    }

    public String delete(Long agencyId) {
        return agencyRepository.delete(agencyId);
    }
}
