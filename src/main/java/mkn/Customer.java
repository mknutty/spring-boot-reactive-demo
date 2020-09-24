package mkn;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {
	@Id
	private Long id;
	
	@NonNull
	private String firstName;
	
	@NonNull
	private String lastName;
}
