package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("student")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student add(@PathVariable String name,
                       @PathVariable int age) {
        return studentService.addStudent(name, age);
    }

    @GetMapping("{id}")
    public Student find(@PathVariable int idInt) {
        Long id = Long.valueOf(idInt);
        return studentService.findStudent(id);
    }

    @PutMapping
    public Student edit(@PathVariable int idInt,
                        @PathVariable String name,
                        @PathVariable int age) {
        Long id = Long.valueOf(idInt);
        return studentService.editStudent(id, name, age);
    }

    @DeleteMapping("{id}")
    public Student remove(@PathVariable int idInt) {
        Long id = Long.valueOf(idInt);
        return studentService.removeStudent(id);
    }

    @GetMapping
    public Map<Long, Student> filterByAge(@PathVariable int age) {
        Map<Long, Student> filtered = new HashMap<>();
        for(int i = 0; i < studentService.getAll().size(); i++) {
            if (studentService.getAll().get(i).getAge() == age) {
                filtered.put(Long.valueOf(i), studentService.getAll().get(i));
            }
        }
        return filtered;
    }

    @GetMapping
    public Map<Long, Student> getAll() {
        return studentService.getAll();
    }
}
