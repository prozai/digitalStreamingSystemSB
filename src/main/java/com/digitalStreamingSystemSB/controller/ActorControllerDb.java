package com.digitalStreamingSystemSB.controller;

import com.digitalStreamingSystemSB.entity.Actor;
import com.digitalStreamingSystemSB.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ActorControllerDb {
    // Dependency Injection (spring framework creates the Repository internally and injects the instance into your app
    @Autowired
    private ActorRepository actorRepository;
    //  get all actors
    @GetMapping("actor")
    public List getActorList() {
        List<Actor> actorList = actorRepository.findAll();
        return actorList;
    }
    // get actor by finding the repository by id
    @GetMapping("actor/{id}")
    public Actor getActorById(@PathVariable(value="id") Integer id) {
        Actor existingActor = actorRepository.findById(id).get();//java 8 to use .get() method
        return existingActor;
    }
    //  post actor details
    @PostMapping("/actor")
    public Actor createActor(@RequestBody Actor actor) {
        Actor savedActor = actorRepository.save(actor);
        return savedActor;
    }
    //  update actor by fetching the actor id
    @PutMapping("/actor/{id}")
    public Actor updateActor(@PathVariable(value="id") Integer id, @RequestBody Actor actor) {
        // fetch the actor
        Actor existingActor = actorRepository.findById(id).get();
        existingActor.setActor_Id(id);
        existingActor.setFirstName(actor.getFirstName());
        existingActor.setLastName(actor.getLastName());
        existingActor.setGender(actor.getGender());
        existingActor.setAge(actor.getAge());
        Actor savedActor = actorRepository.save(actor);
        return savedActor;
    }
    //  delete actor by fetching the actor id
    @DeleteMapping("/actor/{id}")
    public Map<String, Boolean> deleteActorById(@PathVariable(value="id") Integer id) {
        Actor existingActor = actorRepository.findById(id).get();//java 8 to use .get() method
        actorRepository.delete(existingActor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
