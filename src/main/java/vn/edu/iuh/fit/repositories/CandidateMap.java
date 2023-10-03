package vn.edu.iuh.fit.repositories;

import org.springframework.jdbc.core.RowMapper;
import vn.edu.iuh.fit.entities.Address;
import vn.edu.iuh.fit.entities.Candidate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class CandidateMap implements RowMapper<Candidate> {
    @Override
    public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
        Address address = new Address(
                UUID.fromString(rs.getString("a.id")),
                rs.getString("street"),
                rs.getString("city"),
                rs.getInt("country"),
                rs.getString("number"),
                rs.getString("zipcode")
        );
        String replace = rs.getString("dob").replace(" ", "T");

        Candidate candidate = new Candidate(
                UUID.fromString(rs.getString("c.id")),
               LocalDateTime.parse(replace),
                rs.getString("email"),
                rs.getString("full_name"),
                rs.getString("phone"),
                address
        );
        return candidate;
    }
}
