package com.nokia.uwr.influx;

import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author Piotr Stoklosa
 */
@Component
public class QueryCreator {

    Connectivity connectivity;
    WriteApiBlocking writeApi;

    @Autowired
    public QueryCreator(Connectivity connectivity) {
        this.connectivity = connectivity;
        writeApi = connectivity.getClient().getWriteApiBlocking();
    }

    public void write(Integer turnNumber, Integer UEconnected, Integer summarisedSignal) {

        Signal signal = new Signal();
        signal.turnNumber = String.valueOf(turnNumber);
        signal.UEconnected = UEconnected;
        signal.summarisedSignal = summarisedSignal;

        writeApi.writeMeasurement(connectivity.getBucket(), connectivity.getOrg(), WritePrecision.NS, signal);
        try{Thread.sleep(500);}catch(InterruptedException e){}
    }

    public void close() {
        connectivity.getClient().close();
    }

    @Measurement(name = "signal")
    private static class Signal {
        @Column
        String turnNumber;
        @Column
        Integer UEconnected;
        @Column
        Integer summarisedSignal;
        @Column(timestamp = true)
        Instant time;

    }


}
