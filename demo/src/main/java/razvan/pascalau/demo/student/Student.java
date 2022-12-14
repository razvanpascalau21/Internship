package razvan.pascalau.demo.student;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity(name = "Student")
@Table(name = "Student",
        uniqueConstraints = {
                @UniqueConstraint(name ="student_email_unique",columnNames = "email")
        })
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;
    @Column(
            name = "LocalDate",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private LocalDate dateOfBirthday;
    @Column(
            name = "age"
    )
    @Transient
    private Integer age;

    public Student(){
    }

    public Student(String name, String email, LocalDate dateOfBirthday) {
        this.name = name;
        this.email = email;
        this.dateOfBirthday = dateOfBirthday;
    }

    public Student(Long id, String name, String email, LocalDate dateOfBirthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirthday = dateOfBirthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate localDate) {
        this.dateOfBirthday = localDate;
    }

    public Integer getAge() {
        return Period.between(this.dateOfBirthday,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", localDate=" + dateOfBirthday +
                ", age=" + age +
                '}';
    }
}
