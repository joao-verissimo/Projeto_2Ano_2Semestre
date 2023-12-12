package repositores.impl.springdata;

import domain.model.SystemUserAuth;
import domain.model.Username;
import domain.repositories.UserRepository;
import eapli.framework.infrastructure.repositories.impl.springdata.SpringDataBaseRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpringDataUserRepository extends UserRepository, SpringDataBaseRepository<SystemUserAuth, Username> {
    @Modifying
    @Query("DELETE FROM #{#entityName} e WHERE e.username = :id")
    void deleteOfIdentity(@Param("id") Username entityId);

    @Query("SELECT e FROM #{#entityName} e WHERE e.username = :id")
    Optional<SystemUserAuth> ofIdentity(@Param("id") Username entityId);
}
