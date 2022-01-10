package pr.chenziqi.parser.yaml;

import pr.chenziqi.parser.AstParserContext;

/**
 * @author chenziqi
 * @date 2022-01-10
 */
public class YamlScalarNode extends YamlAstNode {

  public static final char SINGLE_QUOTE = '\'';

  public static final char DOUBLE_QUOTE = '"';

  public YamlScalarNode(AstParserContext context,
      YamlAstNode parentNode) {
    super(context, parentNode);
  }

  private String value;

  private String rawValue;

  private boolean singleQuoted;

  private boolean doubleQuoted;

}
