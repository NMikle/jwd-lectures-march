package com.epam.jwd.lectures.dao.api;

import com.epam.jwd.lectures.model.AppUser;

import java.util.Optional;

public interface AppUserDao extends Dao<AppUser> {

    Optional<AppUser> findUserByName(String name);

}
