package boardtest.homework.controller;

import boardtest.homework.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    private final StudentService studentService;

    public MainController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("isEmpty", studentService.isEmptyStudent());
        model.addAttribute("students", studentService.getStudentAll());
        return "index";
    }
}
