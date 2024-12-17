package br.com.fiap.jstl.Dao;

import br.com.fiap.jstl.Model.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDaoImpl implements GameDao{

    @Override
    public void save(Game game) {

        Connection conn = ConnectionManager.getConnection();

        PreparedStatement stmt = null;

        String sql = "insert into tb_games (" +
                "game_id, titulo, estudio, ano_lancamento, finalizado) " +
                "values (seq_games.nextval, ?, ?, ?, ?)";

        try{
//            stmt = conn.prepareStatement(sql);
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
//                conn.close();
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

        String sql = "SELECT * FROM tb_games ORDER BY TITULO ASC";
        List<Game> games = new ArrayList<>();

        try {
//            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Game game = new Game();

                game.setGameId(rs.getInt("game_id"));
                game.setTitulo(rs.getString("titulo"));
                game.setEstudio(rs.getString("estudio"));
                game.setAnoLancamento(rs.getInt("ano_lancamento"));
                game.setFinalizado(rs.getBoolean("finalizado"));

                games.add(game);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }
}
