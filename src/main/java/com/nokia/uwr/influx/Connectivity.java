package com.nokia.uwr.influx;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Piotr Stoklosa
 */
@Component
public class Connectivity {

    private final String bucket;
    private final String org;
    private final InfluxDBClient client;

    @Autowired
    public Connectivity(Environment environment) {
        bucket = environment.getProperty("bucket");
        org = environment.getProperty("org");
        String token = environment.getProperty("token");
        String influxPath = environment.getProperty("influx");
        if (token == null || influxPath == null) {
            throw new IllegalStateException("token and influxPath should not be null!");
        }
        client = InfluxDBClientFactory.create(influxPath, token.toCharArray());
    }

    public InfluxDBClient getClient() {
        return client;
    }

    public String getBucket() {
        return bucket;
    }

    public String getOrg() {
        return org;
    }
}
