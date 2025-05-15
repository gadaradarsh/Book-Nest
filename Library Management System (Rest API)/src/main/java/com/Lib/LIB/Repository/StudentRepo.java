package com.Lib.LIB.Repository;

import com.Lib.LIB.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<StudentModel, Integer> {
    List<StudentModel> findByName(String name);
    Optional<StudentModel> findByEmailId(String emailId);
    Optional<StudentModel> findByUsername(String username);
}
