package eapli.base.classmanagement.repositories;

import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.domain.DayOfTheWeek;
import eapli.base.classmanagement.domain.Duration;
import eapli.framework.domain.repositories.DomainRepository;

public interface ClassRepository extends DomainRepository<Long, Class> {

    Iterable<Class> findAllClassesByAcronym(String acronym);
    Iterable<Class> findAll();
    Class findClassById(Long id);

    void setUpdateClass(Long id, Class c, String newInitalTime, String newFinishTime, DayOfTheWeek valueOf);
}