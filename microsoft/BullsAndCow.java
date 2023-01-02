package com.anshuman;

public class BullsAndCow {
    public String getHint(String secret, String guess) {
        int bulls = 0 ;
        int cows =  0 ;

        int[] secratefeq= new int[10];
        int[] guessfeq= new  int[10];
        // now we have to itrate for the  bulls
        for (int i = 0; i < secret.length() ; i++) {
            if (secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }
            else {
                // find the frequency for both of the  string and
                secratefeq[secret.charAt(i) - '0']++;
                guessfeq[guess.charAt(i)-'0']++;
            }
        }

        // now we have find for cows

        for (int i = 0; i < 10; i++) {
            cows += Math.min(secratefeq[i] , guessfeq[i]);


        }

        return bulls + "A"+cows + "B";


    }
}
