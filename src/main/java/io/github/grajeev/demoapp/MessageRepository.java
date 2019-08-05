package io.github.grajeev.demoapp;

import io.github.grajeev.demoapp.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, String> {
}
