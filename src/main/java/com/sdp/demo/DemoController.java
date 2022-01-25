package com.sdp.demo;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.Host;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final Environment environment;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HostInfoSO> home()  {
        final String port = environment.getProperty("local.server.port");
        final InetAddress localHostInfo = this.getLocalhost();
        final String hostAddress = localHostInfo.getHostAddress();
        final String hostName = localHostInfo.getHostName();
        final HostInfoSO hostInfoSO = new HostInfoSO(port, hostAddress, hostName);

        return ResponseEntity.ok(hostInfoSO);
    }

    private InetAddress getLocalhost() {
        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new CustomServerException("Something went wrong when getting host info", e);
        }
    }
}
