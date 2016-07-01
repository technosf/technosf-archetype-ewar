#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\')
/*
 * Copyright 2016 technosf [https://github.com/technosf]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
public class WarRunner
{

    private final static int CONST_MIN_PORT = 8000;
    private final static String CONST_PORT =
            "${symbol_escape}nThe port number provided is invalid for WarRunner";
    private final static String CONST_ARGS =
            "${symbol_escape}nWarRunner requires a port to run on, where the port number is > "
                    + CONST_MIN_PORT + "${symbol_escape}n";
    private final static String CONST_RUNNING =
            "${symbol_escape}nRunning .war at location: [%1${symbol_dollar}s]${symbol_escape}n";


    /**
     * Entry point to spin up the web archive in the packaged Jetty
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

        ProtectionDomain domain = WarRunner.class.getProtectionDomain();

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
                        "${symbol_escape}nWarRunner  --  Ready...${symbol_escape}n");

        server.join();
    }
}
