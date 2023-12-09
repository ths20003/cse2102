// App.js
import { useState } from "react";
import "./App.css";
import ViewScore from "./ViewScore";
import ViewQuiz from "./ViewQuiz";

function App() {
  const questions = [
    // Question 1
    {
      query: "What is the capital of Australia?",
      options: [{ text: "Sydney" }, { text: "Canberra", isCorrect: true }, { text: "Melbourne" }],
    },
    // Question 2
    {
      query: "In which year did the first moon landing occur?",
      options: [
        { text: "1965" },
        { text: "1969", isCorrect: true },
        { text: "1975" },
        { text: "1980" },
      ],
    },
    // Question 3
    {
      query: "Who wrote 'To Kill a Mockingbird'?",
      options: [
        { text: "George Orwell" },
        { text: "Harper Lee", isCorrect: true },
        { text: "J.K. Rowling" },
        { text: "Ernest Hemingway" },
      ],
    },
    // Question 4
    {
      query: "What is the smallest prime number?",
      options: [
        { text: "0" },
        { text: "1" },
        { text: "2", isCorrect: true },
        { text: "3" },
      ],
    },
    // Question 5
    {
      query: "Which gas makes up the majority of Earth's atmosphere?",
      options: [
        { text: "Oxygen" },
        { text: "Nitrogen", isCorrect: true },
        { text: "Carbon Dioxide" },
        { text: "Argon" },
      ],
    },
    // Question 6
    {
      query: "What is the capital of France?",
      options: [{ text: "Berlin" }, { text: "London" }, { text: "Paris", isCorrect: true }],
    },
    // Question 7
    {
      query: "Who is the author of 'Romeo and Juliet'?",
      options: [
        { text: "Charles Dickens" },
        { text: "Jane Austen" },
        { text: "William Shakespeare", isCorrect: true },
        { text: "Mark Twain" },
      ],
    },
    // Question 8
    {
      query: "What is the largest mammal on Earth?",
      options: [
        { text: "Elephant" },
        { text: "Blue Whale", isCorrect: true },
        { text: "Giraffe" },
        { text: "Polar Bear" },
      ],
    },
    // Question 9
    {
      query: "Which planet is known as the Red Planet?",
      options: [
        { text: "Earth" },
        { text: "Mars", isCorrect: true },
        { text: "Venus" },
        { text: "Jupiter" },
      ],
    },
    // Question 10
    {
      query: "Who painted the Mona Lisa?",
      options: [
        { text: "Vincent van Gogh" },
        { text: "Leonardo da Vinci", isCorrect: true },
        { text: "Pablo Picasso" },
        { text: "Claude Monet" },
      ],
    },
  ];

  const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0);
  const [isQuizOver, setIsQuizOver] = useState(false);
  const [score, setScore] = useState(0);

  const handleAnswerClick = (selectedOption) => {
    if (selectedOption.isCorrect) {
      setScore(score + 1);
    }

    const nextQuestionIndex = currentQuestionIndex + 1;

    if (nextQuestionIndex < questions.length) {
      setCurrentQuestionIndex(nextQuestionIndex);
    } else {
      setIsQuizOver(true);
    }
  };

  const handleResetClick = () => {
    setScore(0);
    setCurrentQuestionIndex(0);
    setIsQuizOver(false);
  };

  return (
    <div className="App">
      {isQuizOver ? (
        <ViewScore score={score} handleResetClick={handleResetClick} />
      ) : (
        <ViewQuiz
          questions={questions}
          currentQuestion={currentQuestionIndex}
          handleAnswerClick={handleAnswerClick}
        />
      )}
    </div>
  );
}

export default App;
