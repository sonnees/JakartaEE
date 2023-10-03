package vn.edu.iuh.fit.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.entities.Candidate;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

@Repository
public class CandidateRepositories extends AbstractRepositories<Candidate, UUID>{
    public CandidateRepositories(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Candidate> getAll() {
        String sql = "select c.*, a.* " +
                "from candidate c " +
                "left join address  a on a.id = c.address " +
                "limit 5";

        return jdbcTemplate.query(sql,new CandidateMap());
    }

    @Override
    public Candidate getByID(UUID uuid) {
        return null;
    }

    @Override
    public boolean add(Candidate entity) {
        return false;
    }

    @Override
    public boolean update(Candidate entity) {
        return false;
    }

    @Override
    public boolean delete(UUID uuid) {
        return false;
    }
}
