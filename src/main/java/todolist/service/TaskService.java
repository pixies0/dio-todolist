package todolist.service;

import todolist.dao.TaskDAO;
import todolist.dto.TaskDTO;
import todolist.entity.Task;
import todolist.repository.TaskRepository;

import java.util.List;

public class TaskService implements TaskRepository {
    private final TaskDAO dao;

    public TaskService() {
        this.dao = new TaskDAO();
    }

    @Override
    public void create(Task task) {
        dao.insert(task);
    }

    public void createFromDTO(TaskDTO dto) {
        dao.insert(new Task(dto.title, dto.description));
    }

    @Override
    public List<Task> getAll() {
        return dao.findAll();
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void complete(int id) {
        dao.updateStatus(id, true);
    }
}
