package by.maiseyeu.webkassa.repository;

import java.util.List;

public interface BaseDAO<I,E> {

    void save(E e);
    void update(E e);
    void delete(E e);
    E getById(I id);
    List<E> getAll();

}
