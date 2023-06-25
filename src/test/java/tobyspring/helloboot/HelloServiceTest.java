package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.Assertions.assertThat;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastUnitTest {
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Test
@interface UnitTest {
}

public class HelloServiceTest {

    @FastUnitTest
    void simpleHelloService() {
        HelloRepository repository = Mockito.mock(HelloRepository.class);
        SimpleHelloService simpleHelloService = new SimpleHelloService(repository);

        String ret = simpleHelloService.sayHello("Test");

        assertThat(ret).isEqualTo("Hello, Test");
    }

    @Test
    void helloDecorator() {
        HelloDecorator helloDecorator = new HelloDecorator(new HelloService() {
            @Override
            public String sayHello(String name) {
                return name;
            }

            @Override
            public int countOf(String name) {
                return 0;
            }
        });

        String ret = helloDecorator.sayHello("Test");

        assertThat(ret).isEqualTo("Test*");
    }
}
