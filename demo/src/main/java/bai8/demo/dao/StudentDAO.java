package bai8.demo.dao;


import bai8.demo.entity.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> findAll();
    public Student getById(int id);
    public Student save(Student student);
    public Student saveAndFlush(Student student);
    public void deleteById(int id);
}
