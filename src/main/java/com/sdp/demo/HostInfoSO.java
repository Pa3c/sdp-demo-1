package com.sdp.demo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class HostInfoSO {
    final String port;
    final String address;
    final String hostname;
}
