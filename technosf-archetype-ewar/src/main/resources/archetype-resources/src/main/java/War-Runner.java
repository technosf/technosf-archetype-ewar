#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\')

import java.security.ProtectionDomain;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Entry point for self-executing .war archives.
 * <p>
 * 
 * @author technosf
 * @since 0.0.1
 * @version 0.0.1
 */
public class War-Runner
{

    private final static int CONST_MIN_PORT = 8000;
    private final static String CONST_PORT =
            "${symbol_escape}nThe port number provided is invalid for SamlOperator";
    private final static String CONST_ARGS =
            "${symbol_escape}nSamlOperator requires a port to run on, where the port number is > "
                    + CONST_MIN_PORT + "${symbol_escape}n";
    private final static String CONST_RUNNING =
            "${symbol_escape}nRunning .war at location: [%1${symbol_dollar}s]${symbol_escape}n";


    /**
     * Entry point to spin up the SamlOperator web archive in the packaged Jetty
     * server
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        /*
         * ------------------------------------------------------------
         * 
         * Parameter checking
         * 
         * ------------------------------------------------------------
         */

        String portArg = null;

        if (args == null || args.length != 1 || (portArg = args[0]) == null)
        {
            System.err.println(CONST_ARGS);
            System.exit(1);
        }

        int port = 0;

        try
        {
            port = Integer.valueOf(portArg);
        }
        catch (Exception e)
        {
            System.err.println(CONST_PORT);
            System.err.println(CONST_ARGS);
            System.exit(1);
        }

        if (port < CONST_MIN_PORT)
        {
            System.err.println(CONST_PORT);
            System.err.println(CONST_ARGS);
            System.exit(1);
        }

        /*
         * ------------------------------------------------------------
         * 
         * Server start up
         * 
         * ------------------------------------------------------------
         */

        ProtectionDomain domain = War-Runner.class.getProtectionDomain();

        String location = domain.getCodeSource().getLocation().toExternalForm();

        System.out.println(String.format(CONST_RUNNING,
                location));

        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setWar(location);

        Server server = new Server(port);
        server.setHandler(webapp);
        server.start();

        System.out
                .println(
                        "${symbol_escape}nSamlOperator  --  Ready...${symbol_escape}n");

        server.join();
    }
}
