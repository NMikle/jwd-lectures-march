package com.epam.jwd.space.impl.repository;

import com.epam.jwd.space.api.repository.SpaceshipRepository;

public interface SpaceshipRepositoryFactory {

    static SpaceshipRepository provider() {
        System.out.println("provider method used");
        return new DBSpaceshipRepository(8);
    }

}
