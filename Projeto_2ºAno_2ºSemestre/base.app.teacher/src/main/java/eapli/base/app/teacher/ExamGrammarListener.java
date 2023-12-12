package eapli.base.app.teacher;// Generated from C:/Users/jnmte/sem4pi-22-23-45/base.app.teacher/src/main/antlr4\ExamGrammar.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExamGrammarParser}.
 */
public interface ExamGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ExamGrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ExamGrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#feedbackRules}.
	 * @param ctx the parse tree
	 */
	void enterFeedbackRules(ExamGrammarParser.FeedbackRulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#feedbackRules}.
	 * @param ctx the parse tree
	 */
	void exitFeedbackRules(ExamGrammarParser.FeedbackRulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#gradeRules}.
	 * @param ctx the parse tree
	 */
	void enterGradeRules(ExamGrammarParser.GradeRulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#gradeRules}.
	 * @param ctx the parse tree
	 */
	void exitGradeRules(ExamGrammarParser.GradeRulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(ExamGrammarParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(ExamGrammarParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#sectionTheme}.
	 * @param ctx the parse tree
	 */
	void enterSectionTheme(ExamGrammarParser.SectionThemeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#sectionTheme}.
	 * @param ctx the parse tree
	 */
	void exitSectionTheme(ExamGrammarParser.SectionThemeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#points}.
	 * @param ctx the parse tree
	 */
	void enterPoints(ExamGrammarParser.PointsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#points}.
	 * @param ctx the parse tree
	 */
	void exitPoints(ExamGrammarParser.PointsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(ExamGrammarParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(ExamGrammarParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#multipleChoiceQuestion}.
	 * @param ctx the parse tree
	 */
	void enterMultipleChoiceQuestion(ExamGrammarParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#multipleChoiceQuestion}.
	 * @param ctx the parse tree
	 */
	void exitMultipleChoiceQuestion(ExamGrammarParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#trueOrFalseQuestion}.
	 * @param ctx the parse tree
	 */
	void enterTrueOrFalseQuestion(ExamGrammarParser.TrueOrFalseQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#trueOrFalseQuestion}.
	 * @param ctx the parse tree
	 */
	void exitTrueOrFalseQuestion(ExamGrammarParser.TrueOrFalseQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#directAnswerQuestion}.
	 * @param ctx the parse tree
	 */
	void enterDirectAnswerQuestion(ExamGrammarParser.DirectAnswerQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#directAnswerQuestion}.
	 * @param ctx the parse tree
	 */
	void exitDirectAnswerQuestion(ExamGrammarParser.DirectAnswerQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#completeSpacesQuestion}.
	 * @param ctx the parse tree
	 */
	void enterCompleteSpacesQuestion(ExamGrammarParser.CompleteSpacesQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#completeSpacesQuestion}.
	 * @param ctx the parse tree
	 */
	void exitCompleteSpacesQuestion(ExamGrammarParser.CompleteSpacesQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#matchingQuestion}.
	 * @param ctx the parse tree
	 */
	void enterMatchingQuestion(ExamGrammarParser.MatchingQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#matchingQuestion}.
	 * @param ctx the parse tree
	 */
	void exitMatchingQuestion(ExamGrammarParser.MatchingQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#numericalQuestion}.
	 * @param ctx the parse tree
	 */
	void enterNumericalQuestion(ExamGrammarParser.NumericalQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#numericalQuestion}.
	 * @param ctx the parse tree
	 */
	void exitNumericalQuestion(ExamGrammarParser.NumericalQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#questionHeader}.
	 * @param ctx the parse tree
	 */
	void enterQuestionHeader(ExamGrammarParser.QuestionHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#questionHeader}.
	 * @param ctx the parse tree
	 */
	void exitQuestionHeader(ExamGrammarParser.QuestionHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#answersList}.
	 * @param ctx the parse tree
	 */
	void enterAnswersList(ExamGrammarParser.AnswersListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#answersList}.
	 * @param ctx the parse tree
	 */
	void exitAnswersList(ExamGrammarParser.AnswersListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(ExamGrammarParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(ExamGrammarParser.DescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#optionList}.
	 * @param ctx the parse tree
	 */
	void enterOptionList(ExamGrammarParser.OptionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#optionList}.
	 * @param ctx the parse tree
	 */
	void exitOptionList(ExamGrammarParser.OptionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(ExamGrammarParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(ExamGrammarParser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#multipleChoiceAnswer}.
	 * @param ctx the parse tree
	 */
	void enterMultipleChoiceAnswer(ExamGrammarParser.MultipleChoiceAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#multipleChoiceAnswer}.
	 * @param ctx the parse tree
	 */
	void exitMultipleChoiceAnswer(ExamGrammarParser.MultipleChoiceAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#trueOrFalseAnswer}.
	 * @param ctx the parse tree
	 */
	void enterTrueOrFalseAnswer(ExamGrammarParser.TrueOrFalseAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#trueOrFalseAnswer}.
	 * @param ctx the parse tree
	 */
	void exitTrueOrFalseAnswer(ExamGrammarParser.TrueOrFalseAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(ExamGrammarParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(ExamGrammarParser.AnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#completeSpacesQuestionHeader}.
	 * @param ctx the parse tree
	 */
	void enterCompleteSpacesQuestionHeader(ExamGrammarParser.CompleteSpacesQuestionHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#completeSpacesQuestionHeader}.
	 * @param ctx the parse tree
	 */
	void exitCompleteSpacesQuestionHeader(ExamGrammarParser.CompleteSpacesQuestionHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#questionHeaderList}.
	 * @param ctx the parse tree
	 */
	void enterQuestionHeaderList(ExamGrammarParser.QuestionHeaderListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#questionHeaderList}.
	 * @param ctx the parse tree
	 */
	void exitQuestionHeaderList(ExamGrammarParser.QuestionHeaderListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#numericalAnswerRange}.
	 * @param ctx the parse tree
	 */
	void enterNumericalAnswerRange(ExamGrammarParser.NumericalAnswerRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#numericalAnswerRange}.
	 * @param ctx the parse tree
	 */
	void exitNumericalAnswerRange(ExamGrammarParser.NumericalAnswerRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#feedbackOrRoleType}.
	 * @param ctx the parse tree
	 */
	void enterFeedbackOrRoleType(ExamGrammarParser.FeedbackOrRoleTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#feedbackOrRoleType}.
	 * @param ctx the parse tree
	 */
	void exitFeedbackOrRoleType(ExamGrammarParser.FeedbackOrRoleTypeContext ctx);
}