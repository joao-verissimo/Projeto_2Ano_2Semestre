package eapli.base.exammanagement.domain;

import eapli.base.studentmanagement.domain.Student;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Evaluation")

public class Evaluation implements AggregateRoot<Code> {
    //a student takes an exam
    @ManyToOne

    private final Student student;
    @ManyToOne

    private final Exam exam;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @ManyToOne

   private final Teacher teacher;
    private int grade;

    @OneToMany
    private List<Question> questions;

    public Evaluation() {
        this.student = null;
        this.exam = null;
        this.id = null;
        this.teacher = null;
        this.grade = 0;
    }

    public Evaluation(Student student, Exam chosenExam, List<Question> list) {
        this.student = student;
        this.exam = chosenExam;
        this.grade=0;
        this.teacher=null;
        this.questions = list;
    }


    public Student getStudent() {
        return student;
    }

    public Exam getExam() {
        return exam;
    }


    public Evaluation(Student student, Exam exam, Teacher teacher, int grade) {
        this.student = student;
        this.exam = exam;
        this.teacher = teacher;
        this.grade = grade;
    }

    public void setGrade(int grade) {
        if (grade >= 0 && grade <= 20) {
            this.grade = grade;
        }
    }
    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Code identity() {
        return null;
    }

    public long getId() {
        return this.id;
    }

    public  long getGrade(){
        return this.grade;
    }
}
