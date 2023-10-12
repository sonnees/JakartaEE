package vn.edu.iuh.fit.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.entity.Address;

@RepositoryRestResource
public interface AddressRepository extends CrudRepository<Address, Long> {
}