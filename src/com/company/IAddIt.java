package com.company;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IAddIt {

    public Map addIt(List usersMap, Map borrowedMap) throws IOException, LibraryException;
}
