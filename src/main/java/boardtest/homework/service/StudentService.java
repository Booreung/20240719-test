package boardtest.homework.service;

import boardtest.homework.dto.StudentDTO;
import boardtest.homework.entity.Student;
import boardtest.homework.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudentAll() {
        return studentRepository.findAll();
    }

    public boolean isEmptyStudent() {
        return studentRepository.findAll().isEmpty();
    }

    public void addStudent(StudentDTO studentDTO) {
        studentRepository.save(
                new Student(studentDTO.getName(),
                        studentDTO.getAge(),
                        studentDTO.getAddress(),
                        studentDTO.getSchool(),
                        studentDTO.getMajor()
                )
        );
    }

    public void removeStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public Student oneStudent(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public void editStudent(Long studentId, StudentDTO updatedStudentDTO){
        Student updatedStudent = studentRepository.findById(studentId).orElse(null);
        updatedStudent.setName(updatedStudentDTO.getName());
        updatedStudent.setAge(updatedStudentDTO.getAge());
        updatedStudent.setAddress(updatedStudentDTO.getAddress());
        updatedStudent.setSchool(updatedStudentDTO.getSchool());
        updatedStudent.setMajor(updatedStudentDTO.getMajor());
        studentRepository.save(updatedStudent);
    }
}
