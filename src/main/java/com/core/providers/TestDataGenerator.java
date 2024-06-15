package com.core.providers;

import java.util.Random;

public class TestDataGenerator {
    static String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur porta pellentesque diam, id cursus libero sodales pharetra. Sed sagittis maximus nulla, vitae eleifend nulla varius ac. Quisque libero augue, volutpat ac pretium vitae, auctor non risus. Fusce et odio et augue aliquam scelerisque eu quis tortor. Morbi tempor, ex in dapibus cursus, quam neque accumsan velit, sed rhoncus ante nisl at magna. Sed facilisis ipsum vitae velit efficitur, in sodales est aliquet. Etiam nec dictum lectus, in imperdiet augue. Nulla vestibulum rhoncus euismod. Pellentesque quis lacinia dolor, vitae tincidunt lacus. Proin at justo lectus. Suspendisse fermentum ornare mi facilisis molestie. Curabitur efficitur dui congue pretium rhoncus. Quisque sed dui vel ante eleifend dapibus. Etiam id dignissim purus, auctor faucibus ligula. Etiam consectetur condimentum congue.";


    public static String randomColor() {
        String[] array = {"red", "white", "black", "green",
                "yellow", "blue", "gray"};
        return array[new Random().nextInt(array.length)];
    }
    public static String randomName() {
        String[] array = {"Lana", "Dana", "Rona", "Georg",
                "Nona", "Rada", "Fania", "Ron", "Scooby",
                "Andy", "Lora", "Hanna", "Kate", "Rita",
                "Sara-Maria", "Ron-Alex", "ReneDeLosan",
                "Don-Alperin", "Carl-Mark", "Gordan-Fox"};
        return array[new Random().nextInt(array.length)];
    }
    public static String randomLastName() {
        String[] array = {"Brown", "Black", "black", "Orange",
                "DeMopasan", "Don-Perignon", "Marxism-Leninism"};
        return array[new Random().nextInt(array.length)];
    }
    public static String randomEmail() {
        return randomName().toLowerCase()+"@gmail.com";
    }
    public static String randomEmailWrong() {
        String[] array = {randomName().toLowerCase()+"@gmailcom",
                randomName().toLowerCase()+"gmail.com",
                randomName().toLowerCase()+"@gmail.c"};
        return array[new Random().nextInt(array.length)];
    }
    public static String randomEmailWrongAT() {
        return randomName().toLowerCase()+"gmail.com";
    }
    public static String randomPassword() {
        String[] array = { "$", "@"};
        return randomName()+(new Random().nextInt(9000))+""+randomName()+array[new Random().nextInt(array.length)];
    }
    public static String randomPasswordWrong() {
        String[] array = {"!", "#", "%", "^", "&",
                "(", ")", "}", "]", "|", "''",
                ":", "/", ">", "±", "+"};
        String[] array2 = {randomName()+(new Random().nextInt(90000)+10000)+""+array[new Random().nextInt(array.length)],
                randomName().toLowerCase()+(new Random().nextInt(90000)+10000)+"$",
                randomName()+"$", "N"+(new Random().nextInt(90000)+10000)+"$"};
        return array2[new Random().nextInt(array2.length)];
    }



    public static String randomString(int strLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strLength; i++) {
            stringBuilder.append(randomChar());
        }
        return stringBuilder.toString();
    }
    public static String randomText(){
        return loremIpsum.substring(0, new Random().nextInt(loremIpsum.length()-1));
    }


    public static String randomLocation() {
        String[] array = {"National Trail, Hadera, Israel", "Colorado, USA", randomPhone()+" London", "+UN "+ randomPhone(), "USA"};
        return array[new Random().nextInt(array.length)];
    }
    public static String randomPhone() {
        return new Random().nextInt(900000000)+1000000000+ "";
    }
    public static String randomPhoneWrong() {
        String[] array = {new Random().nextInt(900)+1000+ "",
                randomName().toLowerCase()+"gmail.com",
                (new Random().nextInt(900000000))+"1000000000000000", ""};
        return array[new Random().nextInt(array.length)];
    }







    private static char randomChar() {
        return (char) ('a' + Math.random() * ('z' - 'a') + 1);
    }

    public int randomInt(){
        return new Random().nextInt(100000);
    }
}
