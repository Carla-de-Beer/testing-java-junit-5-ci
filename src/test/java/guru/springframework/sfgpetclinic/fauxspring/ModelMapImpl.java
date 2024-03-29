package guru.springframework.sfgpetclinic.fauxspring;

import org.junit.jupiter.api.Tag;

import java.util.HashMap;
import java.util.Map;

public class ModelMapImpl implements Model {

    private Map<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        map.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
        // Do nothing
    }

    public Map<String, Object> getMap() {
        return map;
    }

}
