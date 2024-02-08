package homework1.domain.service;

import homework1.domain.Bird;
import homework1.repository.BirdRepository;

import java.util.List;

public interface BirdService {
    Bird create(Bird bird);
    List<Bird> readAll();
    Bird update(Bird bird);
    void deleteByUd(Bird id);
}
