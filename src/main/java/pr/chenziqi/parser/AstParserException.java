package pr.chenziqi.parser;

/**
 * @author chenziqi
 * @date 2022-01-10
 */
public class AstParserException extends Throwable {

  private AstParserContext context;

  public AstParserException(Throwable cause) {
    super(cause);
  }

  public AstParserException(AstParserContext context) {
    this.context = context;
  }


}
