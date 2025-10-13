package org.skypro.skyshop.search;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SearchEngine {
    private final Set<Searchable> items = new HashSet<>();

    public void add(Searchable item) {
        items.add(item); // дубликаты автоматически игнорируются
    }

    public Set<Searchable> search(String text) {
        Set<Searchable> results = new TreeSet<>(new SearchableComparator());
        for (Searchable item : items) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                results.add(item);
            }
        }
   ;     return results;
    }
}

