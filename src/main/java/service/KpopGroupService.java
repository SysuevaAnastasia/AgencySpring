package service;

import dao.KpopGroupDAO;
import entity.KpopGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KpopGroupService {
    private final KpopGroupDAO kpopGroupDAO;

    @Autowired
    public KpopGroupService(KpopGroupDAO kpopGroupDAO) {
        this.kpopGroupDAO = kpopGroupDAO;
    }

    public List<KpopGroup> getAll() {
        return kpopGroupDAO.getAll();
    }

    public KpopGroup getById(Long groupId) {
        return kpopGroupDAO.getById(groupId);
    }

    public Long insert(KpopGroup group) {
        return kpopGroupDAO.insert(group);
    }

    public String update(KpopGroup group) {
        return kpopGroupDAO.update(group);
    }

    public String delete(Long groupId) {
        return kpopGroupDAO.delete(groupId);
    }
}
