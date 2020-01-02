package com.ac.mylib.entity;

import lombok.*;
import lombok.experimental.Accessors;

//@Accessors(chain = true)
//@Setter
//@Getter
//@RequiredArgsConstructor(staticName = "of")
@ToString
@Builder
public class Student {

    private String name;
    private String age;

    public static void main(String[] args) {
//        Student student = Student.of("Echo").setAge("28");
        Student student = Student.builder().name("miaoyi").age("26").build();
        System.out.println(student.toString());
    }
}
