package com.sg.classrosterservicelayer.service;

import com.sg.classrosterservicelayer.dao.ClassRosterPersistenceException;
import com.sg.classrosterservicelayer.dto.Student;
import java.util.List;

public interface ClassRosterServiceLayer {
    
    void createStudent(Student student) throws ClassRosterDuplicateIdException,
                                               ClassRosterDataValidationException,
                                               ClassRosterPersistenceException;
    
    List<Student> getAllStudents() throws ClassRosterPersistenceException;
    
    Student getStudent(String studentId) throws ClassRosterPersistenceException;
    
    Student removeStudent(String studentId) throws ClassRosterPersistenceException;
}
