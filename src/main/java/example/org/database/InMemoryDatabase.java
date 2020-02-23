package example.org.database;

import example.org.model.Program;

import java.util.HashMap;

public class InMemoryDatabase {

    private static HashMap<String, HashMap<Long, Object>> db = new HashMap<>();

    private static HashMap<Long, Program> programDb = new HashMap<>();

    public static HashMap<Long, Object> getDB(String name) {
        return db.computeIfAbsent(name, k -> new HashMap<>());
    }

    public static HashMap<Long, Program> getProgramDB() {
        return programDb;
    }
}
