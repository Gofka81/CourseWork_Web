package taxi.command;

import com.polyteh.taxi.command.CommandContainer;
import com.polyteh.taxi.command.common.LoginCommand;
import com.polyteh.taxi.command.common.NoCommand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CommandContainerTest {
    String commandName;

    @Before
    public void setUp() {
        commandName = "login";
    }

    @Test
    public void shouldReturnLoginCommand() {
        Assert.assertTrue(CommandContainer.getCommand(commandName) instanceof LoginCommand);
    }

    @Test
    public void shouldReturnNoCommand() {
        commandName = "SomeNewCommand";
        Assert.assertTrue(CommandContainer.getCommand(commandName) instanceof NoCommand);
    }

}
