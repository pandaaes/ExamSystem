package com.example.examsystem.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUtil {
    private boolean can_login;

    public static LoginUtil ok() {
        return new LoginUtil(true);
    }

    public static LoginUtil fail() {
        return new LoginUtil(false);
    }
}
