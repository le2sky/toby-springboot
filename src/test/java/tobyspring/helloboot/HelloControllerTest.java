package tobyspring.helloboot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HelloControllerTest {

    private HelloService getHelloService() {
        return new HelloService() {
            @Override
            public String sayHello(String name) {
                return name;
            }

            @Override
            public int countOf(String name) {
                return 0;
            }
        };
    }

    @Test
    void helloController() {
        HelloController controller = new HelloController(getHelloService());

        String ret = controller.hello("Test");

        assertThat(ret).isEqualTo("Test");
    }

    @Test
    void failsHelloController() {
        HelloController controller = new HelloController(getHelloService());

        assertThatThrownBy(() -> {
            controller.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            controller.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
