package eapli.base.exammanagement.application;

import eapli.base.exammanagement.domain.Question;
import eapli.base.exammanagement.domain.TypeofQuestion;
import eapli.base.exammanagement.repositories.QuestionRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class CreateQuestionController {
    private final QuestionRepository questionRepository;

    public CreateQuestionController() {
        this.questionRepository = PersistenceContext.repositories().questions();
    }

    public Iterable<Question> getRandomQuestions() {
        return questionRepository.findAll();
    }

    public void createQuestion(String value, String correctAnswer, TypeofQuestion type) {
        Question question = new Question(value, correctAnswer, type);
        questionRepository.save(question);
    }
}
