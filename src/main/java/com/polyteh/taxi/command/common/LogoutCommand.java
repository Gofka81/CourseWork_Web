package com.polyteh.taxi.command.common;

import com.polyteh.taxi.Path;
import com.polyteh.taxi.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Logout command.
 *
 * @author L. Antonyk
 */
public class LogoutCommand extends Command {

    private static final long serialVersionUID = 1421403039606311780L;
    private static final Logger LOGGER = Logger.getLogger(LogoutCommand.class);

    @Override
    public Path execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.debug("Command starts");

        HttpSession session = request.getSession();
        session.invalidate();

        LOGGER.debug("Command finished");
        return new Path(Path.MAIN, true);
    }
}
