package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.exceptions.UserDAOException;
import gr.aueb.cf.schoolapp.dto.InsertUserDTO;
import gr.aueb.cf.schoolapp.model.User;
import gr.aueb.cf.schoolapp.exceptions.UserNotFoundException;

public interface IUserService {
    User insertUser(InsertUserDTO dto) throws UserDAOException;
    static User getUserByUsername(String username) throws UserNotFoundException, UserDAOException;
    boolean isUserValid(String username, String password) throws UserDAOException;
    boolean isEmailExists(String username) throws UserDAOException;
}
