package expert.os.demos.travel.infrastructure;

import jakarta.json.bind.config.PropertyVisibilityStrategy;

public class FieldVisibilityStrategy implements PropertyVisibilityStrategy {

    @Override
    public boolean isVisible(java.lang.reflect.Field field) {
        return true;
    }

    @Override
    public boolean isVisible(java.lang.reflect.Method method) {
        return false;
    }
}
