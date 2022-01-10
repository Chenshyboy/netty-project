package pr.chenziqi.boot;

import java.io.IOException;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pr.chenziqi.server.ServerProperty;

/**
 * @author chenziqi
 * @date 2022-01-05
 */
public class ServerBoot {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  private ApplicationProperty applicationProperty;

  private ServerProperty serverProperty;

  public ServerBoot() {
    loadBootProperties();
  }

  private void loadBootProperties() {
    InputStream stream = getClass().getResourceAsStream("/application.yml");
  }

  public static void main(String[] args) throws IOException {
    new ServerBoot();
  }

}
