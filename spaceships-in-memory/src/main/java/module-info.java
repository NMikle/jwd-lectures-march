import com.epam.jwd.space.api.repository.SpaceshipRepository;
import com.epam.jwd.space.impl.repository.ListSpaceshipRepository;

module spaceships.in.memory {
    requires spaceships.api;
    provides SpaceshipRepository with ListSpaceshipRepository;
}