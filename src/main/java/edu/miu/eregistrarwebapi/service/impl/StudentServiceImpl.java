package edu.miu.eregistrarwebapi.service.impl;


import edu.miu.eregistrarwebapi.model.Student;
import edu.miu.eregistrarwebapi.repository.StudentRepository;
import edu.miu.eregistrarwebapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(()->new IllegalArgumentException(
                "Invalid student Id: "+studentId));
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudent(Student student) {

        studentRepository.findById(student.getStudentId()).orElseThrow(()->new IllegalArgumentException(
                "Invalid student Id: "+ student.getStudentId()));

        return studentRepository.save(student);
    }

    @Override
    public List<Student> searchStudent(String string) {
        return studentRepository.findAllByFirstNameContainingOrLastNameContainingOrStudentNumberContaining(string,string,string);
    }
}
