package eapli.base.app.teacher;// Generated from C:/Users/jnmte/sem4pi-22-23-45/base.app.teacher/src/main/antlr4\ExamGrammar.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExamGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExamGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ExamGrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#feedbackRules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeedbackRules(ExamGrammarParser.FeedbackRulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#gradeRules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGradeRules(ExamGrammarParser.GradeRulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(ExamGrammarParser.SectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#sectionTheme}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSectionTheme(ExamGrammarParser.SectionThemeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#points}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoints(ExamGrammarParser.PointsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(ExamGrammarParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#multipleChoiceQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleChoiceQuestion(ExamGrammarParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#trueOrFalseQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueOrFalseQuestion(ExamGrammarParser.TrueOrFalseQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#directAnswerQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectAnswerQuestion(ExamGrammarParser.DirectAnswerQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#completeSpacesQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompleteSpacesQuestion(ExamGrammarParser.CompleteSpacesQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#matchingQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchingQuestion(ExamGrammarParser.MatchingQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#numericalQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericalQuestion(ExamGrammarParser.NumericalQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#questionHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionHeader(ExamGrammarParser.QuestionHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#answersList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswersList(ExamGrammarParser.AnswersListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescription(ExamGrammarParser.DescriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#optionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionList(ExamGrammarParser.OptionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(ExamGrammarParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#multipleChoiceAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleChoiceAnswer(ExamGrammarParser.MultipleChoiceAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#trueOrFalseAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueOrFalseAnswer(ExamGrammarParser.TrueOrFalseAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(ExamGrammarParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#completeSpacesQuestionHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompleteSpacesQuestionHeader(ExamGrammarParser.CompleteSpacesQuestionHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#questionHeaderList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionHeaderList(ExamGrammarParser.QuestionHeaderListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#numericalAnswerRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericalAnswerRange(ExamGrammarParser.NumericalAnswerRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#feedbackOrRoleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeedbackOrRoleType(ExamGrammarParser.FeedbackOrRoleTypeContext ctx);
}