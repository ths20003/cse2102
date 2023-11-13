package com.example.demo;

import com.example.demo.HomeController;
import com.example.demo.QuizQuestion;
import com.example.demo.QuizService;
import com.example.demo.EmailValidation;
import com.example.demo.PasswordQuality;
import com.example.demo.LoginCredentials;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Mock
    private QuizService quizService;

    @Mock
    private EmailValidation emailValidation;

    @Mock
    private PasswordQuality passwordQuality;

    @InjectMocks
    private HomeController homeController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShowHomePage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("login"))
                .andExpect(model().attributeExists("loginCredentials", "emailok", "passwordok"));
    }

    @Test
    public void testLoginSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .param("email", "user@example.com")
                .param("password", "StrongPass123"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/question_page"));
    }

    @Test
    public void testLoginFailure() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .param("email", "invalidemail")
                .param("password", "WeakPass"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("login"))
                .andExpect(model().attribute("emailok", false))
                .andExpect(model().attribute("passwordok", false))
                .andExpect(model().attributeExists("loginCredentials"));
    }

    @Test
    public void testQuestionPage() throws Exception {
        // Mock quiz questions
        List<QuizQuestion> mockQuestions = List.of(
                new QuizQuestion("Question 1", List.of("Option 1", "Option 2"), "Option 1"),
                new QuizQuestion("Question 2", List.of("Option A", "Option B"), "Option B")
        );

        // Mock QuizService behavior
        when(quizService.getAllQuizQuestions()).thenReturn(mockQuestions);

        mockMvc.perform(MockMvcRequestBuilders.get("/question_page"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("question_page"))
                .andExpect(model().attribute("questions", mockQuestions));
    }

    @Test
    public void testScorePage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/score_page"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("score_page"));
    }
}
