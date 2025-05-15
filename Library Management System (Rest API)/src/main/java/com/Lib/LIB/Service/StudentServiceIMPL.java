package com.Lib.LIB.Service;

import com.Lib.LIB.Model.StudentModel;
import com.Lib.LIB.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentRepo studentRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void addStudent(StudentModel student) {
        student.setPassword(encoder.encode(student.getPassword()));
        studentRepository.save(student);
    }

    @Override
    public StudentModel getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<StudentModel> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public List<StudentModel> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public boolean updateStudent(int id, StudentModel updatedStudent) {
        if (studentRepository.existsById(id)) {
            updatedStudent.setPassword(encoder.encode(updatedStudent.getPassword()));
            updatedStudent.setStudentId(id);
            studentRepository.save(updatedStudent);
            return true;
        }
        return false;
    }


    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }
}
