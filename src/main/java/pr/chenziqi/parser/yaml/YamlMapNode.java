package pr.chenziqi.parser.yaml;

import java.util.ArrayList;
import java.util.List;
import pr.chenziqi.parser.AstParserContext;

/**
 * @author chenziqi
 * @date 2022-01-10
 */
public class YamlMapNode extends YamlAstNode {

  public static final char CURLY_BRACE_START = '{';

  public static final char CURLY_BRACE_END = '}';

  public YamlMapNode(AstParserContext context,
      YamlAstNode parentNode) {
    super(context, parentNode);
  }

  private final List<YamlAstNode> mappings = new ArrayList<>();

  public List<YamlAstNode> getMappings() {
    return mappings;
  }
}
