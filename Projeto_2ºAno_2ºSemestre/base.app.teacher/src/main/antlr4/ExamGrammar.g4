grammar ExamGrammar;

start: 'EXAM ' HEADER_PHRASE ':' feedbackRules gradeRules description '{' section+ '}';

feedbackRules: 'FEEDBACK TYPE: (' feedbackOrRoleType ');';

gradeRules: 'GRADE TYPE: (' feedbackOrRoleType ');';

section: 'SECTION ' sectionTheme ' {' (question points)+ '}' ;

sectionTheme: HEADER_PHRASE;

points: 'POINTS: (' NUMBER ');';

question: 'MULTIPLE CHOICE ' multipleChoiceQuestion
        | 'V/F ' trueOrFalseQuestion
        | 'DIRECT ANSWER ' directAnswerQuestion
        | 'COMPLETE SPACES QUESTION: ' completeSpacesQuestion
        | 'MATCHING QUESTION:' matchingQuestion
        | 'NUMERICAL ' numericalQuestion
        ;

multipleChoiceQuestion: questionHeader ' {' optionList '}' multipleChoiceAnswer ';';

trueOrFalseQuestion: questionHeader ' (' trueOrFalseAnswer ');';

directAnswerQuestion: questionHeader ' (' answer ');';

completeSpacesQuestion: completeSpacesQuestionHeader ' (' answersList ');';

matchingQuestion: 'QUESTIONS {' questionHeaderList '}' 'ANSWERS {' answersList '};';

numericalQuestion: questionHeader ' (' numericalAnswerRange ');';


//global
questionHeader: 'QUESTION: ' HEADER_PHRASE;
answersList: answer (',' answer)*;
description: 'DESCRIPTION: ' HEADER_PHRASE ';';

//multiple choice
optionList: option (',' option)+;
option: '[' LETTER ']' ' - ' HEADER_PHRASE;
multipleChoiceAnswer: '-> ' '[' LETTER ']';

//true or false
trueOrFalseAnswer: 'V' | 'F';

//direct answer
answer: ANSWER_PHRASE;

//complete spaces
completeSpacesQuestionHeader: COMPLETE_SPACES_PHRASE;

//matching
questionHeaderList: HEADER_PHRASE (',' HEADER_PHRASE)*;

//numerical
numericalAnswerRange: NUMBER '-' NUMBER;

//exam rules
feedbackOrRoleType: 'none'
                    | 'on-submission'
                    | 'after-closing';



HEADER_PHRASE: '"' [a-zA-Z0-9][a-zA-Z_0-9 ]+ '"';
ANSWER_PHRASE: '\'' [a-zA-Z0-9]+[a-zA-Z_0-9, ]* '\'';
COMPLETE_SPACES_PHRASE: '"' ([a-zA-Z0-9, ]* ' ' '[[' NUMBER ']]'+ [a-zA-Z0-9, ]*)+ '"';

LETTER: [A-Z];
NUMBER: [0-9]+;

WS: [ \t\r\n]+ -> skip;