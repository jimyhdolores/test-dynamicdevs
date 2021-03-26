/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import main.Training.NextLetter;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jimy Joaquin Huacho Dolores
 */
public class NextLetterTest {

    private static NextLetter nextLetter;

    @BeforeClass
    public static void setUpClass() {
        nextLetter = new NextLetter();
    }

    /**
     * Validamos un caso valido
     */
    @Test
    public void testNextLetter() {
        assertEquals("123 bcde*3", nextLetter.nextLetter("123 abcd*3"));
    }

    /**
     * Validamos que las "Z" sean reemplazada por la letra "a"
     */
    @Test
    public void testChangeZ() {
        assertEquals("BCD AaaaAAA", nextLetter.nextLetter("ABC ZzzzZZZ"));
    }

    /**
     * Validamos que si se envia un texto vacio o nulo la función debe de
     * retornar el mensaje "TEXT IS EMPTY"
     */
    @Test
    public void testEmptyText() {
        assertEquals("TEXT IS EMPTY", nextLetter.nextLetter(null));
    }

    /**
     * Validamos quesi en valor enviado no contiene ninguna letra del abecedario
     * entonces retorne el mismo valor sin ninguna modificación
     */
    @Test
    public void notLetter() {
        assertEquals("***1256 +/*.", nextLetter.nextLetter("***1256 +/*."));
    }
}
