package com.pmfis.cinemaapp.controller;

import com.pmfis.cinemaapp.dao.PersonDAO;
import com.pmfis.cinemaapp.model.persistence.Person;
import com.pmfis.cinemaapp.model.rest.PersonRequest;
import com.pmfis.cinemaapp.model.rest.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("person")
public class PersonController implements BasicController<PersonRequest, PersonResponse> {

    @Autowired
    private PersonDAO personDAO;

    @Override
    @ResponseBody
    @GetMapping("getAll")
    public List<PersonResponse> getAll() {
        List<Person> result = personDAO.getAll();
        List<PersonResponse> responseList = new LinkedList<>();

        for (Person p : result) {
            responseList.add(new PersonResponse(
                    p.getId(),
                    p.getUsername(),
                    p.getPassword(),
                    p.getRole()
            ));
        }

        return responseList;
    }

    @Override
    @ResponseBody
    @GetMapping("get/{id}")
    public PersonResponse getById(@PathVariable("id") int id) {
        Person result = personDAO.getById(id);
        PersonResponse response = new PersonResponse(
                result.getId(),
                result.getUsername(),
                result.getPassword(),
                result.getRole()
        );

        return response;
    }

    @ResponseBody
    @GetMapping("getUser/{username}")
    public PersonResponse getById(@PathVariable("username") String username) {
        Person result = personDAO.getByUsername(username);

        // if the person is not found
        if (result == null) return
            new PersonResponse(
                    -1, null, null, null
            );

        PersonResponse response = new PersonResponse(
                result.getId(),
                result.getUsername(),
                result.getPassword(),
                result.getRole()
        );

        return response;
    }

    // update
    @Override
    @ResponseBody
    @PutMapping("put/{id}")
    public PersonResponse put(@PathVariable("id") int id, @RequestBody PersonRequest entity) {
        Person person = new Person();

        person.setUsername(entity.getUsername());
        person.setPassword(entity.getPassword());
        person.setRole(entity.getRole());

        personDAO.update(id, person);

        PersonResponse response = new PersonResponse();
        response.setUsername(person.getUsername());
        response.setPassword(person.getPassword());
        response.setRole(person.getRole());

        return response;
    }

    @Override
    @ResponseBody
    @PostMapping("add")
    public PersonResponse post(@RequestBody PersonRequest entity) {
        Person person = new Person();
        person.setUsername(entity.getUsername());
        person.setPassword(entity.getPassword());
        person.setRole(entity.getRole());

        personDAO.create(person);

        PersonResponse response = new PersonResponse(
                person.getId(),
                person.getUsername(),
                person.getPassword(),
                person.getRole()
        );

        return response;
    }

    @Override
    @ResponseBody
    @DeleteMapping("delete/{id}")
    public PersonResponse delete(@PathVariable("id") int id) {
        Person result = personDAO.delete(id);

        return new PersonResponse(
                result.getId(),
                result.getUsername(),
                result.getPassword(),
                result.getRole()
        );
    }
}
