package org.factory;

import org.bean.User;

public class UserFactory {
    public static User createUser() {
        return new User();
    }
    public User createUser2(){
        return new User();
    }
}
