package eapli.base.persistence.impl.inmemory;

import eapli.base.managermanagement.domain.Manager;
import eapli.base.managermanagement.repository.ManagerRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryManagerRepository extends InMemoryDomainRepository<Manager,Long> implements ManagerRepository {
    static {
        InMemoryInitializer.init();
    }
}

