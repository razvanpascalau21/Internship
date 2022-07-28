package razvan.pascalau.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.DECEMBER;
import static java.time.Month.MARCH;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student maria=new Student("Maria","maria.jamila@yahoo.com", LocalDate.of(2000, DECEMBER,18));
            Student alex=new Student("Alex","alex@yahoo.com", LocalDate.of(2004, MARCH,18));
            studentRepository.saveAll(List.of(alex,maria));
        };
    }
}
