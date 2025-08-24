package todolist.dao;

import todolist.exceptions.DatabaseException;
import todolist.config.ConnectionConfig;
import todolist.entity.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    public void insert(Task task) {
        String sql = "INSERT INTO tasks (title, description) VALUES (?, ?)";
        try (Connection conn = ConnectionConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.execute();
        } catch (SQLException e) {
            throw new DatabaseException("Erro ao inserir tarefa no banco de dados.", e);
        }
    }

    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";
        try (Connection conn = ConnectionConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                tasks.add(new Task(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getBoolean("completed")
                ));
            }
        } catch (SQLException e) {
              throw new DatabaseException("Erro ao buscar tarefas no banco de dados.", e);
        }
        return tasks;
    }

    public void delete(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (Connection conn = ConnectionConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new DatabaseException("Erro ao deletar a tarefa com ID: " + id, e);
        }
    }

    public void updateStatus(int id, boolean completed) {
        String sql = "UPDATE tasks SET completed = ? WHERE id = ?";
        try (Connection conn = ConnectionConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, completed);
            stmt.setInt(2, id);
            stmt.execute();
        } catch (SQLException e) {
             throw new DatabaseException("Erro ao atualizar o status da tarefa com ID: " + id, e);
        }
    }
}
