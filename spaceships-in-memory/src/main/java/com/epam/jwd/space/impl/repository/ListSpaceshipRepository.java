package com.epam.jwd.space.impl.repository;

import com.epam.jwd.space.api.model.Pilot;
import com.epam.jwd.space.api.model.Spaceship;
import com.epam.jwd.space.api.repository.SpaceshipRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class ListSpaceshipRepository implements SpaceshipRepository {

    private final List<Spaceship> spaceships;
    private long size;

    public ListSpaceshipRepository() {
        spaceships = new ArrayList<>();
        size = 0;
        System.out.println("in memory repo default constructor");
    }

    @Override
    public Spaceship save(Spaceship entity) {
        System.out.println("saving spaceship");
        final Spaceship spaceshipWithId = new Spaceship(++size,
                entity.name(), entity.distance(), entity.pilot());
        spaceships.add(spaceshipWithId);
        return spaceshipWithId;
    }

    @Override
    public Spaceship findById(Long id) {
        return spaceships.get((int) (id - 1));
    }

    @Override
    public List<Spaceship> findAll() {
        return new ArrayList<>(spaceships);
    }

    @Override
    public Map<Pilot, List<Spaceship>> findSpaceshipsByPilots() {
        return spaceships.stream()
                .collect(
                        groupingBy(
                                Spaceship::pilot,
                                mapping(identity(), toList())
                        )
                );
    }

    @Override
    public List<Spaceship> findSpaceshipsByPilot(Pilot pilot) {
        return spaceships.stream()
                .filter(s -> s.pilot().equals(pilot))
                .collect(toList());
    }
}
