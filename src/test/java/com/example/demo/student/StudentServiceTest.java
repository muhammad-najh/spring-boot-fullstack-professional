package com.example.demo.student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {


    @Mock StudentRepository studentRepository;
    private StudentService underTest;
    private ArgumentCaptor<Student> studentArgumentCapture;


    @BeforeEach
    void setUp(){
        underTest = new StudentService(studentRepository);
    }



    @Test
    void testAddStudent() {


        //when
        Student passedStudent=new Student("Mohammed", "mohammed@gmail.com", Gender.FEMALE);
        //given
        underTest.addStudent(passedStudent);

        //then
        studentArgumentCapture = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(studentArgumentCapture.capture());

        Student captorStudent=studentArgumentCapture.getValue();
        assertThat(passedStudent).isEqualTo(captorStudent);


       
    }

    @Test
    void testDeleteStudent() {

    }

    @Test
    void testGetAllStudents() {
        underTest.getAllStudents();
        verify(studentRepository).findAll();
    }
}
