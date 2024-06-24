package bai8.demo.service;

import bai8.demo.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAll();
    public Student getStudentById(int id);
    public Student addStudent(Student student);
    public Student updateStudent(Student student);
    public  void deleteStudent(int id);

}
