package vn.edu.iuh.fit.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;
import vn.edu.iuh.fit.entities.Address;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

@Component
public class AddressRepositories extends AbstractRepositories<Address, UUID> {

    public AddressRepositories(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Address> getAll() {
        return null;
    }

    @Override
    public Address getByID(UUID uuid) {
        return null;
    }

    @Override
    public boolean add(Address entity) throws Exception {

        String sql = "INSERT INTO `address` (`id`, `street`, `city`, `country`, `number`, `zipcode`) VALUES (?, ?, ?, ?, ?, ?)";

        boolean b = false;
        try {
            b =jdbcTemplate.update(sql, entity.getId(), entity.getStreet(), entity.getCity(), entity.getCountry(), entity.getNumber(), entity.getZipcode()) > 0;
        } catch (Exception e){
            throw new Exception("DuplicateKey");
        }

        return b;

    }

    @Override
    public boolean update(Address entity) {
        return false;
    }

    @Override
    public boolean delete(UUID uuid) {
        return false;
    }
}
