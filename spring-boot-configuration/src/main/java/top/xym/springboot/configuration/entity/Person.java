package top.xym.springboot.configuration.entity;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Person {
    @Value("${person.first-name}")
    private String firstName;
    @Value("${person.last-name}")
    private String lastName;
    @Value("${person.age}")
    private int age;
    @Value("${person.id}")
    private String id;
    @Value("${person.phone}")
    private String phone;
}
