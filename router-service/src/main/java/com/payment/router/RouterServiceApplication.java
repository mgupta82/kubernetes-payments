package com.payment.router;

import javax.jms.ConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import iso.std.iso._20022.tech.xsd.pacs_008_001.Document;

/**
 * Main class for Router Service
 *
 */
@SpringBootApplication
@EnableJms
public class RouterServiceApplication {
	
	@Bean
	public Marshaller marshaller() {
		Class<?>[] classesToBeBound = new Class<?>[] {Document.class,iso.std.iso._20022.tech.xsd.pacs_002_001.Document.class};
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(classesToBeBound);
		return marshaller;
	}
	
	@Bean
	public Unmarshaller unmarshaller() {
		Class<?>[] classesToBeBound = new Class<?>[] {Document.class,iso.std.iso._20022.tech.xsd.pacs_002_001.Document.class};
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(classesToBeBound);
		return marshaller;
	}	

    @Bean // Serialize message content to xml/json using TextMessage
    public MessageConverter messageConverter() {
    	MarshallingMessageConverter converter = new MarshallingMessageConverter();
        //MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setMarshaller(marshaller());
        converter.setUnmarshaller(unmarshaller());
        return converter;
    } 	
	
    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setMessageConverter(messageConverter());
        // This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, connectionFactory);
        
        // You could still override some of Boot's default if necessary.
        return factory;
    }	

	public static void main(String[] args) {
		SpringApplication.run(RouterServiceApplication.class, args);
	}
}
