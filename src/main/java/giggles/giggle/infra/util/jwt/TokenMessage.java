package giggles.giggle.infra.util.jwt;

import java.util.HashMap;

/**
 * @author zty
 * <p>token信息类</p>
 */
public class TokenMessage {
    private String name;

    public TokenMessage() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TokenMessage{" +
                "name='" + name + '\'' +
                '}';
    }
}
