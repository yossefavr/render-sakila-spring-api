package yossefavr.demo.sakila.controller;

import yossefavr.demo.sakila.dto.ActorDTO;
import yossefavr.demo.sakila.repositories.ActorRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/actors")
public class ActorController {
    private final ActorRepository actorRepo;

    public ActorController(ActorRepository actorRepo) {
        this.actorRepo = actorRepo;
    }

    @GetMapping
    public List<ActorDTO> getAllActors() {
        return actorRepo.findAll().stream()
                .map(a -> new ActorDTO(
                        a.getId(),
                        a.getFirstName(),
                        a.getLastName()))
                .collect(Collectors.toList());
    }

    @GetMapping("/searchbyfullname")
    public List<ActorDTO> getActorsByFullName(@RequestParam String fullName) {
        return actorRepo.findByFullName(fullName).stream()
                .map(a -> new ActorDTO(
                        a.getId(),
                        a.getFirstName(),
                        a.getLastName()))
                .collect(Collectors.toList());
    }

}
