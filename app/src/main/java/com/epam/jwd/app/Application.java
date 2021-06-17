package com.epam.jwd.app;

import com.epam.jwd.space.api.model.Pilot;
import com.epam.jwd.space.api.model.Spaceship;
import com.epam.jwd.space.api.repository.SpaceshipRepository;

import java.util.Collection;
import java.util.ServiceLoader;

public class Application {

    public static void main(String[] args) {
        System.out.println("Program start!");

        var ann = new Pilot("Ann");
        var bob = new Pilot("Bob");
        var bravo = new Spaceship("Bravo", 22, ann);
        var firstSpaceship = new Spaceship("First spaceship", 22, bob);
        var secondSpaceship = new Spaceship("Second spaceship", 22, ann);

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

        var address = """
                25 Main Street
                Anytown, USA, 12345, blah blah
                hello""";
        System.out.println(address);

        System.out.println("Program end");
    }

    private static int countLength(Object o) {
        if (o instanceof String s && !s.isBlank()) {
            return s.length();
        } else if (o instanceof Collection<?> c) {
            return c.size();
        } else {
            return -1;
        }
    }

}
