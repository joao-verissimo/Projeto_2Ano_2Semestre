package eapli.base.enrollmentmanagement.domain;

import domain.model.*;
import eapli.base.coursemanagement.domain.*;
import eapli.base.coursemanagement.domain.Name;
import eapli.base.studentmanagement.domain.BirthDate;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.studentmanagement.domain.TaxPayerNumber;
import eapli.base.usermanagement.domain.BaseRoles;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;



public class EnrollmentTest {

  private final String aMecanographicNumber = "abc@gmail.com";
    private final String anotherMecanographicNumber = "xyz";

    public static SystemUserAuth dummyUser(final String username, final Role... roles) {
        // should we load from spring context?
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy").withRoles(roles).build();
    }

    private SystemUserAuth getNewDummyUser() {
        return dummyUser("dummy@gmail.com", BaseRoles.STUDENT);
    }

    private SystemUserAuth getNewDummyUserTwo() {
        return dummyUser("dummy-two@gmail.com", BaseRoles.STUDENT);
    }

    private BirthDate birthdate;

    private TaxPayerNumber taxPayerNumber;

    private eapli.base.coursemanagement.domain.State state;
    private Code code;

    private Code code1;
    private Capacity capacity;
    private Description description;
    private Title title;
    private Name name;

    private final Student student1 = new Student(getNewDummyUser(),birthdate,taxPayerNumber);
    private final Student student2 = new Student(getNewDummyUserTwo(),birthdate,taxPayerNumber);
    private final Course course1 = new Course(code,name,capacity,description,title,state);
    private final Course course2 = new Course(code1,name,capacity,description,title,state);


    private Enrollment createEnrollment1() {
        return new Enrollment(student1,course1);
    }

    private Enrollment createEnrollment2() {
        return new Enrollment(student2,course2);
    }



    @Test
    void ensureEnrollmentAreDifferent() {
        Enrollment a = createEnrollment1();
        Enrollment b = createEnrollment2();

        assertFalse(a.equals(b));
        assertNotSame(a, b);

    }

    @Test
    void ensureEnrollmentEqualsAreSameForSameInstance() {
        Enrollment a = createEnrollment1();

        assertTrue(a.equals(a));
    }

}
