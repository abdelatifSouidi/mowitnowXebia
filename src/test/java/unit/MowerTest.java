package unit;

import com.xebia.casestudy.Lawn;
import com.xebia.casestudy.Location;
import com.xebia.casestudy.Mower;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MowerTest {
    private Lawn  lawn;
    private Location initPosition1;
    private Location initPosition2;
    private Location initPosition3;
    private Mower mower1;
    private Mower mower2;
    private Mower mower3;
    private Mower mower4;
    private Location initPosition4;

    @Before
    public void init (){
        lawn = new Lawn(new Location(5,5,"N"));
        initPosition1 = new Location(1, 2,"N");
        initPosition2 = new Location(1, 2,"E");
        initPosition3= new Location(1, 2,"S");
        initPosition4= new Location(3, 3,"E");
        mower1 = new Mower(initPosition1);
        mower2 = new Mower(initPosition2);
        mower3 = new Mower(initPosition3);
        mower4 = new Mower(initPosition4);
    }

    @Test
    public void shouldCheckIfLawnExist(){
        assertFalse(lawn.equals(new Lawn(new Location(0,0," "))));
    }

    @Test
    public void shouldReturnSamePositionIfDoesntMove(){
        assertEquals(initPosition1, mower1.move("",lawn));
    }

    @Test
    public void shouldMowerMoveUpAfterReadingInstructionAIfOrientationIsNorth(){
        assertEquals(new Location(1, 3,"N"), mower1.move("A",lawn));
    }

    @Test
    public void shouldMowerMoveDownAfterReadingInstructionAifOrientationIsSouth(){
        assertEquals(new Location(1, 1,"S"), mower3.move("A",lawn));
    }

    @Test
    public void shouldMowerMoveRigthAfterReadingInstructionAifOrientationIsEast(){
        assertEquals(new Location(2, 2,"E"), mower2.move("A",lawn));
    }

    @Test
    public void shouldOrientionBeWestIfInstructionIsGAndOrientionIsNorth(){
        assertEquals(new Location(1, 2,"W"), mower1.move("G",lawn));
    }

    @Test
    public void shouldOrientionBeEastIfInstructionIsDAndOrientionIsNorth(){
        assertEquals(new Location(1, 2,"E"), mower1.move("D",lawn));
    }

    @Test
    public void shouldOrientionBeSouthIfInstructionIsDAndOrientionIsEast(){
        assertEquals(new Location(1, 2,"S"), mower2.move("D",lawn));
    }

   @Test
    public void shouldTurnLeftAndAdvanceIfInstructionsAreGandA (){
        assertEquals(new Location(1, 3,"N"), mower2.move("G A",lawn));
    }

    @Test
    public void shouldExecuteAllInstructionIfPassedSomeInstructionsAandGetFinalPosition (){
        assertEquals(new Location(1, 3,"N"), mower1.move(" GAG  AGAGAA  ",lawn));
    }
    @Test
    public void shouldExecuteAllInstructionIfPassedSomeInstructionsAndGetFinalPosition2 (){
        assertEquals(new Location(5, 1,"E"), mower4.move("  AADAADADDA  ",lawn));
    }

    @Test
    public void shouldNotExecuteInstructionsIfWillBeOutOfLawn (){
        assertEquals(new Location(5, 1,"E"), mower4.move("AAAADAAAAAADADADA  ",lawn));
    }
}
