//package bai8.demo.service;
//
//import bai8.demo.dao.StudentDAO;
//import bai8.demo.dao.StudentRepository;
//import bai8.demo.entity.Student;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class StudentServiceImpl implements StudentService {
//    private StudentRepository studentRepository;
//    @Autowired
//    public StudentServiceImpl(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
//
//    @Override
//    public List<Student> getAll() {
//       return studentRepository.findAll();
//    }
//
//    @Override
//    public Student getStudentById(int id) {
//        return studentRepository.getById(id);
//    }
//
//    @Override
//    @Transactional
//    public Student addStudent(Student student) {
//        return studentRepository.save(student);
//    }
//
//    @Override
//    @Transactional
//    public Student updateStudent(Student student) {
//        return studentRepository.saveAndFlush(student);
//    }
//
//    @Override
//    @Transactional // co tac dung voi tat ca ca dao, rollback voi tat ca table ma lien quan khi thay doi du lieu
//    public void deleteStudent(int id) {
//        studentRepository.deleteById(id);
//    }
//}
