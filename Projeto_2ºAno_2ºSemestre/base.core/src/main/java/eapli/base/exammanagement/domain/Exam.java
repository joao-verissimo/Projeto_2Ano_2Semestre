package eapli.base.exammanagement.domain;


import eapli.base.coursemanagement.domain.Course;
import eapli.base.studentmanagement.domain.Student;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.List;
@Entity(name = "Exam")
public class Exam implements AggregateRoot<Code> {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Question> questions;
    private Date date;
    private Header header;
    private SequenceofSections sequenceofSections;
    private Title title;
    @ManyToOne
    private Course course;



    public long getId() {
        return id;
    }

    @OneToMany
    private List<Student> Student;





    protected Exam() {
        // Required by JPA
    }

    public Exam(List<Question> questions, Date date, SequenceofSections sequenceofSections, Title title, Course course,Header header) {
        this.questions = questions;
        this.date = date;
        this.sequenceofSections = sequenceofSections;
        this.title = title;
        this.course = course;
        this.header = header;
    }


    public void appendStudent(Student student) {
        this.Student.add(student);
    }

    /*
    public List<Student> setStudent(List<Student> student) {
        this.Student.addAll(student);
    }
*/

    public Course getCourse() {
        return course;
    }

    public Date getDate() {
        return date;
    }

    //public List<Question> getQuestion() {
    //return questions;
    //}

    public SequenceofSections getSequenceofSections() {
        return sequenceofSections;
    }

    public Title getTitle() {
        return title;
    }

    public List<eapli.base.studentmanagement.domain.Student> getStudent() {
        return Student;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Code identity() {
        return null;
    }


    @Override
    public String toString() {
        return "Exam{" +
                "code=" + id.toString() +
                ", date=" + date.date() +
                ", header=" + header.toString() +
                ", sequenceofSections=" + sequenceofSections.getValue() +
                ", title=" + title.getValue() +
                ", Student=" + Student.toString() +
                '}';
    }


    public Header getHeader() {
        return header;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}


