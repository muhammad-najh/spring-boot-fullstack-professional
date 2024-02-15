package com.example.demo.student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class StudentRepositoryTest {

@Autowired
StudentRepository studentRepository;
    @Test
    void itShouldCheckIfStudentEmailExists() {
        String email="mohammed@gmail.com";

        Student student=new Student("Mohammed", email, Gender.FEMALE);

        studentRepository.save(student);
        studentRepository.save(student);
        studentRepository.save(student);

        assertTrue(studentRepository.selectExistsEmail(email));

    }

    @Test
    void itShouldCheckIfStudentDoesNotEmailExist() {
        String expectedEmail="mohammed@gmail.com";
        boolean isExist=studentRepository.selectExistsEmail(expectedEmail);


    
        assertThat(isExist).isFalse();
    }
}
