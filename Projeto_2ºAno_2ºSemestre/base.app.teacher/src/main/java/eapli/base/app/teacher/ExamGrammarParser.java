package eapli.base.app.teacher;// Generated from C:/Users/jnmte/sem4pi-22-23-45/base.app.teacher/src/main/antlr4\ExamGrammar.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExamGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, HEADER_PHRASE=35, ANSWER_PHRASE=36, COMPLETE_SPACES_PHRASE=37, 
		LETTER=38, NUMBER=39, WS=40;
	public static final int
		RULE_start = 0, RULE_feedbackRules = 1, RULE_gradeRules = 2, RULE_section = 3, 
		RULE_sectionTheme = 4, RULE_points = 5, RULE_question = 6, RULE_multipleChoiceQuestion = 7, 
		RULE_trueOrFalseQuestion = 8, RULE_directAnswerQuestion = 9, RULE_completeSpacesQuestion = 10, 
		RULE_matchingQuestion = 11, RULE_numericalQuestion = 12, RULE_questionHeader = 13, 
		RULE_answersList = 14, RULE_description = 15, RULE_optionList = 16, RULE_option = 17, 
		RULE_multipleChoiceAnswer = 18, RULE_trueOrFalseAnswer = 19, RULE_answer = 20, 
		RULE_completeSpacesQuestionHeader = 21, RULE_questionHeaderList = 22, 
		RULE_numericalAnswerRange = 23, RULE_feedbackOrRoleType = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "feedbackRules", "gradeRules", "section", "sectionTheme", "points", 
			"question", "multipleChoiceQuestion", "trueOrFalseQuestion", "directAnswerQuestion", 
			"completeSpacesQuestion", "matchingQuestion", "numericalQuestion", "questionHeader", 
			"answersList", "description", "optionList", "option", "multipleChoiceAnswer", 
			"trueOrFalseAnswer", "answer", "completeSpacesQuestionHeader", "questionHeaderList", 
			"numericalAnswerRange", "feedbackOrRoleType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'EXAM '", "':'", "'{'", "'}'", "'FEEDBACK TYPE: ('", "');'", "'GRADE TYPE: ('", 
			"'SECTION '", "' {'", "'POINTS: ('", "'MULTIPLE CHOICE '", "'V/F '", 
			"'DIRECT ANSWER '", "'COMPLETE SPACES QUESTION: '", "'MATCHING QUESTION:'", 
			"'NUMERICAL '", "';'", "' ('", "'QUESTIONS {'", "'ANSWERS {'", "'};'", 
			"'QUESTION: '", "','", "'DESCRIPTION: '", "'['", "']'", "' - '", "'-> '", 
			"'V'", "'F'", "'-'", "'none'", "'on-submission'", "'after-closing'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "HEADER_PHRASE", 
			"ANSWER_PHRASE", "COMPLETE_SPACES_PHRASE", "LETTER", "NUMBER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ExamGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExamGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public TerminalNode HEADER_PHRASE() { return getToken(ExamGrammarParser.HEADER_PHRASE, 0); }
		public FeedbackRulesContext feedbackRules() {
			return getRuleContext(FeedbackRulesContext.class,0);
		}
		public GradeRulesContext gradeRules() {
			return getRuleContext(GradeRulesContext.class,0);
		}
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__0);
			setState(51);
			match(HEADER_PHRASE);
			setState(52);
			match(T__1);
			setState(53);
			feedbackRules();
			setState(54);
			gradeRules();
			setState(55);
			description();
			setState(56);
			match(T__2);
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				section();
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__7 );
			setState(62);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FeedbackRulesContext extends ParserRuleContext {
		public FeedbackOrRoleTypeContext feedbackOrRoleType() {
			return getRuleContext(FeedbackOrRoleTypeContext.class,0);
		}
		public FeedbackRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feedbackRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterFeedbackRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitFeedbackRules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitFeedbackRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeedbackRulesContext feedbackRules() throws RecognitionException {
		FeedbackRulesContext _localctx = new FeedbackRulesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_feedbackRules);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__4);
			setState(65);
			feedbackOrRoleType();
			setState(66);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GradeRulesContext extends ParserRuleContext {
		public FeedbackOrRoleTypeContext feedbackOrRoleType() {
			return getRuleContext(FeedbackOrRoleTypeContext.class,0);
		}
		public GradeRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gradeRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterGradeRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitGradeRules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitGradeRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GradeRulesContext gradeRules() throws RecognitionException {
		GradeRulesContext _localctx = new GradeRulesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_gradeRules);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(T__6);
			setState(69);
			feedbackOrRoleType();
			setState(70);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SectionContext extends ParserRuleContext {
		public SectionThemeContext sectionTheme() {
			return getRuleContext(SectionThemeContext.class,0);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public List<PointsContext> points() {
			return getRuleContexts(PointsContext.class);
		}
		public PointsContext points(int i) {
			return getRuleContext(PointsContext.class,i);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(T__7);
			setState(73);
			sectionTheme();
			setState(74);
			match(T__8);
			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
				question();
				setState(76);
				points();
				}
				}
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 129024L) != 0) );
			setState(82);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SectionThemeContext extends ParserRuleContext {
		public TerminalNode HEADER_PHRASE() { return getToken(ExamGrammarParser.HEADER_PHRASE, 0); }
		public SectionThemeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sectionTheme; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterSectionTheme(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitSectionTheme(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitSectionTheme(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionThemeContext sectionTheme() throws RecognitionException {
		SectionThemeContext _localctx = new SectionThemeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sectionTheme);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(HEADER_PHRASE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointsContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ExamGrammarParser.NUMBER, 0); }
		public PointsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_points; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterPoints(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitPoints(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitPoints(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointsContext points() throws RecognitionException {
		PointsContext _localctx = new PointsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_points);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__9);
			setState(87);
			match(NUMBER);
			setState(88);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuestionContext extends ParserRuleContext {
		public MultipleChoiceQuestionContext multipleChoiceQuestion() {
			return getRuleContext(MultipleChoiceQuestionContext.class,0);
		}
		public TrueOrFalseQuestionContext trueOrFalseQuestion() {
			return getRuleContext(TrueOrFalseQuestionContext.class,0);
		}
		public DirectAnswerQuestionContext directAnswerQuestion() {
			return getRuleContext(DirectAnswerQuestionContext.class,0);
		}
		public CompleteSpacesQuestionContext completeSpacesQuestion() {
			return getRuleContext(CompleteSpacesQuestionContext.class,0);
		}
		public MatchingQuestionContext matchingQuestion() {
			return getRuleContext(MatchingQuestionContext.class,0);
		}
		public NumericalQuestionContext numericalQuestion() {
			return getRuleContext(NumericalQuestionContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_question);
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				match(T__10);
				setState(91);
				multipleChoiceQuestion();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(T__11);
				setState(93);
				trueOrFalseQuestion();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				match(T__12);
				setState(95);
				directAnswerQuestion();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				match(T__13);
				setState(97);
				completeSpacesQuestion();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 5);
				{
				setState(98);
				match(T__14);
				setState(99);
				matchingQuestion();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 6);
				{
				setState(100);
				match(T__15);
				setState(101);
				numericalQuestion();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultipleChoiceQuestionContext extends ParserRuleContext {
		public QuestionHeaderContext questionHeader() {
			return getRuleContext(QuestionHeaderContext.class,0);
		}
		public OptionListContext optionList() {
			return getRuleContext(OptionListContext.class,0);
		}
		public MultipleChoiceAnswerContext multipleChoiceAnswer() {
			return getRuleContext(MultipleChoiceAnswerContext.class,0);
		}
		public MultipleChoiceQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleChoiceQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMultipleChoiceQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMultipleChoiceQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitMultipleChoiceQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleChoiceQuestionContext multipleChoiceQuestion() throws RecognitionException {
		MultipleChoiceQuestionContext _localctx = new MultipleChoiceQuestionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_multipleChoiceQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			questionHeader();
			setState(105);
			match(T__8);
			setState(106);
			optionList();
			setState(107);
			match(T__3);
			setState(108);
			multipleChoiceAnswer();
			setState(109);
			match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TrueOrFalseQuestionContext extends ParserRuleContext {
		public QuestionHeaderContext questionHeader() {
			return getRuleContext(QuestionHeaderContext.class,0);
		}
		public TrueOrFalseAnswerContext trueOrFalseAnswer() {
			return getRuleContext(TrueOrFalseAnswerContext.class,0);
		}
		public TrueOrFalseQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueOrFalseQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterTrueOrFalseQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitTrueOrFalseQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitTrueOrFalseQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueOrFalseQuestionContext trueOrFalseQuestion() throws RecognitionException {
		TrueOrFalseQuestionContext _localctx = new TrueOrFalseQuestionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_trueOrFalseQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			questionHeader();
			setState(112);
			match(T__17);
			setState(113);
			trueOrFalseAnswer();
			setState(114);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DirectAnswerQuestionContext extends ParserRuleContext {
		public QuestionHeaderContext questionHeader() {
			return getRuleContext(QuestionHeaderContext.class,0);
		}
		public AnswerContext answer() {
			return getRuleContext(AnswerContext.class,0);
		}
		public DirectAnswerQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directAnswerQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterDirectAnswerQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitDirectAnswerQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitDirectAnswerQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectAnswerQuestionContext directAnswerQuestion() throws RecognitionException {
		DirectAnswerQuestionContext _localctx = new DirectAnswerQuestionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_directAnswerQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			questionHeader();
			setState(117);
			match(T__17);
			setState(118);
			answer();
			setState(119);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompleteSpacesQuestionContext extends ParserRuleContext {
		public CompleteSpacesQuestionHeaderContext completeSpacesQuestionHeader() {
			return getRuleContext(CompleteSpacesQuestionHeaderContext.class,0);
		}
		public AnswersListContext answersList() {
			return getRuleContext(AnswersListContext.class,0);
		}
		public CompleteSpacesQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_completeSpacesQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterCompleteSpacesQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitCompleteSpacesQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitCompleteSpacesQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompleteSpacesQuestionContext completeSpacesQuestion() throws RecognitionException {
		CompleteSpacesQuestionContext _localctx = new CompleteSpacesQuestionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_completeSpacesQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			completeSpacesQuestionHeader();
			setState(122);
			match(T__17);
			setState(123);
			answersList();
			setState(124);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MatchingQuestionContext extends ParserRuleContext {
		public QuestionHeaderListContext questionHeaderList() {
			return getRuleContext(QuestionHeaderListContext.class,0);
		}
		public AnswersListContext answersList() {
			return getRuleContext(AnswersListContext.class,0);
		}
		public MatchingQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchingQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMatchingQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMatchingQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitMatchingQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchingQuestionContext matchingQuestion() throws RecognitionException {
		MatchingQuestionContext _localctx = new MatchingQuestionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_matchingQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__18);
			setState(127);
			questionHeaderList();
			setState(128);
			match(T__3);
			setState(129);
			match(T__19);
			setState(130);
			answersList();
			setState(131);
			match(T__20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumericalQuestionContext extends ParserRuleContext {
		public QuestionHeaderContext questionHeader() {
			return getRuleContext(QuestionHeaderContext.class,0);
		}
		public NumericalAnswerRangeContext numericalAnswerRange() {
			return getRuleContext(NumericalAnswerRangeContext.class,0);
		}
		public NumericalQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericalQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterNumericalQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitNumericalQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitNumericalQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericalQuestionContext numericalQuestion() throws RecognitionException {
		NumericalQuestionContext _localctx = new NumericalQuestionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_numericalQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			questionHeader();
			setState(134);
			match(T__17);
			setState(135);
			numericalAnswerRange();
			setState(136);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuestionHeaderContext extends ParserRuleContext {
		public TerminalNode HEADER_PHRASE() { return getToken(ExamGrammarParser.HEADER_PHRASE, 0); }
		public QuestionHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterQuestionHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitQuestionHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitQuestionHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionHeaderContext questionHeader() throws RecognitionException {
		QuestionHeaderContext _localctx = new QuestionHeaderContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_questionHeader);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__21);
			setState(139);
			match(HEADER_PHRASE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnswersListContext extends ParserRuleContext {
		public List<AnswerContext> answer() {
			return getRuleContexts(AnswerContext.class);
		}
		public AnswerContext answer(int i) {
			return getRuleContext(AnswerContext.class,i);
		}
		public AnswersListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answersList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterAnswersList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitAnswersList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitAnswersList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswersListContext answersList() throws RecognitionException {
		AnswersListContext _localctx = new AnswersListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_answersList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			answer();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22) {
				{
				{
				setState(142);
				match(T__22);
				setState(143);
				answer();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DescriptionContext extends ParserRuleContext {
		public TerminalNode HEADER_PHRASE() { return getToken(ExamGrammarParser.HEADER_PHRASE, 0); }
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitDescription(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(T__23);
			setState(150);
			match(HEADER_PHRASE);
			setState(151);
			match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OptionListContext extends ParserRuleContext {
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public OptionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterOptionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitOptionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitOptionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionListContext optionList() throws RecognitionException {
		OptionListContext _localctx = new OptionListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_optionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			option();
			setState(156); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(154);
				match(T__22);
				setState(155);
				option();
				}
				}
				setState(158); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__22 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OptionContext extends ParserRuleContext {
		public TerminalNode LETTER() { return getToken(ExamGrammarParser.LETTER, 0); }
		public TerminalNode HEADER_PHRASE() { return getToken(ExamGrammarParser.HEADER_PHRASE, 0); }
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__24);
			setState(161);
			match(LETTER);
			setState(162);
			match(T__25);
			setState(163);
			match(T__26);
			setState(164);
			match(HEADER_PHRASE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultipleChoiceAnswerContext extends ParserRuleContext {
		public TerminalNode LETTER() { return getToken(ExamGrammarParser.LETTER, 0); }
		public MultipleChoiceAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleChoiceAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMultipleChoiceAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMultipleChoiceAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitMultipleChoiceAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleChoiceAnswerContext multipleChoiceAnswer() throws RecognitionException {
		MultipleChoiceAnswerContext _localctx = new MultipleChoiceAnswerContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_multipleChoiceAnswer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__27);
			setState(167);
			match(T__24);
			setState(168);
			match(LETTER);
			setState(169);
			match(T__25);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TrueOrFalseAnswerContext extends ParserRuleContext {
		public TrueOrFalseAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueOrFalseAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterTrueOrFalseAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitTrueOrFalseAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitTrueOrFalseAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueOrFalseAnswerContext trueOrFalseAnswer() throws RecognitionException {
		TrueOrFalseAnswerContext _localctx = new TrueOrFalseAnswerContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_trueOrFalseAnswer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			_la = _input.LA(1);
			if ( !(_la==T__28 || _la==T__29) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnswerContext extends ParserRuleContext {
		public TerminalNode ANSWER_PHRASE() { return getToken(ExamGrammarParser.ANSWER_PHRASE, 0); }
		public AnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerContext answer() throws RecognitionException {
		AnswerContext _localctx = new AnswerContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(ANSWER_PHRASE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompleteSpacesQuestionHeaderContext extends ParserRuleContext {
		public TerminalNode COMPLETE_SPACES_PHRASE() { return getToken(ExamGrammarParser.COMPLETE_SPACES_PHRASE, 0); }
		public CompleteSpacesQuestionHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_completeSpacesQuestionHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterCompleteSpacesQuestionHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitCompleteSpacesQuestionHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitCompleteSpacesQuestionHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompleteSpacesQuestionHeaderContext completeSpacesQuestionHeader() throws RecognitionException {
		CompleteSpacesQuestionHeaderContext _localctx = new CompleteSpacesQuestionHeaderContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_completeSpacesQuestionHeader);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(COMPLETE_SPACES_PHRASE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuestionHeaderListContext extends ParserRuleContext {
		public List<TerminalNode> HEADER_PHRASE() { return getTokens(ExamGrammarParser.HEADER_PHRASE); }
		public TerminalNode HEADER_PHRASE(int i) {
			return getToken(ExamGrammarParser.HEADER_PHRASE, i);
		}
		public QuestionHeaderListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionHeaderList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterQuestionHeaderList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitQuestionHeaderList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitQuestionHeaderList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionHeaderListContext questionHeaderList() throws RecognitionException {
		QuestionHeaderListContext _localctx = new QuestionHeaderListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_questionHeaderList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(HEADER_PHRASE);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22) {
				{
				{
				setState(178);
				match(T__22);
				setState(179);
				match(HEADER_PHRASE);
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumericalAnswerRangeContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(ExamGrammarParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(ExamGrammarParser.NUMBER, i);
		}
		public NumericalAnswerRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericalAnswerRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterNumericalAnswerRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitNumericalAnswerRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitNumericalAnswerRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericalAnswerRangeContext numericalAnswerRange() throws RecognitionException {
		NumericalAnswerRangeContext _localctx = new NumericalAnswerRangeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_numericalAnswerRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(NUMBER);
			setState(186);
			match(T__30);
			setState(187);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FeedbackOrRoleTypeContext extends ParserRuleContext {
		public FeedbackOrRoleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feedbackOrRoleType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterFeedbackOrRoleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitFeedbackOrRoleType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor) return ((ExamGrammarVisitor<? extends T>)visitor).visitFeedbackOrRoleType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeedbackOrRoleTypeContext feedbackOrRoleType() throws RecognitionException {
		FeedbackOrRoleTypeContext _localctx = new FeedbackOrRoleTypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_feedbackOrRoleType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30064771072L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001(\u00c0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0004\u0000;\b\u0000\u000b\u0000\f\u0000<\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003O\b\u0003\u000b"+
		"\u0003\f\u0003P\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006g\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u0091\b\u000e\n\u000e\f\u000e\u0094"+
		"\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0004\u0010\u009d\b\u0010\u000b\u0010\f\u0010\u009e"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0005\u0016\u00b5\b\u0016\n\u0016\f\u0016\u00b8"+
		"\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0000\u0000\u0019\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.0\u0000\u0002"+
		"\u0001\u0000\u001d\u001e\u0001\u0000 \"\u00b0\u00002\u0001\u0000\u0000"+
		"\u0000\u0002@\u0001\u0000\u0000\u0000\u0004D\u0001\u0000\u0000\u0000\u0006"+
		"H\u0001\u0000\u0000\u0000\bT\u0001\u0000\u0000\u0000\nV\u0001\u0000\u0000"+
		"\u0000\ff\u0001\u0000\u0000\u0000\u000eh\u0001\u0000\u0000\u0000\u0010"+
		"o\u0001\u0000\u0000\u0000\u0012t\u0001\u0000\u0000\u0000\u0014y\u0001"+
		"\u0000\u0000\u0000\u0016~\u0001\u0000\u0000\u0000\u0018\u0085\u0001\u0000"+
		"\u0000\u0000\u001a\u008a\u0001\u0000\u0000\u0000\u001c\u008d\u0001\u0000"+
		"\u0000\u0000\u001e\u0095\u0001\u0000\u0000\u0000 \u0099\u0001\u0000\u0000"+
		"\u0000\"\u00a0\u0001\u0000\u0000\u0000$\u00a6\u0001\u0000\u0000\u0000"+
		"&\u00ab\u0001\u0000\u0000\u0000(\u00ad\u0001\u0000\u0000\u0000*\u00af"+
		"\u0001\u0000\u0000\u0000,\u00b1\u0001\u0000\u0000\u0000.\u00b9\u0001\u0000"+
		"\u0000\u00000\u00bd\u0001\u0000\u0000\u000023\u0005\u0001\u0000\u0000"+
		"34\u0005#\u0000\u000045\u0005\u0002\u0000\u000056\u0003\u0002\u0001\u0000"+
		"67\u0003\u0004\u0002\u000078\u0003\u001e\u000f\u00008:\u0005\u0003\u0000"+
		"\u00009;\u0003\u0006\u0003\u0000:9\u0001\u0000\u0000\u0000;<\u0001\u0000"+
		"\u0000\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=>\u0001"+
		"\u0000\u0000\u0000>?\u0005\u0004\u0000\u0000?\u0001\u0001\u0000\u0000"+
		"\u0000@A\u0005\u0005\u0000\u0000AB\u00030\u0018\u0000BC\u0005\u0006\u0000"+
		"\u0000C\u0003\u0001\u0000\u0000\u0000DE\u0005\u0007\u0000\u0000EF\u0003"+
		"0\u0018\u0000FG\u0005\u0006\u0000\u0000G\u0005\u0001\u0000\u0000\u0000"+
		"HI\u0005\b\u0000\u0000IJ\u0003\b\u0004\u0000JN\u0005\t\u0000\u0000KL\u0003"+
		"\f\u0006\u0000LM\u0003\n\u0005\u0000MO\u0001\u0000\u0000\u0000NK\u0001"+
		"\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000"+
		"PQ\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RS\u0005\u0004\u0000"+
		"\u0000S\u0007\u0001\u0000\u0000\u0000TU\u0005#\u0000\u0000U\t\u0001\u0000"+
		"\u0000\u0000VW\u0005\n\u0000\u0000WX\u0005\'\u0000\u0000XY\u0005\u0006"+
		"\u0000\u0000Y\u000b\u0001\u0000\u0000\u0000Z[\u0005\u000b\u0000\u0000"+
		"[g\u0003\u000e\u0007\u0000\\]\u0005\f\u0000\u0000]g\u0003\u0010\b\u0000"+
		"^_\u0005\r\u0000\u0000_g\u0003\u0012\t\u0000`a\u0005\u000e\u0000\u0000"+
		"ag\u0003\u0014\n\u0000bc\u0005\u000f\u0000\u0000cg\u0003\u0016\u000b\u0000"+
		"de\u0005\u0010\u0000\u0000eg\u0003\u0018\f\u0000fZ\u0001\u0000\u0000\u0000"+
		"f\\\u0001\u0000\u0000\u0000f^\u0001\u0000\u0000\u0000f`\u0001\u0000\u0000"+
		"\u0000fb\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000g\r\u0001\u0000"+
		"\u0000\u0000hi\u0003\u001a\r\u0000ij\u0005\t\u0000\u0000jk\u0003 \u0010"+
		"\u0000kl\u0005\u0004\u0000\u0000lm\u0003$\u0012\u0000mn\u0005\u0011\u0000"+
		"\u0000n\u000f\u0001\u0000\u0000\u0000op\u0003\u001a\r\u0000pq\u0005\u0012"+
		"\u0000\u0000qr\u0003&\u0013\u0000rs\u0005\u0006\u0000\u0000s\u0011\u0001"+
		"\u0000\u0000\u0000tu\u0003\u001a\r\u0000uv\u0005\u0012\u0000\u0000vw\u0003"+
		"(\u0014\u0000wx\u0005\u0006\u0000\u0000x\u0013\u0001\u0000\u0000\u0000"+
		"yz\u0003*\u0015\u0000z{\u0005\u0012\u0000\u0000{|\u0003\u001c\u000e\u0000"+
		"|}\u0005\u0006\u0000\u0000}\u0015\u0001\u0000\u0000\u0000~\u007f\u0005"+
		"\u0013\u0000\u0000\u007f\u0080\u0003,\u0016\u0000\u0080\u0081\u0005\u0004"+
		"\u0000\u0000\u0081\u0082\u0005\u0014\u0000\u0000\u0082\u0083\u0003\u001c"+
		"\u000e\u0000\u0083\u0084\u0005\u0015\u0000\u0000\u0084\u0017\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0003\u001a\r\u0000\u0086\u0087\u0005\u0012\u0000"+
		"\u0000\u0087\u0088\u0003.\u0017\u0000\u0088\u0089\u0005\u0006\u0000\u0000"+
		"\u0089\u0019\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u0016\u0000\u0000"+
		"\u008b\u008c\u0005#\u0000\u0000\u008c\u001b\u0001\u0000\u0000\u0000\u008d"+
		"\u0092\u0003(\u0014\u0000\u008e\u008f\u0005\u0017\u0000\u0000\u008f\u0091"+
		"\u0003(\u0014\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0094\u0001"+
		"\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001"+
		"\u0000\u0000\u0000\u0093\u001d\u0001\u0000\u0000\u0000\u0094\u0092\u0001"+
		"\u0000\u0000\u0000\u0095\u0096\u0005\u0018\u0000\u0000\u0096\u0097\u0005"+
		"#\u0000\u0000\u0097\u0098\u0005\u0011\u0000\u0000\u0098\u001f\u0001\u0000"+
		"\u0000\u0000\u0099\u009c\u0003\"\u0011\u0000\u009a\u009b\u0005\u0017\u0000"+
		"\u0000\u009b\u009d\u0003\"\u0011\u0000\u009c\u009a\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0001\u0000\u0000\u0000\u009f!\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a1\u0005\u0019\u0000\u0000\u00a1\u00a2\u0005&\u0000\u0000\u00a2\u00a3"+
		"\u0005\u001a\u0000\u0000\u00a3\u00a4\u0005\u001b\u0000\u0000\u00a4\u00a5"+
		"\u0005#\u0000\u0000\u00a5#\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u001c"+
		"\u0000\u0000\u00a7\u00a8\u0005\u0019\u0000\u0000\u00a8\u00a9\u0005&\u0000"+
		"\u0000\u00a9\u00aa\u0005\u001a\u0000\u0000\u00aa%\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ac\u0007\u0000\u0000\u0000\u00ac\'\u0001\u0000\u0000\u0000\u00ad"+
		"\u00ae\u0005$\u0000\u0000\u00ae)\u0001\u0000\u0000\u0000\u00af\u00b0\u0005"+
		"%\u0000\u0000\u00b0+\u0001\u0000\u0000\u0000\u00b1\u00b6\u0005#\u0000"+
		"\u0000\u00b2\u00b3\u0005\u0017\u0000\u0000\u00b3\u00b5\u0005#\u0000\u0000"+
		"\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b7-\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9"+
		"\u00ba\u0005\'\u0000\u0000\u00ba\u00bb\u0005\u001f\u0000\u0000\u00bb\u00bc"+
		"\u0005\'\u0000\u0000\u00bc/\u0001\u0000\u0000\u0000\u00bd\u00be\u0007"+
		"\u0001\u0000\u0000\u00be1\u0001\u0000\u0000\u0000\u0006<Pf\u0092\u009e"+
		"\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}