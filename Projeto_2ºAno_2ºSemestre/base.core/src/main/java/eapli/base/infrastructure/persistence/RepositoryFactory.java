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
package eapli.base.infrastructure.persistence;

import domain.repositories.UserRepository;
import eapli.base.BoardManagement.repositories.BoardRepository;
import eapli.base.BoardManagement.repositories.PostItRepository;
import eapli.base.MeetingManagement.repositories.MeetingALRepository;
import eapli.base.MeetingManagement.repositories.MeetingRepository;
import eapli.base.classmanagement.repositories.ClassRepository;
import eapli.base.classmanagement.repositories.ExtraClassRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
//import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.exammanagement.domain.Question;
import eapli.base.exammanagement.repositories.EvaluationRepository;
import eapli.base.exammanagement.repositories.ExamRepository;
import eapli.base.exammanagement.repositories.QuestionRepository;
import eapli.base.managermanagement.domain.Manager;
import eapli.base.managermanagement.repository.ManagerRepository;
import eapli.base.studentmanagement.repositories.StudentRepository;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.enrollmentmanagement.repositories.EnrollmentRepository;
import eapli.base.studentmanagement.repositories.StudentRepository;
import eapli.base.teachermanagement.repositories.TeacherRepository;
import eapli.framework.domain.repositories.TransactionalContext;

import javax.transaction.Transactional;


/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TransactionalContext newTransactionalContext();

    /**
     *
     * @param autoTx
     *            the transactional context to enrol
     * @return
     */
    UserRepository users(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    UserRepository users();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    ClientUserRepository clientUsers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    ClientUserRepository clientUsers();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    SignupRequestRepository signupRequests(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    SignupRequestRepository signupRequests();

    CourseRepository Course(TransactionalContext autoTx);

    CourseRepository Course();

    ExamRepository exams(TransactionalContext autoTx);

    ExamRepository exams();

    QuestionRepository questions (TransactionalContext autoTx);

    QuestionRepository questions();


    EnrollmentRepository enrollments(TransactionalContext autoTx);

    EnrollmentRepository enrollments();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    ClassRepository classes(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    ClassRepository classes();
    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */

    ExtraClassRepository extraclasses(TransactionalContext autoTx);
    ExtraClassRepository extraclasses();
    StudentRepository students(TransactionalContext autoTx);

    EvaluationRepository evaluations(TransactionalContext autoTx);
    EvaluationRepository evaluations();

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    StudentRepository students();
    TeacherRepository teachers(TransactionalContext autoTx);



    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    TeacherRepository teachers();

    ManagerRepository managers(TransactionalContext autoTx);



    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    ManagerRepository managers();

    BoardRepository boardRepository(TransactionalContext autoTx);
    BoardRepository boardRepository();

    PostItRepository postItRepository(TransactionalContext autoTx);
    PostItRepository postItRepository();

    MeetingRepository meetingRepository(TransactionalContext autoTx);
    MeetingRepository meetingRepository();

    MeetingALRepository meetingAlRepository(TransactionalContext autoTx);
    MeetingALRepository meetingAlRepository();
}
