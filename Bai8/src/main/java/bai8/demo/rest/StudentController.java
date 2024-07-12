//package bai8.demo.rest;
//
//import bai8.demo.dao.StudentDAO;
//import bai8.demo.dao.StudentDAOImpl;
//import bai8.demo.entity.Student;
//import bai8.demo.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/students")
//public class StudentController {
//    private StudentService studentService;
//    @Autowired
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
//
//    @GetMapping()
//    public List<Student> getAll(){
//        return studentService.getAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Student> getById(@PathVariable int id){
//        // co 2 cack kt null
//        // 1 la kt o day return not found
//        // 2 la bat ngoai le
//        Student student = studentService.getStudentById(id);
//        if (student!=null){
//            return ResponseEntity.ok(student);
//        } else{
//            return ResponseEntity.notFound().build();
//        }
//    }
//    @PostMapping()
//    public ResponseEntity<Student> addStudent(@RequestBody Student student){
//        student.setId(0);
//        student= studentService.addStudent(student);
//        return ResponseEntity.status(HttpStatus.CREATED).body(student);
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Student> editStudent(@PathVariable int id, @RequestBody Student student){
//        Student existStudent = studentService.getStudentById(id);
//        if(existStudent!=null){
//            existStudent.setFirstName(student.getFirstName());
//            existStudent.setLastName(student.getLastName());
//            existStudent.setEmail(student.getEmail());
//            studentService.updateStudent(existStudent);
//            return ResponseEntity.ok(existStudent);
//        } else{
//        return  ResponseEntity.notFound().build();
//        }
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
//        Student existStudent = studentService.getStudentById(id);
//        if(existStudent!=null){
//            studentService.deleteStudent(id);
//            return  ResponseEntity.ok().build();
//        } else {
//        return ResponseEntity.notFound().build();
//        }
//    }
//
//
//}
