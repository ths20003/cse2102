import React from "react";
import "./ViewQuiz.css";

const ViewQuiz = ({ questions, currentQuestion, handleAnswerClick }) => {
    const { query: question, options: answers } = questions[currentQuestion];
  return (
    <div className="view-quiz">
      <div className="question">
        <div className="question-number">
          <span>
            Question {currentQuestion + 1} / {questions.length}
          </span>
        </div>
        <div className="question-text">{question}</div>
      </div>

      <div className="answer-options">
        {answers.map(({ text, isCorrect }) => (
          <button key={text} onClick={() => handleAnswerClick({ text, isCorrect })}>
          {text}
        </button>        
        ))}
      </div>
    </div>
  );
};

export default ViewQuiz;
