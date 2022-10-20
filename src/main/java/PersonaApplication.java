import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class })
//@ComponentScan(value = "com.disoft.ceci.persona")
public class PersonaApplication {//extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PersonaApplication.class, args);
	}

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PersonaApplication.class);
	}*/
}
