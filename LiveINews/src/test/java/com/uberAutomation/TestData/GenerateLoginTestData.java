package com.uberAutomation.TestData;

import java.util.Random;

public class GenerateLoginTestData {

    public Integer accountType;
    public String email;
    public String password;
    public String accountName;
    public String firstName;
    public String lastName;
    public String address;
    public String phone;
    public Integer country;
    public Integer state;
    public Integer city;
    public String zipCode;
    public String paypal;

    public GenerateLoginTestData(){

        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String candidateChars1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        String candidateChars2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";

        String candidateChars3 = "1234567890";
        String candidateChars4 = "abcdefghijklmnopqrstuvwxyz1234567890";
        //System.out.println(generateRandomChars(candidateChars1, 17));

        accountName = randomAlphabetic(candidateChars2,5);
        firstName = randomAlphabetic(candidateChars2,5);
        lastName = randomAlphabetic(candidateChars2,5);
        address = randomAlphabetic(candidateChars1,15);
        password = randomAlphabetic(candidateChars1,6);
        email = randomAlphabetic(candidateChars4,5) + "@getnada.com";
        phone = randomAlphabetic(candidateChars4,20);
        zipCode = randomAlphabetic(candidateChars3,5) ;
        paypal = randomAlphabetic(candidateChars4,5) + "@getnada.com";

        accountType = Integer.parseInt(randomAlphabetic("1234",1));
        country = Integer.parseInt(randomAlphabetic("1234",1));
        state = Integer.parseInt(randomAlphabetic("1234",1));
        city = Integer.parseInt(randomAlphabetic("1234",1));

        System.out.println("accountName " + accountName);
        System.out.println("firstName  " + firstName   );
        System.out.println("lastName   " + lastName    );
        System.out.println("address    " + address     );
        System.out.println("password   " + password    );
        System.out.println("email      " + email       );
        System.out.println("phone      " + phone       );
        System.out.println("zipCode    " + zipCode     );
        System.out.println("paypal     " + paypal      );
        System.out.println("accountType " + accountType);
        System.out.println("country    " + country     );
        System.out.println("state      " + state       );
        System.out.println("city       " + city        );

    }
    public static  String generateRandomChars(String candidateChars1,int inum){


        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < inum; i++) {
            sb.append(candidateChars1.charAt(random.nextInt(candidateChars1
                    .length())));
        }
        return sb.toString();


    }
    public static  String randomAlphabetic(String candidateChars1,int inum){

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < inum; i++) {
            sb.append(candidateChars1.charAt(random.nextInt(candidateChars1
                    .length())));
        }
        return sb.toString();

    }

}

