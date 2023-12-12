package eapli.base.classmanagement.domain;

import eapli.base.exammanagement.domain.Date;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "EXTRA_CLASS")
public class ExtraClass implements AggregateRoot<Long> {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long extraclassid;
    Date date;
    @Embedded
    private Title title;

    @Embedded
    private Duration duration;
    @ManyToOne
    private Teacher teacher;
    @OneToMany
    List<Student> Extra_class_access_list;
    public ExtraClass(Title title, Duration duration, Teacher teacher,Date date,List<Student> Extra_class_access_list) {
        this.title = title;
        this.duration = duration;
        this.date=date;
        this.teacher = teacher;
        this.Extra_class_access_list=Extra_class_access_list;
    }

    public ExtraClass() {}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Class ID: ").append(extraclassid).append("\n");
        sb.append("Title: ").append(title.getTitle()).append("\n");
        sb.append("Start Time: ").append(duration.getInitialTime()).append("\n");
        sb.append("End Time: ").append(duration.getFinishTime()).append("\n");
        sb.append("Duration: ").append(duration.getDurationValue()).append("\n");
        sb.append("Teacher: ").append(teacher != null ? teacher.getUser().name() : "N/A").append("\n");
        return sb.toString();
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return null;
    }

    public Duration getDuration() {
        return duration;
    }


    public Title getTitle() {
        return title;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
