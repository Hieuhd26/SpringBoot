package bai8.demo.dao;

import bai8.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path = "students")
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findByFirstName(String firstName);
//    @RestResource(path = "byFirstNameDiff", rel = "byFirstNameDiff")
//    @Query("select s from Student s where s.firstName<>?1")
//    List<Student> finfByFirstNameDiff(String firstName);
@RestResource(path = "byFirstNameDiff", rel = "byFirstNameDiff")
@Query("select s from Student s where s.firstName <> :firstName")
List<Student> findByFirstNameDiff(@Param("firstName") String firstName);

}
