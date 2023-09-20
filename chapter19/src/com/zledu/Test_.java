package com.zledu;

/**
 * @author Alonso
 */
public class Test_ {
    public static void main(String[] args) {
        BufferedReader_ bufferedReader_1 = new BufferedReader_(new FileReader_());
        //bufferedReader_1.readFile(10);
        bufferedReader_1.readFile();

        BufferedReader_ bufferedReader_2 = new BufferedReader_(new StringReader_());
        bufferedReader_2.readString(8);
    }
}
