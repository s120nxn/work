package com.work;

import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请选择功能：");//测试1
            System.out.println("1. 加密");
            System.out.println("2. 解密");
            System.out.println("3. 检查密码强度");
            System.out.println("4. 生成随机密码");
            System.out.println("5. 退出");

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
                    System.out.println("请输入要检查强度的密码：");
                    String passwordToCheck = scanner.nextLine();
                    int strength = checkPasswordStrength(passwordToCheck);
                    System.out.println("密码强度： " + strength);
                    break;
                case 4:
                    System.out.println("生成的随机密码：" + generateRandomPassword());
                    break;
                case 5:
                    System.out.println("已退出。");
                    System.exit(0);
                default:
                    System.out.println("无效的选择。");
            }
        }
    }

    public static String encryptPassword(String password) {
        return password;// 加密逻辑不变
    }

    public static String decryptPassword(String encryptedPassword) {
        return encryptedPassword;// 解密逻辑不变
    }

    public static int checkPasswordStrength(String password) {
        int length = password.length();
        if (length < 8) {
            return 1; // 弱密码
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (isSpecialCharacter(c)) {
                hasSpecialChar = true;
            }
        }

        int strength = 0;
        if (hasUpperCase) strength++;
        if (hasLowerCase) strength++;
        if (hasDigit) strength++;
        if (hasSpecialChar) strength++;

        return strength;
    }

    private static boolean isSpecialCharacter(char c) {
        // 添加您认为是特殊字符的逻辑
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";
        return specialCharacters.contains(String.valueOf(c));
    }

    public static String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 12; i++) { // 生成12位随机密码
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
}