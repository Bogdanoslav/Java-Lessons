package block_9.abstractClasses;

public abstract class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    abstract public void greet();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
