package pr.chenziqi.server;

/**
 * @author chenziqi
 * @date 2022-01-05
 */
public abstract class Server {

  private boolean active = false;

  /**
   * 启动服务器
   */
  private void start() {
    if (active) {
      return;
    }
    doStart();
    active = true;
  }


  /**
   * 关闭服务器
   */
  private void close() {
    if (!active) {
      return;
    }
    doClose();
    active = false;
  }

  /**
   * 供子类实现，实际的关闭服务器操作
   */
  abstract void doClose();

  /**
   * 供子类使用，实际的启动服务器操作
   */
  abstract void doStart();
}
