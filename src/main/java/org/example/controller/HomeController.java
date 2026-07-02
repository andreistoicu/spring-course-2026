package org.example.controller;

import org.example.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home/{name}")
    public String home(@PathVariable String name, Model model) {

        Student student = new Student(name , 32);

        model.addAttribute("student", student);

        return "index";
    }

    @GetMapping("/students")
    public String getMyStudents(Model model) {

        //ne imaginam ca vine din baza de date
        List<Student> students = List.of(
                new Student("Petrica" , 33),
                new Student("Maria" , 44),
                new Student("Pavel" , 55)
        );

        model.addAttribute("students", students);

        return "students";
    }

}
