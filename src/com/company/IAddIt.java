package com.company;

import java.io.IOException;
import java.util.Map;

public interface IAddIt {

    public Map addIt(Map usersMap, Map borrowedMap) throws IOException, LibraryException;
}
