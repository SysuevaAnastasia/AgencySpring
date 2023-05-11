package dao;

import entity.Agency;
import mapper.AgencyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class AgencyDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AgencyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Agency> getAll() {
        String sql = "select \"agencyId\", \"agencyName\", \"directorName\", \"address\", \"telephoneNumber\" from \"Agency\"";
        return jdbcTemplate.query(sql, new AgencyMapper());
    }

    public Agency getById(Long agencyId) {
        String sql = "select \"agencyId\", \"agencyName\", \"directorName\", \"address\", \"telephoneNumber\" from \"Agency\" where \"agencyId\" = ?";
        return jdbcTemplate.queryForObject(sql, new AgencyMapper(), agencyId);
    }

    public Long insert(Agency agency) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "insert into \"Agency\" (\"agencyName\"," +
                "\"directorName\", \"address\", \"telephoneNumber\") values (?, ?, ?, ?)";
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.
                    prepareStatement(sql);
            preparedStatement.setString(1, agency.getAgencyName());
            preparedStatement.setString(2, agency.getDirectorName());
            preparedStatement.setString(3, agency.getAddress());
            preparedStatement.setString(4, agency.getTelephoneNumber());
            return preparedStatement;
        }, keyHolder);
        return (Long) keyHolder.getKey();
    }

    public String update(Agency agency) {
        String sql = "update \"Agency\" set \"agencyName\" = ?," +
                "\"directorName\" = ?, \"address\" = ?, \"telephoneNumber\" = ? where \"agencyId\" = ?";
        int count = jdbcTemplate.update(sql, agency.getAgencyName(), agency.getDirectorName(), agency.getAddress(), agency.getTelephoneNumber(), agency.getAgencyId());
        if (count > 0) {
            return "update success";
        }
        return "";
    }

    public String delete(Long agencyId) {
        String sql = "delete from \"Agency\" where \"agencyId\" = ?";
        int count = jdbcTemplate.update(sql, agencyId);
        if (count > 0) {
            return "delete success";
        }
        return "";
    }
}



