package com.arquitectura.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MicroserviceApplication {

	@GetMapping("/empleados")
	public String getEmpleado (){
		StringBuffer sb = new StringBuffer(); 
		Persona persona = new Empleado(null, null, 0, Profesion.INGENIERO.getTipo()[1]);
		if (persona instanceof Empleado){
			persona.personas_db(persona).forEach(empleado -> {
				sb.append(empleado.toString() + "\n");
			});
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);

		
		/* MicroservicesArchApplication microservicesArchApplication = new MicroservicesArchApplication();

		System.out.println(microservicesArchApplication.getEmpleado());	 */
		
	}

}
