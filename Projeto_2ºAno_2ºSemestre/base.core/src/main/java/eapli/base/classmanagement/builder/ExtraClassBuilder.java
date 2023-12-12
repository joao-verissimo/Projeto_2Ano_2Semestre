package eapli.base.classmanagement.builder;

import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.domain.Duration;
import eapli.base.classmanagement.domain.ExtraClass;
import eapli.base.classmanagement.domain.Title;
import eapli.base.exammanagement.domain.Date;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.framework.domain.model.DomainFactory;

import java.time.LocalTime;
import java.util.List;

public class ExtraClassBuilder implements DomainFactory<ExtraClass> {

    private Title title;

    private Duration duration;
    private Date date;

    private Teacher teacher;

    private List<Student> Extra_class_access_list;

    public ExtraClassBuilder with(final String title, final String initialTime, final String finishTime, final String date, Teacher teacher, List<Student> Extra_class_access_list) {
        withStudents(Extra_class_access_list);
        withTitle(title);
        withDuration(initialTime,finishTime);
        withDate(date);
        withTeacher(teacher);
        return this;
    }

    private void withStudents(List<Student> extra_class_access_list) {
        this.Extra_class_access_list = extra_class_access_list;
    }

    public ExtraClassBuilder withTitle(final String title) {
        this.title = Title.valueOf(title);
        return this;
    }

    public ExtraClassBuilder withDuration(final String initialTime, final String finishTime) {
        this.duration = new Duration(LocalTime.parse(initialTime),LocalTime.parse(finishTime));
        return this;
    }

    public ExtraClassBuilder withDate(final String date) {
        this.date = new Date(date);
        return this;
    }

    public ExtraClassBuilder withTeacher(final Teacher teacher) {
        this.teacher = teacher;
        return this;
    }

    @Override
    public ExtraClass build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor
        ExtraClass classe;

        classe = new ExtraClass(title,duration,teacher,date,Extra_class_access_list);

        return classe;
    }
}
