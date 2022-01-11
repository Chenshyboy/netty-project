package pr.chenziqi.parser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author chenziqi
 * @date 2022-01-10
 */
public abstract class AstParser {

  protected AstParserContext context;

  /**
   * @param stream
   * @throws AstParserException
   */
  public AstParser(InputStream stream) throws AstParserException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
    char[] chs = new char[1024];
    int len;
    StringBuilder builder = new StringBuilder();
    try {
      while ((len = reader.read(chs)) > 0) {
        builder.append(new String(chs, 0, len));
      }
    } catch (Exception e) {
      throw new AstParserException(e);
    }
    initParserContext(builder.toString());
  }

  public AstParser(String code) {
    initParserContext(code);
  }

  private void initParserContext(String code) {
    context = new AstParserContext(code);
  }



  /**
   * 实际的解析ast流程流程，根据不同的语法进行解析
   */
  public abstract void parse();

}
