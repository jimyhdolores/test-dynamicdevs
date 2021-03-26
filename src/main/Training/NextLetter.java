/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.Training;

/**
 *
 * @author Jimy Joaquin Huacho Dolores
 */
public class NextLetter {

    private static final int RANGE_START_MAYUS = 65;
    private static final int RANGE_END_MAYUS = 90;

    private static final int RANGE_START_MIN = 97;
    private static final int RANGE_END_MIN = 122;

    public String nextLetter(String text) {

        if (isStringEmpty(text)) {
            return "TEXT IS EMPTY";
        }

        if (!existLetter(text)) {
            return text;
        }

        String returnText = "";
        for (char character : text.toCharArray()) {
            int ascii = character;
            if (Character.isLetter(character) && isValidRangeASCII(ascii)) {
                returnText = returnText + getNextLetter(character, ascii);
            } else {
                returnText = returnText + character;
            }
        }

        return returnText;
    }

    /**
     * Para internacionalizar Los métodos Character se basan en el estándar
     * Unicode para determinar las propiedades de un carácter; Unicode es una
     * codificación de caracteres de 16 bits que admite los principales idiomas
     * del mundo
     *
     * @param text
     * @return
     */
    public String nextLetterInternational(String text) {
        if (isStringEmpty(text)) {
            return text;
        }

        String returnText = "";
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {

                char nextValue = (char) (character + 1);
                returnText = returnText + nextValue;
            } else {
                returnText = returnText + character;
            }
        }

        return returnText;
    }

    private boolean isStringEmpty(String string) {
        return string == null || string.trim().length() == 0;
    }

    /**
     * Esta función se encargara de retornar el valor siguientes de la letra
     * ademas de verificar si el caracter es una "Z" mayúscula o minúscula a
     * travez de su codigo ASCII; en caso sea una "Z" el valor siguiente tiene
     * que ser un "A" ó "a"
     *
     * @param character
     * @return
     */
    private char getNextLetter(char character, int asciiValue) {
        char nextValue = (char) (character + 1);
        if (asciiValue == RANGE_END_MAYUS || asciiValue == RANGE_END_MIN) {
            nextValue = Character.isLowerCase(character) ? (char) RANGE_START_MIN : (char) RANGE_START_MAYUS;
        }
        return nextValue;
    }

    public static boolean existLetter(String input) {
        long c = input.toLowerCase().chars()
                .filter(ch -> isValidRangeASCII(ch))
                .distinct()
                .count();
        return c > 0;
    }

    private static boolean isValidRangeASCII(int codeAscii) {
        return (codeAscii >= RANGE_START_MAYUS && codeAscii <= RANGE_END_MAYUS) || (codeAscii >= RANGE_START_MIN && codeAscii <= RANGE_END_MIN);
    }
}
