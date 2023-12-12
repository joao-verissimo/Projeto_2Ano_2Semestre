package eapli.base.persistence.impl.inmemory;

import eapli.base.teachermanagement.domain.Acronym;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.base.teachermanagement.repositories.TeacherRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;

public class InMemoryTeacherRepository extends InMemoryDomainRepository<Teacher,Acronym> implements TeacherRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Teacher> findAllTeachers() {
        return null;
    }

    @Override
    public Teacher findByAcronym(String acronym) {
        return null;
    }

    @Override
    public Teacher findTeacherByEmail(String email) {
        return null;
    }

    @Override
    public <S extends Teacher> S save(S entity) {
        return null;
    }

    @Override
    public Iterable<Teacher> findAll() {
        return null;
    }

    @Override
    public boolean containsOfIdentity(Acronym id) {
        return super.containsOfIdentity(id);
    }


    @Override
    public boolean contains(Teacher entity) {
        return TeacherRepository.super.contains(entity);
    }

    @Override
    public void delete(Teacher entity) {

    }


    @Override
    public long count() {
        return 0;
    }

    @Override
    public long size() {
        return TeacherRepository.super.size();
    }

    @Override
    public void remove(Teacher entity) {
        TeacherRepository.super.remove(entity);
    }

    @Override
    public void removeOfIdentity(Acronym entityId) {
        super.removeOfIdentity(entityId);
    }

    @Override
    public void forEach(Consumer<? super Teacher> action) {
        super.forEach(action);
    }

    @Override
    public Spliterator<Teacher> spliterator() {
        return super.spliterator();
    }
}

