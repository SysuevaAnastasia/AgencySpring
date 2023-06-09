package mapper;

import entity.Member;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberMapper implements RowMapper<Member> {
    @Override
    public Member mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Member(
                resultSet.getLong("memberId"),
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getString("nickname"),
                resultSet.getString("telephoneNumber"),
                resultSet.getDate("birth").toLocalDate(),
                resultSet.getString("position"),
                resultSet.getLong("groupIdFk")
        );
    }
}
