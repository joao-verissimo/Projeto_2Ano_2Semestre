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

import java.util.*;

import domain.model.SystemUserAuth;
import domain.repositories.UserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import domain.model.Role;

/**
 * @author Paulo Gandra Sousa
 */
public class MasterUsersBootstrapper extends UsersBootstrapperBase implements Action {

    UserRepository userRepository = PersistenceContext.repositories().users();

    @Override
    public boolean execute() {
        registerAdmin("admin@gmail.com", TestDataConstants.PASSWORD1, "Jane", "Doe Admin");
        registerTeacher("teacher@gmail.com", TestDataConstants.PASSWORD1, "Ben", "Dover","TTT","12/10/1995","123456789");
        registerTeacher("teacher1@gmail.com", TestDataConstants.PASSWORD1, "Tren", "Dover","AAA","12/10/1995","123456789");
        registerTeacher("teacher2@gmail.com", TestDataConstants.PASSWORD1, "Deca", "Dover","RRR","12/10/1995","123456789");
        registerStudent("student@gmail.com", TestDataConstants.PASSWORD1, "Peter", "Parker","15/10/2006","123456789");
        registerStudent("student1@gmail.com", TestDataConstants.PASSWORD1, "Rica", "Parker","15/10/2006","123456789");
        registerStudent("student2@gmail.com", TestDataConstants.PASSWORD1, "Paulo", "Parker","15/10/2006","123456789");
        registerCourse("course",150,"test","course","1");
        registerCourse("course2", 200, "test", "course2", "2");
        registerCourse("course3", 250, "test", "course3", "3");
        registerSharedBoard(15,20,userRepository.findUserByEmail("admin@gmail.com"));
        //registerExam();
        return true;
    }

    /**
     *
     */
    private void registerAdmin(final String email, final String password, final String firstName, final String lastName) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.ADMIN);

        registerUser(email, password, firstName, lastName, roles,null,null,null);
    }
    private void registerTeacher(final String email, final String password, final String firstName, final String lastName,String acronym,String birthDate,String taxpayerNumber) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.TEACHER);

        registerUser(email, password, firstName, lastName,roles,acronym,birthDate,taxpayerNumber);
    }
    private void registerStudent(final String email, final String password, final String firstName, final String lastName,String birthDate,String taxPayerNumber) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.STUDENT);

        registerUser(email, password, firstName, lastName, roles,null,birthDate,taxPayerNumber);
    }

    private void registerCourse(String name,int capacity,String description,String title,String code){
        registerCourses(name,capacity,description,title,code);
    }

    private void registerSharedBoard(int rows, int columns, SystemUserAuth owner){
        registerSharedBoards(rows,columns,owner);
    }

/*    private void registerExam(){
        CreateExamController controller = new CreateExamController();
        Iterator<Question> iterador = controller.getrandomquestion().iterator();
        List<Question> questions= new ArrayList<Question>();
        while (iterador.hasNext()){
            questions.add(iterador.next());
        }
        Exam exam = new Exam(new Code("EXAM001"), new Date(), new Description("Exam Description"),
                new SequenceofSections("Section Sequence"), new Title("Exam Title"));
    }*/
}
