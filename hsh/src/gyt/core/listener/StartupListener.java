package gyt.core.listener;

import java.net.MalformedURLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;

import gyt.core.daemon.SystemStart;
import gyt.core.util.SysControl;

public class StartupListener implements ServletContextListener
{

    private static final Log log = LogFactory.getLog(StartupListener.class);
    public static boolean SysInitSuccess=false;

    public void contextDestroyed(ServletContextEvent event)
    {
        WebApplicationContext context =
            (WebApplicationContext) event.getServletContext().getAttribute(
                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        SystemStart.destroy(context);
    }

    public void contextInitialized(ServletContextEvent event)
    {
        System.setProperty("file.encoding", "utf-8");
        WebApplicationContext context =
            (WebApplicationContext) event.getServletContext().getAttribute(
                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        String portString = event.getServletContext().getInitParameter("port");
        int port = 0;
        if (portString != null)
        {
            port = Integer.parseInt(portString);
        }
        String path;
        try
        {
            path = event.getServletContext().getResource("/").getPath();
            path = path.substring(0, path.length() - 1);
            SysControl.contextName = path.substring(path.lastIndexOf("/") + 1, path.length());
            SysControl.webPath = path;
            SysControl.realPath = event.getServletContext().getRealPath("/");
            if (port == 0)
            {
                SysControl.webPort = 80;
            }
            else
            {
                SysControl.webPort = port;
            }
            SystemStart.start(context);
        }
        catch (MalformedURLException e)
        {
            log.error("", e);
        }
        SysInitSuccess=true;
    }

}
