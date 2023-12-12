package eapli.base.exammanagement.domain;

import eapli.framework.domain.model.ValueObject;

public enum TypeofQuestion implements ValueObject {
    MATCHING_QUESTION,
    SINGLE_ANSWER_QUESTION,
    SHORT_ANSWER_QUESTION,
    NUMERICAL_QUESTION,
    SELECT_MISSING_WORDS_QUESTION,
    TRUE_FALSE_QUESTION
}
