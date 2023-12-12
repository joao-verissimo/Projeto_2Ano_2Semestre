package eapli.base.coursemanagement.domain;

import eapli.base.studentmanagement.domain.Student;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.List;
import javax.persistence.Entity;

import java.util.Objects;

@Entity(name = "Course")
public class Course implements AggregateRoot<Code> {

    private State state;
    private boolean enrollementstate;
    @EmbeddedId
    private Code code;
    private Capacity capacity;
    private Description description;
    private Title title;
    private Name name;
    @OneToMany
    private List<Teacher> teacher;
    @OneToMany
    private List<Student> Student;
    @OneToOne
    private Teacher headTeacher;

    protected Course() {
        // Required by JPA
    }

    public Course(Code code, Name name, Capacity capacity, Description description, Title title, State state) {
        this.code = code;
        this.name = name;
        this.capacity = capacity;
        this.description = description;
        this.title = title;
        this.state = state;
        enrollementstate=true;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public Code getCode() {
        return code;
    }

    public Name getName() {
        return name;
    }

    public void appendTeacher(Teacher teacher) {
        this.teacher.add(teacher);
    }

    public void appendStudent(List<Student> student) {this.Student.addAll(student);}

    public void removeTeacher(Teacher teacher) {
        this.teacher.remove(teacher);
    }

    public void removeStudent(Student student) {this.Student.remove(student);}

    /*
    public List<Student> setStudent(List<Student> student) {
        this.Student.addAll(student);
    }
*/
    public Description getDescription() {
        return description;
    }

    public Title getTitle() {
        return title;
    }

    public State getState() {
        return state;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Code identity() {
        return this.code;
    }

    public boolean isEnrollementstate() {
        return enrollementstate;
    }

    @Override
    public String toString() {
        return "Code=" + code.getValue() +
                ", title=" + title.getValue() +
                ", name=" + name.getValue() +
                ", description=" + description.getValue() +
                ", capacity=" + capacity.getValue() +
                ", state=" + state.toString() +
                ", enrollementstate=" + enrollementstate +
                ", headTeacher=" + headTeacher +
                ", teacher=" + teacher.toString();
    }

    public void toogleStateActivate() {
        this.state = State.ACTIVE;
    }
    public void toogleEnrollementStateActivate() {
        this.enrollementstate = true;
    }
    public void toogleEnrollementStateDeactivate() {
        this.enrollementstate = false;
    }
    public void setHeadTeacher(Teacher headTeacher) {
        this.headTeacher = headTeacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Course course = (Course) o;
        return state == course.state && Objects.equals(code, course.code) && Objects.equals(capacity, course.capacity)
                && Objects.equals(description, course.description) && Objects.equals(title, course.title)
                && Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, code, capacity, description, title, name);
    }

    public void toogleStateDeactivate() {
        this.state = State.INACTIVE;
    }

    public void openEnrollment() {
        this.enrollementstate = true;
    }
    public void closeEnrollment() {
        this.enrollementstate = false;
    }

}
