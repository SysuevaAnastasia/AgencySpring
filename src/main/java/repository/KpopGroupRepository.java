package repository;

import entity.KpopGroup;
import mapper.KpopGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class KpopGroupRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public KpopGroupRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<KpopGroup> getAll() {
        String sql = "select \"groupid\", \"groupname\", \"datastartcontract\", \"dataendcontract\", \"managername\", \"agencyidfk\" from \"kpopgroup\"";
        return jdbcTemplate.query(sql, new KpopGroupMapper());
    }

    public KpopGroup getById(Long groupId) {
        String sql = "select \"groupid\", \"groupname\", \"datastartcontract\", \"dataendcontract\", \"managername\", \"agencyidfk\" from \"kpopgroup\" where \"groupid\" = ?";
        return jdbcTemplate.queryForObject(sql, new KpopGroupMapper(), groupId);
    }

    public Long insert(KpopGroup group) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "insert into \"kpopgroup\" (\"groupname\"," +
                "\"datastartcontract\", \"dataendcontract\", \"managername\", \"agencyidfk\") values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.
                    prepareStatement(sql, new String[]{"groupid"});
            preparedStatement.setString(1, group.getGroupName());
            preparedStatement.setDate(2, Date.valueOf(group.getDataStartContract()));
            preparedStatement.setDate(3, Date.valueOf(group.getDataEndContract()));
            preparedStatement.setString(4, group.getManagerName());
            preparedStatement.setLong(5, group.getAgencyIdFk());
            return preparedStatement;
        }, keyHolder);
        return (Long) keyHolder.getKey();
    }

    public String update(KpopGroup group) {
        String sql = "update \"kpopgroup\" set \"groupname\" = ?," +
                "\"datastartcontract\" = ?, \"dataendcontract\" = ?, \"managername\" = ?, \"agencyidfk\" = ? where \"groupid\" = ?";
        int count = jdbcTemplate.update(sql,
                group.getGroupName(),
                group.getDataStartContract(),
                group.getDataEndContract(),
                group.getManagerName(),
                group.getAgencyIdFk(),
                group.getGroupId());
        if (count > 0) {
            return "update success";
        }
        return "";
    }

    public String delete(Long groupId) {
        String sql = "delete from \"kpopgroup\" where \"groupid\" = ?";
        int count = jdbcTemplate.update(sql, groupId);
        if (count > 0) {
            return "delete success";
        }
        return "";
    }
}
