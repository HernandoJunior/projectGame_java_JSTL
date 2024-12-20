package br.com.fiap.jstl.Controllers;

import br.com.fiap.jstl.Dao.Game;
import br.com.fiap.jstl.Dao.GameDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/gameSave")
public class GameServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Cheguei no do post");
        // Recuperamos os dados do form
        String titulo = req.getParameter("titulo");
        String estudio = req.getParameter("estudio");
        int ano = Integer.parseInt(req.getParameter("lancamento"));
        String finalizado = req.getParameter("finalizado");
        boolean finalizadoBoolean = false;

        if (finalizado != null) {
            finalizadoBoolean = true;
        }

        // Criação de um objeto com os dados do form
        Game game = new Game();
        game.setTitulo(titulo);
        game.setEstudio(estudio);
        game.setAnoLancamento(ano);
        game.setFinalizado(finalizadoBoolean);

        // Chamando o GameDaoImpl
        GameDaoImpl gameDao = new GameDaoImpl();
        gameDao.save(game);

        req.setAttribute("mensagem", "Game cadastrado com sucesso!");

        req.getRequestDispatcher("/menu.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GameDaoImpl gameDao = new GameDaoImpl();
        List<Game> games = gameDao.findAll();


        req.setAttribute("games", games);
        req.getRequestDispatcher("/menu.jsp").forward(req, resp);
    }
}
