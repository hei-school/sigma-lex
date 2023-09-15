package school.hei.sigmalex.linearE;

import school.hei.sigmalex.linearE.instantiableE.SubstitutionContext;
import school.hei.sigmalex.linearE.instantiableE.Variable;

import java.util.Set;

public sealed interface LinearE permits Add, Mono, Mult, NormalizedLE, Substitute {
  NormalizedLE normalize();

  LinearE substitute(SubstitutionContext substitutionContext);

  default NormalizedLE subnormify() {
    var substituted = substitute(SubstitutionContext.of());
    return substituted.normalize().simplify();
  }

  Set<Variable> variables();
}
