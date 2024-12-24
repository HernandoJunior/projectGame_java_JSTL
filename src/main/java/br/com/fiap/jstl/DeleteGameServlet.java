package br.com.fiap.jstl;

import br.com.fiap.jstl.Dao.Game;
import br.com.fiap.jstl.Dao.GameDao;
import br.com.fiap.jstl.Dao.GameDaoImpl;
import br.com.fiap.jstl.Model.ConnectionManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteGame")
public class DeleteGameServlet extends HttpServlet {

    private GameDao gameDao = new GameDaoImpl(); // Certifique-se de usar sua implementação correta.

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Captura o ID enviado pelo formulário
        String gameIdParam = req.getParameter("GAME_ID");
        System.out.println(req);

        try {
            int gameId = Integer.parseInt(gameIdParam); // Converte para Integer

            // Cria um objeto Game apenas com o ID para deletar
            Game gameToDelete = new Game();
            gameToDelete.setGameId(gameId);

            // Chama o metodo delete do DAO
            gameDao.delete(gameToDelete);

            // Retorna uma resposta ao usuário
            resp.getWriter().write("Jogo deletado com sucesso!");

        } catch (NumberFormatException e) {
            resp.getWriter().write("ID inválido!");
        }
    }
}
