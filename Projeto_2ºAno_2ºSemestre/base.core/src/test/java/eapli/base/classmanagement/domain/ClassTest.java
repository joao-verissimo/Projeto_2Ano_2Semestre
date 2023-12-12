package eapli.base.classmanagement.domain;

import application.UserManagementService;
import domain.model.NilPasswordPolicy;
import domain.model.PlainTextEncoder;
import domain.model.SystemUserBuilder;
import eapli.base.classmanagement.builder.ClassBuilder;
import eapli.base.teachermanagement.builder.TeacherBuilder;
import eapli.base.teachermanagement.domain.Acronym;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.base.teachermanagement.repositories.TeacherRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ClassTest {
    TeacherRepository repo = new TeacherRepository() {@Override
        public Iterable<Teacher> findAllTeachers() {return null;}
        @Override
        public Teacher findByAcronym(String acronym) {return null;}
        @Override
        public Teacher findTeacherByEmail(String email) {return null;}
        @Override
        public <S extends Teacher> S save(S entity) {return null;}
        @Override
        public Iterable<Teacher> findAll() {return null;}
        @Override
        public Optional<Teacher> ofIdentity(Acronym id) {return Optional.empty();}
        @Override
        public void delete(Teacher entity) {}
        @Override
        public void deleteOfIdentity(Acronym entityId) {}
        @Override
        public long count() {return 0;}
    };

    @Test
    void ensureClassIsCreated(){
        ClassBuilder build = new ClassBuilder();
        build.with("EAPLI","12:30","13:30","MONDAY",repo.findByAcronym("TTT"));
        Class classe = build.build();
        assertNotNull(classe);
    }

    @Test
    void getDuration() {
        ClassBuilder build = new ClassBuilder();
        build.with("EAPLI","12:30","13:30","MONDAY",repo.findByAcronym("TTT"));
        Class classe = build.build();
        Duration actual = new Duration(LocalTime.parse("12:30"),LocalTime.parse("13:30"));
        assertEquals(classe.getDuration().getInitialTime(),actual.getInitialTime());
        assertEquals(classe.getDuration().getFinishTime(),actual.getFinishTime());
    }

    @Test
    void getDayoftheweek() {
        ClassBuilder build = new ClassBuilder();
        build.with("EAPLI","12:30","13:30","MONDAY",repo.findByAcronym("TTT"));
        Class classe = build.build();
        DayOfTheWeek actual = new DayOfTheWeek("MONDAY");
        assertEquals(classe.getDayoftheweek().getDayoftheweek(),actual.getDayoftheweek());
    }

    @Test
    void getTitle() {
        ClassBuilder build = new ClassBuilder();
        build.with("EAPLI","12:30","13:30","MONDAY",repo.findByAcronym("TTT"));
        Class classe = build.build();
        Title actual = new Title("EAPLI");
        assertEquals(classe.getTitle().getTitle(),actual.getTitle());
    }

    @Test
    void setDuration() {
        ClassBuilder build = new ClassBuilder();
        build.with("EAPLI","12:30","13:30","MONDAY",repo.findByAcronym("TTT"));
        Class classe = build.build();
        classe.setDuration(new Duration(LocalTime.parse("14:30"),LocalTime.parse("16:30")));
        Duration expected = new Duration(LocalTime.parse("14:30"),LocalTime.parse("16:30"));
        assertEquals(classe.getDuration().getInitialTime(),expected.getInitialTime());
        assertEquals(classe.getDuration().getFinishTime(),expected.getFinishTime());
    }

    @Test
    void setDayoftheweek() {
        ClassBuilder build = new ClassBuilder();
        build.with("EAPLI","12:30","13:30","MONDAY",repo.findByAcronym("TTT"));
        Class classe = build.build();
        classe.setDayoftheweek(new DayOfTheWeek("TUESDAY"));
        DayOfTheWeek expected = new DayOfTheWeek("TUESDAY");
        assertEquals(classe.getDayoftheweek().getDayoftheweek(),expected.getDayoftheweek());
    }
}