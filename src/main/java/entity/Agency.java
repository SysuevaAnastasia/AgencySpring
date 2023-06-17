package entity;

public class Agency {
    private Long agencyId;
    private String agencyName;
    private String directorName;
    private String telephoneNumber;
    private String address;

    public Agency() {

    }

    public Agency(Long agencyId, String agencyName, String directorName, String telephoneNumber, String address) {
        this.agencyId = agencyId;
        this.agencyName = agencyName;
        this.directorName = directorName;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }

    public Long getAgencyId() {
        return agencyId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "entity.Agency{" +
                "agencyId=" + agencyId +
                ", agencyName='" + agencyName + '\'' +
                ", directorName='" + directorName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
