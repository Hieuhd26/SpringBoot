package bai7.bai7.controller;

import bai7.bai7.entity.ErrorResponse;
import bai7.bai7.entity.Sach;
import bai7.bai7.exception.SachException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SachController {
    public List<Sach> listSach;
    @PostConstruct
    public void createSach() {
        listSach= new ArrayList<>();
        listSach.add( new Sach(1,"SGK1","Hiệu1","123"));
        listSach.add( new Sach(2,"SGK2","Hiệu2","123"));
        listSach.add( new Sach(3,"SGK3","Hiệu3","123"));
        listSach.add( new Sach(4,"SGK4","Hiệu4","123"));
        listSach.add( new Sach(5,"SGK5","Hiệu5","123"));
        listSach.add( new Sach(6,"SGK6","Hiệu6","123"));

    }
    @GetMapping("/all")
    public List<Sach> getAll(){
        return listSach;
    }

    @GetMapping("/{id}")
    public Sach getSach(@PathVariable int id){
        Sach result = null;
        for (Sach sach:listSach) {
            if(sach.getId()==id){
                return sach;
            }
        }
        if (result==null){
            throw  new SachException("khong tim thay sach voi id: "+ id);
        }
        return  result;
    }

    @GetMapping("/index/{index}")
    public Sach getSachIndex(@PathVariable int index){
        Sach result = null;
        try {
            result= listSach.get(index);
        }catch (Exception e){
            throw  new SachException("khong tim thay sach voi index: "+ index);
        }
       return result;
    }
//    @ExceptionHandler
//    public ResponseEntity<ErrorResponse> handlerErr(SachException ex){
//        ErrorResponse er= new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
//    }
//    @ExceptionHandler
//    public ResponseEntity<ErrorResponse> handlerAllErr(Exception ex){
//        ErrorResponse er= new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
//    }
}
