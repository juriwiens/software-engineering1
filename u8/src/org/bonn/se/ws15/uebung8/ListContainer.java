package org.bonn.se.ws15.uebung8;

import java.util.List;

public class ListContainer<T> {
    private List<T> list;

    public ListContainer(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void replaceList(List<T> list) {
        this.list = list;
    }
}
