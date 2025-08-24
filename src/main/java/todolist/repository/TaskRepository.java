package todolist.repository;

import todolist.entity.Task;
import java.util.List;

public interface TaskRepository {
    void create(Task task);
    List<Task> getAll();
    void delete(int id);
    void complete(int id);
}
