class VarWithLocalClasses1 {
  {
    @lombok.var VarWithLocalClasses2 f2 = new VarWithLocalClasses2() {
      x() {
        super();
      }
    };
  }
  VarWithLocalClasses1() {
    super();
  }
}
class VarWithLocalClasses2 {
  {
    @lombok.var int f3 = 0;
  }
  VarWithLocalClasses2() {
    super();
  }
}
