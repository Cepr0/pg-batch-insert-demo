package io.github.cepr0.demo;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.sql.DataSource;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@SpringBootApplication
public class Application {

	private final ModelRepo repo;
	
	public Application(ModelRepo repo) {
		this.repo = repo;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@EventListener
	public void appReadyHandler(ApplicationReadyEvent e) {

		repo.saveAll(IntStream.rangeClosed(1, 50)
				.mapToObj(i -> new Model("mode" + i))
				.collect(toList())
		);
	}
}
