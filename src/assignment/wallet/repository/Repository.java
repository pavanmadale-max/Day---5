package assignment.wallet.repository;


import assignment.wallet.model.BaseEntity;
import java.util.*;


public interface Repository<T extends BaseEntity> {
    void save(T entity);
    Optional<T> findById(long id);
    List<T> findAll();
}