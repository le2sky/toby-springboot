package tobyspring.helloboot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloServiceTest {

    @Test
    void simpleHelloService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService();

        String ret = simpleHelloService.sayHello("Test");

        assertThat(ret).isEqualTo("Hello, Test");
    }
}