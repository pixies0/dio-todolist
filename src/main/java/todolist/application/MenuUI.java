package todolist.application;

import todolist.dto.TaskDTO;
import todolist.entity.Task;
import todolist.service.TaskService;

import java.util.List;
import java.util.Scanner;

public class MenuUI {
    private final TaskService service;
    private final Scanner scanner;

    public MenuUI() {
        service = new TaskService();
        scanner = new Scanner(System.in);
    }

    public void show() {
        while (true) {
            System.out.println("\n📋 TODO LIST MENU:");
            System.out.println("1. Criar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Concluir tarefa");
            System.out.println("4. Remover tarefa");
            System.out.println("0. Sair");

            switch (scanner.nextLine()) {
                case "1" -> createTask();
                case "2" -> listTasks();
                case "3" -> completeTask();
                case "4" -> deleteTask();
                case "0" -> {
                    System.out.println("👋 Até logo!");
                    return;
                }
                default -> System.out.println("❌ Opção inválida");
            }
        }
    }

    private void createTask() {
        System.out.print("Título: ");
        String title = scanner.nextLine();
        System.out.print("Descrição: ");
        String desc = scanner.nextLine();
        service.createFromDTO(new TaskDTO(title, desc));
        System.out.println("✔️ Tarefa criada.");
    }

    private void listTasks() {
        List<Task> tasks = service.getAll();
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        } else {
            tasks.forEach(t -> System.out.printf("[%d] %s - %s (%s)%n",
                    t.getId(), t.getTitle(), t.getDescription(),
                    t.isCompleted() ? "Concluída" : "Pendente"));
        }
    }

    private void completeTask() {
        System.out.print("ID da tarefa para concluir: ");
        int id = Integer.parseInt(scanner.nextLine());
        service.complete(id);
        System.out.println("✔️ Tarefa concluída.");
    }

    private void deleteTask() {
        System.out.print("ID da tarefa para remover: ");
        int id = Integer.parseInt(scanner.nextLine());
        service.delete(id);
        System.out.println("🗑️ Tarefa removida.");
    }
}
