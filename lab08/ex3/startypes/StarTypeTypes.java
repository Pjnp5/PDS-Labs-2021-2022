package lab08.ex3.startypes;

public enum StarTypeTypes {
  O(new OStar()), B(new BStar()), A(new AStar()), F(new FStar()), G(new GStar()), K(new KStar()), M(new MStar());

  private StarType body;

  private StarTypeTypes(StarType star) {
    this.body = star;
  }

  public StarType getStarBody() {
    return this.body;
  }
}