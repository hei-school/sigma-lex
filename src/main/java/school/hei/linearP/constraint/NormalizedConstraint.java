package school.hei.linearP.constraint;

import school.hei.linearE.NormalizedLE;
import school.hei.linearE.instantiableE.Bounder;
import school.hei.linearE.instantiableE.BounderValue;
import school.hei.linearE.instantiableE.SubstitutionContext;
import school.hei.linearE.instantiableE.Variable;
import school.hei.linearP.constraint.polytope.DisjunctivePolytopes;
import school.hei.linearP.constraint.polytope.Polytope;

import java.util.Objects;
import java.util.Set;

public final class NormalizedConstraint extends Constraint {

  private final NormalizedLE le; // which is <= 0

  public NormalizedConstraint(NormalizedLE le) {
    this.le = le;
  }

  @Override
  public DisjunctivePolytopes normalize(SubstitutionContext substitutionContext) {
    return DisjunctivePolytopes.of(Polytope.of(this));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NormalizedConstraint that = (NormalizedConstraint) o;
    return le.equals(that.le);
  }

  @Override
  public int hashCode() {
    return Objects.hash(le);
  }

  @Override
  public String toString() {
    return "NormalizedConstraint{" +
        "le=" + le +
        '}';
  }

  public NormalizedLE le() {
    return le;
  }

  @Override
  public Set<Variable> variables() {
    return le.variables();
  }

  public double weight(Variable v) {
    return le.simplify().weightedV().get(v).simplify();
  }

  public NormalizedConstraint substitute(Bounder k, BounderValue kValue, SubstitutionContext substitutionContext) {
    return new NormalizedConstraint(le.substitute(k, kValue, substitutionContext));
  }

  public NormalizedConstraint simplify() {
    return new NormalizedConstraint(le.simplify());
  }
}
