package com.manroid.examplemvp.interfaces;

import com.manroid.examplemvp.model.entity.User;

/**
 * Created by manro on 29/09/2017.
 */

public interface MainAction {

    void getData();

    void deleteUser();

    User getUser();

}
