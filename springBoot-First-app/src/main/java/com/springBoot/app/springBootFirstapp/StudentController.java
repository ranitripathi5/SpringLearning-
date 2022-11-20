package com.springBoot.app.springBootFirstapp;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/Student")
    public Student  getStudent(){
        return new Student("Rani","Tripathi");
    }
    @GetMapping("/StudentList")
    public List<Student> getStudents(){
        List<Student> li=new ArrayList<>();
         li.add(new Student("Rani","Tripathi"));
         li.add(new Student("Gauri","Tripathi"));
         li.add(new Student("Shilpi","Tripathi"));
         li.add(new Student("Aakash","Tripathi"));

         return li;
    }

    // student/FirstName/LastName
    @GetMapping("/Student/{FirstName}/{LastName}") // URI Template Variable;
    public Student studentPathVariable(@PathVariable("FirstName")String FirstName, @PathVariable("LastName") String LastName){ //PathVariable annotation  binds
                                                                             // the request URL pathVariable to method variable//
        return new Student(FirstName,LastName);
    }

    //Queryparam
    @GetMapping("/student")
     public Student StudentQueryParam(@RequestParam(name="FirstName") String FirstName,
                                      @RequestParam(name="LastName") String LastName) {
        return new Student(FirstName,LastName);
     }
}
