package boardtest.homework.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String address;

    private String school;

    private String major;

    public Student(String name, int age, String address, String school, String major) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.school = school;
        this.major = major;
    }
}
