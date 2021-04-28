package com.epam.jwd.space.api.repository;

import com.epam.jwd.space.api.model.Pilot;
import com.epam.jwd.space.api.model.Spaceship;

import java.util.List;
import java.util.Map;

public interface SpaceshipRepository extends BaseRepository<Spaceship> {

    Map<Pilot, List<Spaceship>> findSpaceshipsByPilots();

    List<Spaceship> findSpaceshipsByPilot(Pilot pilot);

}
