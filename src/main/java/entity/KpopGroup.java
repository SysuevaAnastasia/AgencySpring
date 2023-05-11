package entity;

import java.time.LocalDate;

public class KpopGroup {
    private Long groupId;
    private String groupName;
    private LocalDate dataStartContract;
    private LocalDate dataEndContract;
    private String managerName;
    private Long agencyIdFk;

    public KpopGroup(Long groupId, String groupName, LocalDate dataStartContract, LocalDate dataEndContract, String managerName, Long agencyIdFk) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.dataStartContract = dataStartContract;
        this.dataEndContract = dataEndContract;
        this.managerName = managerName;
        this.agencyIdFk = agencyIdFk;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public LocalDate getDataStartContract() {
        return dataStartContract;
    }

    public void setDataStartContract(LocalDate dataStartContract) {
        this.dataStartContract = dataStartContract;
    }

    public LocalDate getDataEndContract() {
        return dataEndContract;
    }

    public void setDataEndContract(LocalDate dataEndContract) {
        this.dataEndContract = dataEndContract;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Long getAgencyIdFk() {
        return agencyIdFk;
    }

    public void setAgencyIdFk(Long agencyIdFk) {
        this.agencyIdFk = agencyIdFk;
    }

    @Override
    public String toString() {
        return "entity.KpopGroup{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", dataStartContract=" + dataStartContract +
                ", dataEndContract=" + dataEndContract +
                ", managerName='" + managerName + '\'' +
                ", agencyIdFk=" + agencyIdFk +
                '}';
    }
}
