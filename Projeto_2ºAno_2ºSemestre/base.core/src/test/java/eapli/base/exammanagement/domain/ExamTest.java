package eapli.base.exammanagement.domain;


import eapli.base.coursemanagement.domain.Capacity;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.Name;
import eapli.base.coursemanagement.domain.State;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ExamTest {

    private Course createDummyCourse1() {
        eapli.base.coursemanagement.domain.Code code = new eapli.base.coursemanagement.domain.Code("CD01");
        eapli.base.coursemanagement.domain.Name name = new Name("Dummy Course One");
        Capacity capacity = new Capacity(20);
        eapli.base.coursemanagement.domain.Description description = new eapli.base.coursemanagement.domain.Description("This is dummy course 1 for testing purposes.");
        eapli.base.coursemanagement.domain.Title title = new eapli.base.coursemanagement.domain.Title("Dummy Course Title 1");
        State state = State.ACTIVE;
        return new Course(code, name, capacity, description, title, state);
    }

    private Exam createDummyExam1() {
        List<Question> questions = new ArrayList<>();
        Date date = new Date();
        Description description = new Description("This is an exam");
        SequenceofSections sequenceofSections = new SequenceofSections("This is description");
        eapli.base.exammanagement.domain.Title title = new eapli.base.exammanagement.domain.Title("Examtest");
        Course course = createDummyCourse1();
        Header header = new Header(description, Header.Feedback.NONE, Header.Grade.NONE, "Dummy 1 Global Setting");

        Exam exam = new Exam(questions, date, sequenceofSections, title, course,header);
        return exam;
    }
    private Exam createDummyExam2() {
        List<Question> questions = new ArrayList<>();
        Date date = new Date();
        Description description = new Description("This is another exam");
        SequenceofSections sequenceofSections = new SequenceofSections("Another description");
        Header header = new Header(description, Header.Feedback.NONE, Header.Grade.NONE, "Dummy 2 Global Setting");
        eapli.base.exammanagement.domain.Title title = new eapli.base.exammanagement.domain.Title("Another Exam");
        Course course = createDummyCourse2();
        return new Exam(questions, date, sequenceofSections, title, course,header);
    }

    private Course createDummyCourse2() {
        eapli.base.coursemanagement.domain.Code code = new eapli.base.coursemanagement.domain.Code("CD02");
        eapli.base.coursemanagement.domain.Name name = new Name("Dummy Course Two");
        Capacity capacity = new Capacity(30);
        eapli.base.coursemanagement.domain.Description description = new eapli.base.coursemanagement.domain.Description("This is dummy course 2 for testing purposes.");
        eapli.base.coursemanagement.domain.Title title = new eapli.base.coursemanagement.domain.Title("Dummy Course Title 2");
        State state = State.INACTIVE;
        return new Course(code, name, capacity, description, title, state);
    }

    @Test
    public void ensureExamGettersReturnExpectedValues() {
        List<Question> questions = new ArrayList<>();
        Date date = new Date();
        Description description = new Description("This is an exam");
        SequenceofSections sequenceofSections = new SequenceofSections("This is description");
        eapli.base.exammanagement.domain.Title title = new eapli.base.exammanagement.domain.Title("Examtest");
        Header header = new Header(description, Header.Feedback.NONE, Header.Grade.NONE, "Dummy 1 Global Setting");
        Course course = createDummyCourse1();
        Exam exam = new Exam(questions, date, sequenceofSections, title, course,header);

        assertEquals(date, exam.getDate());
        assertEquals(header, exam.getHeader());
        assertEquals(sequenceofSections, exam.getSequenceofSections());
        assertEquals(title, exam.getTitle());
        assertEquals(course, exam.getCourse());
    }
    @Test
    public void ensureExamEqualsAreSameForSameInstance() {
        Exam exam1 = createDummyExam1();
        Exam exam2 = exam1;

        assertTrue(exam1.equals(exam2));
        assertEquals(exam1.hashCode(), exam2.hashCode());
    }

    @Test
    public void ensureExamsAreDifferent() {
        Exam exam1 = createDummyExam1();
        Exam exam2 = createDummyExam2();

        assertNotEquals(exam1, exam2);
        assertNotEquals(exam1.hashCode(), exam2.hashCode());
    }

}