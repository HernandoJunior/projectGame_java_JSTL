package br.com.fiap.jstl.Dao;

import java.util.List;

public interface GameDao {

    void save(Game game);
    Game findById(Long id);
    List<Game> findAll();

}
