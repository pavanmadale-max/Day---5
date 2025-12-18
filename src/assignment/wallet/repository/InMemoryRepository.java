package assignment.wallet.repository;


import assignment.wallet.model.BaseEntity;
import java.util.*;


public class InMemoryRepository<T extends BaseEntity>
        implements Repository<T> {


    private final Map<Long, T> store = new HashMap<>();


    @Override
    public void save(T entity) {
        store.put(entity.getId(), entity);
    }


    @Override
    public Optional<T> findById(long id) {
        return Optional.ofNullable(store.get(id));
    }


    @Override
    public List<T> findAll() {
        return new ArrayList<>(store.values());
    }
}