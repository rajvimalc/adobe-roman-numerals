package com.adobe.assessment.romannumerals.framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static java.util.Optional.ofNullable;

/**
 * @author Vimalraj Chandra Sekaran (rajvimalc)
 * Email: rajvimalc@gmail.com
 * Created on: 8/5/2021 10:34 PM
 *
 * MetaData Controller for application health check and host info
 */
@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class MetaDataController {

    private final Environment environment;

    /**
     * Health check Api for the application. Returns HttpStatus.OK as ResponseStatus if reachable.
     */
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void healthCheck() {
    }

    /**
     * Host Info Api for the application
     *
     * @return HostInfo response with host name, ip address, port and deployed app version
     * @throws UnknownHostException If host could not be retrieved
     */
    @GetMapping("/api/v1/host-info")
    public HostInfo hostInfo() throws UnknownHostException {

        final String hostAddress = InetAddress.getLocalHost().getHostAddress();
        final String hostName = InetAddress.getLocalHost().getHostName();
        final String portNumber = environment.getProperty("local.server.port");
        final String appVersion = environment.getProperty("spring.application.version");

        final HostInfo hostInfo = new HostInfo(hostName, hostAddress,
                Integer.parseInt(ofNullable(portNumber).orElse("-1")), appVersion);
        log.debug("Host Info: {}", hostInfo);
        return hostInfo;
    }

    @Data
    @AllArgsConstructor
    private static class HostInfo {
        private final String hostName;
        private final String ipAddress;
        private final Integer port;
        private final String appVersion;
    }

}
