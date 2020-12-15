package stubs;

import queries.MaterialQueries;

public class MaterialQueriesStub extends MaterialQueries {
    public static final String[] ALLMATERIALS = {"A", "B", "C"};
    private int fetchAllCounter = 0;

    @Override
    public String[] fetchAll() {
        fetchAllCounter++;
        return ALLMATERIALS; 
    }    
}
