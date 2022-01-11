package pr.chenziqi.parser.yaml;

import static pr.chenziqi.parser.AstNode.ENTER_KEY;
import static pr.chenziqi.parser.AstNode.NEW_LINE_KEY;
import static pr.chenziqi.parser.AstNode.SPACE_KEY;
import static pr.chenziqi.parser.AstNode.TAB_KEY;
import static pr.chenziqi.parser.yaml.YamlAstNode.COMMENT_KEY;
import static pr.chenziqi.parser.yaml.YamlMapNode.CURLY_BRACE_END_KEY;
import static pr.chenziqi.parser.yaml.YamlMapNode.CURLY_BRACE_START_KEY;
import static pr.chenziqi.parser.yaml.YamlMappingNode.COLON_KEY;
import static pr.chenziqi.parser.yaml.YamlSeqNode.BRACKET_END_KEY;
import static pr.chenziqi.parser.yaml.YamlSeqNode.BRACKET_START_KEY;
import static pr.chenziqi.parser.yaml.YamlSeqNode.SEQ_KEY;

import java.io.InputStream;
import pr.chenziqi.parser.AstNode;
import pr.chenziqi.parser.AstParser;
import pr.chenziqi.parser.AstParserException;

/**
 * @author chenziqi
 * @date 2022-01-10
 */
public class YamlAstParser extends AstParser {

  /**
   * 最终生成的astNode
   */
  private AstNode rootAstNode;

  /**
   * 当前正在处理的astNode
   */
  private AstNode currentAstNode;

  public YamlAstParser(InputStream stream) throws AstParserException {
    super(stream);
  }

  public YamlAstParser(String code) {
    super(code);
  }

  @Override
  public void parse() {
    //如果文本还有未解析的部分
    while(!context.isEof()) {
      //根据ch的值做不同的处理
      char ch = context.getChar();
      switch (ch) {
        case COMMENT_KEY: {
          parseCommentKey();
          break;
        }
        case TAB_KEY:
        case SPACE_KEY: {
          parseEmptyKey();
          break;
        }
        case NEW_LINE_KEY:
        case ENTER_KEY: {
          parseNewLineKey();
          break;
        }
        case SEQ_KEY: {
          parseSeqKey();
          break;
        }
        case CURLY_BRACE_START_KEY: {
          parseCurlyBraceStartKey();
          break;
        }
        case CURLY_BRACE_END_KEY: {
          parseCurlyBraceEndKey();
          break;
        }
        case BRACKET_START_KEY: {
          parseBracketStartKey();
          break;
        }
        case BRACKET_END_KEY: {
          parseBracketEndKey();
          break;
        }
        case COLON_KEY: {
          parseColonKey();
          break;
        }
        default: {
          parseStringKey();
        }
      }
    }
  }

  private void parseStringKey() {
  }

  private void parseNewLineKey() {
  }

  private void parseBracketEndKey() {
  }

  private void parseBracketStartKey() {
  }

  private void parseCurlyBraceEndKey() {
  }

  private void parseCurlyBraceStartKey() {
  }


  private void parseColonKey() {
  }

  private void parseSeqKey() {
    //当前是-
    //获取接下来的字符
  }

  /**
   * 跳过空字段
   */
  private void parseEmptyKey() {
    //跳过后续的所有空字符
    while(context.hasNextChar()) {
      char ch = context.nextChar();
      //如果字符不为空，则退出解析
      if(!context.isEmptyChar(ch)) {
        break;
      }
    }
  }

  /**
   * 当解析的#号时的处理方式,此时这一行均被当注释处理
   */
  private void parseCommentKey() {
    //如果下一个字符没有结束
    while(context.hasNextChar()) {
      char ch = context.nextChar();
      if(context.isNewLine(ch)) {
        context.nextChar();
        break;
      }
    }
  }
}
