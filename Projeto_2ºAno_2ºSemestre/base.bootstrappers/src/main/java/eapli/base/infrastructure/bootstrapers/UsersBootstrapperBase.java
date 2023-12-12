/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.infrastructure.bootstrapers;

import java.util.Set;

import domain.model.SystemUserAuth;
import eapli.base.BoardManagement.application.CreateBoardController;
import eapli.base.coursemanagement.domain.*;
import eapli.base.coursemanagement.eventhandler.CreateCourseController;
import eapli.framework.general.domain.model.EmailAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.application.ListUsersController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import domain.model.Role;

public class UsersBootstrapperBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersBootstrapperBase.class);

    final AddUserController userController = new AddUserController();

    final CreateBoardController boardController = new CreateBoardController();

    final CreateCourseController courseController = new CreateCourseController();
    final ListUsersController listUserController = new ListUsersController();

    public UsersBootstrapperBase() {
        super();
    }

    /**
     * @param password
     * @param roles
     */
    protected void registerUser(final String email, final String password, final String fullName, final String shortName, final Set<Role> roles,final String acronym,final String birthDate,final String taxpayerNumber) {
        //SystemUser u = null;
        try {
            userController.addUser(email, password, fullName, shortName, roles,acronym,birthDate,taxpayerNumber);
            LOGGER.debug("»»» %s", email);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
            listUserController.find(EmailAddress.valueOf(email)).orElseThrow(() -> e);
        }
    }
    protected void registerCourses(String name,int capacity,String description,String title,String code){
        try{
            courseController.createCourse(new Name(name),new Capacity(capacity),new Description(description),new Title(title),new Code(code),State.ACTIVE);
        }catch (Exception e){
        }
    }

    protected void registerSharedBoards(int rows, int columnns, SystemUserAuth owner) {
        try {
            boardController.createBoard(rows, columnns,owner);
        } catch (Exception e) {
        }
    }
}
