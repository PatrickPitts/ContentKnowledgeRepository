package org.nerdcore.DesignPatterns;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Strategies to make a class immutable:
 * - All properties set at constructor only
 * - No setter methods
 * - Instance variables 'private' and 'final'
 * - Referenced mutable objects cannot be modified or accessed directly
 * - Prevent methods from being overridden ('final' methods, or use the Factory design pattern).
 */
public class Immutable {
    private final String stringData;
    private final int intData;
    private final List<String> listData;

    public Immutable(String stringData, int intData, List<String> listData) {
        this.stringData = stringData;
        this.intData = intData;
        if(listData == null) throw new RuntimeException("listData is required");
        /*
        * 'listData' may reference a 'List<String>' object that exists outside the scope of 'Immutable'; That object
        * may then be updated outside 'Immutable', which would then change 'listData' INSIDE 'Immutable'. We must ensure
        * that when a mutable object is passed to 'Immutable', we extract the data and create a new 'List<String>'
        * instance.
        * */
        this.listData = new ArrayList<>(listData);
    }
    public String getStringData(){
        return stringData;
    }
    public int getIntData(){
        return intData;
    }
/*
    listData is itself a mutable object, so returning this field makes the object mutable!

    public List<String> getListData() {
        return listData;
    }
*/
    public List<String> getListData() {
        return Collections.unmodifiableList(listData);
    }

}
