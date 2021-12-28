package org.nerdcore.DesignPatterns;

/**
 * The Singleton Pattern: a creational pattern that creates only one instance of an object, which is globally available
 * to the application. Useful for loading reusable data.
 *
 * General Properties:
 * - Cannot instantiate a Singleton (i.e. make the constructor private)
 * - Single 'private static final' instance of Singleton as a member, typically named 'instance'
 * - 'getInstance()' method returns reference to the static 'instance', which can then access the internal data.
 *
 * Since the only constructor is 'private', the class is effectively 'final'
 */
public class Singleton {
    private int localData = 0;
    private static final Singleton instance = new Singleton();
    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }

    //'synchronized' so that the methods are thread safe
    public synchronized void increment(){
        localData++;
    }

    public synchronized boolean decrement(){
        if(localData < 1) return false;
        localData--;
        return true;
    }

    public synchronized int getLocalData(){
        return localData;
    }
}
