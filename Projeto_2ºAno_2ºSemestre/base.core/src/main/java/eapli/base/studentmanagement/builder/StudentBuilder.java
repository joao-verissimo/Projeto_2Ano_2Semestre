package eapli.base.studentmanagement.builder;

import application.AuthzRegistry;
import application.UserManagementService;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.studentmanagement.domain.BirthDate;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.studentmanagement.domain.TaxPayerNumber;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.model.DomainFactory;
import domain.model.Role;
import domain.model.SystemUserAuth;
import eapli.framework.time.util.CurrentTimeCalendars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Student builder.
 */
public class StudentBuilder implements DomainFactory<Student> {

    private final UserManagementService userSvc = AuthzRegistry.userService();
    private MecanographicNumber mecanographicNumber;
    private SystemUserAuth user;
    private BirthDate birthDate;
    private TaxPayerNumber taxPayerNumber;


    /**
     * With student builder.
     *
     * @param email          the email
     * @param password       the password
     * @param fullName       the full name
     * @param shortName      the short name
     * @param birthDate      the birth date
     * @param taxPayerNumber the tax payer number
     * @return the student builder
     */
    public StudentBuilder with(final String email, final String password, final String fullName, final String shortName,final String birthDate, final String taxPayerNumber) {
        //withMecanographicNumber(mecanographicNumber);
        withSystemUser(email,password,fullName,shortName);
        withBirthDate(birthDate);
        withTaxPayerNumber(taxPayerNumber);
        return this;
    }


    /**
     * With mecanographic number student builder.
     *
     * @param mecanographicNumber the mecanographic number
     * @return the student builder
     */
    public StudentBuilder withMecanographicNumber(final String mecanographicNumber) {
        this.mecanographicNumber = MecanographicNumber.valueOf(mecanographicNumber);
        return this;
    }

    /**
     * With system user student builder.
     *
     * @param email     the email
     * @param password  the password
     * @param fullName  the full name
     * @param shortName the short name
     * @return the student builder
     */
    public StudentBuilder withSystemUser(final String email,final String password,String fullName, String shortName) {
        Role[] roleTypes = BaseRoles.student();
        Set<Role> role = new HashSet<>(Arrays.asList(roleTypes));
        this.user = userSvc.registerNewUser(email, password, fullName, shortName, role, CurrentTimeCalendars.now());
        return this;
    }

    /**
     * With birth date student builder.
     *
     * @param birthDate the birth date
     * @return the student builder
     */
    public StudentBuilder withBirthDate(final String birthDate) {
        this.birthDate = BirthDate.valueOf(birthDate);
        return this;
    }

    /**
     * With tax payer number student builder.
     *
     * @param taxPayerNumber the tax payer number
     * @return the student builder
     */
    public StudentBuilder withTaxPayerNumber(final String taxPayerNumber) {
        this.taxPayerNumber = TaxPayerNumber.valueOf(taxPayerNumber);
        return this;
    }


    @Override
    public Student build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor
        Student student;

        student = new Student(user,birthDate,taxPayerNumber);

        return student;
    }
}
