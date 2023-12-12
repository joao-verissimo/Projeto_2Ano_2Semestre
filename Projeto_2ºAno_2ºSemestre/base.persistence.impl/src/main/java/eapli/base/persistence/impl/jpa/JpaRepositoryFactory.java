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
package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.BoardManagement.repositories.BoardRepository;
import eapli.base.BoardManagement.repositories.PostItRepository;
import eapli.base.MeetingManagement.repositories.MeetingALRepository;
import eapli.base.MeetingManagement.repositories.MeetingRepository;
import eapli.base.classmanagement.repositories.ClassRepository;
import eapli.base.classmanagement.repositories.ExtraClassRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.enrollmentmanagement.repositories.EnrollmentRepository;
import eapli.base.exammanagement.repositories.EvaluationRepository;
import eapli.base.exammanagement.repositories.ExamRepository;
import eapli.base.exammanagement.repositories.QuestionRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.managermanagement.repository.ManagerRepository;
import eapli.base.studentmanagement.repositories.StudentRepository;
import eapli.base.teachermanagement.repositories.TeacherRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import domain.repositories.UserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import repositores.impl.jpa.JpaAutoTxUserRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public UserRepository users(final TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }

    @Override
    public UserRepository users() {
        return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
        return new JpaClientUserRepository(autoTx);
    }

    @Override
    public JpaClientUserRepository clientUsers() {
        return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
        return new JpaSignupRequestRepository(autoTx);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CourseRepository Course(TransactionalContext autoTx) {
        return new JpaCourseRepository(autoTx);
    }

    @Override
    public CourseRepository Course() {
        return  new JpaCourseRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }
    


    @Override
    public ClassRepository classes(TransactionalContext autoTx) {
        return new JpaClassRepository(autoTx);
    }

    @Override
    public ClassRepository classes() {
        return new JpaClassRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ExtraClassRepository extraclasses(TransactionalContext autoTx) {
        return new JpaExtraClassRepository(autoTx);
    }

    @Override
    public ExtraClassRepository extraclasses() {
        return new JpaExtraClassRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public StudentRepository students(TransactionalContext autoTx) {
        return new JpaStudentRepository(autoTx);
    }

    @Override
    public EvaluationRepository evaluations(TransactionalContext autoTx) {
        return new JpaEvaluationRepository(autoTx);
    }

    @Override
    public EvaluationRepository evaluations() {
        return new JpaEvaluationRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public StudentRepository students() {
        return new JpaStudentRepository(Application.settings().getPersistenceUnitName());
    }
    @Override
    public EnrollmentRepository enrollments(TransactionalContext autoTx) {
        return new JpaEnrollmentRepository(autoTx);
    }

    @Override
    public EnrollmentRepository enrollments() {
        return new JpaEnrollmentRepository(Application.settings().getPersistenceUnitName());
    }
    @Override
    public TeacherRepository teachers(TransactionalContext autoTx) {
        return new JpaTeacherRepository(autoTx);
    }

    @Override
    public TeacherRepository teachers() {
        return new JpaTeacherRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ExamRepository exams(TransactionalContext autoTx) {
        return new JpaExamRepository(autoTx);
    }

    @Override
    public ExamRepository exams() {
        return new JpaExamRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public QuestionRepository questions(TransactionalContext autoTx) {
        return new JpaQuestionRepository(autoTx);    }

    @Override
    public QuestionRepository questions() {
        return new JpaQuestionRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ManagerRepository managers(TransactionalContext autoTx) {
        return new JpaManagerRepository(autoTx);
    }

    @Override
    public ManagerRepository managers() {
        return new JpaManagerRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public BoardRepository boardRepository(final TransactionalContext autoTx) {
        return new JpaBoardRepository(autoTx);
    }

    @Override
    public BoardRepository boardRepository() {
        return new JpaBoardRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public PostItRepository postItRepository(final TransactionalContext autoTx) {
        return new JpaPostItRepository(autoTx);
    }

    @Override
    public PostItRepository postItRepository() {
        return new JpaPostItRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public MeetingRepository meetingRepository(final TransactionalContext autoTx) {
        return new JpaMeetingRepository(autoTx);
    }

    @Override
    public MeetingRepository meetingRepository() {
        return new JpaMeetingRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public MeetingALRepository meetingAlRepository(final TransactionalContext autoTx) {
        return new JpaMeetingALRepository(autoTx);
    }

    @Override
    public MeetingALRepository meetingAlRepository() {
        return new JpaMeetingALRepository(Application.settings().getPersistenceUnitName());
    }
}
