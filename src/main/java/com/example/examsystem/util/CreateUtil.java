package com.example.examsystem.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUtil {

    private boolean ok_create;

    public static CreateUtil ok() {
        return new CreateUtil(true);
    }

    public static CreateUtil fail() {
        return new CreateUtil(false);
    }
}
