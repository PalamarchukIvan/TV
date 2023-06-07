package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Task task = new Task(
                List.of(-2,
                        1,
                        -1,
                        5,
                        5,
                        1,
                        3,
                        -2,
                        3,
                        4,
                        2,
                        -2,
                        -2,
                        4,
                        -2,
                        -2,
                        2,
                        0,
                        -1,
                        -1,
                        -1,
                        3,
                        4,
                        -1,
                        2,
                        0,
                        1,
                        -1,
                        2,
                        5,
                        4,
                        2,
                        -1,
                        5,
                        1,
                        -1,
                        2,
                        3,
                        -1,
                        1,
                        5,
                        3,
                        2,
                        -1,
                        -1,
                        -1,
                        -2,
                        2,
                        -2,
                        2
                )
        );
        System.err.println(task.showEverythingBefore8());
        System.err.println(task.showColumn3()); // из этих значений делаешь четвертую колонку
                                                // потом запускаешь прогу заного, и заливаешь эти значения как параметры в initTask8()
//        task.initTask8(List.of(
//                -0.5,
//                -0.3599,
//                -0.2422,
//                -0.0871,
//                0.0832,
//                0.2389,
//                0.3554,
//                0.4332,
//                0.5
//        ));
//        System.err.println(task.showLastTasks()); //это все задания
    }
}