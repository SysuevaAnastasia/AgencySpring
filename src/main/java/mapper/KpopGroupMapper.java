package mapper;

import entity.KpopGroup;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KpopGroupMapper implements RowMapper<KpopGroup> {
    @Override
    public KpopGroup mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new KpopGroup(
                resultSet.getLong("groupId"),
                resultSet.getString("groupName"),
                resultSet.getDate("dataStartContract").toLocalDate(),
                resultSet.getDate("dataEndContract").toLocalDate(),
                resultSet.getString("managerName"),
                resultSet.getLong("agencyIdFk")
        );
    }
}
