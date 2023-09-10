package com.work;

import java.util.Scanner;

public class PasswordManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请选择功能：");//挑选功能
            System.out.println("1. 加密");
            System.out.println("2. 解密");
            System.out.println("3. 退出");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("请输入要加密的密码：");
                    String passwordToEncrypt = scanner.nextLine();
                    String encryptedPassword = encryptPassword(passwordToEncrypt);
                    System.out.println("加密后的密码：" + encryptedPassword);
                    break;
                case 2:
                    System.out.println("请输入要解密的密码：");
                    String passwordToDecrypt = scanner.nextLine();
                    String decryptedPassword = decryptPassword(passwordToDecrypt);
                    System.out.println("解密后的密码：" + decryptedPassword);
                    break;
                case 3:
                    System.out.println("已退出。");
                    System.exit(0);
                default:
                    System.out.println("无效的选择。");
            }
        }
    }

    // 加密密码
    public static String encryptPassword(String password) {
        if (password == null || password.isEmpty()) {
            return "无效的密码";
        }

        StringBuilder encryptedPassword = new StringBuilder();

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            int asciiValue = (int) c + (i + 1) + 3;
            encryptedPassword.append((char) asciiValue);
        }

        // 调换第一位和最后一位的顺序
        if (encryptedPassword.length() > 1) {
            char firstChar = encryptedPassword.charAt(0);
            char lastChar = encryptedPassword.charAt(encryptedPassword.length() - 1);
            encryptedPassword.setCharAt(0, lastChar);
            encryptedPassword.setCharAt(encryptedPassword.length() - 1, firstChar);
        }

        // 反转字符串
        return encryptedPassword.reverse().toString();
    }

    // 解密密码
    public static String decryptPassword(String encryptedPassword) {
        if (encryptedPassword == null || encryptedPassword.isEmpty()) {
            return "无效的密码";
        }

        // 先反转字符串
        StringBuilder reversed = new StringBuilder(encryptedPassword).reverse();

        // 恢复第一位和最后一位的顺序
        if (reversed.length() > 1) {
            char firstChar = reversed.charAt(0);
            char lastChar = reversed.charAt(reversed.length() - 1);
            reversed.setCharAt(0, lastChar);
            reversed.setCharAt(reversed.length() - 1, firstChar);
        }

        StringBuilder decryptedPassword = new StringBuilder();

        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            int asciiValue = (int) c - (i + 1) - 3;
            decryptedPassword.append((char) asciiValue);
        }
        return decryptedPassword.toString();
    }
}
