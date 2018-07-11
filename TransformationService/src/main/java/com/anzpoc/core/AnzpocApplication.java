package com.anzpoc.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;

//import com.github.ulisesbocchio.jar.resources.JarResourceLoader;


@SpringBootApplication
public class AnzpocApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnzpocApplication.class, args);
		
		/*new SpringApplicationBuilder()
        .sources(AnzpocApplication.class)
        .resourceLoader(new JarResourceLoader())
        .run(args);*/
	}
}
