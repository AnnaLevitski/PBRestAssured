package com.core.providers;

import java.util.Random;

public class TestDataGenerator {
    static String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur porta pellentesque diam, id cursus libero sodales pharetra. Sed sagittis maximus nulla, vitae eleifend nulla varius ac. Quisque libero augue, volutpat ac pretium vitae, auctor non risus. Fusce et odio et augue aliquam scelerisque eu quis tortor. Morbi tempor, ex in dapibus cursus, quam neque accumsan velit, sed rhoncus ante nisl at magna. Sed facilisis ipsum vitae velit efficitur, in sodales est aliquet. Etiam nec dictum lectus, in imperdiet augue. Nulla vestibulum rhoncus euismod. Pellentesque quis lacinia dolor, vitae tincidunt lacus. Proin at justo lectus. Suspendisse fermentum ornare mi facilisis molestie. Curabitur efficitur dui congue pretium rhoncus. Quisque sed dui vel ante eleifend dapibus. Etiam id dignissim purus, auctor faucibus ligula. Etiam consectetur condimentum congue.";
    public static String randomBreedOfDog() {
        String[] arrayBreed = {"Affenpinscher", "Afghan Hound", "Africanis", "Aidi", "Akita",
                "Boxer", "Boykin Spaniel", "Bracco Italiano"};
        return arrayBreed[new Random().nextInt(arrayBreed.length)];
    }

    public static String randomBreedOfCat() {
        String[] arrayBreed = {"Abyssinian", "Birman", "Egyptian Mau", "Korat",
                "Norwegian Forest Cat", "Russian Blue", "Persian Traditional"};
        return arrayBreed[new Random().nextInt(arrayBreed.length)];
    }

    public static String randomColor() {
        String[] array = {"red", "white", "black", "green",
                "yellow", "blue", "gray"};
        return array[new Random().nextInt(array.length)];
    }
    public static String randomName() {
        String[] array = {"Lana", "Dana", "Rona", "Georg",
                "Nona", "Rada", "Fania", "Ron", "Scooby", "Andy"};
        return array[new Random().nextInt(array.length)];
    }
    public static String randomEmail() {
        return randomName().toLowerCase()+"@gmail.com";
    }
    public static String randomPassword() {
        String[] array = {"!", "@", "#", "$",
                "%", "^", "&", "(", ")", "}", "]", "|"
                , "''", ":", "/", ">", "~", "±", "+", "_"};

        return randomName()+(new Random().nextInt(90000)+10000)+""+array[new Random().nextInt(array.length)];
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

    public static String[] randomTags(){
        String[] arr = {randomBreedOfDog(), randomBreedOfCat(), randomColor(), randomName()};
        return arr;
    }

    public static String randomLocation() {
        String[] array = {"Israel National Trail, Hadera, Israel", "King George St, Jerusalem, Israel", "Levinski St, Tel Aviv-Yafo, Israel", "Ben Yehuda St, Tel Aviv-Yafo, Israel",
                "Frug St, Tel Aviv-Yafo, Israel", "Golda Me'ir St, Holon, Israel", "Khevron St, Tel Aviv-Yafo, Israel"};
        return array[new Random().nextInt(array.length)];
    }
    public static String randomPhone() {
        return new Random().nextInt(900000000)+1000000000+ "";
    }







    private static char randomChar() {
        return (char) ('a' + Math.random() * ('z' - 'a') + 1);
    }
}
