package com.carrera;

import com.carrera.service.CompeticionService;
import javafx.beans.property.ReadOnlyFloatWrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AtletaymedallaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AtletaymedallaApplication.class, args);
		CompeticionService competicionService = context.getBean(CompeticionService.class);

		competicionService.creaClasificados();
	}
}
