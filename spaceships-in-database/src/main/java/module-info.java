import com.epam.jwd.space.api.repository.SpaceshipRepository;
import com.epam.jwd.space.impl.repository.DBSpaceshipRepository;

module spaceships.in.database {
    requires spaceships.api;
    provides SpaceshipRepository with DBSpaceshipRepository;
}