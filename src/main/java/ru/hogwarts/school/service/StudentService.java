package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private Map<Long, Student> students = new HashMap<>();
    private Long count = 1L;

    public Student addStudent(String name, int age) {
        Student student = new Student(count, name, age);
        students.put(count, student);
        count++;
        return student;
    }

    public Student findStudent(Long id) {
        return students.get(id);
    }

    public Student editStudent(Long id, String name, int age) {
        Student student = new Student(id, name, age);
        students.put(id, student);
        return student;
    }

    public Student removeStudent(Long id) {
        Student student = students.get(id);
        students.remove(id);
        return student;
    }

    public Map<Long, Student> getAll() {
        return students;
    }
}
