package ${package.Mapper};

import ${package.Entity}.${entity};
import com.lightkits.framework.database.dao.SuperMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ${author}
 * Created on ${date}
 */
@Mapper
public interface ${entity}Mapper extends SuperMapper<${entity}> {

}