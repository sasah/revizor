package com.sasah.revizor.vuln;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class Maven {

    private SortedMap<String, List<Item>> map = new TreeMap<>();

    public SortedMap<String, List<Item>> getMap() {
        return map;
    }

    public void setMap(SortedMap<String, List<Item>> map) {
        this.map = map;
    }

}
