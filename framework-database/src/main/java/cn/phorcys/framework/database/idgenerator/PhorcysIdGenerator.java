package cn.phorcys.framework.database.idgenerator;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.stereotype.Component;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/13 2:24 下午
 */
@Component
public class PhorcysIdGenerator implements IdentifierGenerator {
    @Override
    public Number nextId(Object entity) {
       return new DefaultIdentifierGenerator().nextId(entity);
    }

    public static Number nextId() {
        return new DefaultIdentifierGenerator().nextId(new Object());
    }

    public static void main(String[] args) {
        System.out.println(PhorcysIdGenerator.nextId());
    }
}
