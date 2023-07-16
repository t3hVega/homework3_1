package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private FacultyService facultyService;
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty add(@PathVariable(required = false, value = "name") String name,
                       @PathVariable(required = false, value = "color") String color) {
        return facultyService.addFaculty(name, color);
    }

    @GetMapping("{id}")
    public Faculty find(@PathVariable(required = false, value = "id") int idInt) {
        Long id = Long.valueOf(idInt);
        return facultyService.findFaculty(id);
    }

    @PutMapping
    public Faculty edit(@PathVariable(required = false, value = "id") int idInt,
                        @PathVariable(required = false, value = "name") String name,
                        @PathVariable(required = false, value = "color") String color) {
        Long id = Long.valueOf(idInt);
        return facultyService.editFaculty(id, name, color);
    }

    @DeleteMapping("{id}")
    public Faculty remove(@PathVariable(required = false, value = "id") int idInt) {
        Long id = Long.valueOf(idInt);
        return facultyService.removeFaculty(id);
    }

    @GetMapping
    public Map<Long, Faculty> filterByColor(@PathVariable(required = false, value = "color") String color) {
        Map<Long, Faculty> filtered = new HashMap<>();
        for(int i = 0; i < facultyService.getAll().size(); i++) {
            if (facultyService.getAll().get(i).getColor().equals(color)) {
                filtered.put(Long.valueOf(i), facultyService.getAll().get(i));
            }
        }
        return filtered;
    }

    @GetMapping("")
    public Map<Long, Faculty> getAll() {
        return facultyService.getAll();
    }
}
