package com.polyteh.taxi.command.admin;

import com.polyteh.taxi.Path;
import com.polyteh.taxi.command.Command;
import com.polyteh.taxi.db.dao.CarDAO;
import com.polyteh.taxi.db.entity.Car;
import com.polyteh.taxi.utils.Pagination;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Command that allows to get a page with all cars
 *
 * @author L. Antonyk
 */
public class GetCarsListCommand extends Command {
    private static final long serialVersionUID = 2821403039606311780L;
    private static final Logger LOGGER = Logger.getLogger(GetCarsListCommand.class);

    @Override
    public Path execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("Command starts");

        CarDAO dao = new CarDAO();
        HttpSession session = request.getSession();
        String locale = (String) session.getAttribute("locale");

        LOGGER.debug("Get locale " + locale);

        List<Car> carList = dao.getCars(locale);

        Pagination.createPagination(carList, request);

        LOGGER.info("Command finished");

        return new Path(Path.PAGE_AUTOPARK, false);
    }
}
