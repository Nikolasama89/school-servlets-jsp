package gr.aueb.cf.schoolapp.exceptions;

import gr.aueb.cf.schoolapp.model.Student;

import java.io.Serial;

public class StudentNotFoundException extends Exception {

  @Serial
  private static final long serialVersionUID = 1L;

  public StudentNotFoundException(String message) {
    super(message);
  }
}
