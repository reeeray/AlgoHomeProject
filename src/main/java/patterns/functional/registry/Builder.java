package patterns.functional.registry;

import patterns.functional.supplier.Factory;

/**
 * Created by Shein G.A. at 01.08.20
 **/
public interface Builder<T> {

    void register(String lable, Factory<T> factory);
}
