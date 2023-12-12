package eapli.base.teachermanagement.builder;

import application.AuthzRegistry;
import application.UserManagementService;
import domain.model.Role;
import domain.model.SystemUserAuth;
import eapli.base.teachermanagement.domain.BirthDate;
import eapli.base.teachermanagement.domain.TaxPayer;
import eapli.base.teachermanagement.domain.Acronym;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.time.util.CurrentTimeCalendars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Teacher builder.
 */
public class TeacherBuilder implements DomainFactory<Teacher> {

    private final UserManagementService userSvc = AuthzRegistry.userService();
    private Acronym acronym;
    private SystemUserAuth user;
    private BirthDate birthDate;
    private TaxPayer taxPayerNumber;


    /**
     * With teacher builder.
     *
     * @param email          the email
     * @param password       the password
     * @param fullName       the full name
     * @param shortName      the short name
     * @param acronym        the acronym
     * @param birthDate      the birth date
     * @param taxPayerNumber the tax payer number
     * @return the teacher builder
     */
    public TeacherBuilder with(final String email, final String password, final String fullName, final String shortName, final String acronym, final String birthDate, final String taxPayerNumber) {
        withAcronym(acronym);
        withSystemUser(email,password,fullName,shortName);
        withBirthDate(birthDate);
        withTaxPayerNumber(taxPayerNumber);
        return this;
    }


    /**
     * With acronym teacher builder.
     *
     * @param acronym the acronym
     * @return the teacher builder
     */
    public TeacherBuilder withAcronym(final String acronym) {
        this.acronym = Acronym.valueOf(acronym);
        return this;
    }

    /**
     * With system user teacher builder.
     *
     * @param username  the username
     * @param password  the password
     * @param fullName  the full name
     * @param shortName the short name
     * @return the teacher builder
     */
    public TeacherBuilder withSystemUser(final String username, final String password, String fullName, String shortName) {
        Role[] roleTypes = BaseRoles.teacher();
        Set<Role> role = new HashSet<>(Arrays.asList(roleTypes));
        this.user = userSvc.registerNewUser(username, password, fullName, shortName, role, CurrentTimeCalendars.now());
        return this;
    }

    /**
     * With birth date teacher builder.
     *
     * @param birthDate the birth date
     * @return the teacher builder
     */
    public TeacherBuilder withBirthDate(final String birthDate) {
        this.birthDate = BirthDate.valueOf(birthDate);
        return this;
    }

    /**
     * With tax payer number teacher builder.
     *
     * @param taxPayerNumber the tax payer number
     * @return the teacher builder
     */
    public TeacherBuilder withTaxPayerNumber(final String taxPayerNumber) {
        this.taxPayerNumber = TaxPayer.valueOf(taxPayerNumber);
        return this;
    }


    @Override
    public Teacher build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor
       Teacher teacher;

        teacher = new Teacher(user,acronym,birthDate,taxPayerNumber);

        return teacher;
    }
}

