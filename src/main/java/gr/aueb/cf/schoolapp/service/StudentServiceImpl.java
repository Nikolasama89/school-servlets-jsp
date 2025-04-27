package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.IStudentDAO;
import gr.aueb.cf.schoolapp.dto.FiltersDTO;
import gr.aueb.cf.schoolapp.dto.StudentInsertDTO;
import gr.aueb.cf.schoolapp.dto.StudentReadOnlyDTO;
import gr.aueb.cf.schoolapp.dto.StudentUpdateDTO;
import gr.aueb.cf.schoolapp.exceptions.StudentAlreadyExistsException;
import gr.aueb.cf.schoolapp.exceptions.StudentDAOException;
import gr.aueb.cf.schoolapp.exceptions.StudentNotFoundException;
import gr.aueb.cf.schoolapp.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.mapper.Mapper;
import gr.aueb.cf.schoolapp.model.Student;
import gr.aueb.cf.schoolapp.model.Teacher;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentServiceImpl implements IStudentService {

    // Dependency Injection
    private final IStudentDAO studentDAO;

    // Constructor Injection
    public StudentServiceImpl(IStudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }


    @Override
    public StudentReadOnlyDTO insertStudent(StudentInsertDTO dto)
            throws StudentDAOException, StudentAlreadyExistsException {

        Student student;
        Student insertedStudent;

        try {
            student = Mapper.mapStudentInsertToModel(dto);
            // Θελουμε κατι μοναδικο και οχι το id γιαυτο χρησιμοποιουμε VAT
            if (studentDAO.getStudentByVat(dto.getVat()) != null)
                throw new StudentAlreadyExistsException("Student with vat: " + dto.getVat() + " already exists");

            insertedStudent = studentDAO.insert(student);
            // logging
            // Mε orElseThrow κανουμε και return και διαχειριση του λαθους!
            return Mapper
                    .mapStudentToReadOnlyDTO(insertedStudent)
                    .orElseThrow(() -> new StudentDAOException("Error in Mapping"));


        } catch (StudentDAOException | StudentAlreadyExistsException e) {
            // logging
            throw e;
        }
    }

    @Override
    public StudentReadOnlyDTO updateStudent(Integer id, StudentUpdateDTO dto) throws StudentDAOException, StudentAlreadyExistsException, StudentNotFoundException {

        Student student;
        Student fetchedStudent;
        Student updatedStudent;

        try {
            if (studentDAO.getById(id) == null) {
                throw new StudentNotFoundException("Student with id: " + id + " was not found");
            }

            fetchedStudent = studentDAO.getStudentByVat(dto.getVat());
            if (fetchedStudent != null && !fetchedStudent.getId().equals(dto.getId())) {
                throw new StudentAlreadyExistsException("Student with id: " + dto.getId() + " already exists.");
            }

            student = Mapper.mapStudentUpdateToModel(dto);
            updatedStudent = studentDAO.update(student);
            // logging
            return Mapper.mapStudentToReadOnlyDTO(updatedStudent).orElseThrow(() -> new StudentDAOException("Error during mapping"));
        } catch (StudentDAOException | StudentAlreadyExistsException | StudentNotFoundException e) {
            // logging
            throw e;
        }
    }

    @Override
    public void deleteStudent(Integer id) throws StudentDAOException, StudentNotFoundException {
        try {
            if (studentDAO.getById(id) == null) {
                throw new StudentNotFoundException("Student with id: " + id + " not found");
            }

            studentDAO.delete(id);
        } catch (StudentDAOException | StudentNotFoundException e) {
            e.printStackTrace();
            // logging
            // rollback
            throw e;
        }
    }

    @Override
    public StudentReadOnlyDTO getStudentById(Integer id) throws StudentDAOException, StudentNotFoundException {
        Student student;

        try {
            student = studentDAO.getById(id);

            return Mapper.mapStudentToReadOnlyDTO(student)
                    .orElseThrow(() -> new StudentNotFoundException(""));
        } catch (StudentDAOException | StudentNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StudentReadOnlyDTO> getAllStudents() throws StudentDAOException {
        List<Student> students;
        try {
            students = studentDAO.getAll();

            return students.stream()
                    .map(Mapper::mapStudentToReadOnlyDTO)
                    .flatMap(Optional::stream)
                    .collect(Collectors.toList());

        } catch (StudentDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StudentReadOnlyDTO> getStudentsByLastname(String lastname) throws StudentDAOException {
        List<Student> students;

        try {
            students = studentDAO.getByLastname(lastname);
            return students.stream()
                    .map(Mapper::mapStudentToReadOnlyDTO)
                    .flatMap(Optional::stream)
                    .collect(Collectors.toList());
        } catch (StudentDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StudentReadOnlyDTO> getFilteredStudents(FiltersDTO filters) throws StudentDAOException {
        List<Student> students;

        try {
            students = studentDAO.getFilteredStudents(filters.getFirstname(), filters.getLastname());
            return students.stream()
                    .map(Mapper::mapStudentToReadOnlyDTO)
                    .flatMap(Optional::stream)
                    .collect(Collectors.toList());
        } catch (StudentDAOException e) {
            e.printStackTrace();
            // logging
            // rollback
            throw e;
        }
    }
}
