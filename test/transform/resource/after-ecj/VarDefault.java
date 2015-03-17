interface VarDefault {
  int size();
  default void method() {
    @lombok.var int x = 1;
    @lombok.var int size = size();
  }
}