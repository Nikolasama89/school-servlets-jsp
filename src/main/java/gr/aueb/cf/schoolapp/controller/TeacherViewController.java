package gr.aueb.cf.schoolapp.controller;

import gr.aueb.cf.schoolapp.dao.CityDAOImpl;
import gr.aueb.cf.schoolapp.dao.ICityDAO;
import gr.aueb.cf.schoolapp.dao.ITeacherDAO;
import gr.aueb.cf.schoolapp.dao.TeacherDAOImpl;
import gr.aueb.cf.schoolapp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.schoolapp.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.exceptions.TeacherNotFoundException;
import gr.aueb.cf.schoolapp.model.City;
import gr.aueb.cf.schoolapp.service.CityServiceImpl;
import gr.aueb.cf.schoolapp.service.ICityService;
import gr.aueb.cf.schoolapp.service.ITeacherService;
import gr.aueb.cf.schoolapp.service.TeacherServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/school-app/teachers/view-detail")
public class TeacherViewController extends HttpServlet {

    ITeacherDAO teacherDAO = new TeacherDAOImpl();
    ITeacherService teacherService = new TeacherServiceImpl(teacherDAO);
    ICityDAO cityDAO = new CityDAOImpl();
    ICityService cityService = new CityServiceImpl(cityDAO);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<City> cities = null;
        Integer id = Integer.parseInt(req.getParameter("id").trim());
        try {
            cities = cityService.getAllCities();
            TeacherReadOnlyDTO teacherReadOnlyDTO = teacherService.getTeacherById(id);
            req.setAttribute("cities", cities);
            if (req.getSession().getAttribute("readOnlyDTO") != null) {
                // Move from session to request scope for JSP
                req.setAttribute("readOnlyDTO", req.getSession().getAttribute("readOnlyDTO"));
                //req.setAttribute("errors", req.getSession().getAttribute("errors"));

                // Clear session data (so it doesn't persist after refresh)
                req.getSession().removeAttribute("readOnlyDTO");
                //req.getSession().removeAttribute("errors");
            }
            else req.setAttribute("readOnlyDTO", teacherReadOnlyDTO);
            req.getRequestDispatcher("/WEB-INF/jsp/teacher-view.jsp").forward(req, resp);
        } catch (SQLException | TeacherDAOException | TeacherNotFoundException e) {
            String errorMessage = e.getMessage();
            req.setAttribute("errorMessage", errorMessage);
            req.getRequestDispatcher("/WEB-INF/jsp/teacher-view.jsp")
                    .forward(req, resp);
        }
    }
}
