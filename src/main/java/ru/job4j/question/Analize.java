package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        Info result = new Info(0, 0, 0);
        int added = 0;
        int deleted = 0;
        int chanced = 0;
        if (previous.size() > current.size()) {
            deleted = previous.size() - current.size();
        }
        if (previous.size() < current.size()) {
            added = current.size() - previous.size();
        }
        Map<Integer, User> previosMap = new HashMap<>();
        for (User user : previous) {
            previosMap.put(user.getId(), user);
        }
        for (User user : current) {
            if (previosMap.containsKey(user.getId())) {
                if (!previosMap.get(user.getId()).equals(user)) {
                    chanced++;
                }
            } else {
                if (previous.size() == current.size()) {
                    added++;
                    deleted++;
                }
            }
        }
        result.setAdded(added);
        result.setDeleted(deleted);
        result.setChanged(chanced);
        return result;
    }
}
