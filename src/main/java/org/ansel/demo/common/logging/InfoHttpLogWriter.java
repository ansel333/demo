package org.ansel.demo.common.logging;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.zalando.logbook.Correlation;
import org.zalando.logbook.HttpLogWriter;
import org.zalando.logbook.Precorrelation;

@NoArgsConstructor
@Slf4j
public class InfoHttpLogWriter implements HttpLogWriter {

  @Override
  public boolean isActive() {
    return log.isInfoEnabled();
  }

  @Override
  public void write(Precorrelation precorrelation, String request) {
    log.info("{} - {}", request, precorrelation);
  }

  @Override
  public void write(Correlation correlation, String response) {
    log.info("{} - {}", correlation, response);
  }
}
