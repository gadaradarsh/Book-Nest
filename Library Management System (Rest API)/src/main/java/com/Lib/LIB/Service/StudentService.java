package com.Lib.LIB.Service;

import com.Lib.LIB.Model.StudentModel;
import java.util.List;

public interface StudentService {
    void addStudent(StudentModel student);
    StudentModel getStudentById(int id);
    List<StudentModel> getStudentsByName(String name);
    List<StudentModel> getAllStudents();
    boolean updateStudent(int id, StudentModel updatedStudent);
    void deleteStudent(int id);
    void deleteAll();  // Fixed method name
}
