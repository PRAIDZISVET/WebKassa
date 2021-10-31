package by.maiseyeu.webkassa.service;

import java.util.List;

public interface ServiceDAO<I,E> {

    void save(E e);
    void update(E e);
    void delete(E e);
    E getById(I id);
    List<E> getAll();

}
