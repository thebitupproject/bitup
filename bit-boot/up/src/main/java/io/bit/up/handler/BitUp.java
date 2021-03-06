package io.bit.up.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.bit.up.BootApplication;
import io.bit.up.pojo.BitUpStartRequest;
import io.bit.up.services.IEC2Service;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

/**
 * Class to handle AWS lambda Up request which launch a new running instance in
 * the AWS cloud.
 * <p>
 * Created by ArthurBaudry and atuffreau on 29/11/16.
 */
public class BitUp implements RequestHandler<BitUpStartRequest, String> {

    private static Logger LOG = Logger.getLogger(BitUp.class);

    /**
     * Handle the AWS lambda Up requests.
     *
     * @param input the request parameters
     * @param context the AWS {@link Context}
     * @return the String OK
     */
    public String handleRequest(BitUpStartRequest input, Context context) {
        runningRequest(input);
        return "OK";
    }

    /**
     * Execute the Bitup request to launch an new instance.
     *
     * @param input the instance configuration
     */
    public void runningRequest(BitUpStartRequest input) {
        ApplicationContext springContext = new BootApplication().run();

        //Get class implementing IEC2Service
        springContext.getBean(IEC2Service.class).up(input);
    }

}
