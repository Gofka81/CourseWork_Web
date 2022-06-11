package com.polyteh.taxi.command.client;

import com.polyteh.taxi.Path;
import com.polyteh.taxi.command.Command;
import com.polyteh.taxi.command.common.GetOrdersListCommand;
import com.polyteh.taxi.db.dao.OrderDAO;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Command allows to delete order by client.
 *
 * @author L. Antonyk
 */
public class DeleteOrderCommand extends Command {
    private static final Logger LOGGER = Logger.getLogger(DeleteOrderCommand.class);

    private static final long serialVersionUID = 8943223412345121512L;

    private final OrderDAO orderDAO = new OrderDAO();

    @Override
    public Path execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("Command starts");

        String orderId = request.getParameter("orderId");

        //If order are null return to error page
        if(orderId == null || orderId.isEmpty()){
            LOGGER.error("Order = null");
            return new Path(Path.PAGE_ERROR_PAGE, true);
        }

        //Delete the order from the database
        orderDAO.deleteOrder(orderId);
        LOGGER.info("Order deleted");

        LOGGER.info("Command finished");

        String a = request.getParameter("refresh");
        return new GetOrdersListCommand().execute(request,response);
    }
}
