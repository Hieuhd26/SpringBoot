package bai8.demo.dao;

import bai8.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
       String jpql = "select s from Student s";
       return entityManager.createQuery(jpql, Student.class).getResultList();
    }

    @Override
    public Student getById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override

    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override

    public Student saveAndFlush(Student student) {
        student= entityManager.merge(student); // cap nhat
        entityManager.flush();
        return student;
    }

    @Override

    public void deleteById(int id) {
           Student student = entityManager.find(Student.class,id);
           entityManager.remove(student);
    }
}
