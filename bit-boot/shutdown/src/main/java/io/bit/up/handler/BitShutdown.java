package io.bit.up.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.bit.up.BootApplication;
import io.bit.up.pojo.BitUpShutdownRequest;
import io.bit.up.services.IEC2Service;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

/**
 * Class to handle AWS lambda Shutdown request which terminate a running instance in
 * the AWS cloud.
 * <p>
 * Created by ArthurBaudry and atuffreau on 29/11/16.
 */
public class BitShutdown implements RequestHandler<BitUpShutdownRequest, String> {

    private static Logger LOG = Logger.getLogger(BitShutdown.class);

    /**
     * Handle the AWS lambda Shutdown requests.
     *
     * @param input the request parameters
     * @param context the AWS {@link Context}
     * @return the String OK
     */
    public String handleRequest(BitUpShutdownRequest input, Context context) {
        runningRequest(input);
        return "OK";
    }

    /**
     * Execute the BitShutDown request to terminate an instance.
     *
     * @param input the instance configuration
     */
    public void runningRequest(BitUpShutdownRequest input) {
        ApplicationContext springContext = new BootApplication().run();

        //Get class implementing IEC2Service
        springContext.getBean(IEC2Service.class).shutdown(input);
    }

}
