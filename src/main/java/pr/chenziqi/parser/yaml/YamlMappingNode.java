package pr.chenziqi.parser.yaml;

import pr.chenziqi.parser.AstParserContext;

/**
 * @author chenziqi
 * @date 2022-01-10
 */
public class YamlMappingNode extends YamlAstNode {

  public static final char COLON_KEY = ':';

  /**
   * mapping对应的key
   */
  private String key;

  /**
   * mapping对应的value
   */
  private YamlAstNode value;

  public YamlMappingNode(AstParserContext context,
      YamlAstNode parentNode) {
    super(context, parentNode);
  }
}
