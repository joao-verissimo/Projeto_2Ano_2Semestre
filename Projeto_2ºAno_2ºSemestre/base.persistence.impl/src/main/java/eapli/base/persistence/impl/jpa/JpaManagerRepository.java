package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.repositories.ClassRepository;
import eapli.base.managermanagement.domain.Manager;
import eapli.base.managermanagement.repository.ManagerRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

class JpaManagerRepository extends JpaAutoTxRepository<Manager, Long, Long> implements ManagerRepository {

    public JpaManagerRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaManagerRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

}
