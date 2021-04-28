package com.epam.jwd.app;

import com.epam.jwd.space.api.model.Pilot;
import com.epam.jwd.space.api.model.Spaceship;
import com.epam.jwd.space.api.repository.SpaceshipRepository;

import java.util.ServiceLoader;

public class Application {

    public static void main(String[] args) {
        System.out.println("Program start!");

        final Pilot ann = new Pilot("Ann");
        final Pilot bob = new Pilot("Bob");
        final Spaceship bravo = new Spaceship("Bravo", 22, ann);
        final Spaceship firstSpaceship = new Spaceship("First spaceship", 22, bob);
        final Spaceship secondSpaceship = new Spaceship("Second spaceship", 22, ann);

        final ServiceLoader<SpaceshipRepository> loadedRepositories
                = ServiceLoader.load(SpaceshipRepository.class);

        for (SpaceshipRepository repository : loadedRepositories) {
            repository.save(bravo);
            repository.save(firstSpaceship);
            repository.save(secondSpaceship);
        }

        for (SpaceshipRepository repo : loadedRepositories) {
            repo.findAll().forEach(System.out::println);
        }

        System.out.println("Program end");
    }

}
