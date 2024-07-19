package boardtest.homework.controller;

import boardtest.homework.dto.StudentDTO;
import boardtest.homework.entity.Student;
import boardtest.homework.repository.StudentRepository;
import boardtest.homework.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/add")
    public String addStudent(){
        return "addStudent";
    }

    @PostMapping("/add-student")
    public String add(@ModelAttribute StudentDTO student){
        studentService.addStudent(student);
        return "redirect:/";
    }

    @GetMapping("/{studentId}")
    public String showStudent(@PathVariable Long studentId, Model model){
        model.addAttribute("student", studentService.oneStudent(studentId));
        return "showStudent";
    }

    @GetMapping("/{studentId}/modify")
    public String modifyStudent(@PathVariable Long studentId, Model model){
        model.addAttribute("student", studentService.oneStudent(studentId));
        return "modifyStudent";
    }

    @PostMapping("/{studentId}/modify")
    public String modify(@PathVariable Long studentId, @ModelAttribute StudentDTO student){
        studentService.editStudent(studentId, student);
        return "redirect:/student/{studentId}";
    }

    @PostMapping("/{studentId}/delete")
    public String delete(@PathVariable Long studentId){
        studentService.removeStudent(studentId);
        return "redirect:/";
    }
}
