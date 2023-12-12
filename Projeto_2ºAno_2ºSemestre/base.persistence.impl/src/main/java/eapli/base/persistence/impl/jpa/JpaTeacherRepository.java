package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.teachermanagement.domain.Acronym;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.base.teachermanagement.repositories.TeacherRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

class JpaTeacherRepository extends JpaAutoTxRepository<Teacher, Acronym, Acronym> implements TeacherRepository {

    public JpaTeacherRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaTeacherRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public Iterable<Teacher> findAllTeachers() {
        final TypedQuery<Teacher> query = entityManager().createQuery(
                "SELECT t FROM Teacher t" ,Teacher.class);

        return query.getResultList();
    }
    @Override
    public Teacher findByAcronym(String acronym){
        Iterable<Teacher> list = findAll();
        for (Teacher teacher:list) {
            if(teacher.getAcronym().toString().equals(acronym)){
                return teacher;
            }
        }
        return null;
    }
    @Override
    public Teacher findTeacherByEmail(String email){
        List<Teacher> list = (List<Teacher>) findAllTeachers();
        for (Teacher teacher:list) {
            if (teacher.getUser().email().toString().equals(email))
                return teacher;

        }
        return null;
    }

    @Override
    public boolean contains(Teacher entity) {
        return TeacherRepository.super.contains(entity);
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
    public void forEach(Consumer<? super Teacher> action) {
        super.forEach(action);
    }

    @Override
    public Spliterator<Teacher> spliterator() {
        return super.spliterator();
    }
}
