package pr.chenziqi.parser.yaml;

import java.io.InputStream;
import pr.chenziqi.parser.AstParser;
import pr.chenziqi.parser.AstParserException;

/**
 * @author chenziqi
 * @date 2022-01-10
 */
public class YamlAstParser extends AstParser {

  public YamlAstParser(InputStream stream) throws AstParserException {
    super(stream);
  }

  public YamlAstParser(String code) {
    super(code);
  }

  @Override
  public void parse() {
  }
}
