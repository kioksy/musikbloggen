
package com.mycompany.musikbloggen;

import java.util.List;

/**
 *
 * @author kloek
 */
public interface IDAO<T, K> {
    
    public void add(T t);

    public void remove(K id);

    public T find(K id);

    public List<T> getAll();

    public List<T> getRange(int maxResults, int firstResult);

    public int getCount();
    
}
