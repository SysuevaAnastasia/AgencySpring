package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import repository.AgencyRepository;
import entity.Agency;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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

    @Async
    public CompletableFuture<Long> insert(Agency agency) {
        return CompletableFuture.completedFuture(agencyRepository.insert(agency));
    }

    @Async
    public CompletableFuture<String> update(Agency agency) {
        return CompletableFuture.completedFuture(agencyRepository.update(agency));
    }

    @Async
    public CompletableFuture<String> delete(Long agencyId) {
        return CompletableFuture.completedFuture(agencyRepository.delete(agencyId));
    }
}
