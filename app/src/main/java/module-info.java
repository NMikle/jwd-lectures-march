import com.epam.jwd.space.api.repository.SpaceshipRepository;

module lectures.space.app {
    requires spaceships.api;
    uses SpaceshipRepository;
}