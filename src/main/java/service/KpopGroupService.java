package service;

import entity.KpopGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.KpopGroupRepository;

import java.util.List;

@Service
public class KpopGroupService {
    private final KpopGroupRepository kpopGroupRepository;

    @Autowired
    public KpopGroupService(KpopGroupRepository kpopGroupRepository) {
        this.kpopGroupRepository = kpopGroupRepository;
    }

    public List<KpopGroup> getAll() {
        return kpopGroupRepository.getAll();
    }

    public KpopGroup getById(Long groupId) {
        return kpopGroupRepository.getById(groupId);
    }

    public Long insert(KpopGroup group) {
        return kpopGroupRepository.insert(group);
    }

    public String update(KpopGroup group) {
        return kpopGroupRepository.update(group);
    }

    public String delete(Long groupId) {
        return kpopGroupRepository.delete(groupId);
    }
}
