package entity;

import java.time.LocalDate;

public class Member {
    private Long memberId;
    private String name;
    private String surname;
    private String nickname;
    private String telephoneNumber;
    private LocalDate birth;
    private String position;
    private Long groupIdFk;

    public Member(Long memberId, String name, String surname, String nickname, String telephoneNumber, LocalDate birth, String position, Long groupIdFk) {
        this.memberId = memberId;
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.telephoneNumber = telephoneNumber;
        this.birth = birth;
        this.position = position;
        this.groupIdFk = groupIdFk;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getGroupIdFk() {
        return groupIdFk;
    }

    public void setGroupIdFk(Long groupIdFk) {
        this.groupIdFk = groupIdFk;
    }

    @Override
    public String toString() {
        return "entity.Member{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", birth=" + birth +
                ", position='" + position + '\'' +
                ", groupIdFk=" + groupIdFk +
                '}';
    }
}
