package MVC.model;

public interface Model {
    ModelData getModelData();

    void loadUsers();

    void loadDeletedUsers();

    void loadUserById(long userId);

    public void deleteUserById(long id);

    public void changeUserData(String name, long id, int level);
}