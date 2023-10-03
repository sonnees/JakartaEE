package vn.edu.iuh.fit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.entities.Address;
import vn.edu.iuh.fit.sevices.AddressService;
import vn.edu.iuh.fit.sevices.CandidateService;

import java.util.UUID;

@SpringBootApplication
public class JakartaEEApplication {
	@Autowired
	private CandidateService candidateService;
	@Autowired
	private AddressService addressService;

	public static void main(String[] args) {
		SpringApplication.run(JakartaEEApplication.class, args);
	}

	@Bean
	public CommandLineRunner candidateServiceTest(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
//				Address address = new Address(
//						UUID.randomUUID(),"street","city",1,"232-323-232","code"
//				);
//				System.out.println(UUID.randomUUID());
//				System.out.println(addressService.add(address));

				candidateService.getAll().forEach(System.out::println);
			}
		};
	}

}
