package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {
    //хранить всех зарегистрированных игроков
    protected List<Player> registeredList = new ArrayList<>();

    public List<Player> getRegisteredList() {
        return registeredList;
    }

    //метод регистрации игрока
    public void register(Player player) {
        registeredList.add(player);
    }

    //найти игрока по имени
    public Player findByName(String name) {
        for (Player player : registeredList) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    //метод соревнования между двумя игроками
    public int round(String playerName1, String playerName2) {
        //проверка регистрации пользователей
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        //исключения
        if (player1 == null) {
            throw new NotRegisteredException("User " + playerName1 + " is not registered");
        }
        if (player2 == null) {
            throw new NotRegisteredException("User " + playerName2 + " is not registered");
        }

        //сравнение силы игроков
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
