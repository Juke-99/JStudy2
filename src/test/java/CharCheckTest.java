import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.logging.Logger;

import org.junit.Test;

public class CharCheckTest {
    @Test
    public void chackTest() {
        CharCheck c = new CharCheck();
        Logger LOG = Logger.getLogger("CheckCharTest");
        
        LOG.info("localhost");
        //Arrays.stream(c.check("localhost")).forEach(System.out::println);
        assertThat(c.check("localhost")).contains("l".charAt(0), "o".charAt(0));
        
        LOG.info("localhost:8080");
        //Arrays.stream(c.check("localhost:8080")).forEach(System.out::println);
        assertThat(c.check("localhost:8080")).contains("l".charAt(0), ":".charAt(0), "8".charAt(0));
        
        LOG.info("ds.localhost-test:8080");
        //Arrays.stream(c.check("ds.localhost-test:8080")).forEach(System.out::println);
        assertThat(c.check("ds.localhost-test:8080")).contains("0".charAt(0), ".".charAt(0), "-".charAt(0));
        
        LOG.info("文字列");
        //Arrays.stream(c.check("文字列")).forEach(System.out::println);
        assertThat(c.check("文字列")).contains("文".charAt(0), "列".charAt(0));
        
        LOG.info("/");
        //Arrays.stream(c.check("/")).forEach(System.out::println);
        assertThat(c.check("/")).contains("/".charAt(0));
    }
}
