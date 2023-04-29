package unibs;

import java.util.Random;

/**
 * @author saleri giorgio
 */
public class RandomGenerator {

    private static final Random random = new Random();
    private RandomGenerator() {
    }

    /**
     * Generate a pseudorandom character between [a-z]
     * @return char
     */
    public static char generateChar() {
        return (char) (random.nextInt(0, 25) + 97);
    }

}
