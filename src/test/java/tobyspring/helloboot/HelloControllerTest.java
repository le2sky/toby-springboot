package tobyspring.helloboot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HelloControllerTest {

    @Test
    void helloController() {
        HelloController controller = new HelloController(name -> name);

        String ret = controller.hello("Test");

        assertThat(ret).isEqualTo("Test");
    }

    @Test
    void failsHelloController() {
        HelloController controller = new HelloController(name -> name);

        assertThatThrownBy(() -> {
            controller.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            controller.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
