package com.Lib.LIB.Service;

import com.Lib.LIB.Model.StudentModel;
import com.Lib.LIB.Repository.StudentRepo;
import com.Lib.LIB.Model.CustomStudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class StudentDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StudentModel student = studentRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return new CustomStudentModel(student);
    }
}
