package com.zipcodewilmington;
import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for(String s : array) {
           if (s.equals(value))
               return true;
       }
               return false;
           }

            /*   int counter=0;
    for(int i=0 ;i < array.length ;i++)
    {
        if(array[i].contains(value))
            counter++;
    }
    return counter==0 ? false:true;
    for (String s : array) {
        if (s == value) {
            return true;
        }
    }
    return false;
}

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        for(int i = 0; i<array.length/2; i++){
            String temp = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = temp;
        }
        return array;
        }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
   public static boolean isPalindromic(String[] array) {
   for (int i = 0; i<array.length; i++) {
       if (!array[i].equals(array[array.length - 1 - i])) {
           return false;
       }
   }
   return true;
   }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        StringBuilder pangramic = new StringBuilder();
        for (String s : array) {
            pangramic.append(s);
        }
        for (char a = 'A'; a <= 'Z'; a++)
            if ((pangramic.indexOf(String.valueOf(a)) < 0) && (pangramic.indexOf(String.valueOf((char) (a + 32))) < 0)) {
                return false;
            }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int index = 0;
        for(String s : array) {
            if (s.equals(value))
                index++;
        }
        return index;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        int returnArraySize = array.length - getNumberOfOccurrences(array, valueToRemove);
        String[] answer = new String[returnArraySize];
        int counter = 0;
        for (String element : array) {
            if (!valueToRemove.equals(element)) {
                answer[counter] = element;
                counter++;
            }
        }
        return answer;
    }


    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        int dupCounter = 0;
        int offsetCounter = 0;

        for (int i = 0; i < array.length-1; i++) {
            if (array[i] == array[i + 1]) {
                dupCounter++;
            }// found dupes to determine size of new array
        }
        int returnArraySize = array.length - dupCounter;
        String[] arrMinusDup = new String[returnArraySize]; // new array - dupCounter

        for (int i = 0; i < array.length; i++) {
            if (i < array.length-1 && array[i] == array[i + 1]) {
                offsetCounter++;
            } else {
                arrMinusDup[i-offsetCounter] = array[i];
            }
            // 2nd for loop fills new array, if is/not dupe, do sth
        }
        for(String s : arrMinusDup){
            System.out.println(s);
        }
        return arrMinusDup;
    }
        /* removing things from array or adding, first step = figure out size of new array
        check if not at end of array and if next character is the same as i iterate thru
        if i come across duplicate in array, skip it in old array and keep my place in new array when i fill it
        separate counter to store duplicates
        iterate thru array and count amt of duplicates, make new array with size of original - duplicates
        make new array - duplicat counter
        2 counters, 1 for holding the place of where i am in the array
        2nd for loop to fill array uses separate counter

         */



    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        int dupCounter = 0;
        int offsetCounter = 0;
        int dupOffsetCounter = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                dupCounter++;
            }// found dupes to determine size of new String array
        }
        int returnArraySize = array.length - dupCounter;
        String[] newArr = new String[returnArraySize];

        for (int i = 0; i < array.length; i++) {
            if (i != 0 && array[i] == array[i - 1]) {
                dupOffsetCounter++;
                newArr[i-offsetCounter-dupOffsetCounter] += array[i]; // if not beginning of array and val at previous element = current element
            } else {
                offsetCounter += dupOffsetCounter;
                dupOffsetCounter = 0;
                newArr[i-offsetCounter] = array[i];
            }

            }

            return newArr;
        }
    }

    //offset counter is to keep array lists at same index when you remove one from one it skips to the next index, but you don't want it to do that inthe shorter array your making bc then you'll get an empty space

    //look for duplicate counters/offset
    // put duplicate elements together into one string

