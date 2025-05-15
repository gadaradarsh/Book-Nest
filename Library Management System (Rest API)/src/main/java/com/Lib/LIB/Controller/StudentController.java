package com.Lib.LIB.Controller;

import com.Lib.LIB.Model.StudentModel;
import com.Lib.LIB.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public String addStudent(@RequestBody StudentModel student) {
        studentService.addStudent(student);
        return "Student added!";
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody StudentModel updatedStudent) {
        boolean isUpdated = studentService.updateStudent(id, updatedStudent);
        if (isUpdated) {
            return "Student updated!";
        } else {
            return "Student not found!";
        }
    }


    @GetMapping("/{id}")
    public StudentModel getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<StudentModel> getStudents(@RequestParam(required = false) String name) {
        if (name != null) {
            return studentService.getStudentsByName(name);
        }
        return studentService.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student deleted!";
    }

    @DeleteMapping("/delete-all")
    public String deleteAllStudents() {
        studentService.deleteAll();
        return "All students deleted!";
    }
}
