package eapli.base.classmanagement.domain;

import application.UserManagementService;
import domain.model.NilPasswordPolicy;
import domain.model.PlainTextEncoder;
import domain.model.SystemUserBuilder;
import eapli.base.classmanagement.builder.ClassBuilder;
import eapli.base.classmanagement.builder.ExtraClassBuilder;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.teachermanagement.builder.TeacherBuilder;
import eapli.base.teachermanagement.domain.Acronym;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.base.teachermanagement.repositories.TeacherRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ExtraClassTest {
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
        ExtraClassBuilder build = new ExtraClassBuilder();
        List<Student> list = new ArrayList<Student>();
        build.with("EAPLI","12:30","13:30","2002-01-01",repo.findByAcronym("TTT"),list);
        ExtraClass ExtraClass = build.build();
        assertNotNull(ExtraClass);
    }

    @Test
    void getDuration() {
        ExtraClassBuilder build = new ExtraClassBuilder();
        List<Student> list = new ArrayList<Student>();
        build.with("EAPLI","12:30","13:30","2002-01-01",repo.findByAcronym("TTT"),list);
        ExtraClass ExtraClass = build.build();
        LocalTime initial = LocalTime.parse("12:30");
        LocalTime finish = LocalTime.parse("13:30");
        assertEquals(ExtraClass.getDuration().getInitialTime(),initial);
        assertEquals(ExtraClass.getDuration().getFinishTime(),finish);
    }

    @Test
    void getTitle() {
        ExtraClassBuilder build = new ExtraClassBuilder();
        List<Student> list = new ArrayList<Student>();
        build.with("EAPLI","12:30","13:30","2002-01-01",repo.findByAcronym("TTT"),list);
        ExtraClass ExtraClass = build.build();
        assertEquals(ExtraClass.getTitle().getTitle(),"EAPLI");
    }

    @Test
    void setDuration() {
        ExtraClassBuilder build = new ExtraClassBuilder();
        List<Student> list = new ArrayList<Student>();
        build.with("EAPLI","12:30","13:30","2002-01-01",repo.findByAcronym("TTT"),list);
        ExtraClass ExtraClass = build.build();
        ExtraClass.setDuration(new Duration(LocalTime.parse("14:30"),LocalTime.parse("16:30")));
        Duration expected = new Duration(LocalTime.parse("14:30"),LocalTime.parse("16:30"));
        assertEquals(ExtraClass.getDuration().getInitialTime(),expected.getInitialTime());
        assertEquals(ExtraClass.getDuration().getFinishTime(),expected.getFinishTime());
    }

}