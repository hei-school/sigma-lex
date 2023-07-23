package school.hei.linearE;

import org.junit.jupiter.api.Test;
import school.hei.linearE.instantiableE.Constant;
import school.hei.linearE.instantiableE.Q;
import school.hei.linearE.instantiableE.Z;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static school.hei.linearE.instantiableE.Constant.ZERO;

class AddETest {
  @Test
  public void add_mono() {
    var x = new Z("x");
    var y = new Q("y");
    assertEquals(
        new Normalized(
            Map.of(
                x, new Constant(3),
                y, new Constant(2.5)),
            ZERO),
        new Add(new Mono(3, x), new Mono(2.5, y)).normalize());
  }
}