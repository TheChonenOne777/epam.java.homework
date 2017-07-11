package unit2.task7;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PreWordForClass {
    String author();
    String dateCreated();
    boolean isInGitHub();
}
