package com.epam.jwd.space.impl.repository;

import com.epam.jwd.space.api.model.Pilot;
import com.epam.jwd.space.api.model.Spaceship;
import com.epam.jwd.space.api.repository.SpaceshipRepository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DBSpaceshipRepository implements SpaceshipRepository {

    public DBSpaceshipRepository(int loadFactor) {
        System.out.printf("DB repo constructor invoked with load factor %s\n", loadFactor);
    }

    @Override
    public Spaceship save(Spaceship entity) {
        System.out.println("saving to database");
        return null;
    }

    @Override
    public Spaceship findById(Long id) {
        return null;
    }

    @Override
    public List<Spaceship> findAll() {
        System.out.println("retrieving from database");
        return Collections.emptyList();
    }

    @Override
    public Map<Pilot, List<Spaceship>> findSpaceshipsByPilots() {
        return null;
    }

    @Override
    public List<Spaceship> findSpaceshipsByPilot(Pilot pilot) {
        return null;
    }
}
