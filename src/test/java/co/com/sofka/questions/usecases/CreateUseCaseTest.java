package co.com.sofka.questions.usecases;

import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.repositories.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

@SpringBootTest
class CreateUseCaseTest {
    @SpyBean
    CreateUseCase createUseCase;

    @MockBean
    QuestionRepository questionRepository;

    @Test
    public void createTest(){
        var questiondto = new QuestionDTO("123","456", "prueba", "prueba1", "intento de test");
        var question = new Question();
        question.setId("123");
        question.setUserId("456");
        question.setQuestion("prueba");
        question.setType("prueba1");
        question.setCategory("intento de test");
        Mockito.when(questionRepository.save(Mockito.any(Question.class))).thenReturn(Mono.just(question));
        var questionId = createUseCase.apply(questiondto);
        Assertions.assertEquals(questionId.block(), questiondto.getId());
    }

}