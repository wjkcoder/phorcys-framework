import cn.phorcys.framework.database.CodeGenerator;
import com.baomidou.mybatisplus.annotation.DbType;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/9 11:32 上午
 */
public class GenerateTest {
    public static void main(String[] args) {
        CodeGenerator root = new CodeGenerator(DbType.MYSQL, "com.mysql.jdbc.Driver",
                "jdbc:mysql://39.100.234.80:36020/phorcys-centre?useSSL=false",
                "root", "H@ndAdmin", "cn.phorcys.center.db");
        root.generate("sys_user");
    }
}
