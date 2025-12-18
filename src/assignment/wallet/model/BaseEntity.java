package assignment.wallet.model;


import java.time.LocalDateTime;


public abstract class BaseEntity {
    protected final long id;
    protected final LocalDateTime createdAt;


    protected BaseEntity(long id) {
        this.id = id;
        this.createdAt = LocalDateTime.now();
    }


    public long getId() {
        return id;
    }
}
