package br.com.fiap.jstl.test;

import br.com.fiap.jstl.Dao.Game;
import br.com.fiap.jstl.Dao.GameDaoImpl;

import java.util.List;

public class GameTest {
    public static void main(String[] args) {
        GameDaoImpl gameDao = new GameDaoImpl();
        List<Game> games = gameDao.findAll();

        for(Game g : games){
            System.out.println(g.getTitulo());
        }
    }
}
