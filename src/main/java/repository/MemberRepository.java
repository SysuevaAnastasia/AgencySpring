package repository;

import entity.Member;
import mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class MemberRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Member> getAll() {
        String sql = "select \"memberId\", \"name\", \"surname\", \"nickname\", \"telephoneNumber\", \"birth\", \"position\", \"groupIdFk\" from \"Member\"";
        return jdbcTemplate.query(sql, new MemberMapper());
    }

    public Member getById(Long memberId) {
        String sql = "select \"memberId\", \"name\", \"surname\", \"nickname\", \"telephoneNumber\", \"birth\", \"position\", \"groupIdFk\" from \"Member\" where \"memberId\" = ?";
        return jdbcTemplate.queryForObject(sql, new MemberMapper(), memberId);
    }

    public Long insert(Member member) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "insert into \"Member\" (\"name\"," +
                "\"surname\", \"nickname\", \"telephoneNumber\", \"birth\", \"position\", \"groupIdFk\") values (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.
                    prepareStatement(sql);
            preparedStatement.setString(1, member.getName());
            preparedStatement.setString(2, member.getSurname());
            preparedStatement.setString(3, member.getNickname());
            preparedStatement.setString(4, member.getTelephoneNumber());
            preparedStatement.setDate(5, Date.valueOf(member.getBirth()));
            preparedStatement.setString(6, member.getPosition());
            preparedStatement.setLong(7, member.getGroupIdFk());
            return preparedStatement;
        }, keyHolder);
        return (Long) keyHolder.getKey();
    }

    public String update(Member member) {
        String sql = "update \"Member\" set \"name\" = ?," +
                "\"surname\" = ?, \"nickname\" = ?, \"telephoneNumber\" = ?, \"birth\" = ?, \"position\" = ?, \"groupIdFk\" = ? where \"memberId\" = ?";
        int count = jdbcTemplate.update(sql,
                member.getName(),
                member.getSurname(),
                member.getNickname(),
                member.getTelephoneNumber(),
                member.getBirth(),
                member.getPosition(),
                member.getGroupIdFk(),
                member.getMemberId());
        if (count > 0) {
            return "update success";
        }
        return "";
    }

    public String delete(Long memberId) {
        String sql = "delete from \"Member\" where \"memberId\" = ?";
        int count = jdbcTemplate.update(sql, memberId);
        if (count > 0) {
            return "delete success";
        }
        return "";
    }
}
