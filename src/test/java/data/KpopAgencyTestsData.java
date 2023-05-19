package data;

import entity.Agency;
import entity.KpopGroup;
import entity.Member;

import java.sql.Date;

public class KpopAgencyTestsData {
    public static final Agency SUNNY = new Agency(null, "sunny", "Пак Хён Сок", "+82 (630) 12 43 345", "Каннам-гу, Сеул, Корея");
    public static final KpopGroup TXT = new KpopGroup(null, "txt", Date.valueOf("2017-09-12").toLocalDate(), Date.valueOf("2024-03-17").toLocalDate(), "Хан Мен Дук", null);
    public static final Member FELIX = new Member(null, "Пак", "Хосок", "Felix", "+82(302) 12 32 134", Date.valueOf("2001-02-18").toLocalDate(), "рэп", null);
}
