package com.github.ctpahhik.cq4j.grammar.from;

import com.github.ctpahhik.cq4j.common.IDataAdapter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class FromElements {

    private Map<String, Integer> tableNames;
    private Map<Integer, IDataAdapter> dataAdapters;

    public FromElements(IDataAdapter dataAdapter) {
        int defaultId = 0;
        tableNames = Collections.singletonMap("", defaultId);
        dataAdapters = Collections.singletonMap(defaultId, dataAdapter);
    }

    public FromElements(Map<String, IDataAdapter> adapters) {
        tableNames = new HashMap<String, Integer>(adapters.size());
        dataAdapters = new HashMap<Integer, IDataAdapter>(adapters.size());
        int id = 0;
        for (Map.Entry<String,IDataAdapter> entry : adapters.entrySet()) {
            tableNames.put(entry.getKey(), id);
            dataAdapters.put(id, entry.getValue());
            id++;
        }
    }

    public int getTableIdByName(String tableName) {
        return tableNames.get(tableName);
    }

    public int getTableIdByFieldName(String fieldName) {
        Integer tableId = null;
        for (Map.Entry<Integer, IDataAdapter> entry : dataAdapters.entrySet()) {
            if (entry.getValue().hasName(fieldName)) {
                if (tableId != null) {
                    throw new IllegalArgumentException("Ambiguous field declaration: " + fieldName);
                }
                tableId = entry.getKey();
            }
        }

        if (tableId == null) {
            throw new IllegalArgumentException("Unknown field: " + fieldName);
        }
        return tableId;
    }

    public int getTableIdByType(Class clazz) {
        return 0;
    }

    public IDataAdapter getDataAdapterById(int tableId) {
        return dataAdapters.get(tableId);
    }

    @Override
    public String toString() {
        return "FromElements{" +
                "dataAdapters=" + dataAdapters +
                '}';
    }
}
