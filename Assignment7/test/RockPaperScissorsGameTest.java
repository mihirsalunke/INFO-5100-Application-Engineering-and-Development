import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RockPaperScissorsGameTest {
    private Rock rock;
    private Paper paper;
    private Scissors scissors;

    @Before
    public void init() {
        rock = new Rock(15);
        paper = new Paper(7);
        scissors = new Scissors(5);
    }

    @Test
    public void fightTest() {
        assertTrue(scissors.fight(paper));
        assertFalse(paper.fight(scissors));
        assertFalse(paper.fight(rock));
        assertTrue(rock.fight(paper));
        assertTrue(rock.fight(scissors));
        assertFalse(scissors.fight(rock));
    }
}
