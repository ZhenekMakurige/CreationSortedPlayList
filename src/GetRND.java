
public class GetRND {
   public static int GetRandom(int max)
    {
        final int min = 1;
        max -= min;
        final int rnd = rnd(min, max);

        return (int) (Math.random() * ++max) + min;
    }

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
