package com.example.examsystem.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeUtil {

    private boolean ok_change;

    public static ChangeUtil ok() {
        return new ChangeUtil(true);
    }

    public static ChangeUtil fail() {
        return new ChangeUtil(false);
    }
}
