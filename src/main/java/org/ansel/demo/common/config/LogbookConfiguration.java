package org.ansel.demo.common.config;

import org.ansel.demo.common.logging.InfoHttpLogWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.autoconfigure.LogbookProperties;
import org.zalando.logbook.core.Conditions;
import org.zalando.logbook.core.DefaultSink;
import org.zalando.logbook.json.JsonHttpLogFormatter;

@Configuration
public class LogbookConfiguration {

  @Bean
  public Logbook logbook(LogbookProperties logbookProperties) {
    return Logbook.builder()
        .condition(
            Conditions.exclude(
                logbookProperties.getExclude().stream().map(Conditions::requestTo).toList()))
        .sink(new DefaultSink(new JsonHttpLogFormatter(), new InfoHttpLogWriter()))
        .build();
  }
}
