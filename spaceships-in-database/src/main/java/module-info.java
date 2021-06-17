import com.epam.jwd.space.api.repository.SpaceshipRepository;
import com.epam.jwd.space.impl.repository.SpaceshipRepositoryFactory;

module spaceships.in.database {
    requires spaceships.api;
    provides SpaceshipRepository with SpaceshipRepositoryFactory;
}