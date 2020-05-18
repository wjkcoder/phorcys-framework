package cn.phorcys.framework.commons.infrastructure;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import org.springframework.stereotype.Component;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/14 5:39 下午
 */
@Component
public class SnowGenerator implements GlobalIdGenerate {
    @Override
    public Long nextId() {
        return new DefaultIdentifierGenerator().nextId(new Object());
    }
}
