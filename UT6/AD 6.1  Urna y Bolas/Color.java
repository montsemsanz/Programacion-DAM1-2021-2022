import java.util.Random;

/**
 * Tipo enumerado
 * 
 */
public enum Color
{
    BLANCO, NEGRO;
    private static final Random random = new Random(); 
    public static Color getRandomColor() {
        return Color.values()[random.nextInt(Color.values().length)];
    }
}
