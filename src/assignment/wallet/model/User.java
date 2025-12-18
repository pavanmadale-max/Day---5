package assignment.wallet.model;


public class User extends BaseEntity {


    private final String name;


    public User(long id, String name) {
        super(id);
        this.name = name;
    }


    public String getName() {
        return name;
    }
}