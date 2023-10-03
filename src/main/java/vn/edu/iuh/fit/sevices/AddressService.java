package vn.edu.iuh.fit.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entities.Address;
import vn.edu.iuh.fit.repositories.AddressRepositories;

@Service
public class AddressService {

    private final AddressRepositories addressRepositories;

    @Autowired
    public AddressService(AddressRepositories addressRepositories) {
        this.addressRepositories = addressRepositories;
    }

    public boolean add(Address entity) throws Exception {
        return addressRepositories.add(entity);
    }
}
