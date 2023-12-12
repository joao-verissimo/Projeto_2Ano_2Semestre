package eapli.base.classmanagement.builder;

import domain.model.SystemUserBuilder;
import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.domain.DayOfTheWeek;
import eapli.base.classmanagement.domain.Duration;
import eapli.base.classmanagement.domain.Title;
import eapli.base.classmanagement.repositories.ClassRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.validations.Preconditions;
import net.bytebuddy.asm.Advice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type Class builder.
 */
public class ClassBuilder implements DomainFactory<Class> {

    private Title title;

    private Duration duration;
    private DayOfTheWeek dayoftheweek;

    private Teacher teacher;

    /**
     * With class builder.
     *
     * @param title        the title
     * @param initialTime  the initial time
     * @param finishTime   the finish time
     * @param dayoftheweek the dayoftheweek
     * @param teacher      the teacher
     * @return the class builder
     */
    public ClassBuilder with(final String title, final String initialTime, final String finishTime, final String dayoftheweek, Teacher teacher) {
        withTitle(title);
        withDuration(initialTime,finishTime);
        withDayOfTheWeek(dayoftheweek);
        withTeacher(teacher);
        return this;
    }

    /**
     * With title class builder.
     *
     * @param title the title
     * @return the class builder
     */
    public ClassBuilder withTitle(final String title) {
        this.title = Title.valueOf(title);
        return this;
    }

    /**
     * With duration class builder.
     *
     * @param initialTime the initial time
     * @param finishTime  the finish time
     * @return the class builder
     */
    public ClassBuilder withDuration(final String initialTime,final String finishTime) {
        this.duration = new Duration(LocalTime.parse(initialTime),LocalTime.parse(finishTime));
        return this;
    }

    /**
     * With day of the week class builder.
     *
     * @param dayOfTheWeek the day of the week
     * @return the class builder
     */
    public ClassBuilder withDayOfTheWeek(final String dayOfTheWeek) {
        this.dayoftheweek = DayOfTheWeek.valueOf(dayOfTheWeek);
        return this;
    }

    /**
     * With teacher class builder.
     *
     * @param teacher the teacher
     * @return the class builder
     */
    public ClassBuilder withTeacher(final Teacher teacher) {
        this.teacher = teacher;
        return this;
    }

    @Override
    public Class build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor
        Class classe;

        classe = new Class(title,duration,dayoftheweek,teacher);

        return classe;
    }
}
