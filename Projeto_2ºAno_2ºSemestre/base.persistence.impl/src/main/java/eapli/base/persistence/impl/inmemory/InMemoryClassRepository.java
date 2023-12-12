package eapli.base.persistence.impl.inmemory;

import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.domain.DayOfTheWeek;
import eapli.base.classmanagement.domain.Duration;
import eapli.base.classmanagement.repositories.ClassRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryClassRepository extends InMemoryDomainRepository<Class,Long> implements ClassRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Class> findAllClassesByAcronym(String acronym) {
        return null;
    }

    @Override
    public Iterable<Class> findAll() {
        return null;
    }

    @Override
    public Class findClassById(Long id) {
        return null;
    }

    @Override
    public void setUpdateClass(Long id, Class c, String newInitalTime, String newFinishTime, DayOfTheWeek valueOf) {

    }

}
