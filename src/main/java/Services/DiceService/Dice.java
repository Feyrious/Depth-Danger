package Services.DiceService;

import java.util.Random;
import java.util.random.RandomGenerator;

public class Dice implements IRollable {

    private static Random rand = new Random();

    private int faces;

    public Dice(int faces) {
        this.faces = faces;
    }

    @Override
    public int Roll() {
        return rand.nextInt(1, faces + 1);
    }
}
