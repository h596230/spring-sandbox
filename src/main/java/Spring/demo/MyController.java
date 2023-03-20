package Spring.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newStudent", new Student());
        return "my-form";
    }

    @PostMapping("/students")
    public String addStudent(@ModelAttribute("newStudent") Student newStudent) {
        studentRepository.save(newStudent);
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String showStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/students/{id}")
    public String showStudentDetails(@PathVariable Long id, Model model){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student student = optionalStudent.get();
        model.addAttribute("student", student);
        System.out.println(student);
        return "student-detail";
    }

    @PostMapping("/students/delete")
    public String deleteStudent(@RequestParam Long id) {
        studentRepository.deleteById(id);
        return "redirect:/students";
    }

    // @GetMapping("/roll")
    // public String roll(){
    //     return "roll";
    // }

    // @PostMapping
    // public String getRoll(){
    //     return "";
    // }
    @GetMapping("/roll")
    public String roll(){
        return "roll";
    }
    @PostMapping("/roll")
    public String getRoll(Model model) {
      int result = (int) (Math.random() * 6) + 1;
      model.addAttribute("result", result);
      return "roll";
    }
}
