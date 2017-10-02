package com.manroid.examplemvp.model;

import com.manroid.examplemvp.model.entity.User;

import java.util.ArrayList;

/**
 * Created by manro on 29/09/2017.
 */

public class DataManager {

    private ArrayList<User> listUser;

    public DataManager() {
        listUser = new ArrayList<>();
    }

    public ArrayList<User> initListUser() {
        for (int i = 0; i < 100; i++) {
            listUser.add(new User("Jack Staham " + i , "USA " + i));
        }

        return listUser;
    }


    public ArrayList<User> getNoteList() {
        return this.listUser;
    }


    public User getNoteAt(int position) {
        return listUser.get(position);
    }


    public void deleteUser(int position){
        listUser.remove(position);
    }


}
