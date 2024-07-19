package boardtest.homework.repository;

import boardtest.homework.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long>{

}
