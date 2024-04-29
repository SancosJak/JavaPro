package de.ait.demouser.repository;

import de.ait.demouser.models.User;

import java.util.List;

//CRUD - Create,Read,Update,Delete ( создать,получить,обновить,удалить)
public interface CrudRepository<T> {
    T findById(Long id);

    List<T> findAll();// получить все данные

    void save(T model); // cохранить обьект в хранилище
    void delete(T model);
    void update(T model);

    void deleteById(User userForDelete);
}