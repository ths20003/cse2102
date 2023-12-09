import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import ViewQuiz from './ViewQuiz';

test('renders ViewQuiz component with a question and answer options', () => {
  const questions = [
    {
      query: 'What is the capital of Australia?',
      options: [
        { text: 'Sydney' },
        { text: 'Canberra', isCorrect: true },
        { text: 'Melbourne' },
      ],
    },
  ];

  const currentQuestion = 0;

  const handleAnswerClick = jest.fn();

  render(
    <ViewQuiz
      questions={questions}
      currentQuestion={currentQuestion}
      handleAnswerClick={handleAnswerClick}
    />
  );

  const questionElement = screen.getByText(/What is the capital of Australia?/i);
  expect(questionElement).toBeInTheDocument();

  const optionCanberra = screen.getByText(/Canberra/i);

  fireEvent.click(optionCanberra);

  expect(handleAnswerClick).toHaveBeenCalledWith({ text: 'Canberra', isCorrect: true });
});
