package org.service;


public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("save user");
    }

    @Override
    public void delete() {
        System.out.println("delete user");
    }

    @Override
    public void update() {
        System.out.println("update user");
    }

    @Override
    public void find() {
        System.out.println("find user");
    }
}
