package mapper;

import entity.Agency;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AgencyMapper implements RowMapper<Agency> {
    @Override
    public Agency mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Agency(
                resultSet.getLong("agencyId"),
                resultSet.getString("agencyName"),
                resultSet.getString("directorName"),
                resultSet.getString("telephoneNumber"),
                resultSet.getString("address")
        );
    }
}
