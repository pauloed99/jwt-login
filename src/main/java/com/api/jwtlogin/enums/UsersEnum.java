package com.api.jwtlogin.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UsersEnum {
    USER_NOT_FOUND_EXCEPTION("User not found!"),
    USER_EMAIL_ALREADY_USED_EXCEPTION("The email is already used by other user");

    private final String message;
}
