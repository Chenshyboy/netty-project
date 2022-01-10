package pr.chenziqi.parser;

/**
 * @author chenziqi
 * @date 2022-01-05
 */
public class AstNode {

  public static final char SPACE_KEY = ' ';

  public static final char TAB_KEY = '\t';

  public static final char NEW_LINE_KEY = '\n';

  public static final char ENTER_KEY = '\r';


  /**
   * 在代码中的开始位置
   */
  protected int startPosition;

  /**
   * 在代码中的结束位置
   */
  protected int endPosition;

}
