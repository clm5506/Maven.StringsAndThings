package io.zipcoder;

import java.util.ArrayList;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){

        int counter = 0;

        //change the String input provided as an argument into a String[]
        String[] inputToArray = input.toLowerCase().split(" ");

        //for each loop iterating through the String[] created above
        for(String str : inputToArray) {
            //get the last char in the String str variable
            char lastChar = str.charAt((str.length()-1));
            //if the lastChar variable is equal
            if(lastChar == 'z'|| lastChar == 'y'){
            //then increment the counter
            counter++;

            }
        }

        return counter;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){

        return base.replace(remove,"");
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {

        String is = "is";
        String not = "not";

        input = input.toLowerCase();

        int countOfIs = calculateCountOfString(input, is);
        int countOfNot = calculateCountOfString(input, not);

        return countOfIs==countOfNot;

    }

    private int calculateCountOfString(String input, String word) {

        StringBuilder strBuilder = new StringBuilder(input);

        int wordCounter = 0;

        int index = strBuilder.indexOf(word);

        while (true) {

            if (index == -1) {
                break;

            } else {
              index = strBuilder.indexOf(word, index + word.length());
                wordCounter++;

            }
        }  return wordCounter;

    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        boolean myBool = false;
        input = input.toLowerCase();

        StringBuilder striBuilder = new StringBuilder(input);

        int index = striBuilder.indexOf("gg");
        if(index == -1) {
            return false;
        } else {
            return true;
        }

    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){

        //make all letters in put lowercase
        input = input.toLowerCase();

        String[] inputArray = input.split("");

        String previousValue = inputArray[0];

        int counter = 0;
        int tripletCounter = 0;


            for (int i = 1; i < inputArray.length-1; i++) {
                counter++;

                if (previousValue.equals(inputArray[i]) && previousValue.equals(inputArray[i + 1])) {
                    previousValue = inputArray[i];
                    System.out.println(counter);
                    tripletCounter++;
                }  else {
                    previousValue = inputArray[i];
                    }
                }
                       return tripletCounter;
            }





}
