package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class HomeController {

    private final EmailValidation emailValidation = new EmailValidation();
    private final PasswordQuality passwordQuality = new PasswordQuality();
    private final QuizService quizService = new QuizService();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("loginCredentials", new LoginCredentials());
        model.addAttribute("emailok", true);
        model.addAttribute("passwordok", true);
        return "home";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginCredentials loginCredentials, Model model) {
        boolean emailValid = emailValidation.isValidEmail(loginCredentials.getUsername());
        boolean passwordStrong = passwordQuality.isPasswordStrong(loginCredentials.getPassword());
        if (emailValid && passwordStrong) {
            return "redirect:https://ths20003-vm.cse.uconn.edu/proxy/8091/not_home";
        } else {
            model.addAttribute("emailyes", emailValid);
            model.addAttribute("passwordyes", passwordStrong);
            model.addAttribute("loginCredentials", loginCredentials);
            return "home";
        }
    }

    @PostMapping("/submitAnswer")
    public String submitAnswer(@ModelAttribute UserAnswers userAnswers, Model model) {
        return "redirect:https://ths20003-vm.cse.uconn.edu/proxy/8091/test";
    }

    
    @GetMapping("/not_home")
    public String questionPage(Model model) {
        List<QuizQuestion> questions = quizService.getAllQuizQuestions();
        model.addAttribute("questions", questions);
        return "not_home";
    }

    @GetMapping("/test")
    public String scorePage(Model model) {
        List<QuizQuestion> questions = quizService.getAllQuizQuestions();

        // Calculate user's score based on correct answers
        int userScore = calculateUserScore(questions);

        model.addAttribute("questions", questions);
        model.addAttribute("score", userScore);

        return "test";
    }

    private int calculateUserScore(List<QuizQuestion> questions) {
    int userScore = 0;

    for (QuizQuestion question : questions) {
        String correctAnswer = question.getCorrectAnswer();
        String userAnswer = question.getUserAnswer();  // Get the user's answer

        // Compare user's answer with the correct answer (ignoring case)
        if (correctAnswer.equalsIgnoreCase(userAnswer)) {
            userScore++;
        }
    }

    return userScore;
}

}
