package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    @Test
    public void shouldRegisterPlayer() {
        Player player = new Player(4, "Anya", 30);
        Game game = new Game();

        game.register(player);

        List<Player> expected = new ArrayList<>();
        expected.add(player);
        List<Player> actual = game.getRegisteredList();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindPlayerByName() {
        Player player = new Player(4, "Anya", 30);
        Game game = new Game();

        game.register(player);

        Player expected = new Player(4, "Anya", 30);
        Player actual = game.findByName("Anya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionIfPlayer1NotRegistered() {
        Player player1 = new Player(4, "Anya", 30);
        Player player2 = new Player(8, "Vasya", 25);
        Game game = new Game();

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Anya", "Vasya");
        });
    }

    @Test
    public void shouldThrowExceptionIfPlayer2NotRegistered() {
        Player player1 = new Player(4, "Anya", 30);
        Player player2 = new Player(8, "Vasya", 25);
        Game game = new Game();

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Anya", "Vasya");
        });
    }

    @Test
    public void Player1ShouldWin() {
        Player player1 = new Player(4, "Anya", 30);
        Player player2 = new Player(8, "Vasya", 25);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Anya", "Vasya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void Player2ShouldWin() {
        Player player1 = new Player(4, "Anya", 30);
        Player player2 = new Player(8, "Vasya", 90);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Anya", "Vasya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeATie() {
        Player player1 = new Player(4, "Anya", 90);
        Player player2 = new Player(8, "Vasya", 90);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Anya", "Vasya");

        Assertions.assertEquals(expected, actual);
    }


}
