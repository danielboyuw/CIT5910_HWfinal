import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class BattleshipGameTest {

    @Test
    public void testGameOutput() {
        String input = "0 0\n1 1\n2 2\n3 3\n4 4\nn\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        BattleshipGame.main(new String[]{});

        String output = out.toString();
        assertTrue(output.contains("Enter row and column"), "You should be prompted for column and column coordinates");
        assertTrue(output.contains("miss") || output.contains("hit"), "Hit or miss information should be returned");
    }







}
