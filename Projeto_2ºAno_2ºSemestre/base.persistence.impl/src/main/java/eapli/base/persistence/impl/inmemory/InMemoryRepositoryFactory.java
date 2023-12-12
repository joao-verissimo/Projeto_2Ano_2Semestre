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
package eapli.base.persistence.impl.inmemory;

import domain.repositories.UserRepository;
import eapli.base.BoardManagement.repositories.BoardRepository;
import eapli.base.BoardManagement.repositories.PostItRepository;
import eapli.base.MeetingManagement.repositories.MeetingALRepository;
import eapli.base.MeetingManagement.repositories.MeetingRepository;
import eapli.base.classmanagement.repositories.ClassRepository;
import eapli.base.classmanagement.repositories.ExtraClassRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.enrollmentmanagement.repositories.EnrollmentRepository;
import eapli.base.exammanagement.repositories.EvaluationRepository;
import eapli.base.exammanagement.repositories.ExamRepository;
import eapli.base.exammanagement.repositories.QuestionRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.managermanagement.repository.ManagerRepository;
import eapli.base.studentmanagement.repositories.StudentRepository;
import eapli.base.teachermanagement.repositories.TeacherRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import repositores.impl.inmemory.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    static {
        // only needed because of the in memory persistence
        new BaseBootstrapper().execute();
    }

    @Override
    public UserRepository users(final TransactionalContext tx) {
        return new InMemoryUserRepository();
    }

    @Override
    public UserRepository users() {
        return users(null);
    }

    @Override
    public ClientUserRepository clientUsers(final TransactionalContext tx) {

        return new InMemoryClientUserRepository();
    }

    @Override
    public ClientUserRepository clientUsers() {
        return clientUsers(null);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return signupRequests(null);
    }

    @Override
    public CourseRepository Course() {
        return null;
    }

    @Override
    public CourseRepository Course(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext tx) {
        return new InMemorySignupRequestRepository();
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        // in memory does not support transactions...
        return null;
    }
    @Override
    public ClassRepository classes(TransactionalContext tx){return new InMemoryClassRepository();}

    @Override
    public ClassRepository classes() {
        return classes(null);
    }

    @Override
    public ExtraClassRepository extraclasses(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public ExtraClassRepository extraclasses() {
        return null;
    }

    @Override
    public EnrollmentRepository enrollments(TransactionalContext tx){return new InMemoryEnrollmentRepository();}

    @Override
    public EnrollmentRepository enrollments() {
        return enrollments(null);
    }

    @Override
    public StudentRepository students(TransactionalContext tx){return new InMemoryStudentRepository();}

    @Override
    public EvaluationRepository evaluations(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public EvaluationRepository evaluations() {
        return null;
    }

    @Override
    public StudentRepository students() {
        return students(null);
    }

    @Override
    public TeacherRepository teachers(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public TeacherRepository teachers() {
        return null;
    }

    @Override
    public ExamRepository exams(TransactionalContext tx){return new InMemoryExamRepository();}

    @Override
    public ExamRepository exams() {
        return exams(null);
    }

    @Override
    public QuestionRepository questions(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public QuestionRepository questions() {
        return null;
    }

    public ManagerRepository managers(TransactionalContext tx){return new InMemoryManagerRepository();}

    @Override
    public ManagerRepository managers() {
        return managers(null);
    }

    @Override
    public BoardRepository boardRepository(TransactionalContext tx){return new InMemoryBoardRepository();}

    @Override
    public BoardRepository boardRepository() {
        return boardRepository(null);
    }

    @Override
    public PostItRepository postItRepository(TransactionalContext tx){return new InMemoryPostItRepository();}

    @Override
    public PostItRepository postItRepository() {
        return postItRepository(null);
    }

    @Override
    public MeetingRepository meetingRepository(TransactionalContext tx){return new InMemoryMeetingRepository();}

    @Override
    public MeetingRepository meetingRepository() {
        return meetingRepository(null);
    }

    @Override
    public MeetingALRepository meetingAlRepository(TransactionalContext tx){return new InMemoryMeetingALRepository();}

    @Override
    public MeetingALRepository meetingAlRepository() {
        return meetingAlRepository(null);
    }
}
