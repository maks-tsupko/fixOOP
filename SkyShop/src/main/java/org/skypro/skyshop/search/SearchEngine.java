package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> data = new ArrayList<>();

    public void add(Searchable searchable) {
        data.add(searchable);
    }

    public List<Searchable> search(String query) {
        String lowerCaseQuery = query.toLowerCase();
        List<Searchable> results = new ArrayList<>();
        for (Searchable s : data) {
            if (s.getName().toLowerCase().contains(lowerCaseQuery) ||
                s.getDescription().toLowerCase().contains(lowerCaseQuery)) {
                results.add(s);
            }
        }
        return results;
    }
}
