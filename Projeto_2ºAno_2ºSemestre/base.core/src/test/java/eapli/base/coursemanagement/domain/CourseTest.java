package eapli.base.coursemanagement.domain;
import org.junit.Test;
import static org.junit.Assert.*;
public class CourseTest{

    private Course createDummyCourse1() {
        Code code = new Code("C001");
        Name name = new Name("Dummy Course One");
        Capacity capacity = new Capacity(20);
        Description description = new Description("This is dummy course 1 for testing purposes.");
        Title title = new Title("Dummy Course Title 1");
        State state = State.ACTIVE;
        return new Course(code, name, capacity, description, title, state);
    }

    private Course createDummyCourse2() {
        Code code = new Code("C002");
        Name name = new Name("Dummy Course Two");
        Capacity capacity = new Capacity(30);
        Description description = new Description("This is dummy course 2 for testing purposes.");
        Title title = new Title("Dummy Course Title 2");
        State state = State.INACTIVE;
        return new Course(code, name, capacity, description, title, state);
    }
    @Test
    public void ensureCoursesAreDifferent() {
        Course course1 = createDummyCourse1();
        Course course2 =createDummyCourse2();
        assertFalse(course1.equals(course2));
        assertNotSame(course1, course2);
        assertNotEquals(course1.getCode(), course2.getCode());
    }

    @Test
    public void ensureCourseEqualsAreSameForSameInstance() {
        Course course = createDummyCourse1();
        assertTrue(course.equals(course));
    }
    @Test
    public void ensureCourseGettersReturnExpectedValues() {
        Code code = new Code("C001");
        Name name = new Name("Dummy Course");
        Capacity capacity = new Capacity(20);
        Description description = new Description("This is a dummy course for testing purposes.");
        Title title = new Title("Dummy Course Title");
        State state = State.ACTIVE;
        Course course = new Course(code, name, capacity, description, title, state);
        assertEquals(code, course.getCode());
        assertEquals(name, course.getName());
        assertEquals(capacity, course.getCapacity());
        assertEquals(description, course.getDescription());
        assertEquals(title, course.getTitle());
        assertEquals(state, course.getState());
    }
    @Test
    public void ensureOCEnrollments(){
        Course course= createDummyCourse1();
        course.closeEnrollment();
        assertFalse(course.isEnrollementstate());
        course.openEnrollment();
        assertTrue(course.isEnrollementstate());
    }

}
