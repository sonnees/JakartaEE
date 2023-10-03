package vn.edu.iuh.fit.sevices;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import vn.edu.iuh.fit.entities.Address;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressServiceTest {
    @Autowired
    AddressService addressService;
    @Test
    void addTrue() throws Exception {
        assertTrue(addressService.add(new Address(
                UUID.fromString("a1f47e3d-11b1-4eab-92c5-89db82728d30"),
                "123 Main Street",
                "Son",
                100,
                "A101",
                "12345"
        )));
    }

    @Test
    void addDuplicateKey() {
        assertThrows(Exception.class,()->{
            addressService.add(new Address(
                    UUID.fromString("a1f47e3d-11b1-4eab-92c5-89db82728d30"),
                    "123 Main Street",
                    "Son",
                    100,
                    "A101",
                    "12345"
            ));
        });
    }


}