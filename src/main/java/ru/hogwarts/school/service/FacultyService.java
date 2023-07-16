package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {
    private Map<Long, Faculty> faculties = new HashMap<>();
    private Long count = 1L;

    public Faculty addFaculty(String name, String color) {
        Faculty faculty = new Faculty(count, name, color);
        faculties.put(count, faculty);
        count++;
        return faculty;
    }

    public Faculty findFaculty(Long id) {
        return faculties.get(id);
    }

    public Faculty editFaculty(Long id, String name, String color) {
        Faculty faculty = new Faculty(id, name, color);
        faculties.put(id, faculty);
        return faculty;
    }

    public Faculty removeFaculty(Long id) {
        Faculty faculty = faculties.get(id);
        faculties.remove(id);
        return faculty;
    }

    public Map<Long, Faculty> getAll() {
        return faculties;
    }
}
