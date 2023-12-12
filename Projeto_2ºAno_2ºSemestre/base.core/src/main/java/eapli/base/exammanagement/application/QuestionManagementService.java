package eapli.base.exammanagement.application;

import eapli.base.exammanagement.repositories.ExamRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class QuestionManagementService {

    ExamRepository examRepository = PersistenceContext.repositories().exams();
}
