package cn.phorcys.framework.commons.infrastructure;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/14 5:38 下午
 */
public interface GlobalIdGenerate {
    Long nextId();

}
