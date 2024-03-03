package com.example.examsystem.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DelUtil {
    private boolean ok_del;

    public static DelUtil ok() {
        return new DelUtil(true);
    }

    public static DelUtil fail() {
        return new DelUtil(false);
    }
}
