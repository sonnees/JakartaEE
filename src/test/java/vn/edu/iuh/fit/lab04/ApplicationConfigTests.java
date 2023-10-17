package vn.edu.iuh.fit.lab04;

import com.neovisionaries.i18n.CountryCode;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.BackEnd.entity.Address;
import vn.edu.iuh.fit.BackEnd.entity.Candidate;
import vn.edu.iuh.fit.BackEnd.repositories.AddressRepository;
import vn.edu.iuh.fit.BackEnd.repositories.CandidateRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

@SpringBootTest
class ApplicationConfigTests {
    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    AddressRepository addressRepository;

    @Test
    void addCandidate(){
        for (int i = 1; i <= 1000; i++) {
            Address address = new Address(
                    i,"Street %s".formatted(i),"City %s".formatted(i), CountryCode.VN,
                    new Random().nextInt(10)+"", new Random().nextInt(10)+""
            );
            addressRepository.save(address);
            Candidate candidate = new Candidate(
                    i,
                    LocalDate.now(),
                    "%s@gmail.com".formatted(i),
                    "Nguyen Van %s".formatted(i),
                    new Random().nextInt(10)+"",
                    address,
                    new ArrayList<>(), new ArrayList<>()
            );

            candidateRepository.save(candidate);
        }
    }
}
