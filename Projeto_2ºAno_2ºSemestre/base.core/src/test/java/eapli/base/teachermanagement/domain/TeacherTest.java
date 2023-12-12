package eapli.base.teachermanagement.domain;

import domain.model.*;

import eapli.base.usermanagement.domain.BaseRoles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TeacherTest {
    private final String aMecanographicNumber = "abc@gmail.com";
    private final String anotherMecanographicNumber = "xyz";

    public static SystemUserAuth dummyUser(final String username, final Role... roles) {
        // should we load from spring context?
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy").withRoles(roles).build();
    }

    @Test
    void testAllGets() {
        Acronym acronym = new Acronym("ABC");
        BirthDate birthDate = new BirthDate("01/01/2002");
        TaxPayer taxPayer = new TaxPayer("123456789");
        SystemUserAuth user = dummyUser("dummy@gmail.com", BaseRoles.TEACHER);

        Teacher teacher = new Teacher(user, acronym, birthDate, taxPayer);

        Assertions.assertEquals(acronym, teacher.getAcronym());
        Assertions.assertEquals(birthDate, teacher.getBirthDate());
        Assertions.assertEquals(taxPayer, teacher.getTaxPayer());
        Assertions.assertEquals(user, teacher.getUser());
    }

    @Test
    void ensureTeacherEqualsAreSameForSameInstance() {
        Acronym acronym = new Acronym("ABC");
        BirthDate birthDate = new BirthDate("01/01/2002");
        TaxPayer taxPayer = new TaxPayer("123456789");
        SystemUserAuth user = dummyUser("dummy@gmail.com", BaseRoles.TEACHER);

        Teacher teacher = new Teacher(user, acronym, birthDate, taxPayer);

        Assertions.assertEquals(teacher, teacher);
    }

    @Test
    void ensureTeacherAreDifferent() {
        Acronym acronym1 = new Acronym("ABC");
        BirthDate birthDate1 = new BirthDate("01/01/2002");
        TaxPayer taxPayer1 = new TaxPayer("123456789");
        SystemUserAuth user1 = dummyUser("dummy@gmail.com", BaseRoles.TEACHER);

        Acronym acronym2 = new Acronym("XYZ");
        BirthDate birthDate2 = new BirthDate("01/01/2000");
        TaxPayer taxPayer2 = new TaxPayer("987654321");
        SystemUserAuth user2 = dummyUser("test@gmail.com", BaseRoles.TEACHER);

        Teacher teacher1 = new Teacher(user1, acronym1, birthDate1, taxPayer1);
        Teacher teacher2 = new Teacher(user2, acronym2, birthDate2, taxPayer2);

        Assertions.assertNotEquals(teacher1, teacher2);
    }
}
