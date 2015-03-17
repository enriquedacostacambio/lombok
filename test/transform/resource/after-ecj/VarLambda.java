class VarLambda {
  VarLambda() {
    super();
  }
  public void easyLambda() {
    @lombok.var java.lang.Runnable foo = (Runnable) () -> {
};
  }
  public void easyIntersectionLambda() {
    @lombok.var java.lang.Object foo = (Runnable & java.io.Serializable) () -> {
};
    @lombok.var java.lang.Object bar = (java.io.Serializable & Runnable) () -> {
};
  }
  public void easyLubLambda() {
    @lombok.var java.lang.Runnable foo = ((System.currentTimeMillis() > 0) ? (Runnable) () -> {
} : (Runnable) System.out::println);
  }
}