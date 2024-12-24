package br.com.fiap.jstl.Dao;

import br.com.fiap.jstl.Model.ConnectionManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDaoImpl implements GameDao {

    @Override
    public void save(Game game) {

        Connection conn = ConnectionManager.getConnection();

        PreparedStatement stmt = null;

        String sql = "insert into TB_GAMES_JAVA (" +
                "game_id, titulo, estudio, ano_lancamento, finalizado) " +
                "values (SEQ_GAMES.nextval, ?, ?, ?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, game.getTitulo());
            stmt.setString(2, game.getEstudio());
            stmt.setInt(3, game.getAnoLancamento());
            stmt.setBoolean(4, game.isFinalizado());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Game findById(Long id) {
        return null;
    }

    @Override
    public List<Game> findAll() {

        Connection conn = ConnectionManager.getConnection();

        PreparedStatement stmt = null;

        String sql = "SELECT * FROM TB_GAMES_JAVA ORDER BY TITULO ASC";
        List<Game> games = new ArrayList<>();

        try {
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Game game = new Game();

                game.setGameId(rs.getInt("GAME_ID"));
                game.setTitulo(rs.getString("TITULO"));
                game.setEstudio(rs.getString("ESTUDIO"));
                game.setAnoLancamento(rs.getInt("ANO_LANCAMENTO"));
                game.setFinalizado(rs.getBoolean("FINALIZADO"));

                games.add(game);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }

    @Override
    public void delete(Game game) {
        Connection conn = ConnectionManager.getConnection();

        String sql = "DELETE FROM TB_GAMES_JAVA WHERE GAME_ID = ?";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, game.getGameId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


