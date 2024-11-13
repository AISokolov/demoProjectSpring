package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student") // directory in web
public class StudentController {

    private final StudentService studentservice;

    @Autowired //not to create a new Object()
    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentservice.getStudents();
    }

    @PostMapping
    public void registerNewStudent (@RequestBody Student student){
        studentservice.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentID}") // in our request DELETE http://localhost:8080/api/v1/student/1 1 passing by path
    public void deleteStudent(
            @PathVariable("studentID") Long studentId){
        studentservice.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentID}")
    public void updateStudent(@PathVariable("studentID") long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email
                              ){
        studentservice.updateStudent(studentId, name, email);
    }
}
