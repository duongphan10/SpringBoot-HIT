package com.example.buoi3_btvn.store;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static List<User> users = new ArrayList<>();
    static {
        users.add(new User("phan", "phan123", "Phan Van Duong"));
        users.add(new User("dao", "dao123", "Dao Van A"));
        users.add(new User("tran", "tran123", "Tran Thi B"));
    }
    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        Store.users = users;
    }
}
