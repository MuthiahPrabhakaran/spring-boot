package com.spring.graphql.service;

import com.spring.graphql.model.Player;
import com.spring.graphql.model.Team;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PlayerService {
    private final List<Player> players = new ArrayList<>();
    AtomicInteger id = new AtomicInteger(0);

    public List<Player> findAll() {
        return players;
    }

    public Optional<Player> findOne(Integer id) {
        return players.stream().filter(player -> Objects.equals(player.Id(), id)).findAny();
    }

    public Player create(String name, Team team) {
        Player player = new Player(id.getAndIncrement(), name, team);
        players.add(player);
        return  player;
    }

    public Player delete(Integer id) {
        Player player = players.stream().filter(p -> Objects.equals(p.Id(), id)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
        players.remove(player);
        return player;
    }

    public Player update(Integer id, String name, Team team) {
        Player updatedPlayer = new Player(id, name, team);
        Player player = players.stream().filter(p -> Objects.equals(p.Id(), id)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
        int index = players.indexOf(player);
        players.set(index, updatedPlayer);
        return updatedPlayer;
    }

    @PostConstruct
    private void init() {
        players.add(new Player(id.incrementAndGet(), "MS Dhoni", Team.CSK));
        players.add(new Player(id.incrementAndGet(), "Rohit Sharma", Team.MI));
        players.add(new Player(id.incrementAndGet(), "Jasprit Bumrah", Team.MI));
        players.add(new Player(id.incrementAndGet(), "Rishabh pant", Team.DC));
        players.add(new Player(id.incrementAndGet(), "Suresh Raina", Team.CSK));
    }
}
