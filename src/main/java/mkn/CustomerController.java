package mkn;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("customers")
@AllArgsConstructor
public class CustomerController {
	private CustomerRepository customerRepository;
	
	@GetMapping
	public Flux<Customer> list() {
		return customerRepository.findAll();
	}
	
	@GetMapping("{id}")
	private Mono<Customer> get(@PathVariable Long id) {
	    return customerRepository.findById(id);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		customerRepository.deleteById(id);
	}
	
	@PostMapping
	public Mono<Customer> add(@RequestBody Customer customer) {
	  return customerRepository.save(customer);
	}
}
