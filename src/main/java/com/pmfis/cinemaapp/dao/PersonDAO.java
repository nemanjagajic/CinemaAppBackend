package com.pmfis.cinemaapp.dao;

import com.pmfis.cinemaapp.model.persistence.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class PersonDAO implements BasicDAO<Person> {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Person> getAll() {
        String hql = "FROM Person p ORDER BY p.id";

        return (List<Person>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Person getById(int id) {
        Person person = entityManager.find(Person.class, id);

        if (person != null) {
            return person;
        } else {
            throw new IllegalArgumentException("Person with the given id doesn't exist");
        }
    }

    public Person getByUsername(String username) {
        String hql = "FROM Person p WHERE p.username= :user";

        List<Person> persons = (List<Person>) entityManager.createQuery(hql).setParameter("user", username).getResultList();

        if (persons.size() == 0)
            return null;

        return persons.get(0);
    }

    @Override
    public Person create(Person entity) {
        entityManager.persist(entity);
        entityManager.flush();
        return entity;
    }

    @Override
    public Person update(int id, Person entity) {
        Person person = getById(id);
        person.setUsername(entity.getUsername());
        person.setPassword(entity.getPassword());
        person.setRole(entity.getRole());
        entityManager.flush();

        return person;
    }

    @Override
    public Person delete(int id) {
        Person person = getById(id);
        entityManager.remove(person);
        entityManager.flush();
        return person;
    }
}
