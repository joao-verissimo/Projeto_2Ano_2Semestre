package eapli.base.classmanagement.repositories;

import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.domain.ExtraClass;
import eapli.framework.domain.repositories.DomainRepository;

public interface ExtraClassRepository extends DomainRepository<Long, ExtraClass> {

    Iterable<ExtraClass> findAllClassesByAcronym(String acronym);
    Iterable<ExtraClass> findAll();
}