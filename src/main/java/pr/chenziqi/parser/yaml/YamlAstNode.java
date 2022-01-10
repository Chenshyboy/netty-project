package pr.chenziqi.parser.yaml;

import pr.chenziqi.parser.AstNode;
import pr.chenziqi.parser.AstParserContext;

/**
 * @author chenziqi
 * @date 2022-01-10
 */
public class YamlAstNode extends AstNode {

  public static final char COMMENT_KEY = '#';

  /**
   * 当前节点的开始列
   */
  private int startColumn;

  /**
   * 当前节点的父亲节点,如果没有父亲节点,则值为空
   */
  private YamlAstNode parentNode;

  public YamlAstNode(AstParserContext context, YamlAstNode parentNode) {
    this.startColumn = context.getColumn();
    this.parentNode = parentNode;
    this.startPosition = context.getCurrentPosition();
  }

}
