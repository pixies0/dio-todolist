package todolist.application;

import todolist.config.ConnectionConfig;
import todolist.migrations.MigrationStrategy;

public class Main {
    public static void main(String[] args) {
        new MigrationStrategy(ConnectionConfig.getConnection()).executeMigration();
        new MenuUI().show();
    }
}
