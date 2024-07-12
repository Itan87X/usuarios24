package edu.ar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ar.data.UsuariosDAO;
import edu.ar.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/users")
public class usuarios24ServletController extends HttpServlet {
    static Logger logger = LoggerFactory.getLogger(usuarios24ServletController.class);
    List<Usuario> usersList = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String route = req.getParameter("action");
        if (route == null) {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            res.setContentType("application/json; charset=UTF-8");
            res.getWriter().write("{\"error\":\"Parámetro 'action' no encontrado\"}");
            logger.error("Parámetro 'action' no encontrado en la solicitud.");
            return;
        }
        logger.info("route : " + route);
        switch (route) {
            case "getAll" -> {
                try {
                    res.setContentType("application/json; charset=UTF-8");
                    usersList = UsuariosDAO.obtener();
                    logger.info("Dentro de getAll : " + usersList.size());
                    mapper.writeValue(res.getWriter(), usersList);
                } catch (Exception e) {
                    res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    res.setContentType("application/json; charset=UTF-8");
                    res.getWriter().write("{\"error\":\"Error al obtener los usuarios\"}");
                    logger.error("Error al obtener los usuarios", e);
                }
            }
            default -> {
                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                res.setContentType("application/json; charset=UTF-8");
                res.getWriter().write("{\"error\":\"Parámetro no válido\"}");
                logger.error("Parámetro no válido: " + route);
            }
        }
    }
}
    



