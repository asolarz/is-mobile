package com.example.is_mobile.laptop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class LaptopSpecification {

    private Long id;
    private String name;
    private String displaySize;
    private String resolution;
    private String screenType;
    private String touchpad;
    private String cpu;
    private String cores;
    private String freq;
    private String ram;
    private String space;
    private String discType;
    private String gpu;
    private String gpuRam;
    private String os;
    private String dvd;
}
