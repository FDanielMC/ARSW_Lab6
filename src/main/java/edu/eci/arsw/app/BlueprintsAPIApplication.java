package edu.eci.arsw.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Clase principal que inicia la aplicación Spring Boot para la API de blueprints.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.blueprints"})
public class BlueprintsAPIApplication {

	/**
	 * Método principal que inicia la aplicación Spring Boot.
	 * @param args Los argumentos de la línea de comandos.
	 */
	public static void main(String[] args) {
		SpringApplication.run(BlueprintsAPIApplication.class, args);
	}
}
