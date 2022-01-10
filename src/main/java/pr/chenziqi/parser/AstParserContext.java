package pr.chenziqi.parser;

/**
 * @author chenziqi
 * @date 2022-01-10
 */
public class AstParserContext {

  /**
   * 待解析的代码源码
   */
  private String sourceCode;

  /**
   * 当前正在处理的token
   */
  private String token;

  /**
   * 当前正在读取的字符的行
   */
  private int row;

  /**
   * 当前正在读取的字符的列
   */
  private int column;

  /**
   * 当前读取的字符距离开始所在的位置
   */
  private int currentPosition;

  public AstParserContext(String code) {
    this.sourceCode = code;
  }

  public int getColumn() {
    return column;
  }

  public int getCurrentPosition() {
    return currentPosition;
  }

}
