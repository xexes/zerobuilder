package net.zerobuilder.examples.derive4j;

import net.zerobuilder.Build;
import org.derive4j.Data;

@Data
public abstract class Request {

  interface Cases<R> {
    R GET(String path);
    R DELETE(String path);
    R PUT(String path, String body);
    R POST(String path, String body);
  }

  public abstract <R> R match(Cases<R> cases);

  @Build(goal = Request.class, toBuilder = false)
  static class PUT {

    @Build.Via
    static Request build(String path, String body) {
      return Requests.PUT(path, body);
    }
  }

  @Build(goal = Request.class, toBuilder = false)
  static class POST {

    @Build.Via
    static Request build(String path, String body) {
      return Requests.POST(path, body);
    }
  }

}
