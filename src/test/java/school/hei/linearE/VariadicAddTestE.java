package school.hei.linearE;

import org.junit.jupiter.api.Test;
import school.hei.linearE.instantiableE.Constant;
import school.hei.linearE.instantiableE.Q;
import school.hei.linearE.instantiableE.Z;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static school.hei.linearE.LEFactory.vadd;

class VariadicAddTestE {

  @Test
  public void add_constants() {
    assertEquals(
        new NormalizedLE(4),
        vadd(new Mono(1), new Mono(3)).normalize().simplify());
    assertEquals(
        new NormalizedLE(2.6),
        vadd(new Mono(0.3), new Mono(1), new Mono(1.3)).normalize().simplify());
  }

  @Test
  public void add_mono() {
    var x = new Z("x");
    var y = new Q("y");
    assertEquals(
        new NormalizedLE(
            Map.of(
                x, new Constant(3.),
                y, new Constant(2.5)),
            new Constant(1.1)),
        vadd(
            new Mono(0.2),
            new Mono(2, x), new Mono(3, y), new Mono(-0.5, y), new Mono(1, x),
            new Mono(0.9))
            .normalize().simplify());
  }
}