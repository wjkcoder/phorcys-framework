import cn.phorcys.framework.commons.exception.PhorcysRuntimeException;
import cn.phorcys.framework.commons.logger.Logger;
import cn.phorcys.framework.commons.logger.LoggerFactory;
import org.junit.Test;

public class LoggerTest {
    @Test
    public void testLogger(){
        Logger LOGGER = LoggerFactory.getLogger(LoggerTest.class);
        LOGGER.info("slf4j info");
        LOGGER.warn("slf4j warn");
        LOGGER.error("slf4j error");

    }
}
