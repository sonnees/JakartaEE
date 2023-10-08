package vn.edu.iuh.fit.services;

import org.hibernate.Internal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entity.Address;
import vn.edu.iuh.fit.repositories.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    public boolean add(Address address) {return addressRepository.save(address).equals(address);}
    public boolean addAll(List<Address> addresses) {return addressRepository.saveAll(addresses).equals(addresses);}
    public List<Address> getAll() {return (List<Address>) addressRepository.findAll();}
    public Optional<Address> getByID(long id) {return addressRepository.findById(id);}
    public void delete(long id) {addressRepository.deleteById(id);}
}
