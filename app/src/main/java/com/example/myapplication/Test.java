package com.example.myapplication;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Test {
    public static Thread t1;
    public static Thread t2;

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt());
        System.out.println();

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("11");
//            }
//        });2147483647
//        t1.start();
//        int n = Integer.MAX_VALUE;
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MAX_VALUE/60);
//        System.out.println(Integer.MAX_VALUE/60/60);
//        System.out.println(Integer.MAX_VALUE/60/60/24);
//        System.out.println(60*60*24);

//        save("我是内容qq");

        t1 = new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 100000; i++) {
                    if (i % 200 == 0) {
                        System.out.println("---");
                    }
                }

            }
        };
        t2 = new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1 " + t1);
                    System.out.println("t1 " + t1.isAlive());
                }
            }
        };
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();

    }

    //保存数据
    private static void save(String content) {
        FileOutputStream fileOutputStream = null;
        try {
            File dir = new File(".", "cxm");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, "test.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);

            //写入内容
            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
