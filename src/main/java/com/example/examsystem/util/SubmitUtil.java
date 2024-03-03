package com.example.examsystem.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmitUtil {
    private boolean ok_submit;

    public static SubmitUtil ok() {
        return new SubmitUtil(true);
    }

    public static SubmitUtil fail() {
        return new SubmitUtil(false);
    }
}
