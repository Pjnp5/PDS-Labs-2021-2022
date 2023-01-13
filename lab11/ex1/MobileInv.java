package lab11.ex1;

import java.util.ArrayList;
import java.util.List;

public class MobileInv {
  private List<Mobile> list;

  public MobileInv() {
    list = new ArrayList<>();
  }

  public void addMobile(Mobile mobile) {
    list.add(mobile);
  }

  public List<Mobile> getMobiles() {
    return getMobiles(new QuickSort());
  }

  public List<Mobile> getMobiles(Sort sort_type) {
    return getMobiles(sort_type, Type.PRECO);
  }

  public List<Mobile> getMobiles(Sort sort_type, Type sort_by) {
    return sort_type.sort(list, sort_by);
  }
}
