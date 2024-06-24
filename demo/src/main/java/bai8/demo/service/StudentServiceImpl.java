package bai8.demo.service;

import bai8.demo.dao.StudentDAO;
import bai8.demo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;
    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAll() {
       return studentDAO.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDAO.getById(id);
    }

    @Override
    @Transactional
    public Student addStudent(Student student) {
        return studentDAO.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return studentDAO.saveAndFlush(student);
    }

    @Override
    @Transactional // co tac dung voi tat ca ca dao, rollback voi tat ca table ma lien quan khi thay doi du lieu
    public void deleteStudent(int id) {
        studentDAO.deleteById(id);
    }
}
