package co.com.sofka.questions.repositories;

import co.com.sofka.questions.collections.Answer;
import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.model.QuestionDTO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public interface AnswerRepository extends ReactiveCrudRepository<Answer, String> {
    Flux<Answer> findAllByQuestionId(String id);
    //@Query(value = "{'questionId' : ?0}")
    Mono<Void> deleteByQuestionId(String questionId);
}
