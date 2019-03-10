package com.hef.wiring.multi02;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CDConfig.class, CDPlayerConfig.class})
public class SoundSystemConfig {
}
