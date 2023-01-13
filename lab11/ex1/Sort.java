package lab11.ex1;

import java.util.List;

// Strategy Pattern
public interface Sort {
  public List<Mobile> sort(List<Mobile> c, Type specType);
}
