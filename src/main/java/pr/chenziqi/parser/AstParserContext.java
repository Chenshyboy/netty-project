package pr.chenziqi.parser;

import static pr.chenziqi.parser.AstNode.ENTER_KEY;
import static pr.chenziqi.parser.AstNode.NEW_LINE_KEY;
import static pr.chenziqi.parser.AstNode.SPACE_KEY;
import static pr.chenziqi.parser.AstNode.TAB_KEY;

/**
 * @author chenziqi
 * @date 2022-01-10
 */
public class AstParserContext {

  public static final char END_CHAR_KEY = '\0';

  /**
   * 待解析的代码源码
   */
  private final String sourceCode;

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

  /**
   * 判断待解析的文本是否已经结束
   *
   * @return 文本是否已到结尾
   */
  public boolean isEof() {
    return currentPosition < sourceCode.length();
  }

  /**
   * 获取当前位置的字符
   *
   * @return 当前字符
   */
  public char getChar() {
    return offsetChar(0);
  }

  private char offsetChar(int offset) {
    return sourceCode.charAt(currentPosition + offset);
  }

  /**
   * 处理文本换行，context的内容更新
   *
   * @param isWindowStyle
   */
  public void advanceNewLine(boolean isWindowStyle) {
    row++;
    column = 0;
    currentPosition += isWindowStyle ? 2 : 1;
  }

  /**
   * 处理文本向前解析的时候，context的内容更新
   */
  public void advanceWord() {
    column += 1;
    currentPosition += 1;
  }

  public boolean hasNextChar() {
    return currentPosition < sourceCode.length() - 1;
  }

  /**
   * 读取下一个字符,各种格式的换行符统一识别为 \n
   *
   * CRLF(\r\n),LF(\n),CR(\r)统一处理
   * @return  下一个字符,如果是结束字符，则返回 \0
   */
  public char nextChar() {
    char prev = getChar();
    //下一个字符
    char next = hasNextChar()? offsetChar(1): END_CHAR_KEY;
    boolean prevIsNewLine = isNewLine(prev);
    boolean prevIsWindowStyle = prev == ENTER_KEY && next == NEW_LINE_KEY;
    //如果前一个字符是换行，操作换行
    if(prevIsNewLine) {
      advanceNewLine(prevIsWindowStyle);
    }
    //如果不是换行，往前进一位
    else {
      advanceWord();
    }
    return isEof()? END_CHAR_KEY: getChar();
  }

  public boolean isNewLine(char ch) {
    return ch == NEW_LINE_KEY || ch == ENTER_KEY;
  }

  public boolean isEmptyChar(char ch) {
    return ch == TAB_KEY || ch == SPACE_KEY;
  }
}
