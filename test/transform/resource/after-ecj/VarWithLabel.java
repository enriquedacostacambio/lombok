import lombok.var;
public class VarWithLabel {
  {
    LABEL: for (@var java.lang.String x : new String[0]) 
  {
    if ((x.toLowerCase() == null))
        {
          continue LABEL;
        }
  }
  }
  public VarWithLabel() {
    super();
  }
}