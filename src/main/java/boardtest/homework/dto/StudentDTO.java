package boardtest.homework.dto;

import lombok.Data;

@Data
public class StudentDTO {

    private String name;
    private int age;
    private String address;
    private String school;
    private String major;

    public StudentDTO(String name, int age, String address, String school, String major) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.school = school;
        this.major = major;
    }
}
