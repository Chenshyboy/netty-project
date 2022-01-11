package pr.chenziqi.parser.yaml;

import java.util.ArrayList;
import java.util.List;
import pr.chenziqi.parser.AstParserContext;

/**
 * @author chenziqi
 * @date 2022-01-10
 */
public class YamlSeqNode extends YamlAstNode {

  public static final char SEQ_KEY = '-';

  public static final char BRACKET_START_KEY = '[';

  public static final char BRACKET_END_KEY = ']';

  private final List<YamlAstNode> items = new ArrayList<>();

  public List<YamlAstNode> getItems() {
    return items;
  }

  public YamlSeqNode(AstParserContext context,
      YamlAstNode parentNode) {
    super(context, parentNode);
  }

}
